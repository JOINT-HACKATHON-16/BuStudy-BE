FROM gradle:8.10.2-jdk17-alpine AS build
WORKDIR /app

COPY gradlew ./
COPY gradle ./gradle
COPY settings.gradle.kts settings.gradle.kts
COPY build.gradle.kts    build.gradle.kts

RUN chmod +x gradlew

# Optional dependency pre-fetch
RUN ./gradlew --no-daemon dependencies || true

COPY . .

RUN ./gradlew bootJar --no-daemon -x test

# ===========================
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app

ENV TZ=Asia/Seoul

COPY --from=build /app/build/libs/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
