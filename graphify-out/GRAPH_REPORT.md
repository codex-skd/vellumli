# Graph Report - 26.2  (2026-08-06)

## Corpus Check
- 208 files · ~52,754 words
- Verdict: corpus is large enough that graph structure adds value.

## Summary
- 1960 nodes · 4688 edges · 107 communities (104 shown, 3 thin omitted)
- Extraction: 95% EXTRACTED · 5% INFERRED · 0% AMBIGUOUS · INFERRED: 253 edges (avg confidence: 0.8)
- Token cost: 0 input · 0 output

## Graph Freshness
- Built from commit: `d6a9c7a7`
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
- JSON Variable Wrapper
- Recipe Test Processor
- Ingredient Variable Serializer
- Item Stack Variable Serializer
- Text Component Variable Serializer
- Variable Handling
- Rotation Utilities
- Sound Management
- Rendering Functions
- Image Component
- Book GUI
- Key Mapping Accessor
- Widget Registration
- Build Scripts
- Project Setup
- Page Interaction
- Variable Availability
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

## Communities (107 total, 3 thin omitted)

### Community 0 - "Recipe Management"
Cohesion: 0.07
Nodes (28): RecipeDisplay, SmithingRecipe, SmithingRecipeDisplay, Override, Component, ContextMap, GuiGraphicsExtractor, Identifier (+20 more)

### Community 1 - "GUI Rendering"
Cohesion: 0.21
Nodes (8): GuiBookWriter, Button, CharacterEvent, EditBox, GuiGraphicsExtractor, KeyEvent, MouseButtonEvent, Override

### Community 2 - "Data Handling"
Cohesion: 0.06
Nodes (40): Codec, CommandDispatcher, CommandSourceStack, ContextAwarePredicate, CriterionTrigger, DataComponentType, EventBusSubscriber, Ints (+32 more)

### Community 3 - "Book GUI Components"
Cohesion: 0.30
Nodes (9): AbstractRecipeBookScreen, Inventory, InventoryMenu, RecipeBookComponent, CallbackInfo, Component, Inject, Mixin (+1 more)

### Community 4 - "Book Entry List"
Cohesion: 0.06
Nodes (21): CrashReportDetail, GuiBookEntryList, Button, CharacterEvent, Component, EditBox, GuiGraphicsExtractor, KeyEvent (+13 more)

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
Cohesion: 0.05
Nodes (43): GuiElementRenderState, Matrix3x2f, RecipeHolder, RenderPipeline, ResourceManagerReloadListener, ScreenRectangle, ClientRecipes, Identifier (+35 more)

### Community 10 - "API Interface"
Cohesion: 0.10
Nodes (14): Logger, IVellumliAPI, BlockPos, Component, Holder, Identifier, Item, ItemStack (+6 more)

### Community 11 - "Component Rendering"
Cohesion: 0.06
Nodes (24): IComponentRenderContext, AbstractWidget, Button, Component, Deprecated, GuiGraphicsExtractor, Identifier, Ingredient (+16 more)

### Community 12 - "Entity Rendering"
Cohesion: 0.06
Nodes (29): GuiGraphicsExtractor, MouseButtonEvent, Override, PageWithText, Entity, GuiGraphicsExtractor, Level, Override (+21 more)

### Community 13 - "Content Loading"
Cohesion: 0.27
Nodes (7): BookContentLoader, BookContentsBuilder, Identifier, Nullable, Pair, Provider, LoadFunc

### Community 14 - "Advancement Handling"
Cohesion: 0.10
Nodes (21): AdvancementHolder, AdvancementProgress, ClientboundUpdateAdvancementsPacket, ClientAdvancements, Font, GuiGraphicsExtractor, Identifier, NotNull (+13 more)

### Community 15 - "Packet Handling"
Cohesion: 0.17
Nodes (15): CustomPacketPayload, IPayloadContext, NeoForgeClientPayloadHandler, FriendlyByteBuf, Identifier, Override, StreamCodec, Type (+7 more)

### Community 16 - "Book Management"
Cohesion: 0.14
Nodes (8): GuiButtonInventoryBook, GuiGraphicsExtractor, Book, Identifier, ItemStackTemplate, JsonObject, MutableComponent, XplatModContainer

### Community 17 - "Book Entry Data"
Cohesion: 0.11
Nodes (10): BookEntry, Identifier, JsonObject, Override, Provider, GuiButtonEntry, GuiGraphicsExtractor, OnPress (+2 more)

### Community 18 - "Book GUI Elements"
Cohesion: 0.10
Nodes (6): GuiBookEntry, GuiGraphicsExtractor, Identifier, MouseButtonEvent, Override, SuppressWarnings

