package com.skd.vellumli.client.book.gui.button;

import com.mojang.blaze3d.systems.RenderSystem;

import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.sounds.SoundManager;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.util.FormattedCharSequence;

import java.util.List;

import com.skd.vellumli.client.base.ClientTicker;
import com.skd.vellumli.client.book.BookEntry;
import com.skd.vellumli.client.book.gui.GuiBook;

public class GuiButtonEntry extends Button {

	private static final int ANIM_TIME = 5;
	/** Pixels each line of a name takes in the index, and the room the icon (left) and the read mark (right) leave. */
	private static final int LINE_HEIGHT = 11;
	private static final int NAME_X = 12;
	private static final int MARK_ROOM = 8;

	private final GuiBook parent;
	private final BookEntry entry;
	private float timeHovered;

	public GuiButtonEntry(GuiBook parent, int x, int y, BookEntry entry, Button.OnPress onPress) {
		super(x, y, GuiBook.PAGE_WIDTH, entryHeight(entry), entry.getName(), onPress, DEFAULT_NARRATION);
		this.parent = parent;
		this.entry = entry;
	}

	/** How many index slots (lines of {@link #LINE_HEIGHT}) this entry takes: two when its name does not fit on one line. */
	public static int slotsFor(BookEntry entry) {
		if (entry.isLocked()) {
			return 1;
		}
		return Minecraft.getInstance().font.width(entry.getName().withStyle(entry.getBook().getFontStyle())) > nameWidth() ? 2 : 1;
	}

	private static int entryHeight(BookEntry entry) {
		return slotsFor(entry) * LINE_HEIGHT - 1;
	}

	private static int nameWidth() {
		return GuiBook.PAGE_WIDTH - NAME_X - MARK_ROOM;
	}

	@Override
	protected void renderWidget(GuiGraphics graphics, int mouseX, int mouseY, float partialTicks) {
		if (!active) {
			return;
		}
		if (isHoveredOrFocused()) {
			timeHovered = Math.min(ANIM_TIME, timeHovered + ClientTicker.delta);
		} else {
			timeHovered = Math.max(0, timeHovered - ClientTicker.delta);
		}

		float time = Math.max(0, Math.min(ANIM_TIME, timeHovered + (isHoveredOrFocused() ? partialTicks : -partialTicks)));
		float widthFract = time / ANIM_TIME;
		boolean locked = entry.isLocked();

		graphics.pose().scale(0.5F, 0.5F, 0.5F);
		graphics.fill(getX() * 2, getY() * 2, (getX() + (int) ((float) width * widthFract)) * 2, (getY() + height) * 2, 0x22000000);
		RenderSystem.enableBlend();

		if (locked) {
			graphics.setColor(1F, 1F, 1F, 0.7F);
			GuiBook.drawLock(graphics, parent.book, getX() * 2 + 2, getY() * 2 + 2);
		} else {
			entry.getIcon().render(graphics, getX() * 2 + 2, getY() * 2 + 2);
		}

		graphics.pose().scale(2F, 2F, 2F);

		MutableComponent name;
		if (locked) {
			name = Component.translatable("vellumli.gui.lexicon.locked");
		} else {
			name = entry.getName();
			if (entry.isPriority()) {
				name = name.withStyle(ChatFormatting.ITALIC);
			}
		}

		name = name.withStyle(entry.getBook().getFontStyle());
		List<FormattedCharSequence> lines = Minecraft.getInstance().font.split(name, nameWidth());
		int shown = Math.min(lines.size(), slotsFor(entry));
		for (int i = 0; i < shown; i++) {
			graphics.drawString(Minecraft.getInstance().font, lines.get(i), getX() + NAME_X, getY() + i * LINE_HEIGHT, getColor(), false);
		}

		if (!entry.isLocked()) {
			GuiBook.drawMarking(graphics, parent.book, getX() + width - 5, getY() + 1, entry.hashCode(), entry.getReadState());
		}
	}

	private int getColor() {
		if (entry.isSecret()) {
			return 0xAA000000 | (parent.book.textColor & 0x00FFFFFF);
		}
		if (entry.isLocked()) {
			return 0x77000000 | (parent.book.textColor & 0x00FFFFFF);
		}
		return entry.getEntryColor();
	}

	@Override
	public void playDownSound(SoundManager soundHandlerIn) {
		if (entry != null && !entry.isLocked()) {
			GuiBook.playBookFlipSound(parent.book);
		}
	}

	public BookEntry getEntry() {
		return entry;
	}

}
