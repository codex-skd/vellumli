# Graph Report - 26.2  (2026-08-10)

## Corpus Check
- 209 files · ~52,689 words
- Verdict: corpus is large enough that graph structure adds value.

## Summary
- 1960 nodes · 4687 edges · 105 communities (101 shown, 4 thin omitted)
- Extraction: 95% EXTRACTED · 5% INFERRED · 0% AMBIGUOUS · INFERRED: 253 edges (avg confidence: 0.8)
- Token cost: 0 input · 0 output

## Graph Freshness
- Built from commit: `d161077f`
- Run `git rev-parse HEAD` and compare to check if the graph is stale.
- Run `graphify update .` after code changes (no API cost).

## Community Hubs (Navigation)
- Recipe Management
- GUI Rendering
- Data Handling
- Book GUI Components
- Book Entry List
- Recipe Types
- Block and Item Data
- API Implementation
- Performance Profiling
- Book GUI Operations
- API Interface
- Component Rendering
- Entity Rendering
- Content Loading
- Advancement Handling
- Packet Handling
- Book Management
- Book Entry Data
- Book GUI Elements
- Variable Handling
- Item and Block Management
- Multiblock Logic
- Book Category Management
- Book Page Rendering
- GUI Button Operations
- Screen Management
- Persistent Data Handling
- Text Parsing
- Modded Book Items
- Platform Abstractions
- Item Stack Utilities
- Variable Providers
- Text Formatting
- Model Baking
- GUI Button Types
- Variable Helpers
- Landing GUI Operations
- Stub Multiblock Logic
- Formatted Text Rendering
- Book Registry Management
- Custom Component Handling
- Read State Management
- External Content Loader
- Event Handling
- Variable Serialization
- Text Layouting
- State Matcher Logic
- Category GUI Operations
- Book Data Management
- Book Management
- GUI Component Framework
- Configuration Handling
- Modular System
- Rendering Utilities
- Drawing Functions
- Page Linking
- Quest Management
- Variable Processing
- Block State Matching
- Book Icon Handling
- Word Component
- Book Folder Loader
- Component Processor
- Text Component
- Span Utilities
- Bookmark Button
- Completion Model Property
- Style Stack Management
- Stack Wrapper
- Component Header
- Item Stack Component
- Tooltip Component
- Item Stack Variable Serializer
- Serialization Utilities
- Entity Test Processor
- Book Entry Management
- JSON Variable Wrapper
- Recipe Test Processor
- Ingredient Variable Serializer
- Item Stack Variable Serializer
- Text Component Variable Serializer
- Rotation Utilities
- Sound Management
- Image Component
- Book GUI
- Key Mapping Accessor
- Widget Registration
- Build Scripts
- Project Setup
- Page Interaction
- Vellumli
- ComponentSeparator.java
- PageEmpty.java
- CLAUDE.md — vellumli (26.2)

## God Nodes (most connected - your core abstractions)
1. `GuiBook` - 125 edges
2. `Book` - 123 edges
3. `BookEntry` - 111 edges
4. `IVariable` - 82 edges
5. `BookPage` - 73 edges
6. `GuiBookEntry` - 68 edges
7. `BookContentsBuilder` - 65 edges
8. `BookCategory` - 45 edges
9. `IVellumliAPI` - 38 edges
10. `IMultiblock` - 37 edges

## Surprising Connections (you probably didn't know these)
- `BookTemplate` --references--> `IComponentProcessor`  [EXTRACTED]
  src/main/java/com/skd/vellumli/client/book/template/BookTemplate.java → src/main/java/com/skd/vellumli/api/IComponentProcessor.java
- `EntityTestProcessor` --implements--> `IComponentProcessor`  [EXTRACTED]
  src/main/java/com/skd/vellumli/client/book/template/test/EntityTestProcessor.java → src/main/java/com/skd/vellumli/api/IComponentProcessor.java
