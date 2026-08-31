# Graph Report - 1.21.1  (2026-09-01)

## Corpus Check
- 200 files · ~56,759 words
- Verdict: corpus is large enough that graph structure adds value.

## Summary
- 2050 nodes · 5056 edges · 116 communities (113 shown, 3 thin omitted)
- Extraction: 94% EXTRACTED · 6% INFERRED · 0% AMBIGUOUS · INFERRED: 279 edges (avg confidence: 0.8)
- Token cost: 0 input · 0 output

## Graph Freshness
- Built from commit: `d4792284`
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
- PageWithText
- PageImage.java
- PageSpotlight.java
- ComponentHeader.java
- ComponentTooltip.java
- GenericArrayVariableSerializer
- .fromNonArray
- NeoForgeXplatModContainer
- NeoForgeNetworkHandler.java
- .loadJson
- PageText
- .getY
- ComponentImage.java
- JsonVariableWrapper
- IngredientVariableSerializer
- ItemStackVariableSerializer
- TextComponentVariableSerializer
- RegisterGeometryLoaders
- GuiButtonBookResize.java
- RotationUtil
- Vellumli
- BookReloadHook.java
- .getStatePredicate
- PageLink.java
- ComponentSeparator.java
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

## Communities (116 total, 3 thin omitted)

### Community 0 - ".tryParse"
Cohesion: 0.06
Nodes (32): EffectRenderingInventoryScreen, Inventory, InventoryMenu, JsonArray, Serializer, BookData, Bookmark, DataHolder (+24 more)

### Community 1 - "Vellumli.java"
Cohesion: 0.06
Nodes (37): CommandDispatcher, CommandSourceStack, CriterionTrigger, DataComponentType, IEventBus, IJeiRuntime, IModPlugin, ISubtypeRegistration (+29 more)

### Community 2 - "ResourceLocation"
Cohesion: 0.08
Nodes (16): ByteBuf, DataResult, JsonSerializationContext, JsonSerializer, Codec, JsonDeserializationContext, JsonElement, Nullable (+8 more)

### Community 3 - "BookModel.java"
Cohesion: 0.07
Nodes (32): BakedModel, BakedQuad, ItemOverrides, ItemTransforms, ModelBaker, ModelState, BookModel, DummyModelBaker (+24 more)

### Community 4 - "IComponentRenderContext"
Cohesion: 0.06
Nodes (20): IComponentRenderContext, AbstractWidget, Button, Component, Deprecated, GuiGraphics, Ingredient, ItemStack (+12 more)

### Community 5 - "ItemModBook.java"
Cohesion: 0.09
Nodes (22): InteractionResultHolder, Item, JsonDeserializer, ClientBookRegistry, Gson, JsonDeserializationContext, JsonElement, Override (+14 more)

### Community 6 - "StubVellumliAPI"
Cohesion: 0.10
Nodes (12): Block, BlockPos, BlockState, Component, ItemStack, NotNull, Nullable, Override (+4 more)

### Community 7 - "GuiBookEntry"
Cohesion: 0.10
Nodes (11): GuiBookEntry, AbstractWidget, Button, Component, GuiGraphics, Ingredient, ItemStack, Override (+3 more)

### Community 8 - "GuiBookEntryList"
Cohesion: 0.08
Nodes (10): GuiBookEntryList, Button, Component, EditBox, GuiGraphics, Override, GuiBookHistory, Override (+2 more)

### Community 9 - "IStateMatcher"
Cohesion: 0.12
Nodes (12): IStateMatcher, Block, BlockPos, BlockState, Component, ItemStack, NotNull, Override (+4 more)

### Community 10 - "ClientAdvancements.java"
Cohesion: 0.08
Nodes (25): AdvancementHolder, AdvancementProgress, ClientboundUpdateAdvancementsPacket, GuiGraphics, OnlyIn, SoundEvent, SoundManager, ToastComponent (+17 more)

### Community 11 - "RecipeManager"
Cohesion: 0.11
Nodes (19): Multimap, Override, StreamCodec, RecipeHolder, CachedCheck, Gson, ItemStack, JsonElement (+11 more)

