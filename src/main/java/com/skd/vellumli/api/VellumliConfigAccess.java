package com.skd.vellumli.api;

import java.util.List;

public interface VellumliConfigAccess {
	boolean disableAdvancementLocking();

	List<String> noAdvancementBooks();

	boolean testingMode();

	String inventoryButtonBook();

	boolean useShiftForQuickLookup();

	TextOverflowMode overflowMode();

	int quickLookupTime();

	enum TextOverflowMode {
		OVERFLOW,
		TRUNCATE,
		RESIZE
	}
}
