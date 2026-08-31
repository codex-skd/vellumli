package com.skd.vellumli;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.client.renderer.item.ItemPropertyFunction;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.ClientPlayerNetworkEvent;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import net.neoforged.neoforge.client.event.ModelEvent;
import net.neoforged.neoforge.client.event.RegisterClientReloadListenersEvent;
import net.neoforged.neoforge.client.event.RenderFrameEvent;
import net.neoforged.neoforge.client.event.RenderTooltipEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;

import com.skd.vellumli.api.VellumliAPI;
import com.skd.vellumli.client.base.BookModel;
import com.skd.vellumli.client.base.ClientAdvancements;
import com.skd.vellumli.client.base.ClientTicker;
import com.skd.vellumli.client.base.PersistentData;
import com.skd.vellumli.client.book.BookContentResourceListenerLoader;
import com.skd.vellumli.client.book.BookReloadHook;
import com.skd.vellumli.client.book.ClientBookRegistry;
import com.skd.vellumli.client.handler.BookRightClickHandler;
import com.skd.vellumli.client.handler.TooltipHandler;
import com.skd.vellumli.common.book.BookRegistry;
import com.skd.vellumli.common.item.ItemModBook;
import com.skd.vellumli.common.item.VellumliItems;

import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Client-side entry point for Vellumli (NeoForge), ported from Patchouli's NeoForgeClientInitializer.
 *
 * VELLUMLI NOTE (deferred in this beta): the in-world multiblock visualization (MultiblockVisualizationHandler,
 * the multiblock progress HUD and the picture-in-picture renderer) is not ported yet, so those hooks are omitted.
 */
@EventBusSubscriber(modid = VellumliAPI.MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class VellumliClient {
	/**
	 * Why are these necessary?
	 * BookRegistry.init is called from CommonSetupEvent / FMLClientSetupEvent. We need the models to be known
	 * in ModelRegistryEvent. However, there is no defined ordering for those events. They all run concurrently
	 * during the initial resource reload.
	 * We need a way of waiting for the books to become known.
	 * Another critical point to note is that loading runs on a fixed-size ForkJoinPool.
	 * Blocking the thread can starve loading completely.
	 * Fortunately, the implementation of Condition.await for ReentrantLock uses ForkJoinPool.managedBlock,
	 * which is aware of potentially blocking operations and can resize the pool accordingly.
	 * If parallel mod loading didn't exist we wouldn't need any of this, but here we are :))))
	 */
	private static final Lock BOOK_LOAD_LOCK = new ReentrantLock();
	private static final Condition BOOK_LOAD_CONDITION = BOOK_LOAD_LOCK.newCondition();
	private static boolean booksLoaded = false;

	public static void signalBooksLoaded() {
		BOOK_LOAD_LOCK.lock();
		booksLoaded = true;
		BOOK_LOAD_CONDITION.signalAll();
		BOOK_LOAD_LOCK.unlock();
	}

	private static List<ResourceLocation> getBookModels() {
		BOOK_LOAD_LOCK.lock();
		try {
			while (!booksLoaded) {
				BOOK_LOAD_CONDITION.awaitUninterruptibly();
			}
			return BookRegistry.INSTANCE.books.values().stream().map(b -> b.model).toList();
		} finally {
			BOOK_LOAD_LOCK.unlock();
		}
	}

	@SubscribeEvent
	public static void modelRegistry(ModelEvent.RegisterAdditional e) {
		getBookModels()
				.stream()
				.map(ModelResourceLocation::standalone)
				.forEach(e::register);

		ItemPropertyFunction prop = (stack, world, entity, seed) -> ItemModBook.getCompletion(stack);
		ItemProperties.register(VellumliItems.BOOK, ResourceLocation.fromNamespaceAndPath(VellumliAPI.MOD_ID, "completion"), prop);
	}

	@SubscribeEvent
	public static void registerReloadListeners(RegisterClientReloadListenersEvent e) {
		e.registerReloadListener(BookContentResourceListenerLoader.INSTANCE);
		e.registerReloadListener(BookReloadHook.INSTANCE);
	}

	@SubscribeEvent
	public static void onInitializeClient(FMLClientSetupEvent evt) {
		ClientBookRegistry.INSTANCE.init();
		PersistentData.setup();
		NeoForge.EVENT_BUS.addListener((ClientTickEvent.Post e) -> {
			ClientTicker.endClientTick(Minecraft.getInstance());
		});
		NeoForge.EVENT_BUS.addListener((PlayerInteractEvent.RightClickBlock e) -> BookRightClickHandler.onRightClick(e.getEntity(), e.getLevel(), e.getHand(), e.getHitVec()));
		NeoForge.EVENT_BUS.addListener((RenderFrameEvent.Pre e) -> {
			ClientTicker.renderTickStart(e.getPartialTick().getGameTimeDeltaPartialTick(false));
		});
		NeoForge.EVENT_BUS.addListener((RenderFrameEvent.Post e) -> {
			ClientTicker.renderTickEnd();
		});
		NeoForge.EVENT_BUS.addListener((ClientPlayerNetworkEvent.LoggingOut e) -> {
			ClientAdvancements.playerLogout();
		});
		NeoForge.EVENT_BUS.addListener((RenderTooltipEvent.Pre e) -> {
			TooltipHandler.onTooltip(e.getGraphics(), e.getItemStack(), e.getX(), e.getY());
		});
	}

	@SubscribeEvent
	public static void replaceBookModel(ModelEvent.ModifyBakingResult evt) {
		evt.getModels().computeIfPresent(
				ModelResourceLocation.inventory(ResourceLocation.fromNamespaceAndPath(VellumliAPI.MOD_ID, "guide_book")),
				(k, oldModel) -> new BookModel(oldModel, (model) -> Minecraft.getInstance().getModelManager().getModel(ModelResourceLocation.standalone(model)))
		);
	}
}