- `RecipeTestProcessor` --implements--> `IComponentProcessor`  [EXTRACTED]
  src/main/java/com/skd/vellumli/client/book/template/test/RecipeTestProcessor.java → src/main/java/com/skd/vellumli/api/IComponentProcessor.java
- `Context` --references--> `IComponentProcessor`  [EXTRACTED]
  src/main/java/com/skd/vellumli/client/book/template/VariableAssigner.java → src/main/java/com/skd/vellumli/api/IComponentProcessor.java
- `GuiBookEntry` --implements--> `IComponentRenderContext`  [EXTRACTED]
  src/main/java/com/skd/vellumli/client/book/gui/GuiBookEntry.java → src/main/java/com/skd/vellumli/api/IComponentRenderContext.java

## Import Cycles
- None detected.

## Communities (105 total, 4 thin omitted)

### Community 0 - "Recipe Management"
Cohesion: 0.07
Nodes (33): RecipeDisplay, RecipeHolder, SmithingRecipe, SmithingRecipeDisplay, ClientRecipes, Identifier, Recipe, RecipeType (+25 more)

### Community 1 - "GUI Rendering"
Cohesion: 0.17
Nodes (8): GuiBookWriter, Button, CharacterEvent, EditBox, GuiGraphicsExtractor, KeyEvent, MouseButtonEvent, Override

### Community 2 - "Data Handling"
Cohesion: 0.15
Nodes (13): CriterionTrigger, EventBusSubscriber, Identifier, VellumliCriteriaTriggers, MinecraftServer, ReloadContentsHandler, Holder, Item (+5 more)

### Community 3 - "Book GUI Components"
Cohesion: 0.16
Nodes (16): BakingContext, Item, ItemDisplayContext, ItemModel, ItemModelResolver, ItemStackRenderState, Matrix4fc, Resolver (+8 more)

### Community 4 - "Book Entry List"
Cohesion: 0.07
Nodes (19): CrashReportDetail, GuiBookEntryList, Button, CharacterEvent, Component, EditBox, GuiGraphicsExtractor, KeyEvent (+11 more)

### Community 5 - "Recipe Types"
Cohesion: 0.06
Nodes (31): BlastingRecipe, CampfireCookingRecipe, SmeltingRecipe, SmokingRecipe, ContextMap, GuiGraphicsExtractor, Override, RecipeType (+23 more)

### Community 6 - "Block and Item Data"
Cohesion: 0.09
Nodes (17): Block, BlockPos, BlockState, Component, Holder, Identifier, Item, ItemStack (+9 more)

### Community 7 - "API Implementation"
Cohesion: 0.10
Nodes (17): Block, BlockPos, BlockState, Component, Holder, Identifier, Item, ItemStack (+9 more)

### Community 8 - "Performance Profiling"
Cohesion: 0.23
Nodes (11): GuiElementRenderState, Matrix3x2f, RenderPipeline, ScreenRectangle, GuiGraphicsExtractor, ItemStack, Override, VertexConsumer (+3 more)

### Community 9 - "Book GUI Operations"
Cohesion: 0.10
Nodes (7): GuiBook, Button, GuiGraphicsExtractor, KeyEvent, MouseButtonEvent, Override, Renderable

### Community 10 - "API Interface"
Cohesion: 0.10
Nodes (14): Logger, IVellumliAPI, BlockPos, Component, Holder, Identifier, Item, ItemStack (+6 more)

### Community 11 - "Component Rendering"
Cohesion: 0.09
Nodes (15): IComponentRenderContext, AbstractWidget, Button, Component, Deprecated, GuiGraphicsExtractor, Identifier, Ingredient (+7 more)

### Community 12 - "Entity Rendering"
Cohesion: 0.11
Nodes (15): Entity, GuiGraphicsExtractor, Level, Override, PageEntity, ComponentEntity, Entity, GuiGraphicsExtractor (+7 more)

