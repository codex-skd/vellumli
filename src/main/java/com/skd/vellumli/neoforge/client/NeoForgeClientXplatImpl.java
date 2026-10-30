package com.skd.vellumli.neoforge.client;

import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.renderer.state.gui.GuiElementRenderState;

import com.skd.vellumli.xplat.IClientXplatAbstractions;

public class NeoForgeClientXplatImpl implements IClientXplatAbstractions {
	@Override
	public void submitGuiElement(GuiGraphicsExtractor graphics, GuiElementRenderState renderState) {
		graphics.submitGuiElementRenderState(renderState);
	}

	// VELLUMLI NOTE (deferred in this beta): Patchouli's renderForMultiblock and the PiP multiblock
	// render helpers were removed because the in-world multiblock visualization and the 3D multiblock
	// page type are not ported yet.
}
