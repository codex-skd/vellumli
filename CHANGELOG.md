# Changelog — Vellumli

## 0.0.0-beta.2

- **Fix**: resolved all NeoForge 26.1→26.2 API breakage found while porting Patchouli (`Minecraft.screen` → `Minecraft.gui.screen()`, `advancements.criterion` → `advancements.predicates`/`predicates.entity`, `getToastManager()` → `gui.toastManager()`, removed `Minecraft.UNIFORM_FONT` constant usage, dropped the `AccessorMultiBufferSource` mixin targeting a class removed from the 26.2 rendering pipeline). `./gradlew build` now succeeds.
- **Fix**: `build.gradle` packaged `neoforge.mods.toml` unprocessed (wrong template source path inherited from `mod_template`) — the mod would not have loaded at all. Fixed, and verified the mod now loads cleanly in a real client (`./gradlew runClient`), including the data-driven demo book (`BookContentResourceListenerLoader preloaded 9 jsons`).
- **Fix**: JAR naming now follows the workflow convention (`vellumli-26.2-neoforge-<version>.jar`).
- Added the mod icon (`assets/vellumli/icon.png`).

## 0.0.0-beta.1

- **Initial project structure.** Repository scaffolding for Vellumli, a fork of Patchouli (Vazkii, williewillus) for Minecraft 26.2 / NeoForge, licensed CC BY-NC-SA 3.0.
- Project setup only — the in-game book/documentation engine port is still in progress.---

## [0.0.0-beta.3] - 2026-08-05

### Change

- **Recompilado contra NeoForge `26.2.0.37-beta`**: bump de `neo_version` en `gradle.properties` (`26.2.0.32-beta` -> `26.2.0.37-beta`). Verificado con `runServer` (arranque sin errores).

## [angelog — Vellumli

## 0.0.0-beta.2

- **Fix**: resolved all NeoForge 26.1→26.2 API breakage found while porting Patchouli (`Minecraft.screen` → `Minecraft.gui.screen()`, `advancements.criterion` → `advancements.predicates`/`predicates.entity`, `getToastManager()` → `gui.toastManager()`, removed `Minecraft.UNIFORM_FONT` constant usage, dropped the `AccessorMultiBufferSource` mixin targeting a class removed from the 26.2 rendering pipeline). `./gradlew build` now succeeds.
- **Fix**: `build.gradle` packaged `neoforge.mods.toml` unprocessed (wrong template source path inherited from `mod_template`) — the mod would not have loaded at all. Fixed, and verified the mod now loads cleanly in a real client (`./gradlew runClient`), including the data-driven demo book (`BookContentResourceListenerLoader preloaded 9 jsons`).
- **Fix**: JAR naming now follows the workflow convention (`vellumli-26.2-neoforge-<version>.jar`).
- Added the mod icon (`assets/vellumli/icon.png`).

## 0.0.0-beta.1

- **Initial project structure.** Repository scaffolding for Vellumli, a fork of Patchouli (Vazkii, williewillus) for Minecraft 26.2 / NeoForge, licensed CC BY-NC-SA 3.0.
- Project setup only — the in-game book/documentation engine port is still in progress.
