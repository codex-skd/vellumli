# Vellumli (1.21.1) — Changelog

Branch `minecraft/1.21.1/neoforge-21.1.249/production`. History independent of the 26.2 branch.

## [Unreleased]

## [1.0.2] - 2026-10-09

Feature release for **Minecraft 1.21.1 / NeoForge 21.1.249**.

### Added

- **Two-line entries in the index.** An entry whose name does not fit on one line is now drawn on two (it takes two slots of the page), and the index paginates by slots instead of by entry count, so long chapter names no longer run off the page.
- **`strip_entry_numbering` (book.json, default `false`).** When `true`, the header on an entry's own page drops the numbering the index shows (for example `  - II. Phase 2: First search` becomes `Phase 2: First search`).

## [1.0.1] - 2026-10-08

Fix release for **Minecraft 1.21.1 / NeoForge 21.1.249**.

### Added

- Public documentation wiki at <https://github.com/codex-skd/vellumli/wiki> (getting started,
  book.json, categories and entries, page types, text formatting, templates, API with per-version
  differences, configuration, migrating from Patchouli). Adapted from Patchouli's documentation
  under CC BY-NC-SA 3.0.

### Fixed

- A long entry name on the first page of an entry ran past the page edge. It now wraps to two
  centred lines (ellipsis if it still does not fit), and the separator and body text move down
  one line. Single-line titles render exactly as before.
- Leftover `patchouli.gui.lexicon.*` translation keys in the Java code (shapeless recipe tooltip,
  entity loading error, related chapters, quest objective/complete/mark buttons, "Added by")
  showed as raw keys in game; they now use the `vellumli.gui.lexicon.*` keys.
- `en_us`: added the missing `button.visualize`, `button.visualize.info`, `multiblock_bookmark`
  and `visualize_letter` strings.
- `es_es`: "Shapeless" was translated as "Informe"; now "Sin forma".
- The in-game book editor help linked to the old Patchouli wiki (and to a broken URL in `cs_cz`);
  it now links to the Vellumli wiki "Text Formatting" page in all 12 languages.
- Crash report section label renamed from "Patchouli open book context" to "Vellumli open book
  context".

## [1.0.0] - 2026-09-09

First stable release for **Minecraft 1.21.1 / NeoForge 21.1.249** (Java 21). Consolidates the
`0.0.0-beta.1` → `0.0.0-beta.2` line with no further code changes. This build has been running in
the *(Develop) Mystical Realms* modded-server pack (it is a guidebook dependency for other
1.21.1 mods).

### Summary of the beta line

- **beta.1** — initial port by **re-forking** the upstream Patchouli 1.21.x sources
  (Vazkii / williewillus, CC BY-NC-SA 3.0), flattened to a single NeoForge module and rebranded
  to the Vellumli identity (package `vazkii.patchouli` → `com.skd.vellumli`, modid `patchouli` →
  `vellumli`). Feature parity with the 26.2 line: the data-driven book engine, all built-in page
  types, custom components and templates, the full book GUI, advancement gating, and the JEI
  subtype interpreter. The multiblock preview system is not included (matches the 26.2 scope; the
  `api` stubs are kept for source compatibility). 26.2 → 1.21.1 API reversions:
  `Identifier` → `ResourceLocation`, `GuiGraphicsExtractor` → `GuiGraphics`, `extractRenderState()`
  → `render()`, `pushMatrix()/popMatrix()` → `pushPose()/popPose()`, the `completion` model
  predicate re-registered via `ItemProperties.register()`, `BookModel` reworked to the 1.21.1
  baked-model form.
- **beta.2** — completed the Spanish (`es_es`) locale (13 missing keys: config-screen labels,
  the two networking failure messages, the "toggle mock header" button).

### Notes

- No code change relative to `0.0.0-beta.2`. Verified: `./gradlew clean build` is green;
  `./gradlew runServer` reaches `Done` with both server-side accessor mixins applied.
