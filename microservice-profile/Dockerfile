# Use Amazon Corretto 21 (Java 21) on Alpine as base image
FROM amazoncorretto:21-alpine-jdk

# Set working directory inside the container
WORKDIR /app

# Copy the application JAR file into the container
ADD ./target/microservice-profile-0.0.1-SNAPSHOT.jar microservice-profile.jar

# Define the command to run the application when the container starts
ENTRYPOINT [ "java", "-jar", "microservice-profile.jar" ]
