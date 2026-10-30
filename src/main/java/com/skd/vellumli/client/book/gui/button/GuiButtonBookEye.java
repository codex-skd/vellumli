package com.skd.vellumli.client.book.gui.button;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.components.Button;
import net.minecraft.network.chat.Component;

import com.skd.vellumli.client.base.ClientTicker;
import com.skd.vellumli.client.base.PersistentData;
import com.skd.vellumli.client.book.gui.GuiBook;

public class GuiButtonBookEye extends GuiButtonBook {

	public GuiButtonBookEye(GuiBook parent, int x, int y, Button.OnPress onPress) {
		super(parent, x, y, 308, 31, 11, 11, onPress,
				Component.translatable("vellumli.gui.lexicon.button.visualize"),
				Component.translatable("vellumli.gui.lexicon.button.visualize.info").withStyle(ChatFormatting.GRAY));
	}

	@Override
	protected void extractContents(GuiGraphicsExtractor graphics, int mouseX, int mouseY, float partialTicks) {
		super.extractContents(graphics, mouseX, mouseY, partialTicks);

		if (!PersistentData.data.clickedVisualize && (ClientTicker.ticksInGame) % 20 < 10) {
			graphics.text(parent.getMinecraft().font, "!", getX(), getY(), 0xFF3333, true);
		}
	}
}
