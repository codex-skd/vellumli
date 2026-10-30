package com.skd.vellumli.common.book;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonObject;
import com.mojang.serialization.Dynamic;
import com.mojang.serialization.JsonOps;

import net.minecraft.resources.Identifier;
import net.minecraft.world.level.Level;

import com.skd.vellumli.api.VellumliAPI;
import com.skd.vellumli.client.book.ClientBookRegistry;
import com.skd.vellumli.common.base.VellumliConfig;
import com.skd.vellumli.xplat.IXplatAbstractions;
import com.skd.vellumli.xplat.XplatModContainer;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class BookRegistry {

	public static final BookRegistry INSTANCE = new BookRegistry();
	public static final String BOOKS_LOCATION = VellumliAPI.MOD_ID + "_books";

	public final Map<Identifier, Book> books = new HashMap<>();
	public static final Gson GSON = new GsonBuilder()
			.registerTypeAdapter(Identifier.class, (JsonDeserializer<Identifier>) (json, _, _) -> Identifier.CODEC.parse(new Dynamic<>(JsonOps.INSTANCE, json)).getOrThrow())
			.create();

	private BookRegistry() {}

	public void init() {
		Collection<XplatModContainer> mods = IXplatAbstractions.INSTANCE.getAllMods();

		for (XplatModContainer mod : mods) {
			String id = mod.getId();
			if (mod.getId().equals("minecraft")) {
				continue;
			}

			mod.visit(String.format("data/%s/%s", id, BOOKS_LOCATION), (path, file) -> {
				if (!path.getFileName().toString().equals("book.json")) {
					return;
				}

				String fileStr = path.toString().replaceAll("\\\\", "/");
				String relPath = fileStr.substring(fileStr.indexOf(BOOKS_LOCATION) + BOOKS_LOCATION.length() + 1);
				String bookName = relPath.substring(0, relPath.indexOf("/"));

				if (bookName.contains("/")) {
					VellumliAPI.LOGGER.warn("Ignored book.json @ {}", path);
					return;
				}

				Identifier bookId = Identifier.fromNamespaceAndPath(id, bookName);
				try (InputStream stream = file.get()) {
					loadBook(mod, bookId, stream, false);
				} catch (Exception e) {
					VellumliAPI.LOGGER.error("Failed to load book {} defined by mod {}, skipping", bookId, mod.getId(), e);
				}
			});
		}

		BookFolderLoader.findBooks();
		IXplatAbstractions.INSTANCE.signalBooksLoaded();
	}

	public void loadBook(XplatModContainer mod, Identifier res, InputStream stream, boolean external) {
		Reader reader = new BufferedReader(new InputStreamReader(stream, StandardCharsets.UTF_8));
		var tree = GSON.fromJson(reader, JsonObject.class);
		books.put(res, new Book(tree, mod, res, external));
	}

	/**
	 * Must only be called on client
	 */
	public void reloadContents(Level level) {
		VellumliConfig.reloadBuiltinFlags();
		for (Book book : books.values()) {
			book.reloadContents(level, false);
		}
		ClientBookRegistry.INSTANCE.reloadLocks(false);
	}
}
