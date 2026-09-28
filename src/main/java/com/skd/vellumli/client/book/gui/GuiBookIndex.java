package com.skd.vellumli.client.book.gui;

import net.minecraft.client.resources.language.I18n;
import net.minecraft.network.chat.Component;

import com.skd.vellumli.client.book.BookEntry;
import com.skd.vellumli.common.book.Book;

import java.util.Collection;

public class GuiBookIndex extends GuiBookEntryList {

	public GuiBookIndex(Book book) {
		super(book, Component.translatable("vellumli.gui.lexicon.index"));
	}

	@Override
	protected String getDescriptionText() {
		return I18n.get("vellumli.gui.lexicon.index.info");
	}

	@Override
	protected Collection<BookEntry> getEntries() {
		return book.getContents().entries.values();
	}

}
