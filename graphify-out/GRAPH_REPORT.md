# Graph Report - 26.2  (2026-08-20)

## Corpus Check
- 212 files · ~52,962 words
- Verdict: corpus is large enough that graph structure adds value.

## Summary
- 1969 nodes · 4693 edges · 101 communities (97 shown, 4 thin omitted)
- Extraction: 95% EXTRACTED · 5% INFERRED · 0% AMBIGUOUS · INFERRED: 253 edges (avg confidence: 0.8)
- Token cost: 0 input · 0 output

## Graph Freshness
- Built from commit: `6cb520e4`
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
- Bookmark Button
- Completion Model Property
- Style Stack Management
- Component Header
- Item Stack Component
- Tooltip Component
- Item Stack Variable Serializer
- Serialization Utilities
- Entity Test Processor
- JSON Variable Wrapper
- Recipe Test Processor
- Rotation Utilities
- Sound Management
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

## Communities (101 total, 4 thin omitted)

### Community 0 - "Recipe Management"
Cohesion: 0.07
Nodes (28): RecipeDisplay, SmithingRecipe, SmithingRecipeDisplay, GuiGraphicsExtractor, Override, Component, ContextMap, GuiGraphicsExtractor (+20 more)

### Community 1 - "GUI Rendering"
Cohesion: 0.15
Nodes (9): BookTextParser, CommandLookup, CommandProcessor, FunctionProcessor, Component, KeyMapping, MutableComponent, Pattern (+1 more)

### Community 2 - "Data Handling"
Cohesion: 0.06
Nodes (40): Codec, CommandDispatcher, CommandSourceStack, ContextAwarePredicate, CriterionTrigger, DataComponentType, EventBusSubscriber, Ints (+32 more)

### Community 3 - "Book GUI Components"
Cohesion: 0.25
Nodes (4): BreakIterator, Component, Font, TextLayouter

### Community 4 - "Book Entry List"
Cohesion: 0.06
Nodes (21): CrashReportDetail, GuiBookEntryList, Button, CharacterEvent, Component, EditBox, GuiGraphicsExtractor, KeyEvent (+13 more)

### Community 5 - "Recipe Types"
Cohesion: 0.06
Nodes (31): BlastingRecipe, CampfireCookingRecipe, SmeltingRecipe, SmokingRecipe, ContextMap, GuiGraphicsExtractor, Override, RecipeType (+23 more)

### Community 6 - "Block and Item Data"
Cohesion: 0.10
Nodes (18): IStateMatcher, Block, BlockPos, BlockState, Component, Holder, Identifier, Item (+10 more)

### Community 7 - "API Implementation"
Cohesion: 0.05
Nodes (29): AbstractRecipeBookScreen, Inventory, InventoryMenu, RecipeBookComponent, VellumliConfigAccess, Block, BlockPos, BlockState (+21 more)

### Community 8 - "Performance Profiling"
Cohesion: 0.05
Nodes (43): GuiElementRenderState, Matrix3x2f, RecipeHolder, RenderPipeline, ResourceManagerReloadListener, ScreenRectangle, ClientRecipes, Identifier (+35 more)

### Community 9 - "Book GUI Operations"
Cohesion: 0.12
Nodes (4): GuiBook, Component, GuiGraphicsExtractor, ItemStack

### Community 10 - "API Interface"
Cohesion: 0.08
Nodes (17): Logger, IVellumliAPI, Block, BlockPos, BlockState, Component, Holder, Identifier (+9 more)

### Community 11 - "Component Rendering"
Cohesion: 0.06
Nodes (23): IComponentRenderContext, AbstractWidget, Button, Component, Deprecated, GuiGraphicsExtractor, Identifier, Ingredient (+15 more)

### Community 12 - "Entity Rendering"
Cohesion: 0.11
Nodes (15): Entity, GuiGraphicsExtractor, Level, Override, PageEntity, ComponentEntity, Entity, GuiGraphicsExtractor (+7 more)

### Community 13 - "Content Loading"
Cohesion: 0.19
Nodes (10): BookContentLoader, BookContentsBuilder, Identifier, Nullable, Pair, Provider, LoadFunc, BookTemplate (+2 more)

### Community 14 - "Advancement Handling"
Cohesion: 0.11
Nodes (20): AdvancementHolder, AdvancementProgress, ClientboundUpdateAdvancementsPacket, ClientAdvancements, Font, GuiGraphicsExtractor, Identifier, NotNull (+12 more)

### Community 15 - "Packet Handling"
Cohesion: 0.17
Nodes (15): CustomPacketPayload, IPayloadContext, NeoForgeClientPayloadHandler, FriendlyByteBuf, Identifier, Override, StreamCodec, Type (+7 more)

