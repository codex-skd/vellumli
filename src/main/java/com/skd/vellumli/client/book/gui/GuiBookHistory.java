package com.skd.vellumli.client.book.gui;

import net.minecraft.client.resources.language.I18n;
import net.minecraft.network.chat.Component;

import com.skd.vellumli.client.base.PersistentData;
import com.skd.vellumli.client.base.PersistentData.BookData;
import com.skd.vellumli.client.book.BookEntry;
import com.skd.vellumli.common.book.Book;

import java.util.Collection;
import java.util.stream.Collectors;

public class GuiBookHistory extends GuiBookEntryList {

	public GuiBookHistory(Book book) {
		super(book, Component.translatable("vellumli.gui.lexicon.history"));
	}

	@Override
	protected String getDescriptionText() {
		return I18n.get("vellumli.gui.lexicon.history.info");
	}

	@Override
	protected boolean shouldDrawProgressBar() {
		return false;
	}

	@Override
	protected boolean shouldSortEntryList() {
		return false;
	}

	@Override
	protected Collection<BookEntry> getEntries() {
		BookData data = PersistentData.data.getBookData(book);

		return data.history.stream()
				.map((res) -> book.getContents().entries.get(res))
				.filter((e) -> e != null && !e.isLocked())
				.collect(Collectors.toList());
	}

}