### Community 13 - "Content Loading"
Cohesion: 0.23
Nodes (8): BookContentLoader, BookContentsBuilder, Identifier, Level, Nullable, Pair, Provider, LoadFunc

### Community 14 - "Advancement Handling"
Cohesion: 0.11
Nodes (20): AdvancementHolder, AdvancementProgress, ClientboundUpdateAdvancementsPacket, ClientAdvancements, Font, GuiGraphicsExtractor, Identifier, NotNull (+12 more)

### Community 15 - "Packet Handling"
Cohesion: 0.12
Nodes (20): CustomPacketPayload, IPayloadContext, RegisterPayloadHandlersEvent, NeoForgeClientPayloadHandler, Identifier, MinecraftServer, ServerPlayer, NeoForgeNetworkHandler (+12 more)

### Community 16 - "Book Management"
Cohesion: 0.15
Nodes (9): Button, GuiButtonInventoryBook, Book, Identifier, ItemStackTemplate, JsonObject, Level, MutableComponent (+1 more)

### Community 17 - "Book Entry Data"
Cohesion: 0.08
Nodes (15): BookEntry, Identifier, ItemStack, JsonObject, Level, MutableComponent, Nullable, Override (+7 more)

### Community 18 - "Book GUI Elements"
Cohesion: 0.09
Nodes (14): GuiBookEntry, AbstractWidget, Button, Component, GuiGraphicsExtractor, Identifier, Ingredient, ItemStack (+6 more)

### Community 19 - "Variable Handling"
Cohesion: 0.20
Nodes (9): IVariable, Deprecated, Provider, Provider, Context, Level, Pattern, Provider (+1 more)

### Community 20 - "Item and Block Management"
Cohesion: 0.15
Nodes (12): Items, GuiGraphicsExtractor, Holder, Identifier, Ingredient, Item, ItemStack, MinecraftServer (+4 more)

### Community 21 - "Multiblock Logic"
Cohesion: 0.14
Nodes (9): IMultiblock, BlockPos, Identifier, Level, Nullable, Pair, Rotation, Vec3i (+1 more)

### Community 22 - "Book Category Management"
Cohesion: 0.11
Nodes (7): BookCategory, Identifier, JsonObject, MutableComponent, Nullable, Override, Provider

### Community 23 - "Book Page Rendering"
Cohesion: 0.17
Nodes (11): BookPage, Button, Component, Font, GuiGraphicsExtractor, JsonObject, Minecraft, MouseButtonEvent (+3 more)

### Community 24 - "GUI Button Operations"
Cohesion: 0.13
Nodes (10): GuiButtonBook, Component, GuiGraphicsExtractor, OnPress, Override, SoundManager, GuiButtonBookArrowSmall, OnPress (+2 more)

### Community 25 - "Screen Management"
Cohesion: 0.15
Nodes (10): GuiGraphicsExtractor, Level, MouseButtonEvent, Override, PageTemplate, BookTemplate, GuiGraphicsExtractor, Identifier (+2 more)

### Community 26 - "Persistent Data Handling"
Cohesion: 0.29
Nodes (6): JsonArray, BookData, DataHolder, Identifier, JsonObject, PersistentData

### Community 27 - "Text Parsing"
Cohesion: 0.18
Nodes (8): ICustomComponent, GuiGraphicsExtractor, MouseButtonEvent, ComponentCustom, GuiGraphicsExtractor, MouseButtonEvent, Override, Provider

### Community 28 - "Modded Book Items"
Cohesion: 0.18
Nodes (14): ItemModBook, Component, Identifier, InteractionHand, InteractionResult, ItemStack, ItemStackTemplate, Level (+6 more)

### Community 29 - "Platform Abstractions"
Cohesion: 0.13
Nodes (10): IXplatAbstractions, GuiGraphicsExtractor, Holder, Identifier, Ingredient, Item, ItemStack, MinecraftServer (+2 more)

