# CurseForge — Variables del proyecto

> **Rama 1.21.1**: `game_versions = 9638, 9639, 11779, 10150` (Client, Server, **1.21.1** id `11779`, NeoForge). `release_type = release`. JAR `vellumli-1.21.1-neoforge-21.1.249-<version>.jar`. Tag `1.21.1-neoforge-<version>`. Proyecto CurseForge compartido con la rama 26.2 (`1638492`).

## Proyecto

| Variable | Valor |
|----------|-------|
| `curseforge_project_id` | `1638492` |
| `mod_id` | `vellumli` |
| `display_name` | `Vellumli` |

## Tokens

| API | Token | Uso |
|-----|-------|-----|
| Upload | `ee776b0a-ee95-4850-b554-06be02a8657f` | Subir archivos JAR |
| Core (GET) | `$2a$10$yGwryAfmRkS9ZJsJUDf5YOKZpOIsmHB8Fji2D8JVCKBSZEKYlwmaO` | Consultar datos del mod |

Autenticación Upload: cabecera `X-Api-Token`
Autenticación Core: cabecera `x-api-key`

> Token de cuenta (mismo para todos los mods).

## Variables para script (lectura automática)

```
project_id = 1638492
api_token = ee776b0a-ee95-4850-b554-06be02a8657f
release_type = release
game_versions = 9638, 9639, 11779, 10150
relations =
```

El script lee `project_id`, `api_token` y `game_versions` de este archivo, y `mod_id`, `mod_name`, `minecraft_version`, `mod_version` de `gradle.properties`. Sube automáticamente el JAR desde `build/libs/` con el changelog de `docs/curseforge/versions/<version>.md`.

## Nota post-subida (manual, obligatorio)

El API de subida de CurseForge no expone el campo de lado (client/server) ni la licencia. Tras **cada** subida de archivo hay que entrar en la web de CurseForge → pestaña "Files" → editar el archivo → marcar el entorno como **Client & Server**. Además, confirmar en la ficha del proyecto que la licencia está en **CC BY-NC-SA 3.0** (no MIT / no "allow 3rd party").

## Datos del proyecto ("Create Project")

| Campo | Valor |
|---|---|
| **Name** | Vellumli |
| **Summary** | Accessible, data-driven, dependency-free documentation for Minecraft. |
| **Project Type** | Mod |
| **Game** | Minecraft |
| **Categories** | API and Library |
| **Mod Loader** | NeoForge |
| **License** | CC BY-NC-SA 3.0 |
| **Client/Server side** | Both |
| **Description** | Contenido de `docs/curseforge/project_description.md` (HTML) |
| **Relaciones / dependencias** | Ninguna obligatoria (Vellumli es dependency-free) |

## Nota para revisores de CurseForge

> This project is an open-source fork of "Patchouli" by Vazkii and williewillus
> (https://github.com/VazkiiMods/Patchouli), licensed CC BY-NC-SA 3.0. The fork stays under
> the same licence per its ShareAlike clause. The `1.21.1` file is a re-fork from the upstream
> Patchouli 1.21.x sources with all package/class identifiers renamed. Attribution is kept in
> LICENSE, README and the mod's `credits` field. Not affiliated with or endorsed by the
> Patchouli authors.

## Rama
minecraft/1.21.1/neoforge-21.1.249/production

## Tag
Formato: `<mc-version>-<framework>-<version>` — Ejemplo: `1.21.1-neoforge-0.0.0-beta.1`

## Repo GitLab
https://gitlab.com/stalking-dragons/minecraft/vellumli.git
