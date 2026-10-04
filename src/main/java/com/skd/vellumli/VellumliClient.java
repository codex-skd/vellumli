package com.skd.vellumli;

import net.minecraft.client.Minecraft;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.AddClientReloadListenersEvent;
import net.neoforged.neoforge.client.event.ClientPlayerNetworkEvent;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import net.neoforged.neoforge.client.event.RecipesReceivedEvent;
import net.neoforged.neoforge.client.event.RegisterItemModelsEvent;
import net.neoforged.neoforge.client.event.RegisterRangeSelectItemModelPropertyEvent;
import net.neoforged.neoforge.client.event.RenderFrameEvent;
import net.neoforged.neoforge.client.event.RenderTooltipEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;

import com.skd.vellumli.api.VellumliAPI;
import com.skd.vellumli.client.base.BookCompletionModelProperty;
import com.skd.vellumli.client.base.BookModel;
import com.skd.vellumli.client.base.ClientAdvancements;
import com.skd.vellumli.client.base.ClientRecipes;
import com.skd.vellumli.client.base.ClientTicker;
import com.skd.vellumli.client.base.PersistentData;
import com.skd.vellumli.client.book.BookContentResourceListenerLoader;
import com.skd.vellumli.client.book.BookReloadHook;
import com.skd.vellumli.client.book.ClientBookRegistry;
import com.skd.vellumli.client.handler.BookRightClickHandler;
import com.skd.vellumli.client.handler.TooltipHandler;

/**
 * Client-side entry point for Vellumli (NeoForge), ported from Patchouli's NeoForgeClientInitializer.
 *
 * VELLUMLI NOTE (deferred in this beta): the in-world multiblock visualization (MultiblockVisualizationHandler,
 * the multiblock progress HUD and the picture-in-picture renderer) is not ported yet, so those hooks are omitted.
 */
@Mod(value = VellumliAPI.MOD_ID, dist = Dist.CLIENT)
public class VellumliClient {
	public VellumliClient(IEventBus modBus) {
		NeoForge.EVENT_BUS.addListener((PlayerInteractEvent.RightClickBlock e) -> {
			BookRightClickHandler.onRightClick(e.getEntity(), e.getLevel(), e.getHand(), e.getHitVec());
		});
		NeoForge.EVENT_BUS.addListener((ClientTickEvent.Post e) -> {
			ClientTicker.endClientTick(Minecraft.getInstance());
		});
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
		NeoForge.EVENT_BUS.addListener((RecipesReceivedEvent e) -> {
			ClientRecipes.INSTANCE.receivedRecipes(e.getRecipeMap().values());
		});
		modBus.addListener((FMLClientSetupEvent e) -> {
			ClientBookRegistry.INSTANCE.init();
			PersistentData.setup();
		});
		modBus.addListener((AddClientReloadListenersEvent e) -> {
			e.addListener(BookContentResourceListenerLoader.ID, BookContentResourceListenerLoader.INSTANCE);
			e.addListener(BookReloadHook.ID, BookReloadHook.INSTANCE);
		});
		modBus.addListener((RegisterRangeSelectItemModelPropertyEvent e) -> {
			e.register(BookCompletionModelProperty.ID, BookCompletionModelProperty.MAP_CODEC);
		});
		modBus.addListener((RegisterItemModelsEvent e) -> {
			e.register(BookModel.Unbaked.ID, BookModel.Unbaked.MAP_CODEC);
		});
	}
}
