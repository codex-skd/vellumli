# Vellumli (1.21.1) — Changelog

Branch `minecraft/1.21.1/neoforge-21.1.249/production`. History independent of the 26.2 branch.

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
