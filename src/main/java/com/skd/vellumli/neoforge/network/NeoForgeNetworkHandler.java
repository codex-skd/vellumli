package com.skd.vellumli.neoforge.network;

import net.minecraft.resources.Identifier;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerPlayer;
import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;

import com.skd.vellumli.api.VellumliAPI;
import com.skd.vellumli.neoforge.network.handler.NeoForgeClientPayloadHandler;
import com.skd.vellumli.network.MessageOpenBookGui;
import com.skd.vellumli.network.MessageReloadBookContents;

import org.jetbrains.annotations.Nullable;

public class NeoForgeNetworkHandler {

	public static void setupPackets(final RegisterPayloadHandlersEvent event) {
		final PayloadRegistrar registrar = event.registrar(VellumliAPI.MOD_ID);
		registrar.playToClient(MessageOpenBookGui.TYPE, MessageOpenBookGui.CODEC, NeoForgeClientPayloadHandler.getInstance()::handleData);
		registrar.playToClient(MessageReloadBookContents.TYPE, MessageReloadBookContents.CODEC, NeoForgeClientPayloadHandler.getInstance()::handleData);
	}

	public static void sendOpenBook(ServerPlayer player, Identifier book, @Nullable Identifier entry, int page) {
		player.connection.send(new MessageOpenBookGui(book, entry, page));
	}

	public static void sendReloadBookContents(MinecraftServer server) {
		PacketDistributor.sendToAllPlayers(new MessageReloadBookContents());
	}
}