### Community 12 - "Files Modified (grouped by package)"
Cohesion: 0.05
Nodes (38): 10. CrashReportDetail, 11. Misc API, 1. `Identifier` → `ResourceLocation`, 26.2 Features Intentionally Dropped, 2. `GuiGraphicsExtractor` → `GuiGraphics`, 3. Method renames on `GuiGraphics`, 4. PoseStack method renames, 5. Render method renames (+30 more)

### Community 13 - "VellumliAPI.java"
Cohesion: 0.09
Nodes (12): IVellumliAPI, Block, BlockPos, BlockState, Component, ItemStack, Logger, Nullable (+4 more)

### Community 14 - "GuiBook"
Cohesion: 0.10
Nodes (4): GuiBook, Button, Override, Renderable

### Community 15 - "ComponentEntity.java"
Cohesion: 0.11
Nodes (15): Entity, GuiGraphics, Level, Override, PageEntity, ComponentEntity, Entity, GuiGraphics (+7 more)

### Community 16 - "BookEntry"
Cohesion: 0.12
Nodes (7): BookEntry, Override, GuiButtonEntry, GuiGraphics, OnPress, Override, SoundManager

### Community 17 - "PageSimpleProcessingRecipe"
Cohesion: 0.11
Nodes (15): BlastingRecipe, CampfireCookingRecipe, SmeltingRecipe, SmokingRecipe, GuiGraphics, ItemStack, Level, Override (+7 more)

### Community 18 - "PageSmithing"
Cohesion: 0.13
Nodes (15): SmithingRecipe, GuiGraphics, Ingredient, ItemStack, Level, Override, PageSmithing, AccessorSmithingTransformRecipe (+7 more)

### Community 19 - "BookContentsBuilder"
Cohesion: 0.14
Nodes (10): BookContentsBuilder, Level, Pair, GuiGraphics, Level, Override, PageTemplate, BookTemplate (+2 more)

### Community 20 - "IVariable"
Cohesion: 0.21
Nodes (8): IVariable, Deprecated, Provider, Context, Level, Pattern, Provider, VariableAssigner

### Community 21 - "ItemStackUtil.java"
Cohesion: 0.17
Nodes (12): DataComponentPatch, Holder, ItemStackUtil, Ingredient, Item, ItemStack, JsonObject, Nullable (+4 more)

### Community 22 - "BookRegistry.java"
Cohesion: 0.11
Nodes (8): JsonObject, Nullable, Provider, JsonObject, BookRegistry, Gson, Level, XplatModContainer

### Community 23 - "BookPage"
Cohesion: 0.12
Nodes (14): BookPage, Button, Component, Font, GuiGraphics, JsonObject, Level, Minecraft (+6 more)

### Community 24 - "TextLayouter"
Cohesion: 0.19
Nodes (8): BreakIterator, Component, MutableComponent, Style, Span, Font, SpanTail, TextLayouter

### Community 25 - "IMultiblock"
Cohesion: 0.15
Nodes (8): IMultiblock, BlockPos, Level, Nullable, Pair, Rotation, Vec3i, SimulateResult

### Community 26 - "BookTextParser"
Cohesion: 0.14
Nodes (9): BookTextParser, CommandLookup, CommandProcessor, FunctionProcessor, Component, KeyMapping, MutableComponent, Pattern (+1 more)

### Community 27 - "BookContentLoader"
Cohesion: 0.17
Nodes (8): Override, BookContentLoader, JsonElement, Nullable, LoadResult, Nullable, Provider, LoadFunc

### Community 28 - "IVariableSerializer"
Cohesion: 0.17
Nodes (10): IVariableSerializer, JsonElement, Nullable, Provider, VariableHelper, JsonElement, Override, Provider (+2 more)

### Community 29 - "SpanState"
Cohesion: 0.20
Nodes (6): MutableComponent, Override, Style, SpanPartialState, SpanState, TextColor

### Community 30 - ".drawFromTexture"
Cohesion: 0.16
Nodes (3): FormattedCharSequence, GuiGraphics, GuiGraphics

