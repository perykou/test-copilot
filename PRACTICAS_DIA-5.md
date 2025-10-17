# Práctica Día 5: Docker Local

**Duración:** 120 minutos | **Nivel:** Intermedio

## Objetivos

- Crear Dockerfiles para aplicaciones Java
- Usar Docker Compose
- Trabajar con volúmenes y redes
- Debugging en contenedores

## Ejercicios Principales

### Ejercicio 1: Dockerfile Multi-Stage (30 min)

Crea un Dockerfile optimizado:

```dockerfile
# Stage 1: Build
FROM maven:3.9-eclipse-temurin-21 AS build
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src ./src
RUN mvn package -DskipTests

# Stage 2: Runtime
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
```

### Ejercicio 2: Docker Compose (30 min)

Crea `docker-compose.yml`:

```yaml
version: '3.8'
services:
  app:
    build: .
    ports:
      - "8080:8080"
    environment:
      - SPRING_PROFILES_ACTIVE=docker
    volumes:
      - ./logs:/app/logs
```

Ejecuta:

```bash
docker-compose up --build
```

### Ejercicio 3: Volúmenes y Persistencia (20 min)

Añade un volumen para datos persistentes y verifica que los logs se guardan en el host.

### Ejercicio 4: Redes Docker (20 min)

Añade un servicio de base de datos (PostgreSQL) y conecta la aplicación.

### Ejercicio 5: Debugging (20 min)

Ejecuta el contenedor en modo debug:

```bash
docker run -p 8080:8080 -p 5005:5005 \
  -e JAVA_TOOL_OPTIONS="-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:5005" \
  curso-spring-boot
```

Conecta el debugger de VSCode al puerto 5005.