# Graph Report - 1.21.1  (2026-09-08)

## Corpus Check
- 201 files · ~56,994 words
- Verdict: corpus is large enough that graph structure adds value.

## Summary
- 2053 nodes · 5058 edges · 104 communities (97 shown, 7 thin omitted)
- Extraction: 94% EXTRACTED · 6% INFERRED · 0% AMBIGUOUS · INFERRED: 279 edges (avg confidence: 0.8)
- Token cost: 0 input · 0 output

## Graph Freshness
- Built from commit: `4940a56c`
- Run `git rev-parse HEAD` and compare to check if the graph is stale.
- Run `graphify update .` after code changes (no API cost).

## Community Hubs (Navigation)
- .tryParse
- Vellumli.java
- ResourceLocation
- BookModel.java
- IComponentRenderContext
- ItemModBook.java
- StubVellumliAPI
- GuiBookEntry
- GuiBookEntryList
- IStateMatcher
- ClientAdvancements.java
- RecipeManager
- Files Modified (grouped by package)
- VellumliAPI.java
- GuiBook
- ComponentEntity.java
- BookEntry
- PageSimpleProcessingRecipe
- PageSmithing
- BookContentsBuilder
- IVariable
- ItemStackUtil.java
- BookRegistry.java
- BookPage
- TextLayouter
- IMultiblock
- BookTextParser
- BookContentLoader
- IVariableSerializer
- SpanState
- .drawFromTexture
- Book
- BookCategory
- GuiButtonBook
- .unwrap
- MessageOpenBookGui
- StubMultiblock
- VellumliConfigAccess
- GuiBookLanding
- NeoForgeXplatImpl
- IXplatAbstractions
- GuiBook.java
- IComponentProcessor
- IVariableProvider
- BookDrawScreenEvent
- .fromNamespaceAndPath
- ModelEvent.java
- GuiBookCategory
- PageDoubleRecipe
- ModelResourceLocation
- TemplateComponent
- EntryDisplayState
- BookIcon
- TextOverflowMode
- TriggerInstance
- TooltipHandler.java
- BookTextRenderer
- Variable
- .addRelevantStack
- .getContents
- GuiBookWriter
- Flujo de trabajo — Vellumli (NeoForge)
- StubMatcher.java
- BookContents
- LiquidBlockVertexConsumer
- PageCrafting.java
- Word
- BookCrashHandler.java
- CurseForge — Variables del proyecto
- PageRelations.java
- ComponentText.java
- BookRightClickHandler.java
- Button
- IStyleStack
- BookContentExternalLoader
- VellumliClient.java
- Delegation brief — Vellumli: finish the 1.21.1 / NeoForge 21.1.249 port
- RegisterClientReloadListenersEvent
- PageDoubleRecipeRegistry
- PageImage.java
- PageSpotlight.java
- ComponentHeader.java
- ComponentTooltip.java
- NeoForgeXplatModContainer
- NeoForgeNetworkHandler.java
- .loadJson
- PageText
- JsonVariableWrapper
- GuiButtonBookResize.java
- RotationUtil
- Vellumli
- [0.0.0-beta.1] - 2026-09-01
- CLAUDE.md — vellumli (26.2)
- gradlew

## God Nodes (most connected - your core abstractions)
1. `ResourceLocation` - 231 edges
2. `GuiBook` - 125 edges
3. `Book` - 123 edges
4. `BookEntry` - 111 edges
5. `IVariable` - 82 edges
6. `BookPage` - 73 edges
7. `GuiBookEntry` - 68 edges
8. `BookContentsBuilder` - 65 edges
9. `BookCategory` - 45 edges
10. `IMultiblock` - 37 edges

## Surprising Connections (you probably didn't know these)
- `LexiconToast` --implements--> `Toast`  [EXTRACTED]
  src/main/java/com/skd/vellumli/client/base/ClientAdvancements.java → net/minecraft/client/gui/components/toasts/Toast.java
