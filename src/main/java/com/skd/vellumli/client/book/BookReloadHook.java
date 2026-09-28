package com.skd.vellumli.client.book;

import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.server.packs.resources.ResourceManagerReloadListener;

import com.skd.vellumli.api.VellumliAPI;

public final class BookReloadHook implements ResourceManagerReloadListener {
	public static final ResourceLocation ID = ResourceLocation.fromNamespaceAndPath(VellumliAPI.MOD_ID, "reload_hook");
	public static final ResourceManagerReloadListener INSTANCE = new BookReloadHook();

	@Override
	public void onResourceManagerReload(ResourceManager manager) {
		if (Minecraft.getInstance().level != null) {
			VellumliAPI.LOGGER.info("Reloading resource pack-based books");
			ClientBookRegistry.INSTANCE.reload();
		} else {
			VellumliAPI.LOGGER.debug("Not reloading resource pack-based books as client world is missing");
		}
	}
}