### Community 16 - "Book Management"
Cohesion: 0.13
Nodes (10): GuiButtonInventoryBook, GuiGraphicsExtractor, Override, Book, Identifier, ItemStack, ItemStackTemplate, JsonObject (+2 more)

### Community 17 - "Book Entry Data"
Cohesion: 0.10
Nodes (10): BookEntry, Identifier, JsonObject, Override, Provider, GuiButtonEntry, GuiGraphicsExtractor, OnPress (+2 more)

### Community 18 - "Book GUI Elements"
Cohesion: 0.10
Nodes (14): GuiBookEntry, AbstractWidget, Button, Component, GuiGraphicsExtractor, Identifier, Ingredient, ItemStack (+6 more)

### Community 19 - "Variable Handling"
Cohesion: 0.25
Nodes (5): Deprecated, Provider, Provider, Provider, VariableAssigner

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
Cohesion: 0.14
Nodes (9): BookPage, Button, Component, Font, GuiGraphicsExtractor, JsonObject, Level, Minecraft (+1 more)

### Community 24 - "GUI Button Operations"
Cohesion: 0.14
Nodes (11): Button, GuiButtonBook, Component, GuiGraphicsExtractor, OnPress, Override, SoundManager, GuiButtonBookConfig (+3 more)

### Community 25 - "Screen Management"
Cohesion: 0.16
Nodes (8): Screen, GuiGraphicsExtractor, Level, MouseButtonEvent, Override, PageTemplate, GuiGraphicsExtractor, MouseButtonEvent

### Community 26 - "Persistent Data Handling"
Cohesion: 0.09
Nodes (20): JsonArray, BookData, Bookmark, DataHolder, Identifier, JsonObject, Nullable, PersistentData (+12 more)

### Community 27 - "Text Parsing"
Cohesion: 0.23
Nodes (5): IVariablesAvailableCallback, Provider, Context, Level, Pattern

### Community 28 - "Modded Book Items"
Cohesion: 0.06
Nodes (42): BakingContext, Item, ItemDisplayContext, ItemModel, ItemModelResolver, ItemStackRenderState, Matrix4fc, RangeSelectItemModelProperty (+34 more)

### Community 29 - "Platform Abstractions"
Cohesion: 0.13
Nodes (10): IXplatAbstractions, GuiGraphicsExtractor, Holder, Identifier, Ingredient, Item, ItemStack, MinecraftServer (+2 more)

### Community 30 - "Item Stack Utilities"
Cohesion: 0.08
Nodes (25): Either, HolderSet, ItemStack, Level, ItemStackArrayVariableSerializer, ItemStack, JsonElement, Override (+17 more)

### Community 31 - "Variable Providers"
Cohesion: 0.27
Nodes (7): Component, Font, GuiGraphicsExtractor, MouseButtonEvent, MutableComponent, Style, Word

### Community 32 - "Text Formatting"
Cohesion: 0.18
Nodes (6): MutableComponent, Override, Style, SpanPartialState, SpanState, TextColor

### Community 33 - "Model Baking"
Cohesion: 0.29
Nodes (9): ProfilerFiller, SimpleJsonResourceReloadListener, BookContentResourceListenerLoader, Identifier, JsonElement, Nullable, Override, Pattern (+1 more)

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
Cohesion: 0.16
Nodes (10): FormattedCharSequence, NarratableEntry, Screen, GuiButtonBookArrow, Minecraft, Pair, AccessorScreen, Accessor (+2 more)

### Community 39 - "Book Registry Management"
Cohesion: 0.11
Nodes (15): JsonDeserializer, ClientBookRegistry, Gson, Identifier, JsonDeserializationContext, JsonElement, Override, Type (+7 more)

### Community 40 - "Custom Component Handling"
Cohesion: 0.18
Nodes (3): Button, KeyEvent, MouseButtonEvent

### Community 41 - "Read State Management"
Cohesion: 0.18
Nodes (8): AbstractReadStateHolder, Override, EntryDisplayState, COMPLETED, NEUTRAL, PENDING, UNREAD, fromOrdinal()

### Community 42 - "External Content Loader"
Cohesion: 0.39
Nodes (4): BookContentResourceDirectLoader, Identifier, Nullable, Override

### Community 43 - "Event Handling"
Cohesion: 0.30
Nodes (4): BookDrawScreenEvent, GuiGraphicsExtractor, Identifier, Screen

### Community 44 - "Variable Serialization"
Cohesion: 0.27
Nodes (6): ComponentText, Component, GuiGraphicsExtractor, MouseButtonEvent, Override, Provider

### Community 45 - "Text Layouting"
Cohesion: 0.30
Nodes (5): Component, MutableComponent, Style, Span, SpanTail

