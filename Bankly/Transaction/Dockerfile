FROM openjdk:11
ARG WAR_FILE=target/*.jar
COPY target/Transaction-0.0.1-SNAPSHOT.jar transaction.jar
ENTRYPOINT ["java", "-jar","transaction.jar"]