
FROM gradle:8.10-jdk21-alpine AS builder

WORKDIR /app

COPY build.gradle* settings.gradle* gradlew ./
COPY gradle ./gradle

RUN ./gradlew --version

COPY src ./src

RUN ./gradlew clean bootJar -x test

FROM eclipse-temurin:21-jre-alpine

WORKDIR /app

# Копируем собранный jar из билд-стадии
COPY --from=builder /app/build/libs/*.jar app.jar

EXPOSE 8998

# Запускаем Spring Boot
ENTRYPOINT ["java", "-jar", "/app/app.jar"]