### Community 46 - "State Matcher Logic"
Cohesion: 0.47
Nodes (3): BlockGetter, BlockPos, BlockState

### Community 47 - "Category GUI Operations"
Cohesion: 0.27
Nodes (4): GuiBookCategory, EditBox, GuiGraphicsExtractor, Override

### Community 48 - "Book Data Management"
Cohesion: 0.29
Nodes (5): RegisterPayloadHandlersEvent, Identifier, MinecraftServer, ServerPlayer, NeoForgeNetworkHandler

### Community 49 - "Book Management"
Cohesion: 0.17
Nodes (8): ImmutableMap, BookContents, Identifier, ItemStack, Nullable, Pair, Level, Level

### Community 50 - "GUI Component Framework"
Cohesion: 0.13
Nodes (11): ComponentFrame, GuiGraphicsExtractor, Override, ComponentImage, GuiGraphicsExtractor, Identifier, Override, GuiGraphicsExtractor (+3 more)

### Community 51 - "Configuration Handling"
Cohesion: 0.18
Nodes (9): ConfigValue, EnumValue, ModConfigSpec, TextOverflowMode, OVERFLOW, RESIZE, TRUNCATE, Config (+1 more)

### Community 52 - "Modular System"
Cohesion: 0.21
Nodes (6): IOSupplier, ModContainer, Override, NeoForgeXplatModContainer, FunctionalInterface, Visitor

### Community 53 - "Rendering Utilities"
Cohesion: 0.34
Nodes (5): PoseStack, BlockPos, Override, LiquidBlockVertexConsumer, VertexConsumer

### Community 54 - "Drawing Functions"
Cohesion: 0.31
Nodes (6): GuiButtonCategory, Component, GuiGraphicsExtractor, Nullable, Override, SoundManager

### Community 55 - "Page Linking"
Cohesion: 0.43
Nodes (4): Component, Level, Override, PageLink

### Community 56 - "Quest Management"
Cohesion: 0.60
Nodes (3): Event, BookContentsReloadEvent, Identifier

### Community 57 - "Variable Processing"
Cohesion: 0.19
Nodes (8): IVariable, JsonDeserializationContext, JsonElement, Override, Provider, Type, Serializer, Provider

### Community 58 - "Block State Matching"
Cohesion: 0.24
Nodes (7): BlockGetter, BlockPos, BlockState, Override, StubMatcher, FunctionalInterface, TriPredicate

### Community 59 - "Book Icon Handling"
Cohesion: 0.22
Nodes (9): BookIcon, GuiGraphicsExtractor, Identifier, ItemStack, Override, Provider, StackIcon, TextureIcon (+1 more)

### Community 62 - "Component Processor"
Cohesion: 0.18
Nodes (7): IComponentProcessor, Level, Nullable, Level, JsonObject, Level, TemplateInclusion

### Community 63 - "Text Component"
Cohesion: 0.06
Nodes (30): Renderable, BookTextRenderer, GuiGraphicsExtractor, MouseButtonEvent, Override, GuiBookWriter, Button, CharacterEvent (+22 more)

### Community 65 - "Bookmark Button"
Cohesion: 0.29
Nodes (5): InputWithModifiers, GuiButtonBookMarkRead, Component, GuiGraphicsExtractor, Override

### Community 66 - "Completion Model Property"
Cohesion: 0.15
Nodes (12): Buenas prácticas, Commits (Conventional Commits), Convenciones de nomenclatura, Específico del mod, Estructura del proyecto, Flujo de trabajo — Vellumli (NeoForge), Flujo por tarea, Idioma (+4 more)

### Community 69 - "Component Header"
Cohesion: 0.33
Nodes (5): ComponentHeader, Component, GuiGraphicsExtractor, Override, Provider

### Community 70 - "Item Stack Component"
Cohesion: 0.33
Nodes (5): ComponentItemStack, GuiGraphicsExtractor, ItemStack, Override, Provider

### Community 71 - "Tooltip Component"
Cohesion: 0.33
Nodes (5): ComponentTooltip, Component, GuiGraphicsExtractor, Override, Provider

### Community 72 - "Item Stack Variable Serializer"
Cohesion: 0.18
Nodes (5): BookFolderLoader, BookRegistry, Gson, Identifier, XplatModContainer

### Community 73 - "Serialization Utilities"
Cohesion: 0.26
Nodes (5): Button, GuiGraphicsExtractor, Level, Override, PageRelations

### Community 74 - "Entity Test Processor"
Cohesion: 0.27
Nodes (5): IVariableProvider, Provider, EntityTestProcessor, Level, Override

### Community 76 - "JSON Variable Wrapper"
Cohesion: 0.36
Nodes (4): JsonObject, Override, Provider, JsonVariableWrapper

