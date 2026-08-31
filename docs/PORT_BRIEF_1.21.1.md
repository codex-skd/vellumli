# Delegation brief — Vellumli: finish the 1.21.1 / NeoForge 21.1.249 port

## Mission

`vellumli` (our fork of **Patchouli** by Vazkii / williewillus, CC BY-NC-SA 3.0)
currently exists only for Minecraft 26.2. We are creating a **Minecraft 1.21.1 /
NeoForge 21.1.249 / Java 21** version.

The scaffold is already in place. `src/main/java` currently holds the **26.2 fork's
source, unchanged** (151 files, already renamed to the `com.skd.vellumli` identity).
It **does not compile on 1.21.1** — `./gradlew compileJava` reports **~200 errors**,
almost all `cannot find symbol` from **26.2-only Minecraft/NeoForge API** that must
be reverted to its 1.21.1 form.

**The reference that makes this easy**: `temp/ref/patchouli-xplat-java/` +
`temp/ref/patchouli-neoforge-java/` is the **upstream Patchouli 1.21.x source** —
i.e. the exact code the 26.2 fork was ported *up* from. Every broken symbol in our
tree has a working 1.21.1 counterpart in that reference. Your job is mostly:
*find the same file/method in the upstream 1.21.x reference and use its 1.21.1 API*.

## Paths (all inside the work dir — sandbox blocks reads outside `--dir`)

| What | Path |
|---|---|
| **Work dir** (edit here) | `G:/Proyectos/Mods_Minecraft/vellumli/neoforge/1.21.1` |
| Upstream Patchouli 1.21.x — Xplat Java (**1.21.1 API truth**) | `temp/ref/patchouli-xplat-java/vazkii/patchouli/` |
| Upstream Patchouli 1.21.x — NeoForge module Java | `temp/ref/patchouli-neoforge-java/vazkii/patchouli/neoforge/` |
| Upstream Patchouli 1.21.x — resources | `temp/ref/patchouli-xplat-resources/`, `temp/ref/patchouli-neoforge-resources/` |
| The **26.2 fork** — Java (identity + scope reference, NOT API) | `temp/ref/vellumli-26.2-java/com/skd/vellumli/` |
| 26.2 fork — build.gradle | `temp/ref/vellumli-26.2-build.gradle` |

`temp/` is gitignored. Upstream package root is `vazkii.patchouli`; our identity is
`com.skd.vellumli` (main class `Patchouli` -> `Vellumli`, `PatchouliAPI` ->
`VellumliAPI`, `PatchouliConfig` -> `VellumliConfig`, `PatchouliItems` ->
`VellumliItems`, `PatchouliSounds`/`PatchouliDataComponents`/`PatchouliCriteriaTriggers`
/`PatchouliJeiPlugin` -> `Vellumli*`, `StubPatchouliAPI` -> `StubVellumliAPI`;
modid `patchouli` -> `vellumli`; asset/data namespace `patchouli:` -> `vellumli:`;
package `client.jei` -> `compat.jei`).

## Scaffold already done (do NOT redo)

- `src/main/java` = 26.2 fork tree (renamed identity), 151 files.
- `src/main/resources` = 26.2 fork resources, already `vellumli` namespace. The 26.2
  client item-model-definitions dir `assets/vellumli/items/` has been **deleted**
  (1.21.1 uses `models/item/*.json` + an item property, see Task 3).
- `gradle.properties`: MC 1.21.1, range `[1.21.1,1.22)`, neo `21.1.249`,
  `loader_version_range=[1,)`, `mod_version=0.0.0-beta.1`, `mod_license=CC BY-NC-SA 3.0`.
- `build.gradle`: Java 21; `mavenCentral()`; JEI `mezz.jei:jei-1.21.1-*-api:19.21.2.313`
  (compileOnly); `org.jspecify:jspecify:1.0.0` (compileOnly); mixin AP 0.8.7;
  `loader_version_range` in the `generateModMetadata` map.
- `src/main/resources/templates/META-INF/neoforge.mods.toml`: `modLoader="javafml"` +
  `loaderVersion="${loader_version_range}"` added.
- `src/main/resources/vellumli.mixins.json`: already `JAVA_21`, 6 `client.*` entries.

## HARD CONSTRAINTS

