# =========================
# Stage 1: Build the application
# =========================
FROM eclipse-temurin:21-jdk AS build

# Working directory inside the build container
WORKDIR /app

# Copy the complete project into the container
COPY . .

# Make Maven Wrapper executable
RUN chmod +x mvnw

# Build the Spring Boot application
# Tests are skipped because GitHub Actions already runs the build/test pipeline
RUN ./mvnw clean package -DskipTests


# =========================
# Stage 2: Run the application
# =========================
FROM eclipse-temurin:21-jre

# Working directory inside the runtime container
WORKDIR /app

# Copy the generated JAR from the build stage
COPY --from=build /app/target/*.jar app.jar

# Spring Boot application port
EXPOSE 3002

# Start the application
ENTRYPOINT ["java", "-jar", "app.jar"]