### Community 77 - "Recipe Test Processor"
Cohesion: 0.36
Nodes (5): Level, Nullable, Override, Recipe, RecipeTestProcessor

### Community 82 - "Rotation Utilities"
Cohesion: 0.43
Nodes (3): Direction, Rotation, RotationUtil

### Community 83 - "Sound Management"
Cohesion: 0.20
Nodes (9): Alta del proyecto en CurseForge (formulario manual), CurseForge — Variables del proyecto, Nota, Nota post-subida (manual, obligatorio), Proyecto, Rama, Tag, Tokens (+1 more)

### Community 86 - "Book GUI"
Cohesion: 0.14
Nodes (13): 0.0.0-beta.1, 0.0.0-beta.2, [0.0.0-beta.3] - 2026-08-05, [1.0.0] - 2026-08-10, [1.0.1] - 2026-08-12, [1.0.2] - 2026-08-18, [1.1.0] - 2026-08-19, Change (+5 more)

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
- **39 isolated node(s):** `OVERFLOW`, `TRUNCATE`, `RESIZE`, `UNREAD`, `PENDING` (+34 more)
  These have ≤1 connection - possible missing edges or undocumented components.
- **4 thin communities (<3 nodes) omitted from report** — run `graphify query` to explore isolated nodes.

## Suggested Questions
_Questions this graph is uniquely positioned to answer:_

- **Why does `Book` connect `Book Management` to `GUI Rendering`, `Book Entry List`, `API Implementation`, `Performance Profiling`, `Book GUI Operations`, `Content Loading`, `Advancement Handling`, `Book Entry Data`, `Book GUI Elements`, `Book Category Management`, `Book Page Rendering`, `GUI Button Operations`, `Persistent Data Handling`, `Modded Book Items`, `Item Stack Utilities`, `Variable Providers`, `Text Formatting`, `Model Baking`, `Landing GUI Operations`, `Formatted Text Rendering`, `External Content Loader`, `Category GUI Operations`, `Book Management`, `Configuration Handling`, `Text Component`, `Bookmark Button`, `Item Stack Variable Serializer`, `Widget Registration`, `PageEmpty.java`?**
  _High betweenness centrality (0.206) - this node is a cross-community bridge._
- **Why does `GuiBook` connect `Book GUI Operations` to `Recipe Management`, `GUI Rendering`, `Book GUI Components`, `Book Entry List`, `Recipe Types`, `API Implementation`, `Performance Profiling`, `Entity Rendering`, `Book Management`, `Book Entry Data`, `Book GUI Elements`, `GUI Button Operations`, `Persistent Data Handling`, `Variable Providers`, `Text Formatting`, `GUI Button Types`, `Landing GUI Operations`, `Formatted Text Rendering`, `Custom Component Handling`, `Variable Serialization`, `Text Layouting`, `Book Management`, `GUI Component Framework`, `Configuration Handling`, `Drawing Functions`, `Page Linking`, `Book Icon Handling`, `Word Component`, `Text Component`, `Bookmark Button`, `Component Header`, `Serialization Utilities`, `Page Interaction`, `ComponentSeparator.java`, `PageEmpty.java`?**
  _High betweenness centrality (0.184) - this node is a cross-community bridge._
- **Why does `BookEntry` connect `Book Entry Data` to `Recipe Management`, `Book Entry List`, `API Implementation`, `Performance Profiling`, `Book GUI Operations`, `Component Rendering`, `Entity Rendering`, `Content Loading`, `Book Management`, `Book GUI Elements`, `Book Category Management`, `Book Page Rendering`, `Screen Management`, `Persistent Data Handling`, `Item Stack Utilities`, `Landing GUI Operations`, `Formatted Text Rendering`, `Read State Management`, `Variable Serialization`, `Category GUI Operations`, `Book Management`, `GUI Component Framework`, `Page Linking`, `Book Icon Handling`, `Text Component`, `Bookmark Button`, `Component Header`, `Item Stack Component`, `Serialization Utilities`, `ComponentSeparator.java`?**
  _High betweenness centrality (0.118) - this node is a cross-community bridge._
- **What connects `OVERFLOW`, `TRUNCATE`, `RESIZE` to the rest of the system?**
  _39 weakly-connected nodes found - possible documentation gaps or missing edges._
- **Should `Recipe Management` be split into smaller, more focused modules?**
  _Cohesion score 0.07390648567119155 - nodes in this community are weakly interconnected._
- **Should `GUI Rendering` be split into smaller, more focused modules?**
  _Cohesion score 0.14761904761904762 - nodes in this community are weakly interconnected._
- **Should `Data Handling` be split into smaller, more focused modules?**
  _Cohesion score 0.058469945355191254 - nodes in this community are weakly interconnected._