### Community 30 - "Item Stack Utilities"
Cohesion: 0.09
Nodes (23): Either, HolderSet, ItemStackArrayVariableSerializer, ItemStack, JsonElement, Override, Provider, ItemStackVariableSerializer (+15 more)

### Community 31 - "Variable Providers"
Cohesion: 0.25
Nodes (11): Codec, ContextAwarePredicate, Ints, SimpleCriterionTrigger, SimpleInstance, BookOpenTrigger, Identifier, NotNull (+3 more)

### Community 32 - "Text Formatting"
Cohesion: 0.05
Nodes (31): BreakIterator, Component, BookTextParser, CommandLookup, CommandProcessor, FunctionProcessor, Component, KeyMapping (+23 more)

### Community 33 - "Model Baking"
Cohesion: 0.29
Nodes (9): ProfilerFiller, SimpleJsonResourceReloadListener, BookContentResourceListenerLoader, Identifier, JsonElement, Nullable, Override, Pattern (+1 more)

### Community 34 - "GUI Button Types"
Cohesion: 0.17
Nodes (6): GuiButtonBookEye, GuiGraphicsExtractor, OnPress, Override, GuiGraphicsExtractor, Override

### Community 35 - "Variable Helpers"
Cohesion: 0.06
Nodes (31): IVariableSerializer, JsonElement, Provider, JsonElement, Nullable, Provider, VariableHelper, GenericArrayVariableSerializer (+23 more)

### Community 36 - "Landing GUI Operations"
Cohesion: 0.18
Nodes (5): GuiBookLanding, Button, GuiGraphicsExtractor, MouseButtonEvent, Override

### Community 37 - "Stub Multiblock Logic"
Cohesion: 0.22
Nodes (8): BlockPos, Identifier, Level, Override, Pair, Rotation, Vec3i, StubMultiblock

### Community 38 - "Formatted Text Rendering"
Cohesion: 0.14
Nodes (10): FormattedCharSequence, NarratableEntry, Screen, GuiButtonBookArrow, Minecraft, Pair, AccessorScreen, Accessor (+2 more)

### Community 39 - "Book Registry Management"
Cohesion: 0.11
Nodes (15): JsonDeserializer, ClientBookRegistry, Gson, Identifier, JsonDeserializationContext, JsonElement, Override, Type (+7 more)

### Community 40 - "Custom Component Handling"
Cohesion: 0.26
Nodes (6): Bookmark, Nullable, GuiButtonBookBookmark, Component, GuiGraphicsExtractor, Override

### Community 41 - "Read State Management"
Cohesion: 0.14
Nodes (8): AbstractReadStateHolder, Override, EntryDisplayState, COMPLETED, NEUTRAL, PENDING, UNREAD, fromOrdinal()

### Community 42 - "External Content Loader"
Cohesion: 0.39
Nodes (4): BookContentResourceDirectLoader, Identifier, Nullable, Override

### Community 43 - "Event Handling"
Cohesion: 0.20
Nodes (7): Event, BookContentsReloadEvent, Identifier, BookDrawScreenEvent, GuiGraphicsExtractor, Identifier, Screen

### Community 44 - "Variable Serialization"
Cohesion: 0.29
Nodes (5): ClientTicker, Minecraft, IEventBus, Mod, VellumliClient

### Community 45 - "Text Layouting"
Cohesion: 0.24
Nodes (7): GuiElementRenderState, GuiGraphicsExtractor, Override, NeoForgeClientXplatImpl, IClientXplatAbstractions, GuiElementRenderState, GuiGraphicsExtractor

### Community 46 - "State Matcher Logic"
Cohesion: 0.20
Nodes (7): IStateMatcher, BlockGetter, BlockPos, BlockState, Block, BlockState, TagKey

### Community 47 - "Category GUI Operations"
Cohesion: 0.27
Nodes (4): GuiBookCategory, EditBox, GuiGraphicsExtractor, Override