- Same CurseForge project as the 26.2 line (`1638492`); pick the file that matches your Minecraft
  version. Dependency-free.

## [0.0.0-beta.2] - 2026-09-08

### Fixed

- **Spanish (`es_es`) locale**: added the 13 keys present in `en_us` but missing from `es_es`
  — the config-screen labels (`vellumli.configuration.*`), the two networking failure messages
  (`open_book.failed`, `reload_contents.failed`) and the lexicon "toggle mock header" button.
  Values from the Mystical Realms Translation & Fixes resource-pack QA pass, moved here so they
  ship with the mod. No code change.

## [0.0.0-beta.1] - 2026-09-01

### Added

- **Initial port to Minecraft 1.21.1 / NeoForge 21.1.249** (Java 21). Strategy: **re-fork**
  from the upstream Patchouli 1.21.x sources (Vazkii / williewillus, CC BY-NC-SA 3.0),
  flattened to a single NeoForge module and rebranded to the Vellumli identity — carrying
  the 26.2 line's scope, not a back-port of the 26.2 fork.
- Feature parity with the 26.2 line: the data-driven book engine, all built-in page types
  (text, crafting / smelting / smithing / blasting / campfire, image, spotlight, entity,
  relations, link, quest), custom components and templates, book GUI (landing, categories,
  search, bookmarks, history), advancement gating, and the JEI subtype interpreter so each
  mod's book is a distinct searchable ingredient.

### Technical

- Package `vazkii.patchouli` → `com.skd.vellumli`; modid `patchouli` → `vellumli`; classes
  `Patchouli*` → `Vellumli*` (`VellumliAPI`, `VellumliConfig`, `VellumliItems`,
  `VellumliSounds`, `VellumliCriteriaTriggers`, `VellumliDataComponents`, `VellumliJeiPlugin`,
  `StubVellumliAPI`); `client.jei` package → `compat.jei`; asset/data namespace
  `patchouli:` → `vellumli:`.
- Delegated bulk API reversion 26.2 → 1.21.1 (opencode-go/mimo-v2.5): ~200 compile errors,
  overwhelmingly `Identifier` → `ResourceLocation`, `GuiGraphicsExtractor` → `GuiGraphics`,
  `extractRenderState()` → `render()`, `pushMatrix()/popMatrix()` → `pushPose()/popPose()`,
  using the upstream Patchouli 1.21.x source as the exact 1.21.1 reference. Operator recovery:
  restored the two `AccessorSmithing*Recipe` mixins from upstream (needed on 1.21.1), removed
  the orphaned `ClientRecipes` and three unused `NeoForgeXplatImpl` methods, dropped the
  vestigial `@EventBusSubscriber` on the main class (fatal on NeoForge 21.1 with no
  `@SubscribeEvent` methods), fixed a missing `Button` import.
- `BookCompletionModelProperty` (26.2 `RangeSelectItemModelProperty`) removed; the guide-book
  `completion` model predicate is registered the 1.21.1 way via `ItemProperties.register()`.
  `BookModel` reworked from the 26.2 `ItemModel` to the 1.21.1 baked-model form.
- Multiblock preview system: not included (matches the 26.2 fork's scope; the `api`
  multiblock interfaces/stubs are kept for source compatibility).
- Build: `net.neoforged.moddev` template retargeted to NeoForge 21.1.249 / Java 21;
  `modLoader`/`loaderVersion` in `neoforge.mods.toml`; `org.jspecify:jspecify:1.0.0` +
  `mezz.jei:jei-1.21.1-*-api:19.21.2.313` as `compileOnly`; mixin AP left to moddev.
- Verified: `./gradlew build` OK; `./gradlew runServer` reaches `Done`, `vellumli` loads,
  both server-side accessor mixins apply, no errors.
- Port detail: `docs/PORT_REPORT_1.21.1.md`.