### Community 31 - "Book"
Cohesion: 0.16
Nodes (7): LexiconToast, GuiButtonInventoryBook, GuiGraphics, Book, ItemStack, Level, MutableComponent

### Community 32 - "BookCategory"
Cohesion: 0.13
Nodes (3): BookCategory, MutableComponent, Override

### Community 33 - "GuiButtonBook"
Cohesion: 0.12
Nodes (11): GuiButtonBook, Component, GuiGraphics, OnPress, Override, SoundManager, GuiButtonBookArrow, GuiButtonBookArrowSmall (+3 more)

### Community 34 - ".unwrap"
Cohesion: 0.15
Nodes (7): JsonDeserializationContext, JsonElement, Override, Provider, Type, Serializer, Provider

### Community 35 - "MessageOpenBookGui"
Cohesion: 0.17
Nodes (13): CustomPacketPayload, IPayloadContext, NeoForgeClientPayloadHandler, FriendlyByteBuf, Override, StreamCodec, Type, MessageOpenBookGui (+5 more)

### Community 36 - "StubMultiblock"
Cohesion: 0.23
Nodes (7): BlockPos, Level, Override, Pair, Rotation, Vec3i, StubMultiblock

### Community 38 - "GuiBookLanding"
Cohesion: 0.21
Nodes (3): GuiBookLanding, Button, Override

### Community 39 - "NeoForgeXplatImpl"
Cohesion: 0.20
Nodes (7): GuiGraphics, ItemStack, MinecraftServer, Override, Screen, ServerPlayer, NeoForgeXplatImpl

### Community 40 - "IXplatAbstractions"
Cohesion: 0.13
Nodes (6): IXplatAbstractions, GuiGraphics, ItemStack, MinecraftServer, Screen, ServerPlayer

### Community 41 - "GuiBook.java"
Cohesion: 0.16
Nodes (10): NarratableEntry, Screen, Component, ItemStack, Minecraft, Pair, AccessorScreen, Accessor (+2 more)

### Community 42 - "IComponentProcessor"
Cohesion: 0.17
Nodes (6): IComponentProcessor, Level, Screen, JsonObject, Level, TemplateInclusion

### Community 43 - "IVariableProvider"
Cohesion: 0.18
Nodes (9): IVariableProvider, Provider, EntityTestProcessor, Level, Override, Level, Override, Recipe (+1 more)

### Community 44 - "BookDrawScreenEvent"
Cohesion: 0.18
Nodes (6): Event, Internal, RecipesUpdatedEvent, BookDrawScreenEvent, GuiGraphics, Screen

### Community 45 - ".fromNamespaceAndPath"
Cohesion: 0.20
Nodes (9): SimpleJsonResourceReloadListener, BookContentResourceListenerLoader, JsonElement, Nullable, Override, Pattern, ProfilerFiller, ResourceManager (+1 more)

### Community 46 - "ModelEvent.java"
Cohesion: 0.31
Nodes (8): ModelBakery, ModelManager, BakingCompleted, BakedModel, Material, TextureAtlasSprite, ModelEvent, ModifyBakingResult

### Community 47 - "GuiBookCategory"
Cohesion: 0.27
Nodes (4): GuiBookCategory, EditBox, GuiGraphics, Override

### Community 48 - "PageDoubleRecipe"
Cohesion: 0.27
Nodes (6): Component, GuiGraphics, ItemStack, Level, Override, PageDoubleRecipe

### Community 49 - "ModelResourceLocation"
Cohesion: 0.22
Nodes (4): OnlyIn, Override, ModelResourceLocation, RegisterAdditional

### Community 50 - "TemplateComponent"
Cohesion: 0.17
Nodes (7): IVariablesAvailableCallback, GuiGraphics, JsonObject, Level, Override, Provider, TemplateComponent

### Community 51 - "EntryDisplayState"
Cohesion: 0.19
Nodes (8): AbstractReadStateHolder, Override, EntryDisplayState, COMPLETED, NEUTRAL, PENDING, UNREAD, fromOrdinal()

