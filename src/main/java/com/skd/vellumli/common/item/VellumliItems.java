package com.skd.vellumli.common.item;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

import com.skd.vellumli.api.VellumliAPI;

import java.util.function.BiConsumer;

public class VellumliItems {

	public static final ResourceLocation BOOK_ID = ResourceLocation.fromNamespaceAndPath(VellumliAPI.MOD_ID, "guide_book");
	public static final Item BOOK = new ItemModBook();

	public static void submitItemRegistrations(BiConsumer<ResourceLocation, Item> consumer) {
		consumer.accept(BOOK_ID, BOOK);
	}
}
