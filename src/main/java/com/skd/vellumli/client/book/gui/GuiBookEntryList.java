package com.skd.vellumli.client.book.gui;

import com.mojang.blaze3d.systems.RenderSystem;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.network.chat.Component;

import org.lwjgl.glfw.GLFW;

import com.skd.vellumli.client.book.BookEntry;
import com.skd.vellumli.client.book.gui.button.GuiButtonCategory;
import com.skd.vellumli.client.book.gui.button.GuiButtonEntry;
import com.skd.vellumli.common.book.Book;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public abstract class GuiBookEntryList extends GuiBook {

	public static final int ENTRIES_PER_PAGE = 13;
	public static final int ENTRIES_IN_FIRST_PAGE = 11;

	private BookTextRenderer text;

	protected final List<Button> entryButtons = new ArrayList<>();
	private List<BookEntry> allEntries;
	private final List<BookEntry> visibleEntries = new ArrayList<>();
	/** Index in visibleEntries where each index page starts; an entry whose name wraps takes two slots of a page. */
	private final List<Integer> pageStarts = new ArrayList<>();

	private EditBox searchField;

	public GuiBookEntryList(Book book, Component title) {
		super(book, title);
	}

	@Override
	public void init() {
		super.init();

		text = new BookTextRenderer(this, Component.literal(getDescriptionText()), LEFT_PAGE_X, TOP_PADDING + 22);

		allEntries = new ArrayList<>(getEntries());
		allEntries.removeIf(BookEntry::shouldHide);
		if (shouldSortEntryList()) {
			Collections.sort(allEntries);
		}

		this.searchField = createSearchBar();
		buildEntryButtons();
	}

	protected EditBox createSearchBar() {
		EditBox field = new EditBox(font, 160, 170, 90, 12, Component.empty());
		field.setMaxLength(32);
		field.setBordered(false);
		field.setCanLoseFocus(false);
		field.setFocused(true);
		return field;
	}

	protected abstract String getDescriptionText();
	protected abstract Collection<BookEntry> getEntries();

	protected boolean doesEntryCountForProgress(BookEntry entry) {
		return true;
	}

	protected boolean shouldDrawProgressBar() {
		return true;
	}

	protected boolean shouldSortEntryList() {
		return true;
	}

	protected void addSubcategoryButtons() {
		// NO-OP
	}

	@Override
	void drawForegroundElements(GuiGraphics graphics, int mouseX, int mouseY, float partialTicks) {
		super.drawForegroundElements(graphics, mouseX, mouseY, partialTicks);

		if (spread == 0) {
			drawCenteredStringNoShadow(graphics, getTitle().getVisualOrderText(), LEFT_PAGE_X + PAGE_WIDTH / 2, TOP_PADDING, book.headerColor);
			drawCenteredStringNoShadow(graphics, getChapterListTitle(), RIGHT_PAGE_X + PAGE_WIDTH / 2, TOP_PADDING, book.headerColor);

			drawSeparator(graphics, book, LEFT_PAGE_X, TOP_PADDING + 12);
			drawSeparator(graphics, book, RIGHT_PAGE_X, TOP_PADDING + 12);

			text.render(graphics, mouseX, mouseY, partialTicks);
			if (shouldDrawProgressBar()) {
				drawProgressBar(graphics, book, mouseX, mouseY, this::doesEntryCountForProgress);
			}
		} else if (spread % 2 == 1 && spread == maxSpreads - 1 && entryButtons.size() <= ENTRIES_PER_PAGE) {
			drawPageFiller(graphics, book);
		}

		if (!searchField.getValue().isEmpty()) {
			RenderSystem.setShaderColor(1F, 1F, 1F, 1F);
			drawFromTexture(graphics, book, searchField.getX() - 8, searchField.getY(), 140, 183, 99, 14);
			Component toDraw = Component.literal(searchField.getValue()).setStyle(book.getFontStyle());
			graphics.drawString(font, toDraw, searchField.getX() + 7, searchField.getY() + 1, book.textColor, false);
		}

		if (visibleEntries.isEmpty()) {
			if (!searchField.getValue().isEmpty()) {
				drawCenteredStringNoShadow(graphics, I18n.get("vellumli.gui.lexicon.no_results"), GuiBook.RIGHT_PAGE_X + GuiBook.PAGE_WIDTH / 2, 80, 0x333333);
				graphics.pose().scale(2F, 2F, 2F);
				drawCenteredStringNoShadow(graphics, I18n.get("vellumli.gui.lexicon.sad"), GuiBook.RIGHT_PAGE_X / 2 + GuiBook.PAGE_WIDTH / 4, 47, 0x999999);
				graphics.pose().scale(0.5F, 0.5F, 0.5F);
			} else {
				drawCenteredStringNoShadow(graphics, getNoEntryMessage(), GuiBook.RIGHT_PAGE_X + GuiBook.PAGE_WIDTH / 2, 80, 0x333333);
			}
		}
	}

	protected String getChapterListTitle() {
		return I18n.get("vellumli.gui.lexicon.chapters");
	}

	protected String getNoEntryMessage() {
		return I18n.get("vellumli.gui.lexicon.no_entries");
	}

	@Override
	public boolean mouseClickedScaled(double mouseX, double mouseY, int mouseButton) {
		return text.click(mouseX, mouseY, mouseButton)
				|| searchField.mouseClicked(mouseX - bookLeft, mouseY - bookTop, mouseButton)
				|| super.mouseClickedScaled(mouseX, mouseY, mouseButton);
	}

	@Override
	public boolean charTyped(char c, int i) {
		String currQuery = searchField.getValue();
		if (searchField.charTyped(c, i)) {
			if (!searchField.getValue().equals(currQuery)) {
				buildEntryButtons();
			}

			return true;
		}

		return super.charTyped(c, i);
	}

	@Override
	public boolean keyPressed(int key, int scanCode, int modifiers) {
		String currQuery = searchField.getValue();

		if (key == GLFW.GLFW_KEY_ENTER) {
			if (visibleEntries.size() == 1) {
				displayLexiconGui(new GuiBookEntry(book, visibleEntries.get(0)), true);
				return true;
			}
		} else if (searchField.keyPressed(key, scanCode, modifiers)) {
			if (!searchField.getValue().equals(currQuery)) {
				buildEntryButtons();
			}

			return true;
		}

		return super.keyPressed(key, scanCode, modifiers);
	}

	public void handleButtonCategory(Button button) {
		displayLexiconGui(new GuiBookCategory(book, ((GuiButtonCategory) button).getCategory()), true);
	}

	public void handleButtonEntry(Button button) {
		GuiBookEntry.displayOrBookmark(this, ((GuiButtonEntry) button).getEntry());
	}

	@Override
	void onPageChanged() {
		buildEntryButtons();
	}

	void buildEntryButtons() {
		removeDrawablesIn(entryButtons);
		entryButtons.clear();
		visibleEntries.clear();

		String query = searchField.getValue().toLowerCase();
		allEntries.stream().filter((e) -> e.isFoundByQuery(query)).forEach(visibleEntries::add);

		pageStarts.clear();
		int used = 0;
		pageStarts.add(0);
		for (int i = 0; i < visibleEntries.size(); i++) {
			int capacity = pageStarts.size() == 1 ? ENTRIES_IN_FIRST_PAGE : ENTRIES_PER_PAGE;
			int slots = GuiButtonEntry.slotsFor(visibleEntries.get(i));
			if (used > 0 && used + slots > capacity) {
				pageStarts.add(i);
				used = 0;
			}
			used += slots;
		}
		// Page 0 is the right page of the first spread; every later spread shows two pages.
		maxSpreads = 1 + (int) Math.ceil((pageStarts.size() - 1) / 2.0);
		if (spread >= maxSpreads) {
			spread = maxSpreads - 1;
		}

		if (spread == 0) {
			addEntryButtons(RIGHT_PAGE_X, TOP_PADDING + 20, 0, ENTRIES_IN_FIRST_PAGE);
			addSubcategoryButtons();
		} else {
			addEntryButtons(LEFT_PAGE_X, TOP_PADDING, startOfPage(spread * 2 - 1), ENTRIES_PER_PAGE);
			addEntryButtons(RIGHT_PAGE_X, TOP_PADDING, startOfPage(spread * 2), ENTRIES_PER_PAGE);
		}
	}

	private int startOfPage(int page) {
		return page < pageStarts.size() ? pageStarts.get(page) : visibleEntries.size();
	}

	int getEntryCountStart() {
		return spread == 0 ? 0 : startOfPage(spread * 2 - 1);
	}

	/** Adds buttons from {@code start} until {@code slots} index lines are used up; wrapped names take two. */
	void addEntryButtons(int x, int y, int start, int slots) {
		int used = 0;
		for (int i = start; i < visibleEntries.size(); i++) {
			BookEntry entry = visibleEntries.get(i);
			int entrySlots = GuiButtonEntry.slotsFor(entry);
			if (used + entrySlots > slots) {
				break;
			}
			Button button = new GuiButtonEntry(this, bookLeft + x, bookTop + y + used * 11, entry, this::handleButtonEntry);
			addRenderableWidget(button);
			entryButtons.add(button);
			used += entrySlots;
		}
	}

	public String getSearchQuery() {
		return searchField.getValue();
	}

}
