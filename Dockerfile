# the base image
FROM amazoncorretto:17

# the JAR file path
ARG JAR_FILE=target/*.jar

# Copy the JAR file from the build context into the Docker image
COPY ${JAR_FILE} template.jar

# Set the default command to run the Java application
ENTRYPOINT ["java", "-Xmx2048M", "-jar", "/template.jar", "–trace"]