- `BookDrawScreenEvent` --references--> `ResourceLocation`  [EXTRACTED]
  src/main/java/com/skd/vellumli/api/BookDrawScreenEvent.java → net/minecraft/resources/ResourceLocation.java
- `LexiconToast` --references--> `ResourceLocation`  [EXTRACTED]
  src/main/java/com/skd/vellumli/client/base/ClientAdvancements.java → net/minecraft/resources/ResourceLocation.java
- `BookData` --references--> `ResourceLocation`  [EXTRACTED]
  src/main/java/com/skd/vellumli/client/base/PersistentData.java → net/minecraft/resources/ResourceLocation.java
- `Bookmark` --references--> `ResourceLocation`  [EXTRACTED]
  src/main/java/com/skd/vellumli/client/base/PersistentData.java → net/minecraft/resources/ResourceLocation.java

## Import Cycles
- None detected.

## Communities (104 total, 7 thin omitted)

### Community 0 - ".tryParse"
Cohesion: 0.20
Nodes (8): JsonArray, BookData, DataHolder, JsonObject, PersistentData, JsonObject, MutableComponent, Nullable

### Community 1 - "Vellumli.java"
Cohesion: 0.05
Nodes (43): CommandDispatcher, CommandSourceStack, ContextAwarePredicate, CriterionTrigger, IEventBus, InteractionResultHolder, Ints, Item (+35 more)

### Community 2 - "ResourceLocation"
Cohesion: 0.10
Nodes (8): DataComponentType, Nullable, Override, ResourceLocation, BookContentsReloadEvent, VellumliDataComponents, Item, VellumliItems

### Community 3 - "BookModel.java"
Cohesion: 0.07
Nodes (32): BakedModel, BakedQuad, ItemOverrides, ItemTransforms, ModelBaker, ModelState, BookModel, DummyModelBaker (+24 more)

### Community 4 - "IComponentRenderContext"
Cohesion: 0.07
Nodes (19): IComponentRenderContext, AbstractWidget, Button, Component, Deprecated, GuiGraphics, Ingredient, ItemStack (+11 more)

### Community 5 - "ItemModBook.java"
Cohesion: 0.18
Nodes (9): JsonDeserializer, ClientBookRegistry, Gson, JsonDeserializationContext, JsonElement, Override, Type, LexiconPageAdapter (+1 more)

### Community 6 - "StubVellumliAPI"
Cohesion: 0.10
Nodes (12): Block, BlockPos, BlockState, Component, ItemStack, NotNull, Nullable, Override (+4 more)

### Community 7 - "GuiBookEntry"
Cohesion: 0.10
Nodes (11): GuiBookEntry, AbstractWidget, Button, Component, GuiGraphics, Ingredient, ItemStack, Override (+3 more)

### Community 8 - "GuiBookEntryList"
Cohesion: 0.13
Nodes (6): GuiBookEntryList, Button, Component, EditBox, GuiGraphics, Override

### Community 9 - "IStateMatcher"
Cohesion: 0.11
Nodes (11): Block, BlockPos, BlockState, Component, ItemStack, NotNull, Override, Rotation (+3 more)

### Community 10 - "ClientAdvancements.java"
Cohesion: 0.08
Nodes (25): AdvancementHolder, AdvancementProgress, ClientboundUpdateAdvancementsPacket, GuiGraphics, OnlyIn, SoundEvent, SoundManager, ToastComponent (+17 more)

### Community 11 - "RecipeManager"
Cohesion: 0.12
Nodes (18): Multimap, StreamCodec, RecipeHolder, CachedCheck, Gson, ItemStack, JsonElement, JsonObject (+10 more)

### Community 12 - "Files Modified (grouped by package)"
Cohesion: 0.05
Nodes (38): 10. CrashReportDetail, 11. Misc API, 1. `Identifier` → `ResourceLocation`, 26.2 Features Intentionally Dropped, 2. `GuiGraphicsExtractor` → `GuiGraphics`, 3. Method renames on `GuiGraphics`, 4. PoseStack method renames, 5. Render method renames (+30 more)

