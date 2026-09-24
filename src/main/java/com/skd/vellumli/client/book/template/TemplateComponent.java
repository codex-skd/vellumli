package com.skd.vellumli.client.book.template;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;

import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.input.MouseButtonEvent;
import net.minecraft.core.HolderLookup;
import net.minecraft.world.level.Level;

import com.skd.vellumli.api.IComponentProcessor;
import com.skd.vellumli.api.IVariable;
import com.skd.vellumli.api.IVariableProvider;
import com.skd.vellumli.api.IVariablesAvailableCallback;
import com.skd.vellumli.client.base.ClientAdvancements;
import com.skd.vellumli.client.book.BookContentsBuilder;
import com.skd.vellumli.client.book.BookEntry;
import com.skd.vellumli.client.book.BookPage;
import com.skd.vellumli.client.book.gui.GuiBookEntry;
import com.skd.vellumli.common.base.VellumliConfig;

import org.jetbrains.annotations.Nullable;

import java.util.function.UnaryOperator;

public abstract class TemplateComponent implements IVariablesAvailableCallback {

	public String group = "";
	public int x, y;

	public String flag = "";

	public String advancement = "";
	@SerializedName("negate_advancement") boolean negateAdvancement = false;

	public String guard = null;

	transient boolean guardPass = false;
	transient boolean isVisible = true;
	private transient boolean compiled = false;

	public transient JsonObject sourceObject;

	public final void compile(Level level, IVariableProvider variables, IComponentProcessor processor, @Nullable TemplateInclusion encapsulation) {
		if (compiled) {
			return;
		}

		if (encapsulation != null) {
			x += encapsulation.x;
			y += encapsulation.y;
		}

		VariableAssigner.assignVariableHolders(level, this, variables, processor, encapsulation);
		compiled = true;
	}

	public boolean getVisibleStatus(IComponentProcessor processor) {
		if (processor != null && group != null && !group.isEmpty() && !processor.allowRender(group)) {
			return false;
		}

		if (!guardPass) {
			return false;
		}

		if (!flag.isEmpty() && !VellumliConfig.getConfigFlag(flag)) {
			return false;
		}

		if (!advancement.isEmpty()) {
			return ClientAdvancements.hasDone(advancement) != negateAdvancement;
		}

		return true;
	}

	public void build(BookContentsBuilder builder, BookPage page, BookEntry entry, int pageNum) {
		// NO-OP
	}

	public void onDisplayed(BookPage page, GuiBookEntry parent, int left, int top) {
		// NO-OP
	}

	public void extractRenderState(GuiGraphicsExtractor graphics, BookPage page, int mouseX, int mouseY, float pticks) {
		// NO-OP
	}

	public boolean mouseClicked(BookPage page, MouseButtonEvent event, boolean doubleClick) {
		return false;
	}

	@Override
	public void onVariablesAvailable(UnaryOperator<IVariable> lookup, HolderLookup.Provider registries) {
		// TODO fix this up to use IVariable more intelligently
		group = lookup.apply(IVariable.wrap(group, registries)).asString();
		flag = lookup.apply(IVariable.wrap(flag, registries)).asString();
		advancement = lookup.apply(IVariable.wrap(advancement, registries)).asString();
		guardPass = (guard == null || lookup.apply(IVariable.wrap(guard, registries)).asBoolean());
	}
}
