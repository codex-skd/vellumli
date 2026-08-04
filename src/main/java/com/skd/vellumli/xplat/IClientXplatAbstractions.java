package com.skd.vellumli.xplat;

import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.renderer.state.gui.GuiElementRenderState;

import org.jspecify.annotations.Nullable;

import com.skd.vellumli.api.VellumliAPI;

import java.util.ServiceLoader;
import java.util.stream.Collectors;

public interface IClientXplatAbstractions {
	IClientXplatAbstractions INSTANCE = find();

	private static IClientXplatAbstractions find() {
		var providers = ServiceLoader.load(IClientXplatAbstractions.class, IClientXplatAbstractions.class.getClassLoader()).stream().toList();
		if (providers.size() != 1) {
			var names = providers.stream().map(p -> p.type().getName()).collect(Collectors.joining(",", "[", "]"));
			throw new IllegalStateException("There should be exactly one IClientXplatAbstractions implementation on the classpath. Found: " + names);
		} else {
			var provider = providers.getFirst();
			VellumliAPI.LOGGER.debug("Instantiating client xplat impl: {}", provider.type().getName());
			return provider.get();
		}
	}

	// VELLUMLI NOTE (deferred in this beta): Patchouli's renderForMultiblock and the PiP (picture-in-picture)
	// multiblock render helpers were removed because the in-world multiblock visualization and the 3D
	// multiblock page type are not ported yet. They will be restored along with the multiblock machinery.

	void submitGuiElement(GuiGraphicsExtractor graphics, GuiElementRenderState renderState);
}
