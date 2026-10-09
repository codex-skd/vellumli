package com.skd.vellumli.network;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;

import com.skd.vellumli.api.VellumliAPI;

public record MessageReloadBookContents() implements CustomPacketPayload {
	public static final ResourceLocation ID = ResourceLocation.fromNamespaceAndPath(VellumliAPI.MOD_ID, "reload_books");
	public static final StreamCodec<FriendlyByteBuf, MessageReloadBookContents> CODEC = StreamCodec.unit(new MessageReloadBookContents());
	public static final Type<MessageReloadBookContents> TYPE = new Type<>(ID);

	@Override
	public Type<? extends CustomPacketPayload> type() {
		return TYPE;
	}
}
