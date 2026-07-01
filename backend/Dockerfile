# Development Dockerfile.
#
# This intentionally runs the app with the Maven wrapper directly (not a
# pre-built jar), so DevTools can watch for file changes and restart the app
# automatically when you edit code on your host machine. This is NOT how you'd
# package a real production image (see Module 12, which introduces an
# optimized multi-stage build instead).
FROM eclipse-temurin:21-jdk

WORKDIR /app

# Copy just the wrapper + pom first so Docker can cache the dependency
# download step separately from your actual source code.
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
RUN ./mvnw -q dependency:go-offline

# Source code is bind-mounted over this in docker-compose.yml for live-reload
# during development; this COPY just means the image also works standalone.
COPY src src

EXPOSE 8080

CMD ["./mvnw", "spring-boot:run"]
