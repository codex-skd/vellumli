package com.skd.vellumli.client.base;

import com.mojang.serialization.MapCodec;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.item.properties.numeric.RangeSelectItemModelProperty;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.ItemOwner;
import net.minecraft.world.item.ItemStack;

import com.skd.vellumli.api.VellumliAPI;
import com.skd.vellumli.common.item.ItemModBook;
import com.skd.vellumli.common.item.VellumliItems;

import org.jetbrains.annotations.Nullable;

public class BookCompletionModelProperty implements RangeSelectItemModelProperty {
	public static final Identifier ID = Identifier.fromNamespaceAndPath(VellumliAPI.MOD_ID, "completion");
	public static final MapCodec<BookCompletionModelProperty> MAP_CODEC = MapCodec.unit(new BookCompletionModelProperty());

	@Override
	public float get(ItemStack stack, @Nullable ClientLevel level, @Nullable ItemOwner owner, int seed) {
		return stack.is(VellumliItems.BOOK) ? ItemModBook.getCompletion(stack) : 0;
	}

	@Override
	public MapCodec<? extends RangeSelectItemModelProperty> type() {
		return MAP_CODEC;
	}
}
