package com.skd.vellumli.common.item;

import net.minecraft.core.Holder;
import net.minecraft.world.item.Item;

import com.skd.vellumli.xplat.IXplatAbstractions;

public class VellumliItems {

	public static final Holder<Item> BOOK = IXplatAbstractions.INSTANCE.registerItem("guide_book", ItemModBook::new, p -> p.stacksTo(1));

	public static void init() {}
}
