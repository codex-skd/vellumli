package com.skd.vellumli.client.book.template.test;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.input.MouseButtonEvent;
import net.minecraft.core.HolderLookup;
import net.minecraft.network.chat.Component;

import com.skd.vellumli.api.IComponentRenderContext;
import com.skd.vellumli.api.ICustomComponent;
import com.skd.vellumli.api.IVariable;
import com.skd.vellumli.api.VellumliAPI;

import java.util.function.UnaryOperator;

public class ComponentCustomTest implements ICustomComponent {
	private transient int x, y;
	private transient String text = "";

	@Override
	public void build(int componentX, int componentY, int pageNum) {
		x = componentX;
		y = componentY;
		VellumliAPI.LOGGER.debug("Custom Component Test built at ({}, {}) page {}", componentX, componentY, pageNum);
	}

	@Override
	public void extractRenderState(GuiGraphicsExtractor graphics, IComponentRenderContext context, float pticks, int mouseX, int mouseY) {
		Component toRender = Component.literal(text).setStyle(context.getFontStyle());
		graphics.text(Minecraft.getInstance().font, toRender, x, y, -1, true);
	}

	@Override
	public boolean mouseClicked(IComponentRenderContext context, MouseButtonEvent event, boolean doubleClick) {
		VellumliAPI.LOGGER.debug("Custom Component Test clicked {}", event);
		return false;
	}

	@Override
	public void onVariablesAvailable(UnaryOperator<IVariable> lookup, HolderLookup.Provider registries) {
		text = lookup.apply(IVariable.wrap("First we eat #spaghet#, then we drink #pop#", registries)).asString();
	}
}