1. **Target API = Minecraft 1.21.1 + NeoForge 21.1.249 + Java 21.** The upstream
   Patchouli 1.21.x reference (`temp/ref/patchouli-*-java`) is the API truth. Do NOT
   keep 26.2-only API. Known 26.2 -> 1.21.1 reversions you WILL hit:
   - `net.minecraft.resources.Identifier` -> `net.minecraft.resources.ResourceLocation`
     (constructors: `Identifier.of(...)` / `Identifier.fromNamespaceAndPath(...)` ->
     `ResourceLocation.fromNamespaceAndPath(...)` / `ResourceLocation.parse(...)` /
     `new ResourceLocation(ns, path)` — match upstream).
   - `net.minecraft.client.input.*` (26.2) -> 1.21.1 has no such package; upstream
     `ICustomComponent` uses `com.mojang.blaze3d.platform.InputConstants` / plain
     `int keyCode` — match `temp/ref/patchouli-xplat-java/vazkii/patchouli/api/ICustomComponent.java`.
   - `net.minecraft.client.renderer.item.properties.numeric.*` and the `ItemModel`
     package (26.2 item-model rework) -> 1.21.1 uses
     `net.minecraft.client.renderer.item.ItemProperties.register(Item, ResourceLocation, ClampedItemPropertyFunction)`.
     `BookCompletionModelProperty` (26.2) should become the 1.21.1 registration in
     `VellumliClient` / client init exactly as upstream
     `temp/ref/patchouli-xplat-java/vazkii/patchouli/client/base/ClientTicker.java` /
     wherever upstream registers the `completion` property (search upstream for
     `"completion"` / `ItemProperties`).
   - `BookModel` (`client/base/BookModel.java`) — upstream's 1.21.1 equivalent may be
     absent (26.2 fork's `BookModel` is a 26.2 `ItemModel` impl). If upstream has no
     such class, the `models/item/book_completion.json` + `ItemProperties` path
     replaces it — delete `BookModel` / `BookCompletionModelProperty` and wire the
     property the upstream 1.21.x way. Confirm against upstream.
   - Registration / codec / `DataComponent` / payload APIs: use the 1.21.1 form from
     the matching upstream file.
   - `GuiGraphics`, tooltip, `Font`, key-handling, `Screen` hooks: 1.21.1 signatures
     per upstream.
2. **Match the 26.2 fork's FILE SET exactly.** Do not add back files the 26.2 fork
   removed (e.g. the `common/multiblock/*` implementations, `MixinLevelRenderer`,
   `AccessorSmithing*Recipe`, `NeoForgeClientInitializer`, `NeoForgeModInitializer`).
   Do not delete files the 26.2 fork kept (the `api` multiblock interfaces/stubs —
   `IMultiblock`, `api/stub/StubMultiblock` — STAY; just make them compile against
   1.21.1 types). The only deletions allowed are 26.2-only shim classes that have no
   1.21.1 role once their API is reverted (e.g. `BookModel` /
   `BookCompletionModelProperty` if the upstream property-registration path replaces
   them) — note each such deletion in the report.
3. **Do NOT run git or gradle.** The operator builds and verifies.
4. **License headers**: preserve verbatim. Vellumli is CC BY-NC-SA 3.0 (fork of
   Patchouli). Do not change `Patchouli` in license headers / attribution comments.
5. **Do NOT bump any dependency or the NeoForge version.** JEI stays `19.21.2.313`,
   jspecify `1.0.0`, mixin `0.8.7`, NeoForge `21.1.249`.
6. All code / comments / your report: **English**.

## TASK A — make `src/main/java` compile on 1.21.1 (~200 errors)

Work package by package (`api/`, `api/stub/`, `client/base/`, `client/book/**`,
`client/gui/`, `client/handler/`, `common/**`, `mixin/**`, `network/`,
`neoforge/**`, `compat/jei/`, `xplat/`). For each failing symbol:

1. Open the **same-named file** under `temp/ref/patchouli-xplat-java/` (or
   `patchouli-neoforge-java/` for `neoforge/**`). It is the 1.21.1 version of that
   exact code.
2. Apply the 1.21.1 API it uses, keeping our `com.skd.vellumli` identity renames and
   any behavioural changes the 26.2 fork intentionally made (diff against
   `temp/ref/vellumli-26.2-java` when in doubt about whether a line is a fork change
   or a 26.2-API change — fork changes stay, 26.2-API changes revert).
3. If a whole 26.2-fork file has no upstream counterpart and no 1.21.1 role, delete
   it and fix references (report it).

## TASK B — resources & metadata

1. `src/main/resources/assets/vellumli/models/item/book_completion.json` already
   exists (classic `overrides` + `predicate:{completion:N}` form). Make sure the
   Java side registers a `completion` `ClampedItemPropertyFunction` on the guide-book
   item (upstream 1.21.x does this — copy that call, renamed). Remove any leftover
   reference to the deleted `assets/vellumli/items/` dir.
2. `src/main/resources/META-INF/services/` — the two SPI files already name
   `com.skd.vellumli.neoforge.*` impls. Verify those impl classes still exist and
   still implement `com.skd.vellumli.xplat.IXplatAbstractions` /
   `IClientXplatAbstractions` after Task A.
3. `vellumli.mixins.json` — the 6 `client.*` mixins must match the files in
   `src/main/java/com/skd/vellumli/mixin/client/`. If Task A drops/renames a mixin,
   update this list. `compatibilityLevel` stays `JAVA_21`.
4. `pack.mcmeta` — match upstream Patchouli 1.21.x's `pack_format` (check
   `temp/ref/patchouli-xplat-resources/pack.mcmeta`).
5. `neoforge.mods.toml` (template): keep deps as they are (neoforge + minecraft
   required; no others). `modLoader`/`loaderVersion` already present.

## Deliverable

1. Tasks A/B applied under `src/`.
2. `src/main/java` correct for `./gradlew build` on NeoForge 21.1.249 by inspection.
3. `docs/PORT_REPORT_1.21.1.md` (English): every file modified / deleted with the
   reason; every 26.2 -> 1.21.1 API reversion pattern you applied; anything where
   you guessed at the 1.21.1 API; any 26.2 feature/file intentionally dropped.

Work only inside `G:/Proyectos/Mods_Minecraft/vellumli/neoforge/1.21.1`.