### Community 13 - "VellumliAPI.java"
Cohesion: 0.09
Nodes (16): IStateMatcher, BlockGetter, BlockPos, BlockState, IVellumliAPI, Block, BlockPos, BlockState (+8 more)

### Community 14 - "GuiBook"
Cohesion: 0.10
Nodes (5): GuiButtonBookArrow, GuiBook, Button, Override, Renderable

### Community 15 - "ComponentEntity.java"
Cohesion: 0.17
Nodes (9): Entity, GuiGraphics, Level, Override, PageEntity, EntityUtil, Entity, Level (+1 more)

### Community 16 - "BookEntry"
Cohesion: 0.14
Nodes (7): BookEntry, Override, GuiButtonEntry, GuiGraphics, OnPress, Override, SoundManager

### Community 17 - "PageSimpleProcessingRecipe"
Cohesion: 0.11
Nodes (15): BlastingRecipe, CampfireCookingRecipe, SmeltingRecipe, SmokingRecipe, GuiGraphics, ItemStack, Level, Override (+7 more)

### Community 18 - "PageSmithing"
Cohesion: 0.13
Nodes (15): SmithingRecipe, GuiGraphics, Ingredient, ItemStack, Level, Override, PageSmithing, AccessorSmithingTransformRecipe (+7 more)

### Community 19 - "BookContentsBuilder"
Cohesion: 0.09
Nodes (14): Screen, BookContentsBuilder, Level, Nullable, Pair, ItemStack, Level, GuiGraphics (+6 more)

### Community 20 - "IVariable"
Cohesion: 0.16
Nodes (12): ByteBuf, DataResult, JsonSerializationContext, JsonSerializer, Codec, JsonDeserializationContext, JsonElement, StreamCodec (+4 more)

### Community 21 - "ItemStackUtil.java"
Cohesion: 0.06
Nodes (35): DataComponentPatch, Holder, ImmutableMap, BookContents, ItemStack, Nullable, Pair, ItemStackArrayVariableSerializer (+27 more)

### Community 22 - "BookRegistry.java"
Cohesion: 0.18
Nodes (4): BookRegistry, Gson, Level, XplatModContainer

### Community 23 - "BookPage"
Cohesion: 0.07
Nodes (25): IVariablesAvailableCallback, Provider, BookPage, Button, Component, Font, GuiGraphics, JsonObject (+17 more)

### Community 24 - "TextLayouter"
Cohesion: 0.19
Nodes (8): BreakIterator, Component, MutableComponent, Style, Span, Font, SpanTail, TextLayouter

### Community 25 - "IMultiblock"
Cohesion: 0.14
Nodes (8): IMultiblock, BlockPos, Level, Nullable, Pair, Rotation, Vec3i, SimulateResult

### Community 26 - "BookTextParser"
Cohesion: 0.17
Nodes (9): BookTextParser, CommandLookup, CommandProcessor, FunctionProcessor, Component, KeyMapping, MutableComponent, Pattern (+1 more)

### Community 27 - "BookContentLoader"
Cohesion: 0.19
Nodes (7): Override, BookContentLoader, JsonElement, Nullable, LoadResult, Provider, LoadFunc

### Community 28 - "IVariableSerializer"
Cohesion: 0.06
Nodes (31): IVariableSerializer, JsonElement, Provider, JsonElement, Nullable, Provider, VariableHelper, GenericArrayVariableSerializer (+23 more)

### Community 29 - "SpanState"
Cohesion: 0.17
Nodes (6): MutableComponent, Override, Style, SpanPartialState, SpanState, TextColor

### Community 31 - "Book"
Cohesion: 0.17
Nodes (7): LexiconToast, Book, ItemStack, JsonObject, Level, MutableComponent, Style

