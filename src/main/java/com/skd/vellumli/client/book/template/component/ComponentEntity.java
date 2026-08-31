package com.skd.vellumli.client.book.template.component;

import com.google.gson.annotations.SerializedName;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.core.HolderLookup;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;

import com.skd.vellumli.api.IVariable;
import com.skd.vellumli.api.VellumliAPI;
import com.skd.vellumli.client.base.ClientTicker;
import com.skd.vellumli.client.book.BookContentsBuilder;
import com.skd.vellumli.client.book.BookEntry;
import com.skd.vellumli.client.book.BookPage;
import com.skd.vellumli.client.book.gui.GuiBookEntry;
import com.skd.vellumli.client.book.page.PageEntity;
import com.skd.vellumli.client.book.template.TemplateComponent;
import com.skd.vellumli.common.util.EntityUtil;

import java.util.function.Function;
import java.util.function.UnaryOperator;

public class ComponentEntity extends TemplateComponent {

	@SerializedName("entity") public IVariable entityId;

	@SerializedName("render_size") float renderSize = 100;

	boolean rotate = true;
	@SerializedName("default_rotation") float defaultRotation = -45f;

	transient boolean errored;
	transient Entity entity;
	transient Function<Level, Entity> creator;
	transient float renderScale, offset;

	@Override
	public void build(BookContentsBuilder builder, BookPage page, BookEntry entry, int pageNum) {
		creator = EntityUtil.loadEntity(entityId.asString());
	}

	@Override
	public void onDisplayed(BookPage page, GuiBookEntry parent, int left, int top) {
		loadEntity(page.mc.level);
	}

	@Override
	public void render(GuiGraphics graphics, BookPage page, int mouseX, int mouseY, float pticks) {
		if (errored) {
			graphics.drawString(page.fontRenderer, Component.translatable("patchouli.gui.lexicon.loading_error"), x, y, 0xFF0000, false);
		}

		if (entity != null) {
			float rotation = rotate ? ClientTicker.total : defaultRotation;
			PageEntity.renderEntity(graphics, entity, x, y, rotation, renderScale, offset);
		}
	}

	@Override
	public void onVariablesAvailable(UnaryOperator<IVariable> lookup, HolderLookup.Provider registries) {
		super.onVariablesAvailable(lookup, registries);
		entityId = lookup.apply(entityId);
	}

	private void loadEntity(Level world) {
		if (!errored && (entity == null || !entity.isAlive() || entity.level() != world)) {
			try {
				entity = creator.apply(world);
				float width = entity.getBbWidth();
				float height = entity.getBbHeight();

				float entitySize = Math.max(width, height);
				entitySize = Math.max(1F, entitySize);

				renderScale = renderSize / entitySize * 0.8F;
				offset = Math.max(height, entitySize) * 0.5F;
			} catch (Exception e) {
				errored = true;
				VellumliAPI.LOGGER.error("Failed to load entity", e);
			}
		}
	}

}
