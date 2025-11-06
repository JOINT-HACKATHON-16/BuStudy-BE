#############################
# Build Stage
#############################
FROM gradle:8.10.2-jdk17-alpine AS build
WORKDIR /app

# 프로젝트 고정 파일들만 먼저 복사 → 의존성 캐시
COPY gradlew ./
COPY gradle ./gradle
COPY settings.gradle.kts settings.gradle.kts
COPY build.gradle.kts    build.gradle.kts

RUN chmod +x gradlew

# 의존성 미리 다운로드
RUN ./gradlew --no-daemon dependencies || true

# 나머지 소스 복사
COPY . .

# Spring Boot 실행 JAR 생성 (test skip)
RUN ./gradlew clean bootJar -x test


#############################
# Runtime Stage
#############################
FROM eclipse-temurin:17-jre
WORKDIR /app

ENV TZ=Asia/Seoul

# 빌드 산출물 복사 (bootJar)
COPY --from=build /app/build/libs/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
