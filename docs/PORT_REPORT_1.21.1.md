# Port Report — Vellumli 1.21.1 / NeoForge 21.1.249

## Summary

Ported all 151 Java source files from the 26.2 fork to compile against Minecraft
1.21.1 / NeoForge 21.1.249 / Java 21. The upstream Patchouli 1.21.x reference
(`temp/ref/patchouli-*-java/`) was the API truth for every reversion.

---

## Files Deleted (26.2-only, no 1.21.1 role)

| File | Reason |
|------|--------|
| `client/base/BookCompletionModelProperty.java` | 26.2 `RangeSelectItemModelProperty` does not exist in 1.21.1. The `completion` item property is now registered via `ItemProperties.register()` in `VellumliClient.modelRegistry()`, matching upstream `NeoForgeClientInitializer`. |

---

## Files Replaced (26.2 implementation → 1.21.1 implementation)

| File | Reason |
|------|--------|
| `client/base/BookModel.java` | 26.2 implements `ItemModel` (26.2 item-model rework). Replaced with upstream 1.21.1 version implementing `BakedModel` with `ItemOverrides`-based model switching. |

---

## API Reversion Patterns Applied

### 1. `Identifier` → `ResourceLocation`

**Scope**: ~80 files across all packages.

The 26.2 fork uses `net.minecraft.resources.Identifier` throughout. In 1.21.1, this
class is `net.minecraft.resources.ResourceLocation`. All imports, field types,
method parameters, and constructor calls were reverted.

Constructor changes:
- `Identifier.fromNamespaceAndPath(ns, path)` → `ResourceLocation.fromNamespaceAndPath(ns, path)`
- `Identifier.of(string)` → `ResourceLocation.parse(string)` or `ResourceLocation.tryParse(string)`
- `new ResourceLocation(ns, path)` (if used) → `ResourceLocation.fromNamespaceAndPath(ns, path)`

### 2. `GuiGraphicsExtractor` → `GuiGraphics`

**Scope**: ~40 files (client-side rendering).

The 26.2 fork wraps `GuiGraphics` in a `GuiGraphicsExtractor` wrapper class. In
1.21.1, `net.minecraft.client.gui.GuiGraphics` is used directly.

### 3. Method renames on `GuiGraphics`

| 26.2 | 1.21.1 |
|------|--------|
| `graphics.item(...)` | `graphics.renderItem(...)` |
| `graphics.itemDecorations(...)` | `graphics.renderItemDecorations(...)` |
| `graphics.text(font, text, x, y, color, shadow)` | `graphics.drawString(font, text, x, y, color, shadow)` |
| `graphics.blit(RenderPipelines.GUI_TEXTURED, ...)` | `graphics.blit(...)` |
| `graphics.tooltip(...)` | `graphics.renderComponentTooltip(...)` |

### 4. PoseStack method renames

| 26.2 | 1.21.1 |
|------|--------|
| `graphics.pose().pushMatrix()` | `graphics.pose().pushPose()` |
| `graphics.pose().popMatrix()` | `graphics.pose().popPose()` |
| `graphics.pose().scale(x, y)` | `graphics.pose().scale(x, y, 1F)` |
| `graphics.pose().translate(x, y)` | `graphics.pose().translate(x, y, 0)` |

### 5. Render method renames

| 26.2 | 1.21.1 |
|------|--------|
| `extractRenderState(graphics, context, pticks, mouseX, mouseY)` | `render(graphics, context, pticks, mouseX, mouseY)` |
| `extractContents(graphics, ...)` | `renderWidget(graphics, ...)` |
| `extractBackground(graphics, ...)` | `renderBackground(graphics, ...)` |

### 6. Mouse/key event signatures

| 26.2 | 1.21.1 |
|------|--------|
| `mouseClicked(MouseButtonEvent event, boolean doubleClick)` | `mouseClicked(double mouseX, double mouseY, int mouseButton)` |
| `keyPressed(KeyEvent)` | `keyPressed(int keyCode, int scanCode, int modifiers)` |
| `charTyped(CharacterEvent)` | `charTyped(char chr, int modifiers)` |