### Community 33 - "GuiButtonBook"
Cohesion: 0.09
Nodes (17): Button, GuiButtonBook, Component, GuiGraphics, OnPress, Override, SoundManager, GuiButtonBookConfig (+9 more)

### Community 34 - ".unwrap"
Cohesion: 0.12
Nodes (14): IVariable, Deprecated, JsonDeserializationContext, JsonElement, Override, Provider, Type, Serializer (+6 more)

### Community 35 - "MessageOpenBookGui"
Cohesion: 0.17
Nodes (13): CustomPacketPayload, IPayloadContext, NeoForgeClientPayloadHandler, FriendlyByteBuf, Override, StreamCodec, Type, MessageOpenBookGui (+5 more)

### Community 36 - "StubMultiblock"
Cohesion: 0.23
Nodes (7): BlockPos, Level, Override, Pair, Rotation, Vec3i, StubMultiblock

### Community 37 - "VellumliConfigAccess"
Cohesion: 0.07
Nodes (19): ConfigValue, EffectRenderingInventoryScreen, EnumValue, Inventory, InventoryMenu, ModConfigSpec, TextOverflowMode, OVERFLOW (+11 more)

### Community 38 - "GuiBookLanding"
Cohesion: 0.19
Nodes (4): GuiBookLanding, Button, GuiGraphics, Override

### Community 39 - "NeoForgeXplatImpl"
Cohesion: 0.20
Nodes (7): GuiGraphics, ItemStack, MinecraftServer, Override, Screen, ServerPlayer, NeoForgeXplatImpl

### Community 40 - "IXplatAbstractions"
Cohesion: 0.13
Nodes (6): IXplatAbstractions, GuiGraphics, ItemStack, MinecraftServer, Screen, ServerPlayer

### Community 41 - "GuiBook.java"
Cohesion: 0.14
Nodes (10): NarratableEntry, Screen, Component, ItemStack, Minecraft, Pair, AccessorScreen, Accessor (+2 more)

### Community 42 - "IComponentProcessor"
Cohesion: 0.11
Nodes (13): IComponentProcessor, Level, IVariableProvider, Provider, JsonObject, Level, TemplateInclusion, EntityTestProcessor (+5 more)

### Community 43 - "IVariableProvider"
Cohesion: 0.39
Nodes (4): Level, Override, Recipe, RecipeTestProcessor

### Community 44 - "BookDrawScreenEvent"
Cohesion: 0.18
Nodes (6): Event, Internal, RecipesUpdatedEvent, BookDrawScreenEvent, GuiGraphics, Screen

### Community 45 - ".fromNamespaceAndPath"
Cohesion: 0.20
Nodes (8): SimpleJsonResourceReloadListener, BookContentResourceListenerLoader, JsonElement, Nullable, Override, Pattern, ProfilerFiller, ResourceManager

### Community 46 - "ModelEvent.java"
Cohesion: 0.06
Nodes (35): Condition, EventBusSubscriber, FMLClientSetupEvent, IGeometryLoader, IModBusEvent, Lock, ModelBakery, ModelManager (+27 more)

### Community 47 - "GuiBookCategory"
Cohesion: 0.27
Nodes (4): GuiBookCategory, EditBox, GuiGraphics, Override

### Community 48 - "PageDoubleRecipe"
Cohesion: 0.27
Nodes (6): Component, GuiGraphics, ItemStack, Level, Override, PageDoubleRecipe

### Community 49 - "ModelResourceLocation"
Cohesion: 0.17
Nodes (13): IJeiRuntime, IModPlugin, ISubtypeRegistration, JeiPlugin, ItemStack, KeyMapping, NotNull, Override (+5 more)

### Community 50 - "TemplateComponent"
Cohesion: 0.29
Nodes (5): Button, GuiGraphics, Level, Override, PageQuest

