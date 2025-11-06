#############################
# Build Stage
#############################
FROM gradle:8.10.2-jdk17-alpine AS build
WORKDIR /app

# Gradle wrapper + configs
COPY gradlew ./
COPY gradle ./gradle
COPY settings.gradle.kts settings.gradle.kts
COPY build.gradle.kts build.gradle.kts

RUN chmod +x gradlew

# Optional: dependency download
RUN ./gradlew dependencies --no-daemon || true

# Copy all project files
COPY . .

# Build Spring Boot JAR (skip tests)
RUN ./gradlew build --no-daemon -x test


#############################
# Runtime Stage
#############################
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app

ENV TZ=Asia/Seoul

# Copy JAR from build stage
COPY --from=build /app/build/libs/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
