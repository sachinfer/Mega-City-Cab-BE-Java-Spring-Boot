# Use an official Java runtime as a parent image
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the jar file from your local system to the container
COPY target/vehicle-portal-0.0.1-SNAPSHOT.jar /app/vehicle-portal.jar

# Expose the port the app will run on (default is 8080 for Spring Boot apps)
EXPOSE 8080

# Run the jar file
CMD ["java", "-jar", "vehicle-portal.jar"]