### Community 51 - "EntryDisplayState"
Cohesion: 0.16
Nodes (9): AbstractReadStateHolder, Override, Override, EntryDisplayState, COMPLETED, NEUTRAL, PENDING, UNREAD (+1 more)

### Community 52 - "BookIcon"
Cohesion: 0.23
Nodes (8): BookIcon, GuiGraphics, ItemStack, Override, Provider, StackIcon, TextureIcon, OnPress

### Community 53 - "TextOverflowMode"
Cohesion: 0.29
Nodes (6): ComponentEntity, Entity, GuiGraphics, Level, Override, Provider

### Community 54 - "TriggerInstance"
Cohesion: 0.25
Nodes (6): Serializer, Provider, Gson, JsonObject, Nullable, SerializationUtil

### Community 55 - "TooltipHandler.java"
Cohesion: 0.38
Nodes (5): Bookmark, GuiButtonBookBookmark, Component, GuiGraphics, Override

### Community 56 - "BookTextRenderer"
Cohesion: 0.17
Nodes (8): Renderable, BookTextRenderer, Component, GuiGraphics, Override, GuiGraphics, Override, PageWithText

### Community 57 - "Variable"
Cohesion: 0.25
Nodes (4): JsonObject, MutableComponent, Nullable, Provider

### Community 58 - ".addRelevantStack"
Cohesion: 0.36
Nodes (5): ComponentItemStack, GuiGraphics, ItemStack, Override, Provider

### Community 59 - ".getContents"
Cohesion: 0.35
Nodes (3): GuiButtonBookMarkRead, Component, GuiGraphics

### Community 60 - "GuiBookWriter"
Cohesion: 0.27
Nodes (5): GuiBookWriter, Button, EditBox, GuiGraphics, Override

### Community 61 - "Flujo de trabajo — Vellumli (NeoForge)"
Cohesion: 0.15
Nodes (12): Buenas prácticas, Commits (Conventional Commits), Convenciones de nomenclatura, Específico del mod, Estructura del proyecto, Flujo de trabajo — Vellumli (NeoForge), Flujo por tarea, Idioma (+4 more)

### Community 62 - "StubMatcher.java"
Cohesion: 0.24
Nodes (7): FunctionalInterface, BlockGetter, BlockPos, BlockState, Override, StubMatcher, TriPredicate

### Community 64 - "LiquidBlockVertexConsumer"
Cohesion: 0.36
Nodes (5): BlockPos, Override, PoseStack, LiquidBlockVertexConsumer, VertexConsumer

### Community 65 - "PageCrafting.java"
Cohesion: 0.29
Nodes (7): NonNullList, GuiGraphics, ItemStack, Level, Override, Recipe, PageCrafting

### Community 66 - "Word"
Cohesion: 0.24
Nodes (6): Component, Font, GuiGraphics, MutableComponent, Style, Word

### Community 67 - "BookCrashHandler.java"
Cohesion: 0.26
Nodes (7): BookCrashHandler, Override, CallbackInfo, Inject, Mixin, MixinSystemReport, SystemReport

### Community 68 - "CurseForge — Variables del proyecto"
Cohesion: 0.18
Nodes (10): CurseForge — Variables del proyecto, Datos del proyecto ("Create Project"), Nota para revisores de CurseForge, Nota post-subida (manual, obligatorio), Proyecto, Rama, Repo GitLab, Tag (+2 more)

### Community 69 - "PageRelations.java"
Cohesion: 0.29
Nodes (5): Button, GuiGraphics, Level, Override, PageRelations

### Community 70 - "ComponentText.java"
Cohesion: 0.29
Nodes (5): ComponentText, Component, GuiGraphics, Override, Provider

### Community 72 - "Button"
Cohesion: 0.31
Nodes (6): GuiButtonCategory, Component, GuiGraphics, Nullable, Override, SoundManager

### Community 75 - "VellumliClient.java"
Cohesion: 0.50
Nodes (3): GuiGraphics, Override, PageEmpty

