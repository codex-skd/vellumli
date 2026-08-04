# CurseForge — Variables del proyecto

## Proyecto

| Variable | Valor |
|----------|-------|
| `curseforge_project_id` | `1638492` |
| `mod_id` | `vellumli` |
| `display_name` | `Vellumli` |

## Tokens

| API | Token | Uso |
|-----|-------|-----|
| Upload | *(mismo token de cuenta que el resto de mods — ver `data_miner/26.1.2/docs/curseforge/project_vars.md` u otro mod ya publicado)* | Subir archivos JAR |
| Core (GET) | *(mismo token de cuenta)* | Consultar datos del mod |

Autenticación Upload: cabecera `X-Api-Token`
Autenticación Core: cabecera `x-api-key`

> Token de cuenta (mismo para todos los mods). No hace falta generar uno nuevo, copiarlo del `project_vars.md` de cualquier mod ya publicado.

## Variables para script (lectura automática)

```
project_id = 1638492
api_token = PENDIENTE (copiar del token de cuenta)
release_type = beta
game_versions = 16498  # Minecraft 26.2 — verificar ID exacto en CurseForge al publicar
relations =            # sin dependencias obligatorias
```

## Rama

```
minecraft/26.2/neoforge-26.2.0.32-beta/production
```

## Tag

Formato: `<mc-version>-<framework>-<version>`
Ejemplo: `26.2-neoforge-0.0.0-beta.1`

## Nota

La **primera subida a CurseForge se hace manual** (proyecto recién creado, sin archivos previos que verificar por API). A partir de la segunda subida se puede usar el script `codex-docs/scripts/curseforge-upload.ps1`.

---

## Alta del proyecto en CurseForge (formulario manual)

Datos a usar al crear el proyecto en https://www.curseforge.com/ (Minecraft → Create Project):

| Campo | Valor |
|---|---|
| **Name** | Vellumli |
| **Summary** (short, ~1 línea) | Accessible, data-driven, dependency-free documentation for Minecraft. |
| **Project Type** | Mod |
| **Game** | Minecraft |
| **Categories** | API and Library (categoría principal usada por Patchouli en CurseForge) |
| **Mod Loader** | NeoForge |
| **License** | CC BY-NC-SA 3.0 (seleccionar "Attribution-NonCommercial-ShareAlike" si aparece como opción, o pegar el texto/enlace de `LICENSE` si CurseForge solo permite texto libre) |
| **Client/Server side** | Both |
| **Repository URL** | `https://github.com/stalking-dragons/vellumli` (mirror público — confirmar tras configurar el mirror en GitLab) |
| **Issue tracker** | `https://gitlab.com/stalking-dragons/minecraft/vellumli/-/issues` |
| **Description** | Contenido de `docs/curseforge/project_description.md` (HTML) |
| **Logo** | `assets/vellumli/icon.png` — **pendiente de diseñar**, no reutilizar el logo de Patchouli |
| **Relaciones / dependencias** | Ninguna obligatoria (Vellumli es dependency-free, como el original) |

Proyecto ya creado (`project_id=1638492`, nombre "Vellumli" — "Vellum" a secas estaba ya ocupado en CurseForge). Falta copiar el token de subida en la tabla de arriba.

## Nota post-subida (manual, obligatorio)

El API de subida de CurseForge no expone el campo de lado (client/server). Tras **cada** subida de archivo hay que entrar en la web de CurseForge → pestaña "Files" → editar el archivo → marcar el entorno como **Client & Server**.