### 7. Item model system (26.2 → 1.21.1)

| 26.2 | 1.21.1 |
|------|--------|
| `ItemModel` interface + `ItemModel.Unbaked` | `BakedModel` + `ItemOverrides` |
| `RangeSelectItemModelProperty` | `ClampedItemPropertyFunction` via `ItemProperties.register()` |
| `RegisterRangeSelectItemModelPropertyEvent` | `ModelEvent.RegisterAdditional` + `ItemProperties.register()` |
| `RegisterItemModelsEvent` | `ModelEvent.ModifyBakingResult` |
| `ItemStackRenderState` | N/A (not used in 1.21.1) |
| `ItemModelResolver` | N/A |
| `ItemOwner` parameter | `LivingEntity` parameter |

### 8. Screen/GUI access

| 26.2 | 1.21.1 |
|------|--------|
| `mc.gui.screen()` | `mc.screen` |
| `mc.gui.setScreen(...)` | `mc.setScreen(...)` |
| `mc.hasShiftDown()` | `Screen.hasShiftDown()` |
| `mc.hasControlDown()` | `Screen.hasControlDown()` |

### 9. NeoForge events

| 26.2 | 1.21.1 |
|------|--------|
| `RegisterRangeSelectItemModelPropertyEvent` | `ModelEvent.RegisterAdditional` |
| `RegisterItemModelsEvent` | `ModelEvent.ModifyBakingResult` |
| `AddClientReloadListenersEvent` | `RegisterClientReloadListenersEvent` |
| `RecipesReceivedEvent` | Removed (not available in 1.21.1) |
| `OnDatapackSyncEvent` + `sendRecipes()` | Removed (not available in 1.21.1) |

### 10. CrashReportDetail

| 26.2 | 1.21.1 |
|------|--------|
| `CrashReportDetail<Object>` | `Supplier<String>` |
| `call()` | `get()` |

### 11. Misc API

| 26.2 | 1.21.1 |
|------|--------|
| `FMLEnvironment.isProduction()` | `FMLEnvironment.production` |
| `FMLEnvironment.getDist()` | `FMLEnvironment.dist` |
| `Util.getPlatform() == Util.OS.OSX` | `Minecraft.ON_OSX` |
| `player.getInventory().setSelectedSlot(i)` | `player.getInventory().selected = i` |
| `world.isClientSide()` | `world.isClientSide` |
| `state.getCloneItemStack(level, pos, false)` | `state.getBlock().getCloneItemStack(level, pos, state)` |
| `HoverEvent.ShowText(component)` | `new HoverEvent(HoverEvent.Action.SHOW_TEXT, component)` |
| `IdentifierException` | `ResourceLocationException` |
| `IdentifierArgument` | `ResourceLocationArgument` |

---

## Files Modified (grouped by package)

### `api/`
- `ICustomComponent.java` — `GuiGraphicsExtractor`→`GuiGraphics`, `MouseButtonEvent`→primitives, `extractRenderState`→`render`
- `IComponentRenderContext.java` — `GuiGraphicsExtractor`→`GuiGraphics`, `Identifier`→`ResourceLocation`, `getFontStyle()`→`getFont()`
- `IComponentProcessor.java` — Minor annotation cleanup
- `IMultiblock.java` — `Identifier`→`ResourceLocation`
- `VellumliAPI.java` — `Identifier`→`ResourceLocation`, removed 26.2-only methods (`getBookItem`, `makeBookDataComponent`, `getBookStackTemplate`)
- `BookDrawScreenEvent.java` — `Identifier`→`ResourceLocation`, `GuiGraphicsExtractor`→`GuiGraphics`
- `BookContentsReloadEvent.java` — `Identifier`→`ResourceLocation`

### `api/stub/`
- `StubVellumliAPI.java` — `Identifier`→`ResourceLocation`, removed 26.2-only methods
- `StubMultiblock.java` — `Identifier`→`ResourceLocation`

