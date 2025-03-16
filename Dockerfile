# Step 1: Build the application
# Use an official Maven image with OpenJDK 17
FROM maven:3.8.4-openjdk-17-slim AS build

# Set the working directory
WORKDIR /app

# Copy the pom.xml and source code into the container
COPY pom.xml . 
COPY src ./src

# Run Maven to build the project and skip tests (or remove `-DskipTests` to run them)
RUN mvn clean package -DskipTests

# Step 2: Create the runtime image
# Use a smaller base image for running the application
FROM openjdk:17-jre-slim

# Set the working directory
WORKDIR /app

# Copy the JAR file from the build image
COPY --from=build /app/target/*.jar app.jar

# Expose the port the app will run on (optional, change if necessary)
EXPOSE 8089

# Run the application
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