### Community 19 - "Variable Handling"
Cohesion: 0.18
Nodes (8): IVariable, Deprecated, Provider, Override, Provider, Provider, Provider, VariableAssigner

### Community 20 - "Item and Block Management"
Cohesion: 0.15
Nodes (12): Items, GuiGraphicsExtractor, Holder, Identifier, Ingredient, Item, ItemStack, MinecraftServer (+4 more)

### Community 21 - "Multiblock Logic"
Cohesion: 0.14
Nodes (9): IMultiblock, BlockPos, Identifier, Level, Nullable, Pair, Rotation, Vec3i (+1 more)

### Community 22 - "Book Category Management"
Cohesion: 0.12
Nodes (7): BookCategory, Identifier, JsonObject, MutableComponent, Nullable, Override, Provider

### Community 23 - "Book Page Rendering"
Cohesion: 0.22
Nodes (9): BookPage, Button, Component, Font, GuiGraphicsExtractor, JsonObject, Level, Minecraft (+1 more)

### Community 24 - "GUI Button Operations"
Cohesion: 0.17
Nodes (8): GuiButtonBook, Component, GuiGraphicsExtractor, OnPress, Override, SoundManager, GuiButtonBookArrowSmall, OnPress

### Community 25 - "Screen Management"
Cohesion: 0.18
Nodes (9): GuiGraphicsExtractor, Level, MouseButtonEvent, Override, PageTemplate, BookTemplate, GuiGraphicsExtractor, Identifier (+1 more)

### Community 26 - "Persistent Data Handling"
Cohesion: 0.10
Nodes (22): JsonArray, BookData, Bookmark, DataHolder, Identifier, JsonObject, Nullable, PersistentData (+14 more)

### Community 27 - "Text Parsing"
Cohesion: 0.15
Nodes (9): BookTextParser, CommandLookup, CommandProcessor, FunctionProcessor, Component, KeyMapping, MutableComponent, Pattern (+1 more)

### Community 28 - "Modded Book Items"
Cohesion: 0.07
Nodes (38): BakingContext, Item, ItemDisplayContext, ItemModel, ItemModelResolver, ItemStackRenderState, Matrix4fc, RangeSelectItemModelProperty (+30 more)

### Community 29 - "Platform Abstractions"
Cohesion: 0.13
Nodes (10): IXplatAbstractions, GuiGraphicsExtractor, Holder, Identifier, Ingredient, Item, ItemStack, MinecraftServer (+2 more)

### Community 30 - "Item Stack Utilities"
Cohesion: 0.18
Nodes (11): Either, HolderSet, ItemStackUtil, Ingredient, Item, ItemStack, ItemStackTemplate, JsonObject (+3 more)

### Community 31 - "Variable Providers"
Cohesion: 0.24
Nodes (5): IVariablesAvailableCallback, Provider, Context, Level, Pattern

### Community 32 - "Text Formatting"
Cohesion: 0.18
Nodes (6): MutableComponent, Override, Style, SpanPartialState, SpanState, TextColor

### Community 33 - "Model Baking"
Cohesion: 0.29
Nodes (9): ProfilerFiller, SimpleJsonResourceReloadListener, BookContentResourceListenerLoader, Identifier, JsonElement, Nullable, Override, Pattern (+1 more)

### Community 34 - "GUI Button Types"
Cohesion: 0.13
Nodes (12): Button, GuiButtonBookConfig, OnPress, GuiButtonBookEye, GuiGraphicsExtractor, OnPress, GuiButtonCategory, Component (+4 more)

### Community 35 - "Variable Helpers"
Cohesion: 0.16
Nodes (9): JsonElement, Nullable, Provider, VariableHelper, JsonElement, Override, Provider, SuppressWarnings (+1 more)

### Community 36 - "Landing GUI Operations"
Cohesion: 0.17
Nodes (5): GuiBookLanding, Button, GuiGraphicsExtractor, MouseButtonEvent, Override

### Community 37 - "Stub Multiblock Logic"
Cohesion: 0.22
Nodes (8): BlockPos, Identifier, Level, Override, Pair, Rotation, Vec3i, StubMultiblock

### Community 38 - "Formatted Text Rendering"
Cohesion: 0.15
Nodes (10): FormattedCharSequence, NarratableEntry, Screen, Minecraft, Pair, Renderable, AccessorScreen, Accessor (+2 more)

### Community 39 - "Book Registry Management"
Cohesion: 0.10
Nodes (19): JsonDeserializer, SoundEvent, ClientBookRegistry, Gson, Identifier, JsonDeserializationContext, JsonElement, Override (+11 more)