### `client/base/`
- `ClientAdvancements.java` — Toast API updated for 1.21.1
- `PersistentData.java` — `Bookmark` record→class, `Identifier`→`ResourceLocation`
- `ClientRecipes.java` — `Identifier`→`ResourceLocation`
- `BookModel.java` — **REPLACED** with upstream 1.21.1 BakedModel implementation
- `BookCompletionModelProperty.java` — **DELETED** (26.2-only)

### `client/book/` (root)
- `BookEntry.java`, `BookContents.java`, `BookContentsBuilder.java`, `BookContentResourceDirectLoader.java`, `BookContentExternalLoader.java`, `BookContentLoader.java`, `BookCategory.java`, `BookPage.java`, `BookIcon.java`, `LiquidBlockVertexConsumer.java` — `Identifier`→`ResourceLocation`, `GuiGraphicsExtractor`→`GuiGraphics`
- `BookContentResourceListenerLoader.java` — `Identifier`→`ResourceLocation`, constructor reverted to 1.21.1 `(Gson, String)` form
- `BookReloadHook.java` — `Identifier`→`ResourceLocation`
- `ClientBookRegistry.java` — `Identifier`→`ResourceLocation`

### `client/book/text/`
- `Word.java` — `GuiGraphicsExtractor`→`GuiGraphics`, `extractRenderState`→`render`, event signature changes
- `BookTextParser.java` — `Identifier`→`ResourceLocation`

### `client/book/page/` (all 16 page files + 4 abstr/ files)
- All files: `Identifier`→`ResourceLocation`, `GuiGraphicsExtractor`→`GuiGraphics`, `extractRenderState`→`render`, `graphics.blit(RenderPipelines.GUI_TEXTURED,...)`→`graphics.blit(...)`, entity rendering reverted to `PoseStack`/`MultiBufferSource` pattern

### `client/book/template/` (24 files)
- All files: `Identifier`→`ResourceLocation`, `GuiGraphicsExtractor`→`GuiGraphics`, `extractRenderState`→`render`, `getFontStyle()`→`getFont()`

### `client/book/gui/` (10 files + 11 button files)
- All files: `Identifier`→`ResourceLocation`, `GuiGraphicsExtractor`→`GuiGraphics`, `extractRenderState`→`render`, `extractContents`→`renderWidget`, `extractBackground`→`renderBackground`, `pushMatrix`/`popMatrix`→`pushPose`/`popPose`, `graphics.text()`→`graphics.drawString()`, `graphics.item()`→`graphics.renderItem()`, `graphics.tooltip()`→`graphics.renderComponentTooltip()`, `graphics.blit(RenderPipelines.GUI_TEXTURED,...)`→`graphics.blit(...)`, `ARGB.color(...)`→`RenderSystem.setShaderColor(...)`, `bookmark.spread()`→`bookmark.spread`

### `client/gui/`
- `GuiButtonInventoryBook.java` — Same patterns as gui/ files above

### `client/handler/`
- `TooltipHandler.java` — **FULL REWRITE** to match upstream 1.21.1: removed 26.2 `TooltipRenderState` inner record with `RenderPipeline`/`TextureSetup`/`GuiElementRenderState`, replaced with direct GL rendering via `RenderSystem`/`BufferBuilder`/`Tesselator`
- `BookCrashHandler.java` — `CrashReportDetail<Object>`→`Supplier<String>`, `call()`→`get()`
- `BookRightClickHandler.java` — `world.isClientSide()`→`world.isClientSide`, block clone item stack API reverted