### Community 52 - "BookIcon"
Cohesion: 0.23
Nodes (8): BookIcon, GuiGraphics, ItemStack, Override, Provider, StackIcon, TextureIcon, OnPress

### Community 53 - "TextOverflowMode"
Cohesion: 0.18
Nodes (9): ConfigValue, EnumValue, ModConfigSpec, TextOverflowMode, OVERFLOW, RESIZE, TRUNCATE, Config (+1 more)

### Community 54 - "TriggerInstance"
Cohesion: 0.21
Nodes (10): ContextAwarePredicate, Ints, SimpleCriterionTrigger, SimpleInstance, BookOpenTrigger, Codec, NotNull, Override (+2 more)

### Community 55 - "TooltipHandler.java"
Cohesion: 0.23
Nodes (6): FMLClientSetupEvent, ClientTicker, Minecraft, GuiGraphics, ItemStack, TooltipHandler

### Community 56 - "BookTextRenderer"
Cohesion: 0.23
Nodes (6): Renderable, BookTextRenderer, Component, GuiGraphics, Override, Style

### Community 57 - "Variable"
Cohesion: 0.22
Nodes (6): JsonElement, Provider, JsonElement, Override, Provider, Variable

### Community 58 - ".addRelevantStack"
Cohesion: 0.19
Nodes (7): ItemStack, Level, ComponentItemStack, GuiGraphics, ItemStack, Override, Provider

### Community 59 - ".getContents"
Cohesion: 0.26
Nodes (4): GuiButtonBookMarkRead, Component, GuiGraphics, Override

### Community 60 - "GuiBookWriter"
Cohesion: 0.27
Nodes (5): GuiBookWriter, Button, EditBox, GuiGraphics, Override

### Community 61 - "Flujo de trabajo — Vellumli (NeoForge)"
Cohesion: 0.15
Nodes (12): Buenas prácticas, Commits (Conventional Commits), Convenciones de nomenclatura, Específico del mod, Estructura del proyecto, Flujo de trabajo — Vellumli (NeoForge), Flujo por tarea, Idioma (+4 more)

### Community 62 - "StubMatcher.java"
Cohesion: 0.24
Nodes (7): FunctionalInterface, BlockGetter, BlockPos, BlockState, Override, StubMatcher, TriPredicate

### Community 63 - "BookContents"
Cohesion: 0.27
Nodes (5): ImmutableMap, BookContents, ItemStack, Nullable, Pair

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

### Community 71 - "BookRightClickHandler.java"
Cohesion: 0.33
Nodes (8): BookRightClickHandler, BlockHitResult, InteractionHand, InteractionResult, Level, Nullable, Pair, Player

### Community 72 - "Button"
Cohesion: 0.29
Nodes (7): Button, GuiButtonCategory, Component, GuiGraphics, Nullable, Override, SoundManager

### Community 75 - "VellumliClient.java"
Cohesion: 0.36
Nodes (5): Condition, EventBusSubscriber, Lock, VellumliClient, SubscribeEvent

### Community 76 - "Delegation brief — Vellumli: finish the 1.21.1 / NeoForge 21.1.249 port"
Cohesion: 0.22
Nodes (8): Delegation brief — Vellumli: finish the 1.21.1 / NeoForge 21.1.249 port, Deliverable, HARD CONSTRAINTS, Mission, Paths (all inside the work dir — sandbox blocks reads outside `--dir`), Scaffold already done (do NOT redo), TASK A — make `src/main/java` compile on 1.21.1 (~200 errors), TASK B — resources & metadata

### Community 77 - "RegisterClientReloadListenersEvent"
Cohesion: 0.36
Nodes (5): IModBusEvent, Internal, RegisterClientReloadListenersEvent, PreparableReloadListener, ReloadableResourceManager

### Community 78 - "PageDoubleRecipeRegistry"
Cohesion: 0.33
Nodes (4): Level, Nullable, Override, PageDoubleRecipeRegistry

### Community 79 - "PageWithText"
Cohesion: 0.39
Nodes (3): GuiGraphics, Override, PageWithText

