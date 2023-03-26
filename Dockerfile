FROM amazoncorretto:19
MAINTAINER ryanez
COPY target/ryanez-0.0.1-SNAPSHOT.jar  ryanez-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/ryanez-0.0.1-SNAPSHOT.jar"]