### Community 76 - "Delegation brief — Vellumli: finish the 1.21.1 / NeoForge 21.1.249 port"
Cohesion: 0.22
Nodes (8): Delegation brief — Vellumli: finish the 1.21.1 / NeoForge 21.1.249 port, Deliverable, HARD CONSTRAINTS, Mission, Paths (all inside the work dir — sandbox blocks reads outside `--dir`), Scaffold already done (do NOT redo), TASK A — make `src/main/java` compile on 1.21.1 (~200 errors), TASK B — resources & metadata

### Community 78 - "PageDoubleRecipeRegistry"
Cohesion: 0.39
Nodes (4): Level, Nullable, Override, PageDoubleRecipeRegistry

### Community 80 - "PageImage.java"
Cohesion: 0.21
Nodes (6): GuiButtonBookArrowSmall, OnPress, Button, GuiGraphics, Override, PageImage

### Community 81 - "PageSpotlight.java"
Cohesion: 0.36
Nodes (5): GuiGraphics, ItemStack, Level, Override, PageSpotlight

### Community 82 - "ComponentHeader.java"
Cohesion: 0.33
Nodes (5): ComponentHeader, Component, GuiGraphics, Override, Provider

### Community 83 - "ComponentTooltip.java"
Cohesion: 0.33
Nodes (5): ComponentTooltip, Component, GuiGraphics, Override, Provider

### Community 86 - "NeoForgeXplatModContainer"
Cohesion: 0.36
Nodes (3): ModContainer, Override, NeoForgeXplatModContainer

### Community 87 - "NeoForgeNetworkHandler.java"
Cohesion: 0.36
Nodes (4): RegisterPayloadHandlersEvent, MinecraftServer, ServerPlayer, NeoForgeNetworkHandler

### Community 88 - ".loadJson"
Cohesion: 0.39
Nodes (3): BookContentResourceDirectLoader, Nullable, Override

### Community 89 - "PageText"
Cohesion: 0.18
Nodes (7): Component, Level, Override, PageLink, GuiGraphics, Override, PageText

### Community 92 - "JsonVariableWrapper"
Cohesion: 0.47
Nodes (3): JsonObject, Override, JsonVariableWrapper

### Community 97 - "GuiButtonBookResize.java"
Cohesion: 0.33
Nodes (4): GuiButtonBookResize, Component, OnPress, Override

### Community 98 - "RotationUtil"
Cohesion: 0.43
Nodes (3): Direction, Rotation, RotationUtil

### Community 99 - "Vellumli"
Cohesion: 0.33
Nodes (5): Installation, License, Requirements, Status, Vellumli

### Community 104 - "[0.0.0-beta.1] - 2026-09-01"
Cohesion: 0.29
Nodes (6): [0.0.0-beta.1] - 2026-09-01, [0.0.0-beta.2] - 2026-09-08, Added, Fixed, Technical, Vellumli (1.21.1) — Changelog

### Community 105 - "CLAUDE.md — vellumli (26.2)"
Cohesion: 0.50
Nodes (3): CLAUDE.md — vellumli (26.2), Prioridad de instrucciones, Workflow del mod

### Community 106 - "gradlew"
Cohesion: 0.83
Nodes (3): gradlew script, die(), warn()

## Knowledge Gaps
- **79 isolated node(s):** `SHOW`, `HIDE`, `OVERFLOW`, `TRUNCATE`, `RESIZE` (+74 more)
  These have ≤1 connection - possible missing edges or undocumented components.
- **7 thin communities (<3 nodes) omitted from report** — run `graphify query` to explore isolated nodes.

## Suggested Questions
_Questions this graph is uniquely positioned to answer:_