### Community 80 - "PageImage.java"
Cohesion: 0.33
Nodes (4): Button, GuiGraphics, Override, PageImage

### Community 81 - "PageSpotlight.java"
Cohesion: 0.36
Nodes (5): GuiGraphics, ItemStack, Level, Override, PageSpotlight

### Community 82 - "ComponentHeader.java"
Cohesion: 0.33
Nodes (5): ComponentHeader, Component, GuiGraphics, Override, Provider

### Community 83 - "ComponentTooltip.java"
Cohesion: 0.33
Nodes (5): ComponentTooltip, Component, GuiGraphics, Override, Provider

### Community 84 - "GenericArrayVariableSerializer"
Cohesion: 0.31
Nodes (5): GenericArrayVariableSerializer, JsonElement, Override, Provider, SuppressWarnings

### Community 85 - ".fromNonArray"
Cohesion: 0.42
Nodes (5): ItemStackArrayVariableSerializer, ItemStack, JsonElement, Override, Provider

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
Cohesion: 0.32
Nodes (3): GuiGraphics, Override, PageText

### Community 90 - ".getY"
Cohesion: 0.29
Nodes (4): GuiButtonBookEye, GuiGraphics, OnPress, Override

### Community 91 - "ComponentImage.java"
Cohesion: 0.36
Nodes (4): ComponentImage, GuiGraphics, Override, Provider

### Community 92 - "JsonVariableWrapper"
Cohesion: 0.36
Nodes (4): JsonObject, Override, Provider, JsonVariableWrapper

### Community 93 - "IngredientVariableSerializer"
Cohesion: 0.50
Nodes (5): IngredientVariableSerializer, Ingredient, JsonElement, Override, Provider

### Community 94 - "ItemStackVariableSerializer"
Cohesion: 0.50
Nodes (5): ItemStackVariableSerializer, ItemStack, JsonElement, Override, Provider

### Community 95 - "TextComponentVariableSerializer"
Cohesion: 0.50
Nodes (5): Component, JsonElement, Override, Provider, TextComponentVariableSerializer

### Community 96 - "RegisterGeometryLoaders"
Cohesion: 0.38
Nodes (3): IGeometryLoader, Internal, RegisterGeometryLoaders

### Community 97 - "GuiButtonBookResize.java"
Cohesion: 0.33
Nodes (4): GuiButtonBookResize, Component, OnPress, Override

### Community 98 - "RotationUtil"
Cohesion: 0.43
Nodes (3): Direction, Rotation, RotationUtil

### Community 99 - "Vellumli"
Cohesion: 0.33
Nodes (5): Installation, License, Requirements, Status, Vellumli

### Community 100 - "BookReloadHook.java"
Cohesion: 0.47
Nodes (4): ResourceManagerReloadListener, BookReloadHook, Override, ResourceManager

### Community 101 - ".getStatePredicate"
Cohesion: 0.47
Nodes (3): BlockGetter, BlockPos, BlockState

### Community 102 - "PageLink.java"
Cohesion: 0.47
Nodes (4): Component, Level, Override, PageLink

### Community 103 - "ComponentSeparator.java"
Cohesion: 0.47
Nodes (3): ComponentSeparator, GuiGraphics, Override

### Community 104 - "[0.0.0-beta.1] - 2026-09-01"
Cohesion: 0.40
Nodes (4): [0.0.0-beta.1] - 2026-09-01, Added, Technical, Vellumli (1.21.1) — Changelog

### Community 105 - "CLAUDE.md — vellumli (26.2)"
Cohesion: 0.50
Nodes (3): CLAUDE.md — vellumli (26.2), Prioridad de instrucciones, Workflow del mod

### Community 106 - "gradlew"
Cohesion: 0.83
Nodes (3): gradlew script, die(), warn()

## Knowledge Gaps
- **78 isolated node(s):** `SHOW`, `HIDE`, `OVERFLOW`, `TRUNCATE`, `RESIZE` (+73 more)
  These have ≤1 connection - possible missing edges or undocumented components.
- **3 thin communities (<3 nodes) omitted from report** — run `graphify query` to explore isolated nodes.

