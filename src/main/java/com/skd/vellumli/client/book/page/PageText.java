package com.skd.vellumli.client.book.page;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.resources.ResourceLocation;

import com.skd.vellumli.api.IVariable;
import com.skd.vellumli.client.book.gui.GuiBook;
import com.skd.vellumli.client.book.page.abstr.PageWithText;

public class PageText extends PageWithText {

	String title;

	public void setText(String text) {
		this.text = IVariable.wrap(text);
	}

	@Override
	public int getTextHeight() {
		if (pageNum == 0) {
			int titleLines = parent.splitHeaderText(entry.getPageTitle()).size();
			return 22 + (titleLines - 1) * GuiBook.TEXT_LINE_HEIGHT;
		}

		if (title != null && !title.isEmpty()) {
			return 12;
		}

		return -4;
	}

	@Override
	public void render(GuiGraphics graphics, int mouseX, int mouseY, float pticks) {
		super.render(graphics, mouseX, mouseY, pticks);

		if (pageNum == 0) {
			String smolText = "";

			if (mc.options.advancedItemTooltips) {
				ResourceLocation res = parent.getEntry().getId();
				smolText = res.toString();
			} else if (entry.getAddedBy() != null) {
				smolText = I18n.get("vellumli.gui.lexicon.added_by", entry.getAddedBy());
			}

			int headerLines = parent.drawCenteredHeader(graphics, parent.getEntry().getPageTitle(), GuiBook.PAGE_WIDTH / 2, smolText.isEmpty() ? 0 : -3, book.headerColor);

			if (!smolText.isEmpty()) {
				graphics.pose().scale(0.5F, 0.5F, 1F);
				parent.drawCenteredStringNoShadow(graphics, smolText, GuiBook.PAGE_WIDTH, 12 + (headerLines - 1) * GuiBook.TEXT_LINE_HEIGHT * 2, book.headerColor);
				graphics.pose().scale(2F, 2F, 1F);
			}

			GuiBook.drawSeparator(graphics, book, 0, 12 + (headerLines - 1) * GuiBook.TEXT_LINE_HEIGHT);
		} else if (title != null && !title.isEmpty()) {
			parent.drawCenteredStringNoShadow(graphics, i18n(title), GuiBook.PAGE_WIDTH / 2, 0, book.headerColor);
		}
	}

}