### Community 48 - "Book Data Management"
Cohesion: 0.35
Nodes (8): RangeSelectItemModelProperty, BookCompletionModelProperty, ClientLevel, Identifier, ItemOwner, ItemStack, MapCodec, Override

### Community 49 - "Book Management"
Cohesion: 0.26
Nodes (6): ImmutableMap, BookContents, Identifier, ItemStack, Nullable, Pair

### Community 50 - "GUI Component Framework"
Cohesion: 0.15
Nodes (9): IVariablesAvailableCallback, Provider, GuiGraphicsExtractor, JsonObject, Level, MouseButtonEvent, Override, Provider (+1 more)

### Community 51 - "Configuration Handling"
Cohesion: 0.06
Nodes (20): AbstractRecipeBookScreen, ConfigValue, EnumValue, Inventory, InventoryMenu, ModConfigSpec, RecipeBookComponent, TextOverflowMode (+12 more)

### Community 52 - "Modular System"
Cohesion: 0.21
Nodes (6): IOSupplier, ModContainer, Override, NeoForgeXplatModContainer, FunctionalInterface, Visitor

### Community 53 - "Rendering Utilities"
Cohesion: 0.34
Nodes (5): PoseStack, BlockPos, Override, LiquidBlockVertexConsumer, VertexConsumer

### Community 55 - "Page Linking"
Cohesion: 0.47
Nodes (4): Component, Level, Override, PageLink

### Community 56 - "Quest Management"
Cohesion: 0.23
Nodes (6): Button, GuiGraphicsExtractor, Identifier, Level, Override, PageQuest

### Community 57 - "Variable Processing"
Cohesion: 0.15
Nodes (7): JsonDeserializationContext, JsonElement, Override, Provider, Type, Serializer, Provider

### Community 58 - "Block State Matching"
Cohesion: 0.24
Nodes (7): BlockGetter, BlockPos, BlockState, Override, StubMatcher, FunctionalInterface, TriPredicate

### Community 59 - "Book Icon Handling"
Cohesion: 0.12
Nodes (16): BookIcon, GuiGraphicsExtractor, Identifier, ItemStack, Override, Provider, StackIcon, TextureIcon (+8 more)

### Community 60 - "Word Component"
Cohesion: 0.33
Nodes (8): BookRightClickHandler, BlockHitResult, InteractionHand, InteractionResult, Level, Nullable, Pair, Player

### Community 61 - "Book Folder Loader"
Cohesion: 0.36
Nodes (4): BookRegistry, Gson, Identifier, Level

### Community 62 - "Component Processor"
Cohesion: 0.16
Nodes (8): IComponentProcessor, Level, Nullable, Screen, IVariableProvider, JsonObject, Level, TemplateInclusion

### Community 63 - "Text Component"
Cohesion: 0.06
Nodes (28): Renderable, BookTextRenderer, GuiGraphicsExtractor, MouseButtonEvent, Override, GuiGraphicsExtractor, MouseButtonEvent, Override (+20 more)

### Community 64 - "Span Utilities"
Cohesion: 0.36
Nodes (6): CommandDispatcher, CommandSourceStack, Identifier, ServerPlayer, OpenBookCommand, SuggestionProvider

### Community 65 - "Bookmark Button"
Cohesion: 0.27
Nodes (5): InputWithModifiers, GuiButtonBookMarkRead, Component, GuiGraphicsExtractor, Override

### Community 66 - "Completion Model Property"
Cohesion: 0.15
Nodes (12): Buenas prácticas, Commits (Conventional Commits), Convenciones de nomenclatura, Específico del mod, Estructura del proyecto, Flujo de trabajo — Vellumli (NeoForge), Flujo por tarea, Idioma (+4 more)

### Community 68 - "Stack Wrapper"
Cohesion: 0.38
Nodes (7): LecternBlockEntity, BlockHitResult, InteractionHand, InteractionResult, Level, Player, LecternEventHandler

