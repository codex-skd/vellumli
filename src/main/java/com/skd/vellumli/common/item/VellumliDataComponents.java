package com.skd.vellumli.common.item;

import net.minecraft.core.component.DataComponentType;
import net.minecraft.resources.Identifier;

import com.skd.vellumli.api.VellumliAPI;

import java.util.function.BiConsumer;

public class VellumliDataComponents {

	public static final Identifier COMPONENT_ID = Identifier.fromNamespaceAndPath(VellumliAPI.MOD_ID, "book");
	public static final DataComponentType<Identifier> BOOK = DataComponentType.<Identifier>builder()
			.persistent(Identifier.CODEC)
			.networkSynchronized(Identifier.STREAM_CODEC)
			.build();

	public static void submitDataComponentRegistrations(BiConsumer<Identifier, DataComponentType<?>> consumer) {
		consumer.accept(COMPONENT_ID, BOOK);
	}
}
