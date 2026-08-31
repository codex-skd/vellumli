package com.skd.vellumli.client.book.gui.button;

import net.minecraft.network.chat.Component;

import com.skd.vellumli.client.book.gui.GuiBook;

import java.util.function.Supplier;

public class GuiButtonBookArrowSmall extends GuiButtonBook {

	public final boolean left;

	public GuiButtonBookArrowSmall(GuiBook parent, int x, int y, boolean left, Supplier<Boolean> displayCondition, OnPress onPress) {
		super(parent, x, y, 272, left ? 27 : 20, 5, 7, displayCondition, onPress,
				Component.translatable(left ? "vellumli.gui.lexicon.button.prev_page" : "vellumli.gui.lexicon.button.next_page"));
		this.left = left;
	}

}
