package com.skd.vellumli.common.handler;

import net.minecraft.server.MinecraftServer;

import com.skd.vellumli.api.VellumliAPI;
import com.skd.vellumli.xplat.IXplatAbstractions;

public class ReloadContentsHandler {
	public static void dataReloaded(MinecraftServer server) {
		// Also reload contents when someone types /reload
		VellumliAPI.LOGGER.info("Sending reload packet to clients");
		IXplatAbstractions.INSTANCE.sendReloadContentsMessage(server);
	}
}
