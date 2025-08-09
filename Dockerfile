# Use an official lightweight OpenJDK 17 runtime as base image
FROM openjdk:17-jdk-slim

# Argument to pass the built jar location
ARG JAR_FILE=target/*.jar

# Copy the jar file into the image
COPY ${JAR_FILE} app.jar

# Expose port 8080 inside container (your Spring Boot app listens on this port)
EXPOSE 8080

# Run the jar file
ENTRYPOINT ["java", "-jar", "/app.jar"]