## Suggested Questions
_Questions this graph is uniquely positioned to answer:_

- **Why does `ResourceLocation` connect `ResourceLocation` to `.tryParse`, `Vellumli.java`, `BookModel.java`, `IComponentRenderContext`, `ItemModBook.java`, `StubVellumliAPI`, `GuiBookEntry`, `IStateMatcher`, `ClientAdvancements.java`, `RecipeManager`, `VellumliAPI.java`, `BookEntry`, `PageSimpleProcessingRecipe`, `BookContentsBuilder`, `BookRegistry.java`, `IMultiblock`, `BookContentLoader`, `Book`, `BookCategory`, `MessageOpenBookGui`, `StubMultiblock`, `NeoForgeXplatImpl`, `IXplatAbstractions`, `BookDrawScreenEvent`, `.fromNamespaceAndPath`, `ModelEvent.java`, `PageDoubleRecipe`, `ModelResourceLocation`, `BookIcon`, `TriggerInstance`, `BookContents`, `BookContentExternalLoader`, `VellumliClient.java`, `PageDoubleRecipeRegistry`, `PageImage.java`, `NeoForgeNetworkHandler.java`, `.loadJson`, `ComponentImage.java`, `RegisterGeometryLoaders`, `BookReloadHook.java`, `.displayOrBookmark`?**
  _High betweenness centrality (0.391) - this node is a cross-community bridge._
- **Why does `GuiBook` connect `GuiBook` to `.tryParse`, `GuiBookEntry`, `GuiBookEntryList`, `IStateMatcher`, `ComponentEntity.java`, `BookEntry`, `PageSimpleProcessingRecipe`, `PageSmithing`, `BookPage`, `TextLayouter`, `BookTextParser`, `SpanState`, `.drawFromTexture`, `Book`, `GuiButtonBook`, `GuiBookLanding`, `GuiBook.java`, `PageDoubleRecipe`, `BookIcon`, `TextOverflowMode`, `TooltipHandler.java`, `BookTextRenderer`, `.getContents`, `GuiBookWriter`, `BookContents`, `PageCrafting.java`, `Word`, `BookCrashHandler.java`, `PageRelations.java`, `ComponentText.java`, `Button`, `PageImage.java`, `PageSpotlight.java`, `ComponentHeader.java`, `PageText`, `.getY`, `GuiButtonBookResize.java`, `PageLink.java`, `ComponentSeparator.java`, `.displayOrBookmark`?**
  _High betweenness centrality (0.159) - this node is a cross-community bridge._
- **Why does `Book` connect `Book` to `.tryParse`, `ResourceLocation`, `ItemModBook.java`, `GuiBookEntry`, `GuiBookEntryList`, `ClientAdvancements.java`, `GuiBook`, `BookEntry`, `BookContentsBuilder`, `ItemStackUtil.java`, `BookRegistry.java`, `BookPage`, `BookTextParser`, `BookContentLoader`, `SpanState`, `.drawFromTexture`, `BookCategory`, `GuiButtonBook`, `VellumliConfigAccess`, `GuiBookLanding`, `GuiBook.java`, `.fromNamespaceAndPath`, `GuiBookCategory`, `TextOverflowMode`, `BookTextRenderer`, `.getContents`, `GuiBookWriter`, `BookContents`, `Word`, `BookRightClickHandler.java`, `BookContentExternalLoader`, `.loadJson`?**
  _High betweenness centrality (0.141) - this node is a cross-community bridge._
- **What connects `SHOW`, `HIDE`, `OVERFLOW` to the rest of the system?**
  _78 weakly-connected nodes found - possible documentation gaps or missing edges._
- **Should `.tryParse` be split into smaller, more focused modules?**
  _Cohesion score 0.05920745920745921 - nodes in this community are weakly interconnected._
- **Should `Vellumli.java` be split into smaller, more focused modules?**
  _Cohesion score 0.0576271186440678 - nodes in this community are weakly interconnected._
- **Should `ResourceLocation` be split into smaller, more focused modules?**
  _Cohesion score 0.08055152394775036 - nodes in this community are weakly interconnected._