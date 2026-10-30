package com.skd.vellumli.mixin.client;

import net.minecraft.SystemReport;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.skd.vellumli.client.handler.BookCrashHandler;

@Mixin(SystemReport.class)
public class MixinSystemReport {
	@Inject(at = @At("RETURN"), method = "<init>")
	private void vellumli_addContext(CallbackInfo ci) {
		BookCrashHandler.appendToCrashReport((SystemReport) (Object) this);
	}
}