- **Why does `ResourceLocation` connect `ResourceLocation` to `.tryParse`, `Vellumli.java`, `BookModel.java`, `IComponentRenderContext`, `ItemModBook.java`, `StubVellumliAPI`, `GuiBookEntry`, `IStateMatcher`, `ClientAdvancements.java`, `RecipeManager`, `VellumliAPI.java`, `BookEntry`, `PageSimpleProcessingRecipe`, `BookContentsBuilder`, `IVariable`, `ItemStackUtil.java`, `BookRegistry.java`, `BookPage`, `IMultiblock`, `BookContentLoader`, `Book`, `BookCategory`, `MessageOpenBookGui`, `StubMultiblock`, `NeoForgeXplatImpl`, `IXplatAbstractions`, `IComponentProcessor`, `IVariableProvider`, `BookDrawScreenEvent`, `.fromNamespaceAndPath`, `ModelEvent.java`, `PageDoubleRecipe`, `ModelResourceLocation`, `TemplateComponent`, `BookIcon`, `TriggerInstance`, `TooltipHandler.java`, `Variable`, `BookContentExternalLoader`, `PageDoubleRecipeRegistry`, `PageImage.java`, `NeoForgeNetworkHandler.java`, `.loadJson`, `.displayOrBookmark`?**
  _High betweenness centrality (0.390) - this node is a cross-community bridge._
- **Why does `GuiBook` connect `GuiBook` to `GuiBookEntry`, `GuiBookEntryList`, `IStateMatcher`, `ComponentEntity.java`, `BookEntry`, `PageSimpleProcessingRecipe`, `PageSmithing`, `ItemStackUtil.java`, `BookPage`, `TextLayouter`, `BookTextParser`, `SpanState`, `.drawFromTexture`, `Book`, `GuiButtonBook`, `VellumliConfigAccess`, `GuiBookLanding`, `GuiBook.java`, `ModelEvent.java`, `PageDoubleRecipe`, `TemplateComponent`, `BookIcon`, `TooltipHandler.java`, `BookTextRenderer`, `.getContents`, `GuiBookWriter`, `PageCrafting.java`, `Word`, `BookCrashHandler.java`, `PageRelations.java`, `ComponentText.java`, `Button`, `VellumliClient.java`, `PageImage.java`, `PageSpotlight.java`, `ComponentHeader.java`, `PageText`, `GuiButtonBookResize.java`, `.displayOrBookmark`?**
  _High betweenness centrality (0.159) - this node is a cross-community bridge._
- **Why does `Book` connect `Book` to `.tryParse`, `Vellumli.java`, `ResourceLocation`, `GuiBookEntry`, `GuiBookEntryList`, `ClientAdvancements.java`, `GuiBook`, `BookEntry`, `BookContentsBuilder`, `ItemStackUtil.java`, `BookRegistry.java`, `BookPage`, `BookTextParser`, `BookContentLoader`, `SpanState`, `.drawFromTexture`, `BookCategory`, `GuiButtonBook`, `VellumliConfigAccess`, `GuiBookLanding`, `GuiBook.java`, `IComponentProcessor`, `.fromNamespaceAndPath`, `GuiBookCategory`, `TemplateComponent`, `TriggerInstance`, `TooltipHandler.java`, `BookTextRenderer`, `Variable`, `.getContents`, `GuiBookWriter`, `BookContents`, `Word`, `BookRightClickHandler.java`, `BookContentExternalLoader`, `.loadJson`?**
  _High betweenness centrality (0.140) - this node is a cross-community bridge._
- **What connects `SHOW`, `HIDE`, `OVERFLOW` to the rest of the system?**
  _79 weakly-connected nodes found - possible documentation gaps or missing edges._
- **Should `Vellumli.java` be split into smaller, more focused modules?**
  _Cohesion score 0.05136986301369863 - nodes in this community are weakly interconnected._
- **Should `ResourceLocation` be split into smaller, more focused modules?**
  _Cohesion score 0.1 - nodes in this community are weakly interconnected._
- **Should `BookModel.java` be split into smaller, more focused modules?**
  _Cohesion score 0.07239819004524888 - nodes in this community are weakly interconnected._