### Community 41 - "Read State Management"
Cohesion: 0.18
Nodes (8): AbstractReadStateHolder, Override, EntryDisplayState, COMPLETED, NEUTRAL, PENDING, UNREAD, fromOrdinal()

### Community 42 - "External Content Loader"
Cohesion: 0.21
Nodes (8): Identifier, JsonElement, Nullable, LoadResult, BookContentResourceDirectLoader, Identifier, Nullable, Override

### Community 43 - "Event Handling"
Cohesion: 0.30
Nodes (4): BookDrawScreenEvent, GuiGraphicsExtractor, Identifier, Screen

### Community 44 - "Variable Serialization"
Cohesion: 0.21
Nodes (8): IVariableSerializer, JsonElement, Provider, GenericArrayVariableSerializer, JsonElement, Override, Provider, SuppressWarnings

### Community 45 - "Text Layouting"
Cohesion: 0.19
Nodes (8): BreakIterator, Component, MutableComponent, Style, Span, Font, SpanTail, TextLayouter

### Community 46 - "State Matcher Logic"
Cohesion: 0.20
Nodes (7): IStateMatcher, BlockGetter, BlockPos, BlockState, Block, BlockState, TagKey

### Community 47 - "Category GUI Operations"
Cohesion: 0.27
Nodes (4): GuiBookCategory, EditBox, GuiGraphicsExtractor, Override

### Community 48 - "Book Data Management"
Cohesion: 0.22
Nodes (7): Renderable, BookTextRenderer, Component, GuiGraphicsExtractor, MouseButtonEvent, Override, Style

### Community 49 - "Book Management"
Cohesion: 0.17
Nodes (8): ImmutableMap, BookContents, Identifier, ItemStack, Nullable, Pair, Level, Level

### Community 50 - "GUI Component Framework"
Cohesion: 0.19
Nodes (6): ComponentFrame, GuiGraphicsExtractor, Override, GuiGraphicsExtractor, MouseButtonEvent, TemplateComponent

### Community 51 - "Configuration Handling"
Cohesion: 0.11
Nodes (10): ConfigValue, EnumValue, ModConfigSpec, TextOverflowMode, OVERFLOW, RESIZE, TRUNCATE, VellumliConfigAccess (+2 more)

### Community 52 - "Modular System"
Cohesion: 0.21
Nodes (6): IOSupplier, ModContainer, Override, NeoForgeXplatModContainer, FunctionalInterface, Visitor

### Community 53 - "Rendering Utilities"
Cohesion: 0.34
Nodes (5): PoseStack, BlockPos, Override, LiquidBlockVertexConsumer, VertexConsumer

### Community 54 - "Drawing Functions"
Cohesion: 0.15
Nodes (5): GuiGraphicsExtractor, GuiBook, Component, GuiGraphicsExtractor, ItemStack

### Community 55 - "Page Linking"
Cohesion: 0.20
Nodes (7): Component, Level, Override, PageLink, GuiGraphicsExtractor, Override, PageText

### Community 56 - "Quest Management"
Cohesion: 0.27
Nodes (6): Button, GuiGraphicsExtractor, Identifier, Level, Override, PageQuest

### Community 57 - "Variable Processing"
Cohesion: 0.24
Nodes (6): JsonDeserializationContext, JsonElement, Override, Provider, Type, Serializer

### Community 58 - "Block State Matching"
Cohesion: 0.24
Nodes (7): BlockGetter, BlockPos, BlockState, Override, StubMatcher, FunctionalInterface, TriPredicate

### Community 59 - "Book Icon Handling"
Cohesion: 0.25
Nodes (8): BookIcon, GuiGraphicsExtractor, Identifier, ItemStack, Override, Provider, StackIcon, TextureIcon

### Community 60 - "Word Component"
Cohesion: 0.27
Nodes (7): Component, Font, GuiGraphicsExtractor, MouseButtonEvent, MutableComponent, Style, Word

### Community 61 - "Book Folder Loader"
Cohesion: 0.27
Nodes (4): BookFolderLoader, BookRegistry, Gson, Identifier

### Community 62 - "Component Processor"
Cohesion: 0.15
Nodes (9): IComponentProcessor, Level, Nullable, Screen, JsonObject, Level, JsonObject, Level (+1 more)

### Community 63 - "Text Component"
Cohesion: 0.27
Nodes (6): ComponentText, Component, GuiGraphicsExtractor, MouseButtonEvent, Override, Provider

### Community 64 - "Span Utilities"
Cohesion: 0.15
Nodes (3): GuiButtonBookArrow, Button, MouseButtonEvent

