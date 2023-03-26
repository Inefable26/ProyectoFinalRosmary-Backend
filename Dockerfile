FROM amazoncorretto:17-alpine
MAINTAINER ryanez
COPY target/ryanez-0.0.1-SNAPSHOT.jar  ryanez.jar
ENTRYPOINT ["java","-jar","/ryanez.jar"]
EXPOSE 8080
