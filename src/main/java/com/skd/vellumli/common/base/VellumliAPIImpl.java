package com.skd.vellumli.common.base;

import com.google.common.base.Preconditions;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;

import org.apache.commons.io.IOUtils;

import com.skd.vellumli.api.*;
import com.skd.vellumli.api.VellumliAPI.IVellumliAPI;
import com.skd.vellumli.client.book.BookContents;
import com.skd.vellumli.client.book.ClientBookRegistry;
import com.skd.vellumli.client.book.gui.GuiBook;
import com.skd.vellumli.client.book.template.BookTemplate;
import com.skd.vellumli.client.book.text.BookTextParser;
import com.skd.vellumli.common.advancement.BookOpenTrigger;
import com.skd.vellumli.common.book.Book;
import com.skd.vellumli.common.book.BookRegistry;
import com.skd.vellumli.common.item.ItemModBook;
import com.skd.vellumli.xplat.IXplatAbstractions;

import org.jetbrains.annotations.NotNull;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class VellumliAPIImpl implements IVellumliAPI {

	private static void assertPhysicalClient() {
		Preconditions.checkState(
				IXplatAbstractions.INSTANCE.isPhysicalClient(),
				"Not on the physical client"
		);
	}

	@Override
	public boolean isStub() {
		return false;
	}

	@NotNull
	@Override
	public VellumliConfigAccess getConfig() {
		return VellumliConfig.get();
	}

	@Override
	public void setConfigFlag(String flag, boolean value) {
		VellumliConfig.setFlag(flag, value);
	}

	@Override
	public boolean getConfigFlag(String flag) {
		return VellumliConfig.getConfigFlag(flag);
	}

	@Override
	public void openBookGUI(ServerPlayer player, ResourceLocation book) {
		BookOpenTrigger.INSTANCE.trigger(player, book);
		IXplatAbstractions.INSTANCE.sendOpenBookGui(player, book, null, 0);
	}

	@Override
	public void openBookEntry(ServerPlayer player, ResourceLocation book, ResourceLocation entry, int page) {
		BookOpenTrigger.INSTANCE.trigger(player, book, entry, page);
		IXplatAbstractions.INSTANCE.sendOpenBookGui(player, book, entry, page);
	}

	@Override
	public void openBookGUI(ResourceLocation book) {
		assertPhysicalClient();
		ClientBookRegistry.INSTANCE.displayBookGui(book, null, 0);
	}

	@Override
	public void openBookEntry(ResourceLocation book, ResourceLocation entry, int page) {
		assertPhysicalClient();
		ClientBookRegistry.INSTANCE.displayBookGui(book, entry, page);
	}

	@Override
	public ResourceLocation getOpenBookGui() {
		assertPhysicalClient();
		Screen gui = Minecraft.getInstance().screen;
		if (gui instanceof GuiBook) {
			return ((GuiBook) gui).book.id;
		}
		return null;
	}

	@NotNull
	@Override
	public Component getSubtitle(@NotNull ResourceLocation bookId) {
		Book book = BookRegistry.INSTANCE.books.get(bookId);
		if (book == null) {
			throw new IllegalArgumentException("Book not found: " + bookId);
		}
		return book.getSubtitle();
	}

	@Override
	public void registerCommand(String name, Function<IStyleStack, String> command) {
		assertPhysicalClient();
		BookTextParser.register(command::apply, name);
	}

	@Override
	public void registerFunction(String name, BiFunction<String, IStyleStack, String> function) {
		assertPhysicalClient();
		BookTextParser.register(function::apply, name);
	}

	@Override
	public ItemStack getBookStack(ResourceLocation book) {
		return ItemModBook.forBook(book);
	}

	@Override
	public void registerTemplateAsBuiltin(ResourceLocation res, Supplier<InputStream> streamProvider) {
		assertPhysicalClient();
		InputStream testStream = streamProvider.get();
		if (testStream == null) {
			throw new NullPointerException("Stream provider can't return a null stream");
		}
		IOUtils.closeQuietly(testStream);

		Supplier<BookTemplate> prev = BookContents.addonTemplates.put(res, () -> {
			InputStream stream = streamProvider.get();
			InputStreamReader reader = new InputStreamReader(stream);
			return ClientBookRegistry.INSTANCE.gson.fromJson(reader, BookTemplate.class);
		});

		if (prev != null) {
			throw new IllegalArgumentException("Template " + res + " is already registered");
		}
	}

	// ================================================================================================
	// Multiblock API.
	// VELLUMLI NOTE (deferred in this beta): the in-world multiblock visualization and the 3D
	// multiblock page type are NOT ported yet. The data model (DenseMultiblock/SparseMultiblock/
	// StateMatcher/StringStateMatcher/MultiblockRegistry) and the visualization handler were cut.
	// For API compatibility the methods below keep their signatures but return no-op stubs; they
	// should be reimplemented when the multiblock machinery is ported in a later beta.
	// ================================================================================================

	@Override
	public IMultiblock getMultiblock(ResourceLocation res) {
		return null;
	}

	@Override
	public IMultiblock registerMultiblock(ResourceLocation res, IMultiblock mb) {
		return mb;
	}

	@Override
	public IMultiblock getCurrentMultiblock() {
		return null;
	}

	@Override
	public void showMultiblock(@NotNull IMultiblock multiblock, @NotNull Component displayName, @NotNull BlockPos center, @NotNull Rotation rotation) {
		// Not implemented: multiblock visualization is deferred.
	}

	@Override
	public void clearMultiblock() {
		// Not implemented: multiblock visualization is deferred.
	}

	@Override
	public IMultiblock makeMultiblock(String[][] pattern, Object... targets) {
		return null;
	}

	@Override
	public IMultiblock makeSparseMultiblock(Map<BlockPos, IStateMatcher> positions) {
		return null;
	}

	@Override
	public IStateMatcher predicateMatcher(BlockState display, Predicate<BlockState> predicate) {
		return null;
	}

	@Override
	public IStateMatcher predicateMatcher(Block display, Predicate<BlockState> predicate) {
		return null;
	}

	@Override
	public IStateMatcher stateMatcher(BlockState state) {
		return null;
	}

	@Override
	public IStateMatcher propertyMatcher(BlockState state, Property<?>... properties) {
		return null;
	}

	@Override
	public IStateMatcher looseBlockMatcher(Block block) {
		return null;
	}

	@Override
	public IStateMatcher strictBlockMatcher(Block block) {
		return null;
	}

	@Override
	public IStateMatcher displayOnlyMatcher(BlockState state) {
		return null;
	}

	@Override
	public IStateMatcher displayOnlyMatcher(Block block) {
		return null;
	}

	@NotNull
	@Override
	public IStateMatcher tagMatcher(@NotNull TagKey<Block> tag) {
		/* TODO deduplicate with StringStateMatcher's version. This one is okay with
		* tags that don't exist but that one validates that the tag exists.
		*/
		return new IStateMatcher() {
			@NotNull
			@Override
			public BlockState getDisplayedState(long ticks) {
				return BuiltInRegistries.BLOCK.getTag(tag).map(n -> {
					int idx = (int) ((ticks / 20) % n.size());
					return n.get(idx).value().defaultBlockState();
				}).orElse(Blocks.BEDROCK.defaultBlockState());
			}

			@NotNull
			@Override
			public TriPredicate<BlockGetter, BlockPos, BlockState> getStatePredicate() {
				return (w, p, s) -> s.is(tag);
			}
		};
	}

	@Override
	public IStateMatcher airMatcher() {
		return null;
	}

	@Override
	public IStateMatcher anyMatcher() {
		return null;
	}

}
