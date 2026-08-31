<h1 align="center">&#128214; Vellumli</h1>

<p align="center"><strong>Accessible, data-driven, dependency-free in-game guidebooks &mdash; no Java required.</strong></p>

<p align="center">
<img src="https://img.shields.io/badge/loader-NeoForge-orange?style=plastic&logo=curseforge" alt="NeoForge">
<img src="https://img.shields.io/badge/minecraft-26.2%20%7C%201.21.1-blue?style=plastic" alt="Minecraft 26.2 and 1.21.1">
<img src="https://img.shields.io/badge/type-library-brightgreen?style=plastic" alt="Library">
<img src="https://img.shields.io/badge/license-CC%20BY--NC--SA%203.0-lightgrey?style=plastic" alt="CC BY-NC-SA 3.0">
</p>

<br>

---

<br>

<h2>&#10024; Overview</h2>

<table>
<tr>
<td width="65%">
<p>Vellumli lets modders and pack makers write in-game guidebooks for their content using nothing but data files &mdash; categories, entries and pages are defined in JSON and rendered as a fully navigable in-game book. It has no gameplay dependency on any other mod: any mod or datapack can ship its own book by adding data, not code.</p>

<p>A fork of <a href="https://github.com/VazkiiMods/Patchouli"><strong>Patchouli</strong></a> by <em>Vazkii</em> and <em>williewillus</em>, rebranded and maintained by <strong>Stalking Dragons</strong>. Not affiliated with or endorsed by the Patchouli authors.</p>
</td>
<td width="35%" align="center">
<a href="https://codex.skdragons.com/" target="_blank"><img src="https://node-files.skdragons.com/uploads/MINECRAFT/Codex/logo_codex_stalking_dragons.png" alt="Codex Stalking Dragons" width="160"></a>
</td>
</tr>
</table>

<br>

<h2>&#128218; Data-Driven Books</h2>

<p>Define categories, entries and pages entirely as JSON. Books, categories and entries can be added or overridden by datapacks and resource packs without touching Java code.</p>

<br>

<h2>&#129517; Rich Page Types</h2>

<p>Built-in page types for text, crafting / smelting / smithing / blasting / campfire recipe turn-ins, images, spotlight items, entity previews, relations, links and quests &mdash; enough to document almost any mod without custom code. Custom component and template systems allow reusable, parameterised layouts.</p>

<br>

<h2>&#129513; In-Game Navigation</h2>

<p>A full book GUI with a landing page, category browsing, entry search, bookmarks and history &mdash; players find the documentation they need without leaving the game.</p>

<br>

<h2>&#128275; Advancement-Gated Content</h2>

<p>Lock entries and categories behind advancements so documentation unlocks progressively as the player advances.</p>

<br>

<h2>&#129521; Mod Structure</h2>

<table>
<tr><th align="left">Area</th><th align="left">What it provides</th></tr>
<tr><td><code>api</code></td><td>The public surface other mods build against: the book/entry/page model, custom-component and multiblock hooks, and the render-context interfaces.</td></tr>
<tr><td><code>common/book</code></td><td>Book loading, the datapack/resourcepack registry, and folder discovery.</td></tr>
<tr><td><code>client/book</code></td><td>The book GUI, the page renderers, text layout and the bookmark/history system.</td></tr>
<tr><td><code>common/item</code></td><td>The guide-book item, its <code>book</code> data component and completion model property.</td></tr>
<tr><td><code>compat/jei</code></td><td>JEI subtype interpreter so each mod's book is a distinct, searchable ingredient. Optional.</td></tr>
<tr><td><code>xplat</code> / <code>neoforge</code></td><td>The platform abstraction layer and its NeoForge implementation (networking, mod list, events).</td></tr>
</table>

<br>

<h2>&#128203; Requirements</h2>

<table>
<tr><td><strong>Minecraft / NeoForge / Java</strong></td><td>see <em>Available Versions</em> below</td></tr>
<tr><td><strong>Dependencies</strong></td><td>None &mdash; Vellumli is dependency-free by design</td></tr>
<tr><td><strong>JEI</strong></td><td>Optional (searchable-book compat only)</td></tr>
<tr><td><strong>Side</strong></td><td>Client and Server (required on both)</td></tr>
</table>

<br>

<h2>&#128230; Available Versions</h2>

<table>
<tr><th align="left">Minecraft</th><th align="left">NeoForge</th><th align="left">Java</th><th align="left">Latest build</th><th align="left">Status</th></tr>
<tr><td>26.2</td><td>26.2.0.57+</td><td>21</td><td><code>1.2.0</code></td><td>Stable</td></tr>
<tr><td>1.21.1</td><td>21.1.249+</td><td>21</td><td><code>0.0.0-beta.1</code></td><td>Beta &mdash; re-fork port from upstream Patchouli 1.21.x</td></tr>
</table>

<p><em>Both versions share this CurseForge project. Pick the file that matches your Minecraft version.</em></p>

<br>

<h2>&#127918; How to Use</h2>

<ol>
<li>Install the mod on <strong>both client and server</strong>.</li>
<li>Craft or obtain a book item associated with a Vellumli-powered book (added by another mod or your datapack).</li>
<li>Author your own book by adding category / entry / page JSON files under a datapack &mdash; the format matches Patchouli's.</li>
</ol>

<br>

---

<br>

<h2>&#128591; Credits &amp; License</h2>

<p>Vellumli is a fork of <a href="https://github.com/VazkiiMods/Patchouli">Patchouli</a> by <strong>Vazkii</strong> and <strong>williewillus</strong>, rebranded and maintained by <strong>Stalking Dragons</strong>. The <code>1.21.1</code> build is a re-fork from the upstream Patchouli 1.21.x sources.</p>

<p><strong>License:</strong> <strong>CC BY-NC-SA 3.0</strong>, the same license as Patchouli. This is a <strong>ShareAlike</strong> requirement inherited from the original project: Vellumli (and any of its own forks) must stay under this license, credit Vazkii and williewillus, and <strong>may not be used for commercial purposes</strong>. The full licence text and attribution ship in the jar and the repository <code>LICENSE</code> file.</p>

<br>
<br>

<p align="center">
  <a href="https://codex.skdragons.com/" target="_blank">
    <img src="https://node-files.skdragons.com/uploads/MINECRAFT/Codex/logo_codex_stalking_dragons.png" alt="Codex Stalking Dragons" width="200">
  </a>
  <br>
  <a href="https://codex.skdragons.com/">https://codex.skdragons.com/</a>
  <br>
  <em>Codex Stalking Dragons &mdash; Minecraft Modding</em>
</p>
