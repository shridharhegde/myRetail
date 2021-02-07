FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG JAR_FILE=target/myretail-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} myretail-0.0.1-SNAPSHOT.jar

# Run the jar file
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/myretail-0.0.1-SNAPSHOT.jar"]
