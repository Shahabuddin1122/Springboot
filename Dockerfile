# Use a base image with Java and Maven installed
FROM maven:3.8.3-openjdk-11 AS builder

# Set the working directory in the container
WORKDIR /app

# Copy the Maven project file
COPY pom.xml .

# Download the dependencies
RUN mvn dependency:go-offline

# Copy the project source
COPY src ./src

# Build the application
RUN mvn package
RUN mvn verify

# Use a smaller base image for the runtime environment
FROM adoptopenjdk:11-jre-hotspot

# Set the working directory in the container
WORKDIR /app

# Copy the built JAR file from the builder stage
COPY --from=builder /app/target/*.jar app.jar

# Expose the port the application runs on
EXPOSE 8080

# Define the command to run the application
CMD ["java", "-jar", "app.jar"]