### Community 65 - "Bookmark Button"
Cohesion: 0.31
Nodes (5): InputWithModifiers, GuiButtonBookMarkRead, Component, GuiGraphicsExtractor, Override

### Community 66 - "Completion Model Property"
Cohesion: 0.15
Nodes (12): Buenas prácticas, Commits (Conventional Commits), Convenciones de nomenclatura, Específico del mod, Estructura del proyecto, Flujo de trabajo — Vellumli (NeoForge), Flujo por tarea, Idioma (+4 more)

### Community 68 - "Stack Wrapper"
Cohesion: 0.24
Nodes (4): ItemStack, Level, Override, StackWrapper

### Community 69 - "Component Header"
Cohesion: 0.29
Nodes (5): ComponentHeader, Component, GuiGraphicsExtractor, Override, Provider

### Community 70 - "Item Stack Component"
Cohesion: 0.33
Nodes (5): ComponentItemStack, GuiGraphicsExtractor, ItemStack, Override, Provider

### Community 71 - "Tooltip Component"
Cohesion: 0.33
Nodes (5): ComponentTooltip, Component, GuiGraphicsExtractor, Override, Provider

### Community 72 - "Item Stack Variable Serializer"
Cohesion: 0.42
Nodes (5): ItemStackArrayVariableSerializer, ItemStack, JsonElement, Override, Provider

### Community 73 - "Serialization Utilities"
Cohesion: 0.29
Nodes (5): Button, GuiGraphicsExtractor, Level, Override, PageRelations

### Community 74 - "Entity Test Processor"
Cohesion: 0.18
Nodes (6): IVariableProvider, Provider, Level, EntityTestProcessor, Level, Override

### Community 76 - "JSON Variable Wrapper"
Cohesion: 0.36
Nodes (4): JsonObject, Override, Provider, JsonVariableWrapper

### Community 77 - "Recipe Test Processor"
Cohesion: 0.43
Nodes (5): Level, Nullable, Override, Recipe, RecipeTestProcessor

### Community 78 - "Ingredient Variable Serializer"
Cohesion: 0.50
Nodes (5): IngredientVariableSerializer, Ingredient, JsonElement, Override, Provider

### Community 79 - "Item Stack Variable Serializer"
Cohesion: 0.50
Nodes (5): ItemStackVariableSerializer, ItemStack, JsonElement, Override, Provider

### Community 80 - "Text Component Variable Serializer"
Cohesion: 0.50
Nodes (5): Component, JsonElement, Override, Provider, TextComponentVariableSerializer

### Community 81 - "Variable Handling"
Cohesion: 0.43
Nodes (4): JsonElement, Override, Provider, Variable

### Community 82 - "Rotation Utilities"
Cohesion: 0.43
Nodes (3): Direction, Rotation, RotationUtil

### Community 83 - "Sound Management"
Cohesion: 0.20
Nodes (9): Alta del proyecto en CurseForge (formulario manual), CurseForge — Variables del proyecto, Nota, Nota post-subida (manual, obligatorio), Proyecto, Rama, Tag, Tokens (+1 more)

### Community 84 - "Rendering Functions"
Cohesion: 0.29
Nodes (5): RegisterPayloadHandlersEvent, Identifier, MinecraftServer, ServerPlayer, NeoForgeNetworkHandler

### Community 85 - "Image Component"
Cohesion: 0.43
Nodes (4): ComponentImage, GuiGraphicsExtractor, Identifier, Override