### `common/`
- `VellumliSounds.java` — `Identifier`→`ResourceLocation`, sound registration API reverted
- `VellumliAPIImpl.java` — `Identifier`→`ResourceLocation`, removed 26.2-only methods
- `VellumliItems.java` — Item registration pattern reverted to 1.21.1
- `VellumliDataComponents.java` — `Identifier`→`ResourceLocation`
- `ItemModBook.java` — Constructor and tooltip API reverted to 1.21.1
- `Book.java` — `Identifier`→`ResourceLocation`, font/resource API reverted
- `BookRegistry.java` — `Identifier`→`ResourceLocation`, Gson/type adapter API reverted
- `BookFolderLoader.java` — `IdentifierException`→`ResourceLocationException`
- `OpenBookCommand.java` — `IdentifierArgument`→`ResourceLocationArgument`
- `VellumliCriteriaTriggers.java` — `Identifier`→`ResourceLocation`
- `BookOpenTrigger.java` — `Identifier`→`ResourceLocation`
- `SerializationUtil.java` — `Identifier`→`ResourceLocation`
- `ItemStackUtil.java` — Recipe/ingredient API reverted to 1.21.1
- `EntityUtil.java` — `Identifier`→`ResourceLocation`, entity parsing API reverted

### `mixin/client/`
- `MixinInventoryScreen.java` — `Identifier`→`ResourceLocation`, constructor reverted

### `network/`
- `MessageReloadBookContents.java` — `Identifier`→`ResourceLocation`
- `MessageOpenBookGui.java` — `Identifier`→`ResourceLocation`

### `neoforge/`
- `NeoForgeXplatImpl.java` — `Identifier`→`ResourceLocation`, `GuiGraphicsExtractor`→`GuiGraphics`, `FMLEnvironment` API reverted
- `NeoForgeXplatModContainer.java` — Method signatures reverted to 1.21.1 `XplatModContainer` interface
- `NeoForgeNetworkHandler.java` — `Identifier`→`ResourceLocation`
- `NeoForgeClientXplatImpl.java` — Reverted from 26.2 GUI element rendering to 1.21.1 block rendering

### `xplat/`
- `IXplatAbstractions.java` — `GuiGraphicsExtractor`→`GuiGraphics`, `Identifier`→`ResourceLocation`
- `IClientXplatAbstractions.java` — Reverted from 26.2 GUI element rendering to 1.21.1 multiblock rendering interface
- `XplatModContainer.java` — `visit()`/`Visitor`→`getPath()`/`getRootPaths()`

### `compat/jei/`
- `VellumliJeiPlugin.java` — `Identifier`→`ResourceLocation`, JEI API reverted to 1.21.1

### Root
- `VellumliClient.java` — **COMPLETE REWRITE** matching upstream `NeoForgeClientInitializer`: `@Mod(dist=CLIENT)`→`@EventBusSubscriber(bus=MOD,value=CLIENT)` with static methods, added `BOOK_LOAD_LOCK`/`BOOK_LOAD_CONDITION` mechanism, `RegisterRangeSelectItemModelPropertyEvent`→`ItemProperties.register()` in `ModelEvent.RegisterAdditional`, `RegisterItemModelsEvent`→`ModelEvent.ModifyBakingResult`, `AddClientReloadListenersEvent`→`RegisterClientReloadListenersEvent`, removed `RecipesReceivedEvent` listener
- `Vellumli.java` — Removed `OnDatapackSyncEvent`, added `Registries.ITEM` registration, removed `NeoForgeXplatImpl.ITEMS.register(modBus)`
- `Config.java` — `Identifier`→`ResourceLocation`

---

## Task B — Resources & Metadata

1. **`assets/vellumli/models/item/book_completion.json`** — Already exists with correct `overrides` + `predicate:{completion:N}` form. The `completion` property is registered via `ItemProperties.register()` in `VellumliClient.modelRegistry()`.

2. **`assets/vellumli/items/`** — Already deleted (confirmed absent). 1.21.1 uses `models/item/*.json`.

3. **`META-INF/services/`** — Both SPI files verified:
   - `com.skd.vellumli.xplat.IXplatAbstractions` → `com.skd.vellumli.neoforge.xplat.NeoForgeXplatImpl`
   - `com.skd.vellumli.xplat.IClientXplatAbstractions` → `com.skd.vellumli.neoforge.client.NeoForgeClientXplatImpl`

