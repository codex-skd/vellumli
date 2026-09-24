package com.skd.vellumli.client.book.template.component;

import net.minecraft.client.gui.GuiGraphicsExtractor;

import com.skd.vellumli.client.book.BookContentsBuilder;
import com.skd.vellumli.client.book.BookEntry;
import com.skd.vellumli.client.book.BookPage;
import com.skd.vellumli.client.book.gui.GuiBook;
import com.skd.vellumli.client.book.template.TemplateComponent;

public class ComponentSeparator extends TemplateComponent {

	@Override
	public void build(BookContentsBuilder builder, BookPage page, BookEntry entry, int pageNum) {
		if (x == -1) {
			x = 0;
		}
		if (y == -1) {
			y = 12;
		}
	}

	@Override
	public void extractRenderState(GuiGraphicsExtractor graphics, BookPage page, int mouseX, int mouseY, float pticks) {
		GuiBook.drawSeparator(graphics, page.book, x, y);
	}

}
