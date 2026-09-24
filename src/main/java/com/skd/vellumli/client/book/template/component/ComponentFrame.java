package com.skd.vellumli.client.book.template.component;

import net.minecraft.client.gui.GuiGraphicsExtractor;

import com.skd.vellumli.client.book.BookContentsBuilder;
import com.skd.vellumli.client.book.BookEntry;
import com.skd.vellumli.client.book.BookPage;
import com.skd.vellumli.client.book.gui.GuiBook;
import com.skd.vellumli.client.book.template.TemplateComponent;

public class ComponentFrame extends TemplateComponent {

	@Override
	public void build(BookContentsBuilder builder, BookPage page, BookEntry entry, int pageNum) {
		if (x == -1) {
			x = GuiBook.PAGE_WIDTH / 2 - 53;
		}
		if (y == -1) {
			y = 7;
		}
	}

	@Override
	public void extractRenderState(GuiGraphicsExtractor graphics, BookPage page, int mouseX, int mouseY, float pticks) {
		//RenderSystem.enableBlend();
		//RenderSystem.setShaderColor(1F, 1F, 1F, 1F);
		GuiBook.drawFromTexture(graphics, page.book, x, y, 405, 149, 106, 106);
	}

}
