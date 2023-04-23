FROM amazoncorretto:17-alpine
MAINTAINER ryanez
COPY target/ryanez-0.0.1-SNAPSHOT.jar ryanez-app.jar
ENTRYPOINT ["java", "-jar", "/ryanez-app.jar"]
EXPOSE 8080