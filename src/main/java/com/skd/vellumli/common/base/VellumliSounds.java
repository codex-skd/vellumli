package com.skd.vellumli.common.base;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvent;

import com.skd.vellumli.api.VellumliAPI;

import java.util.function.BiConsumer;

public class VellumliSounds {

	public static final ResourceKey<SoundEvent> BOOK_OPEN = ResourceKey.create(Registries.SOUND_EVENT, Identifier.fromNamespaceAndPath(VellumliAPI.MOD_ID, "book_open"));
	public static final ResourceKey<SoundEvent> BOOK_FLIP = ResourceKey.create(Registries.SOUND_EVENT, Identifier.fromNamespaceAndPath(VellumliAPI.MOD_ID, "book_flip"));

	public static void submitRegistrations(BiConsumer<Identifier, SoundEvent> e) {
		e.accept(BOOK_OPEN.identifier(), SoundEvent.createVariableRangeEvent(BOOK_OPEN.identifier()));
		e.accept(BOOK_FLIP.identifier(), SoundEvent.createVariableRangeEvent(BOOK_FLIP.identifier()));
	}

	public static SoundEvent getSound(Identifier key, ResourceKey<SoundEvent> fallback) {
		return BuiltInRegistries.SOUND_EVENT.getOptional(key).orElseGet(() -> BuiltInRegistries.SOUND_EVENT.getValue(fallback));
	}

}
