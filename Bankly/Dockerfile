FROM openjdk:11
ARG WAR_FILE=target/*.war
COPY target/Bankly-0.0.1.war app.war
ENTRYPOINT ["java", "-jar","app.war"]