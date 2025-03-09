# Step 1: Use a valid Maven image
FROM maven:3.9.6-openjdk-17-slim AS build

# Step 2: Set the working directory in the container
WORKDIR /app

# Step 3: Copy the pom.xml and install dependencies
COPY pom.xml .

# Step 4: Download the dependencies (using Maven)
RUN mvn dependency:go-offline

# Step 5: Copy the rest of the application code
COPY src /app/src

# Step 6: Build the Spring Boot application
RUN mvn clean package -DskipTests

# Step 7: Use OpenJDK to run the Spring Boot app
FROM openjdk:17-jdk-slim

# Step 8: Copy the built jar file from the build stage
COPY --from=build /app/target/*.jar /app/app.jar

# Step 9: Expose port 8080 for the app to be accessible
EXPOSE 8089

# Step 10: Run the Spring Boot application
CMD ["java", "-jar", "/app/app.jar"]
