# Use the official OpenJDK image as a base image
FROM openjdk:17-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the Spring Boot application's JAR file to the container
COPY target/*.jar /app/myfirstspringbootapp.jar

# Expose the port the application will run on
EXPOSE 8082

# Command to run the JAR file
ENTRYPOINT ["java", "-jar", "/app/myfirstspringbootapp.jar"]        