package com.skd.vellumli.client.book.page;

import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.StonecutterRecipe;

import com.skd.vellumli.client.book.page.abstr.PageSimpleProcessingRecipe;

public class PageStonecutting extends PageSimpleProcessingRecipe<StonecutterRecipe> {

	public PageStonecutting() {
		super(RecipeType.STONECUTTING);
	}
}