### Community 86 - "Book GUI"
Cohesion: 0.22
Nodes (8): 0.0.0-beta.1, 0.0.0-beta.1, 0.0.0-beta.2, 0.0.0-beta.2, [0.0.0-beta.3] - 2026-08-05, [angelog — Vellumli, Change, Changelog — Vellumli

### Community 87 - "Key Mapping Accessor"
Cohesion: 0.53
Nodes (4): AccessorKeyMapping, Accessor, KeyMapping, Mixin

### Community 88 - "Widget Registration"
Cohesion: 0.42
Nodes (3): BookContentExternalLoader, Identifier, Override

### Community 89 - "Build Scripts"
Cohesion: 0.83
Nodes (3): gradlew script, die(), warn()

### Community 90 - "Project Setup"
Cohesion: 0.67
Nodes (3): Build fixes and mod icon, Initial project structure, Mod Icon

### Community 91 - "Page Interaction"
Cohesion: 0.33
Nodes (4): GuiButtonBookResize, Component, OnPress, Override

### Community 92 - "Variable Availability"
Cohesion: 0.60
Nodes (3): Event, BookContentsReloadEvent, Identifier

### Community 99 - "Vellumli"
Cohesion: 0.33
Nodes (5): Installation, License, Requirements, Status, Vellumli

### Community 100 - "ComponentSeparator.java"
Cohesion: 0.47
Nodes (3): ComponentSeparator, GuiGraphicsExtractor, Override

### Community 101 - "PageEmpty.java"
Cohesion: 0.50
Nodes (3): GuiGraphicsExtractor, Override, PageEmpty

### Community 102 - "CLAUDE.md — vellumli (26.2)"
Cohesion: 0.50
Nodes (3): CLAUDE.md — vellumli (26.2), Prioridad de instrucciones, Workflow del mod

## Knowledge Gaps
- **38 isolated node(s):** `OVERFLOW`, `TRUNCATE`, `RESIZE`, `UNREAD`, `PENDING` (+33 more)
  These have ≤1 connection - possible missing edges or undocumented components.
- **3 thin communities (<3 nodes) omitted from report** — run `graphify query` to explore isolated nodes.

## Suggested Questions
_Questions this graph is uniquely positioned to answer:_

- **Why does `Book` connect `Book Management` to `GUI Rendering`, `Book Entry List`, `Performance Profiling`, `Book GUI Operations`, `Content Loading`, `Advancement Handling`, `Book Entry Data`, `Book GUI Elements`, `Book Category Management`, `Book Page Rendering`, `GUI Button Operations`, `Screen Management`, `Persistent Data Handling`, `Text Parsing`, `Modded Book Items`, `Item Stack Utilities`, `Text Formatting`, `Model Baking`, `Landing GUI Operations`, `Formatted Text Rendering`, `Custom Component Handling`, `External Content Loader`, `Category GUI Operations`, `Book Data Management`, `Book Management`, `Configuration Handling`, `Drawing Functions`, `Quest Management`, `Book Icon Handling`, `Word Component`, `Book Folder Loader`, `Bookmark Button`, `Widget Registration`?**
  _High betweenness centrality (0.209) - this node is a cross-community bridge._
- **Why does `GuiBook` connect `Drawing Functions` to `Recipe Management`, `GUI Rendering`, `Book Entry List`, `Recipe Types`, `API Implementation`, `Performance Profiling`, `Book GUI Operations`, `Entity Rendering`, `Book Management`, `Book Entry Data`, `Book GUI Elements`, `GUI Button Operations`, `Persistent Data Handling`, `Text Parsing`, `Text Formatting`, `GUI Button Types`, `Landing GUI Operations`, `Formatted Text Rendering`, `Text Layouting`, `Book Data Management`, `Book Management`, `GUI Component Framework`, `Configuration Handling`, `Page Linking`, `Quest Management`, `Word Component`, `Text Component`, `Span Utilities`, `Bookmark Button`, `Component Header`, `Serialization Utilities`, `Book Entry Management`, `Page Interaction`, `ComponentSeparator.java`, `PageEmpty.java`?**
  _High betweenness centrality (0.186) - this node is a cross-community bridge._
- **Why does `BookEntry` connect `Book Entry Data` to `Recipe Management`, `Book Entry List`, `Performance Profiling`, `Component Rendering`, `Entity Rendering`, `Content Loading`, `Book Management`, `Book GUI Elements`, `Book Category Management`, `Book Page Rendering`, `Screen Management`, `Persistent Data Handling`, `Landing GUI Operations`, `Formatted Text Rendering`, `Custom Component Handling`, `Read State Management`, `Category GUI Operations`, `Book Management`, `GUI Component Framework`, `Drawing Functions`, `Page Linking`, `Quest Management`, `Book Icon Handling`, `Component Processor`, `Text Component`, `Bookmark Button`, `Stack Wrapper`, `Component Header`, `Item Stack Component`, `Serialization Utilities`, `Book Entry Management`, `Image Component`, `ComponentSeparator.java`?**
  _High betweenness centrality (0.120) - this node is a cross-community bridge._
- **What connects `OVERFLOW`, `TRUNCATE`, `RESIZE` to the rest of the system?**
  _38 weakly-connected nodes found - possible documentation gaps or missing edges._
- **Should `Recipe Management` be split into smaller, more focused modules?**
  _Cohesion score 0.07256894049346879 - nodes in this community are weakly interconnected._
- **Should `Data Handling` be split into smaller, more focused modules?**
  _Cohesion score 0.059322033898305086 - nodes in this community are weakly interconnected._
- **Should `Book Entry List` be split into smaller, more focused modules?**
  _Cohesion score 0.05868118572292801 - nodes in this community are weakly interconnected._