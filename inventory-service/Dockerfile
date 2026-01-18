# 1️⃣ Build stage
FROM maven:3.9.9-eclipse-temurin-21 AS build
WORKDIR /app

# Copy pom first (for dependency caching)
COPY pom.xml .
RUN mvn dependency:go-offline

# Copy source code
COPY src ./src

# Build jar
RUN mvn clean package -DskipTests


# 2️⃣ Runtime stage
FROM eclipse-temurin:21-jre
WORKDIR /app

# Copy jar from build stage
COPY --from=build /app/target/*jar app.jar

# Expose inventory service port
EXPOSE 8083

# Run application
ENTRYPOINT ["java", "-jar", "app.jar"]
