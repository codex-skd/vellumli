package com.skd.vellumli;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.CreativeModeTabRegistry;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.RegisterCommandsEvent;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.neoforge.event.server.ServerStartedEvent;
import net.neoforged.neoforge.registries.RegisterEvent;

import com.skd.vellumli.api.VellumliAPI;
import com.skd.vellumli.common.advancement.VellumliCriteriaTriggers;
import com.skd.vellumli.common.base.VellumliSounds;
import com.skd.vellumli.common.book.BookRegistry;
import com.skd.vellumli.common.command.OpenBookCommand;
import com.skd.vellumli.common.handler.LecternEventHandler;
import com.skd.vellumli.common.handler.ReloadContentsHandler;
import com.skd.vellumli.common.item.ItemModBook;
import com.skd.vellumli.common.item.VellumliDataComponents;
import com.skd.vellumli.common.item.VellumliItems;
import com.skd.vellumli.neoforge.network.NeoForgeNetworkHandler;

/**
 * Main entry point for Vellumli (NeoForge).
 *
 * Ported from Patchouli's NeoForgeModInitializer: registers the guide book item, the book data
 * component, sounds, advancement triggers, network payloads, datapack reload handling, the
 * /open-vellumli-book command and the lectern interaction handler.
 */
@Mod(VellumliAPI.MOD_ID)
public class Vellumli {
	public Vellumli(IEventBus modBus, ModContainer container) {
		Config.setup(container);

		modBus.addListener(NeoForgeNetworkHandler::setupPackets);
		modBus.addListener((RegisterEvent evt) -> {
			evt.register(Registries.SOUND_EVENT, rh -> {
				VellumliSounds.submitRegistrations(rh::register);
			});
			evt.register(Registries.DATA_COMPONENT_TYPE, rh -> {
				VellumliDataComponents.submitDataComponentRegistrations(rh::register);
			});
			evt.register(Registries.ITEM, rh -> {
				VellumliItems.submitItemRegistrations(rh::register);
			});
			evt.register(Registries.TRIGGER_TYPE, rh -> VellumliCriteriaTriggers.submitTriggerRegistrations(rh::register));
		});
		modBus.addListener((BuildCreativeModeTabContentsEvent evt) -> {
			BookRegistry.INSTANCE.books.values().forEach(b -> {
				if (!b.noBook) {
					ItemStack book = ItemModBook.forBook(b);
					if (evt.getTabKey() == CreativeModeTabs.SEARCH) {
						if (!evt.getSearchEntries().contains(book)) {
							evt.accept(book, CreativeModeTab.TabVisibility.SEARCH_TAB_ONLY);
						}
					} else if (b.creativeTab != null) {
						if (evt.getTab() == CreativeModeTabRegistry.getTab(b.creativeTab)) {
							evt.accept(book);
						}
					}
				}
			});
		});
		modBus.addListener((FMLCommonSetupEvent evt) -> BookRegistry.INSTANCE.init());
		NeoForge.EVENT_BUS.addListener((RegisterCommandsEvent e) -> OpenBookCommand.register(e.getDispatcher()));
		NeoForge.EVENT_BUS.addListener((PlayerInteractEvent.RightClickBlock e) -> {
			var result = LecternEventHandler.rightClick(e.getEntity(), e.getLevel(), e.getHand(), e.getHitVec());
			if (result.consumesAction()) {
				e.setCanceled(true);
				e.setCancellationResult(result);
			}
		});
		NeoForge.EVENT_BUS.addListener((ServerStartedEvent e) -> ReloadContentsHandler.dataReloaded(e.getServer()));
	}
}
