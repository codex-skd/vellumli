package com.skd.vellumli.common.item;

import net.minecraft.ChatFormatting;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import com.skd.vellumli.api.VellumliAPI;
import com.skd.vellumli.client.book.BookEntry;
import com.skd.vellumli.common.base.VellumliSounds;
import com.skd.vellumli.common.book.Book;
import com.skd.vellumli.common.book.BookRegistry;

import java.util.List;

public class ItemModBook extends Item {

	public ItemModBook() {
		super(new Item.Properties().stacksTo(1));
	}

	public static float getCompletion(ItemStack stack) {
		Book book = getBook(stack);
		float progression = 0F; // default incomplete

		if (book != null) {
			int totalEntries = 0;
			int unlockedEntries = 0;

			for (BookEntry entry : book.getContents().entries.values()) {
				if (!entry.isSecret()) {
					totalEntries++;
					if (!entry.isLocked()) {
						unlockedEntries++;
					}
				}
			}

			progression = ((float) unlockedEntries) / Math.max(1f, (float) totalEntries);
		}

		return progression;
	}

	public static ItemStack forBook(Book book) {
		return forBook(book.id);
	}

	public static ItemStack forBook(ResourceLocation book) {
		ItemStack stack = new ItemStack(VellumliItems.BOOK);

		stack.set(VellumliDataComponents.BOOK, book);

		return stack;
	}

	// SoftImplement IForgeItem
	public String getCreatorModId(ItemStack stack) {
		var book = getBook(stack);
		if (book != null) {
			return book.owner.getId();
		}
		return BuiltInRegistries.ITEM.getKey(this).getNamespace();
	}

	public static Book getBook(ItemStack stack) {
		ResourceLocation res = getBookId(stack);
		if (res == null) {
			return null;
		}
		return BookRegistry.INSTANCE.books.get(res);
	}

	private static ResourceLocation getBookId(ItemStack stack) {
		if (!stack.has(VellumliDataComponents.BOOK)) {
			return null;
		}

		return stack.get(VellumliDataComponents.BOOK);
	}

	@Override
	public Component getName(ItemStack stack) {
		Book book = getBook(stack);
		if (book != null) {
			return Component.translatable(book.name);
		}

		return super.getName(stack);
	}

	@Override
	public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltip, TooltipFlag flagIn) {
		super.appendHoverText(stack, context, tooltip, flagIn);

		ResourceLocation rl = getBookId(stack);
		if (flagIn.isAdvanced()) {
			tooltip.add(Component.literal("Book ID: " + rl).withStyle(ChatFormatting.GRAY));
		}

		Book book = getBook(stack);
		if (book != null && !book.getContents().isErrored()) {
			tooltip.add(book.getSubtitle().withStyle(ChatFormatting.GRAY));
		} else if (book == null) {
			if (rl == null) {
				tooltip.add(Component.translatable("item.vellumli.guide_book.undefined")
						.withStyle(ChatFormatting.DARK_GRAY));
			} else {
				tooltip.add(Component.translatable("item.vellumli.guide_book.invalid", rl)
						.withStyle(ChatFormatting.DARK_GRAY));
			}
		}
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level worldIn, Player playerIn, InteractionHand handIn) {
		ItemStack stack = playerIn.getItemInHand(handIn);
		Book book = getBook(stack);
		if (book == null) {
			return new InteractionResultHolder<>(InteractionResult.FAIL, stack);
		}

		if (playerIn instanceof ServerPlayer) {
			VellumliAPI.get().openBookGUI((ServerPlayer) playerIn, book.id);

			// This plays the sound to others nearby, playing to the actual opening player handled from the packet
			SoundEvent sfx = VellumliSounds.getSound(book.openSound, VellumliSounds.BOOK_OPEN);
			playerIn.playSound(sfx, 1F, (float) (0.7 + Math.random() * 0.4));
		}

		return new InteractionResultHolder<>(InteractionResult.SUCCESS, stack);
	}

}
