package com.skd.vellumli.client.book.template;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import net.minecraft.core.HolderLookup;

import com.skd.vellumli.api.IVariable;
import com.skd.vellumli.api.IVariableProvider;

public final class JsonVariableWrapper implements IVariableProvider {

	private final JsonObject source;

	public JsonVariableWrapper(JsonObject source) {
		this.source = source;
	}

	@Override
	public IVariable get(String key, HolderLookup.Provider registries) {
		JsonElement prim = source.get(key);
		if (prim == null) {
			throw new IllegalArgumentException("Attempted to get variable " + key + " when it's not present");
		}

		return IVariable.wrap(prim, registries);
	}

	@Override
	public boolean has(String key) {
		return source.has(key);
	}

}
