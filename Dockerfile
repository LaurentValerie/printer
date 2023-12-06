# Первый этап сборки: собираем JAR с использованием Gradle и JDK
FROM gradle:8.4.0-jdk17 AS builder

# Устанавливаем рабочую директорию внутри контейнера
WORKDIR /app

# Копируем файлы для сборки
COPY build.gradle .
COPY settings.gradle .
COPY src ./src

# Собираем JAR-файл
RUN gradle bootJar --no-daemon

# Второй этап сборки: создаем контейнер с JDK 17 и копируем собранный JAR
FROM openjdk:17-jdk-slim

# Устанавливаем рабочую директорию внутри контейнера
WORKDIR /app

# Копируем собранный JAR-файл из предыдущего этапа
COPY --from=builder /app/build/libs/*.jar ./printer.jar

# Определение порта, который будет использоваться приложением
EXPOSE 8080

# Команда для запуска приложения при старте контейнера
CMD ["java", "-jar", "printer.jar"]