### Community 69 - "Component Header"
Cohesion: 0.33
Nodes (5): ComponentHeader, Component, GuiGraphicsExtractor, Override, Provider

### Community 70 - "Item Stack Component"
Cohesion: 0.33
Nodes (5): ComponentItemStack, GuiGraphicsExtractor, ItemStack, Override, Provider

### Community 71 - "Tooltip Component"
Cohesion: 0.33
Nodes (5): ComponentTooltip, Component, GuiGraphicsExtractor, Override, Provider

### Community 73 - "Serialization Utilities"
Cohesion: 0.26
Nodes (5): Button, GuiGraphicsExtractor, Level, Override, PageRelations

### Community 74 - "Entity Test Processor"
Cohesion: 0.36
Nodes (4): Provider, EntityTestProcessor, Level, Override

### Community 75 - "Book Entry Management"
Cohesion: 0.43
Nodes (5): ResourceManagerReloadListener, BookReloadHook, Identifier, Override, ResourceManager

### Community 76 - "JSON Variable Wrapper"
Cohesion: 0.36
Nodes (4): JsonObject, Override, Provider, JsonVariableWrapper

### Community 77 - "Recipe Test Processor"
Cohesion: 0.43
Nodes (5): Level, Nullable, Override, Recipe, RecipeTestProcessor

### Community 78 - "Ingredient Variable Serializer"
Cohesion: 0.62
Nodes (4): SoundEvent, Identifier, ResourceKey, VellumliSounds

### Community 80 - "Text Component Variable Serializer"
Cohesion: 0.80
Nodes (3): DataComponentType, Identifier, VellumliDataComponents

### Community 82 - "Rotation Utilities"
Cohesion: 0.43
Nodes (3): Direction, Rotation, RotationUtil

### Community 83 - "Sound Management"
Cohesion: 0.20
Nodes (9): Alta del proyecto en CurseForge (formulario manual), CurseForge — Variables del proyecto, Nota, Nota post-subida (manual, obligatorio), Proyecto, Rama, Tag, Tokens (+1 more)

### Community 85 - "Image Component"
Cohesion: 0.43
Nodes (4): ComponentImage, GuiGraphicsExtractor, Identifier, Override

### Community 86 - "Book GUI"
Cohesion: 0.25
Nodes (7): 0.0.0-beta.1, 0.0.0-beta.2, [0.0.0-beta.3] - 2026-08-05, [1.0.0] - 2026-08-10, Change, Changelog — Vellumli, Release

### Community 87 - "Key Mapping Accessor"
Cohesion: 0.53
Nodes (4): AccessorKeyMapping, Accessor, KeyMapping, Mixin

### Community 88 - "Widget Registration"
Cohesion: 0.22
Nodes (7): BookContentExternalLoader, Identifier, Override, Identifier, JsonElement, Nullable, LoadResult

### Community 89 - "Build Scripts"
Cohesion: 0.83
Nodes (3): gradlew script, die(), warn()

### Community 90 - "Project Setup"
Cohesion: 0.67
Nodes (3): Build fixes and mod icon, Initial project structure, Mod Icon

### Community 91 - "Page Interaction"
Cohesion: 0.33
Nodes (4): GuiButtonBookResize, Component, OnPress, Override

### Community 99 - "Vellumli"
Cohesion: 0.33
Nodes (5): Installation, License, Requirements, Status, Vellumli

### Community 100 - "ComponentSeparator.java"
Cohesion: 0.47
Nodes (3): ComponentSeparator, GuiGraphicsExtractor, Override

### Community 101 - "PageEmpty.java"
Cohesion: 0.40
Nodes (3): GuiGraphicsExtractor, Override, PageEmpty

### Community 102 - "CLAUDE.md — vellumli (26.2)"
Cohesion: 0.50
Nodes (3): CLAUDE.md — vellumli (26.2), Prioridad de instrucciones, Workflow del mod

