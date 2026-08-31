package com.skd.vellumli.client.book.page;

import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.SmokingRecipe;

import com.skd.vellumli.client.book.page.abstr.PageSimpleProcessingRecipe;

public class PageSmoking extends PageSimpleProcessingRecipe<SmokingRecipe> {

	public PageSmoking() {
		super(RecipeType.SMOKING);
	}
}
