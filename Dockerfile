# Use official Maven image with JDK 17
FROM maven:3.9.4-eclipse-temurin-17 AS build
WORKDIR /app

# Copy code and build the app
COPY . .
RUN mvn clean package -DskipTests

# Runtime image
FROM eclipse-temurin:17
WORKDIR /app
COPY --from=build /app/target/jobscheduler-0.0.1-SNAPSHOT.jar app.jar

# Expose port
EXPOSE 8080

# Run the app
ENTRYPOINT ["java", "-jar", "app.jar"]
