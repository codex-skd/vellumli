# Changelog — Vellumli


## [1.2.0] - 2026-08-21

### Feature

- **Integración opcional con JEI**: se registra un `ISubtypeInterpreter` para `vellumli:guide_book` basado en el componente `vellumli:book`, de forma que JEI trata el libro de cada mod (p. ej. `workhand_tools:workhand_guide`) como un ingrediente distinto y buscable con su propio nombre, en vez de colapsar todos los libros Vellumli en una única entrada no buscable.

### Fix

- **Eliminado el "Vellumli Demo Book" incluido por defecto**: era contenido de desarrollo/ejemplo (id `vellumli:demo`) que no debía llegar a los jugadores; aparecía en el inventario creativo y en JEI de cualquier partida.

## [1.1.0] - 2026-08-19

### Change

- **Actualización de NeoForge**: actualizado de 26.2.0.45-beta a 26.2.0.57.
- **Nombre de JAR con versión del cargador**: el artefacto ahora se compila como `vellumli-26.2-neoforge-26.2.0.57-1.1.0.jar`.
- **Documentación del workflow**: actualizada `docs/WORKFLOW_VELLUMLI_26-2.md` para reflejar la nueva rama de trabajo.

## [1.0.2] - 2026-08-18

### Change

- **Actualización de NeoForge**: actualizado de 26.2.0.37-beta a 26.2.0.45-beta.
- **Nombre de JAR con versión del cargador**: el artefacto ahora se compila como `vellumli-26.2-neoforge-26.2.0.45-beta-1.0.2.jar`.
- **Documentación del workflow**: actualizada `docs/WORKFLOW_VELLUMLI_26-2.md` para reflejar la nueva rama de trabajo.


## [1.0.1] - 2026-08-12

### Change

- **Nombre de JAR con versión del cargador**: el artefacto ahora se compila como `vellumli-26.2-neoforge-26.2.0.37-beta-1.0.1.jar` (se añade la versión de cargador/NeoForge al nombre del archivo). Empaquetado y documentación; sin cambios de funcionalidad.

## [1.0.0] - 2026-08-10

### Release

- **Primera release estable.** Port completo y estable del motor de libros de Patchouli (Vazkii, williewillus) a Vellumli para NeoForge 26.2, bajo el package `com.skd.vellumli` y namespace `vellumli:`. Verificado en cliente y servidor sin errores de carga.

## [0.0.0-beta.3] - 2026-08-05

### Change

- **Recompilado contra NeoForge `26.2.0.37-beta`**: bump de `neo_version` en `gradle.properties` (`26.2.0.32-beta` -> `26.2.0.37-beta`). Verificado con `runServer` (arranque sin errores).

## 0.0.0-beta.2

- **Fix**: resolved all NeoForge 26.1→26.2 API breakage found while porting Patchouli (`Minecraft.screen` → `Minecraft.gui.screen()`, `advancements.criterion` → `advancements.predicates`/`predicates.entity`, `getToastManager()` → `gui.toastManager()`, removed `Minecraft.UNIFORM_FONT` constant usage, dropped the `AccessorMultiBufferSource` mixin targeting a class removed from the 26.2 rendering pipeline). `./gradlew build` now succeeds.
- **Fix**: `build.gradle` packaged `neoforge.mods.toml` unprocessed (wrong template source path inherited from `mod_template`) — the mod would not have loaded at all. Fixed, and verified the mod now loads cleanly in a real client (`./gradlew runClient`), including the data-driven demo book (`BookContentResourceListenerLoader preloaded 9 jsons`).
- **Fix**: JAR naming now follows the workflow convention (`vellumli-26.2-neoforge-<version>.jar`).
- Added the mod icon (`assets/vellumli/icon.png`).

## 0.0.0-beta.1

- **Initial project structure.** Repository scaffolding for Vellumli, a fork of Patchouli (Vazkii, williewillus) for Minecraft 26.2 / NeoForge, licensed CC BY-NC-SA 3.0.
- Project setup only — the in-game book/documentation engine port is still in progress.
