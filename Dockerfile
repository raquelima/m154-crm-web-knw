FROM openjdk:13-alpine3.10

EXPOSE 7070

COPY target/m154-crm-web-0.0.1-SNAPSHOT-shaded.jar ./app.jar 

cmd ["java", "-jar", "app.jar"]