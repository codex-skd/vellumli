package com.skd.vellumli.compat.jei;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.ingredients.subtypes.ISubtypeInterpreter;
import mezz.jei.api.ingredients.subtypes.UidContext;
import mezz.jei.api.registration.ISubtypeRegistration;

import com.skd.vellumli.api.VellumliAPI;
import com.skd.vellumli.common.item.VellumliDataComponents;
import com.skd.vellumli.common.item.VellumliItems;

import net.minecraft.resources.Identifier;
import net.minecraft.world.item.ItemStack;

import org.jetbrains.annotations.Nullable;

@JeiPlugin
public class VellumliJeiPlugin implements IModPlugin {
    @Override
    public Identifier getPluginUid() {
        return Identifier.fromNamespaceAndPath(VellumliAPI.MOD_ID, "vellumli_jei_plugin");
    }

    @Override
    public void registerItemSubtypes(ISubtypeRegistration registration) {
        registration.registerSubtypeInterpreter(VellumliItems.BOOK.value(), new BookSubtypes());
    }

    private static class BookSubtypes implements ISubtypeInterpreter<ItemStack> {
        private String apply(ItemStack stack, UidContext context) {
            Identifier bookId = stack.get(VellumliDataComponents.BOOK);
            if (bookId != null) {
                return bookId.toString();
            }
            return "undefined";
        }

        @Nullable
        @Override
        public Object getSubtypeData(ItemStack stack, UidContext context) {
            return apply(stack, context);
        }
    }
}