## Knowledge Gaps
- **36 isolated node(s):** `OVERFLOW`, `TRUNCATE`, `RESIZE`, `UNREAD`, `PENDING` (+31 more)
  These have ≤1 connection - possible missing edges or undocumented components.
- **4 thin communities (<3 nodes) omitted from report** — run `graphify query` to explore isolated nodes.

## Suggested Questions
_Questions this graph is uniquely positioned to answer:_

- **Why does `Book` connect `Book Management` to `GUI Rendering`, `Book Entry List`, `Book GUI Operations`, `Content Loading`, `Advancement Handling`, `Book Entry Data`, `Book GUI Elements`, `Book Category Management`, `Book Page Rendering`, `GUI Button Operations`, `Screen Management`, `Persistent Data Handling`, `Modded Book Items`, `Item Stack Utilities`, `Text Formatting`, `Model Baking`, `GUI Button Types`, `Landing GUI Operations`, `Formatted Text Rendering`, `Custom Component Handling`, `Read State Management`, `External Content Loader`, `Category GUI Operations`, `Book Management`, `Configuration Handling`, `Drawing Functions`, `Quest Management`, `Book Icon Handling`, `Word Component`, `Book Folder Loader`, `Text Component`, `Bookmark Button`, `Item Stack Variable Serializer`, `Item Stack Variable Serializer`, `Widget Registration`, `PageEmpty.java`?**
  _High betweenness centrality (0.209) - this node is a cross-community bridge._
- **Why does `GuiBook` connect `Book GUI Operations` to `Recipe Management`, `GUI Rendering`, `Book Entry List`, `Recipe Types`, `API Implementation`, `Performance Profiling`, `Entity Rendering`, `Book Management`, `Book Entry Data`, `Book GUI Elements`, `Book Category Management`, `Book Page Rendering`, `GUI Button Operations`, `Text Formatting`, `GUI Button Types`, `Landing GUI Operations`, `Formatted Text Rendering`, `Custom Component Handling`, `Book Management`, `Configuration Handling`, `Drawing Functions`, `Page Linking`, `Quest Management`, `Book Icon Handling`, `Text Component`, `Bookmark Button`, `Component Header`, `Serialization Utilities`, `Page Interaction`, `ComponentSeparator.java`, `PageEmpty.java`?**
  _High betweenness centrality (0.186) - this node is a cross-community bridge._
- **Why does `BookEntry` connect `Book Entry Data` to `Recipe Management`, `Book Entry List`, `Book GUI Operations`, `Entity Rendering`, `Content Loading`, `Book Management`, `Book GUI Elements`, `Book Category Management`, `Book Page Rendering`, `Screen Management`, `Persistent Data Handling`, `Text Parsing`, `Item Stack Utilities`, `GUI Button Types`, `Landing GUI Operations`, `Formatted Text Rendering`, `Custom Component Handling`, `Read State Management`, `Category GUI Operations`, `Book Management`, `GUI Component Framework`, `Configuration Handling`, `Page Linking`, `Quest Management`, `Book Icon Handling`, `Word Component`, `Text Component`, `Bookmark Button`, `Component Header`, `Item Stack Component`, `Serialization Utilities`, `Item Stack Variable Serializer`, `Image Component`, `ComponentSeparator.java`?**
  _High betweenness centrality (0.120) - this node is a cross-community bridge._
- **What connects `OVERFLOW`, `TRUNCATE`, `RESIZE` to the rest of the system?**
  _36 weakly-connected nodes found - possible documentation gaps or missing edges._
- **Should `Recipe Management` be split into smaller, more focused modules?**
  _Cohesion score 0.06604324956165984 - nodes in this community are weakly interconnected._
- **Should `Book Entry List` be split into smaller, more focused modules?**
  _Cohesion score 0.06823529411764706 - nodes in this community are weakly interconnected._
- **Should `Recipe Types` be split into smaller, more focused modules?**
  _Cohesion score 0.06352941176470588 - nodes in this community are weakly interconnected._