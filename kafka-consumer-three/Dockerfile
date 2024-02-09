# Use a base image with Java 17 and Maven installed
FROM maven:3.8.3-openjdk-17 AS build

# Set the working directory inside the container
WORKDIR /app

# Copy the pom.xml and dependencies
COPY pom.xml .

# Resolve the dependencies and download them
RUN mvn dependency:go-offline -B

# Copy the application source code
COPY src ./src

# Build the application
RUN mvn clean package -DskipTests

# Use a lightweight base image with Java 17 installed
FROM openjdk:17.0.2-jdk-oracle AS runtime

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file from the previous build stage
COPY --from=build /app/target/*.jar ./app.jar

# Expose the port on which your Spring Boot application will listen
EXPOSE 6002

# Set the entry point command to run your application
CMD ["java", "-jar", "app.jar"]
