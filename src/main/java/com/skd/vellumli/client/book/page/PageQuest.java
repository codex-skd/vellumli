package com.skd.vellumli.client.book.page;

import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.Level;

import com.skd.vellumli.client.base.ClientAdvancements;
import com.skd.vellumli.client.base.PersistentData;
import com.skd.vellumli.client.base.PersistentData.BookData;
import com.skd.vellumli.client.book.BookContentsBuilder;
import com.skd.vellumli.client.book.BookEntry;
import com.skd.vellumli.client.book.gui.GuiBook;
import com.skd.vellumli.client.book.gui.GuiBookEntry;
import com.skd.vellumli.client.book.page.abstr.PageWithText;
import com.skd.vellumli.common.book.Book;

public class PageQuest extends PageWithText {

	Identifier trigger;
	String title;

	transient boolean isManual;

	@Override
	public int getTextHeight() {
		return 22;
	}

	@Override
	public void build(Level level, BookEntry entry, BookContentsBuilder builder, int pageNum) {
		super.build(level, entry, builder, pageNum);

		isManual = trigger == null;
	}

	public boolean isCompleted(Book book) {
		return isManual
				? PersistentData.data.getBookData(book).completedManualQuests.contains(entry.getId())
				: trigger != null && ClientAdvancements.hasDone(trigger.toString());
	}

	@Override
	public void onDisplayed(GuiBookEntry parent, int left, int top) {
		super.onDisplayed(parent, left, top);

		if (isManual) {
			Button button = Button.builder(Component.empty(), this::questButtonClicked).pos(GuiBook.PAGE_WIDTH / 2 - 50, GuiBook.PAGE_HEIGHT - 35).size(100, 20).build();
			addButton(button);
			updateButtonText(button);
		}
	}

	private void updateButtonText(Button button) {
		boolean completed = isCompleted(parent.book);
		Component s = Component.translatable(completed ? "vellumli.gui.lexicon.mark_incomplete" : "vellumli.gui.lexicon.mark_complete");
		button.setMessage(s);
	}

	protected void questButtonClicked(Button button) {
		var res = entry.getId();
		BookData data = PersistentData.data.getBookData(parent.book);

		if (data.completedManualQuests.contains(res)) {
			data.completedManualQuests.remove(res);
		} else {
			data.completedManualQuests.add(res);
		}
		PersistentData.save();

		updateButtonText(button);
		entry.markReadStateDirty();
	}

	@Override
	public void extractRenderState(GuiGraphicsExtractor graphics, int mouseX, int mouseY, float pticks) {
		super.extractRenderState(graphics, mouseX, mouseY, pticks);

		parent.drawCenteredStringNoShadow(graphics, title == null || title.isEmpty() ? I18n.get("vellumli.gui.lexicon.objective") : i18n(title), GuiBook.PAGE_WIDTH / 2, 0, book.headerColor);
		GuiBook.drawSeparator(graphics, book, 0, 12);

		if (!isManual) {
			GuiBook.drawSeparator(graphics, book, 0, GuiBook.PAGE_HEIGHT - 25);

			boolean completed = isCompleted(parent.book);
			String s = I18n.get(completed ? "vellumli.gui.lexicon.complete" : "vellumli.gui.lexicon.incomplete");
			int color = completed ? 0x008b1a : book.headerColor;

			parent.drawCenteredStringNoShadow(graphics, s, GuiBook.PAGE_WIDTH / 2, GuiBook.PAGE_HEIGHT - 17, color);
		}

	}

}
