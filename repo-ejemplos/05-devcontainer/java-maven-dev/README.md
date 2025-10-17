# Día 5 — Dev Containers (Java/Maven + debug) — VM Debian 13

**Objetivo:** abrir este proyecto en un Dev Container, compilar, ejecutar y depurar con VSCode dentro del contenedor. Todo **local** dentro de la VM (sin servidores).

## Pasos
1. Abre la carpeta `java-maven-dev` en VSCode.
2. Acepta la propuesta “Reopen in Container” o ejecuta “Dev Containers: Reopen in Container”.
3. Espera a que finalice `postCreateCommand` (`mvn -v && java -version`).
4. Ejecuta tareas: **Terminal → Run Task… → mvn package** o pulsa **F5** (**Depurar App (Main)**).
5. Cambia el argumento en `launch.json` si quieres personalizar el saludo.

## Verificaciones
- `Help → About` muestra VSCode corriendo dentro del contenedor.
- `mvn -q test` pasa en el contenedor.
- No se exponen puertos; todo funciona en **localhost** dentro de la VM.

## Troubleshooting
- Si el contenedor no levanta, revisa el log de “Dev Containers” y la salida de Docker en la VM.
- Si no hay Internet, usa un devcontainer con cache local o instala dependencias en la VM previamente.