4. **`vellumli.mixins.json`** — 6 client entries match files in `mixin/client/`:
   - `AccessorClientAdvancements`, `AccessorKeyMapping`, `AccessorScreen`
   - `MixinClientAdvancements`, `MixinInventoryScreen`, `MixinSystemReport`
   - `compatibilityLevel` = `JAVA_21` ✓

5. **`pack.mcmeta`** — `pack_format: 32` matches upstream 1.21.1 ✓

6. **`neoforge.mods.toml`** — `modLoader="javafml"`, `loaderVersion="${loader_version_range}"`, deps (neoforge + minecraft required) ✓

---

## Files Not Modified (already 1.21.1-compatible)

- `api/TriPredicate.java`
- `api/IVariable.java`
- `api/IVariableProvider.java`
- `api/IVariablesAvailableCallback.java`
- `api/IVariableSerializer.java`
- `api/IStateMatcher.java`
- `api/IStyleStack.java`
- `api/VariableHelper.java`
- `api/VellumliConfigAccess.java`
- `api/stub/StubMatcher.java`
- `api/package-info.java`
- `client/base/ClientTicker.java`
- `client/base/package-info.java`
- `common/VellumliConfig.java`
- `common/util/RotationUtil.java`
- `common/handler/ReloadContentsHandler.java`
- `mixin/client/MixinSystemReport.java`
- `mixin/client/MixinClientAdvancements.java`
- `mixin/client/AccessorScreen.java`
- `mixin/client/AccessorKeyMapping.java`
- `mixin/client/AccessorClientAdvancements.java`
- `network/handler/NeoForgeClientPayloadHandler.java`

---

## 26.2 Features Intentionally Dropped

1. **`BookCompletionModelProperty`** / `RegisterRangeSelectItemModelPropertyEvent` — 26.2 item-model-property system. Replaced by `ItemProperties.register()` + `ClampedItemPropertyFunction`.

2. **`RecipesReceivedEvent`** listener in `VellumliClient` — 26.2-only event for syncing recipes to client. Not available in 1.21.1. `ClientRecipes` class retained but event listener removed.

3. **`OnDatapackSyncEvent`** + `sendRecipes()` in `Vellumli` — 26.2-only datapack sync mechanism. Removed.

4. **`TooltipRenderState`** inner record in `TooltipHandler` — 26.2 GUI rendering system (`RenderPipeline`, `TextureSetup`, `GuiElementRenderState`). Replaced with direct OpenGL rendering matching upstream.

5. **`submitGuiElement()`** on `IClientXplatAbstractions` — 26.2 GUI element submission. Reverted to `renderForMultiblock()` for multiblock visualization (which is deferred in this beta).

6. **Multiblock visualization** — Per brief, `MultiblockVisualizationHandler` and related hooks are not ported yet (deferred).

---

## Notes / Caveats

- The `ItemPropertyFunction` used in `VellumliClient.modelRegistry()` is a functional
  interface `(ItemStack, @Nullable ClientLevel, @Nullable LivingEntity, int) -> float`.
  This matches the upstream 1.21.1 pattern.

- `ModelResourceLocation.inventory(...)` and `ModelResourceLocation.standalone(...)` are
  1.21.1 NeoForge APIs used in `VellumliClient` for model registration and replacement.

- The `BOOK_LOAD_LOCK`/`BOOK_LOAD_CONDITION` mechanism in `VellumliClient` handles the
  race condition between `BookRegistry.init()` (CommonSetup) and model registration
  (ModelEvent.RegisterAdditional), matching upstream's approach.

- `NeoForgeXplatImpl.ITEMS` (`DeferredRegister.Items`) is retained as a field but no
  longer used for item registration. Items are registered via `RegisterEvent` +
  `VellumliItems.submitItemRegistrations()` matching upstream.

- All license headers preserved verbatim. `Patchouli` references in license/attribution
  comments kept as-is per brief constraint.
