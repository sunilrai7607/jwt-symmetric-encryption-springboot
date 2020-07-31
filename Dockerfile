FROM openjdk:8-jdk-alpine
MAINTAINER Sunil Rai <sunilrai7607@gmail.com>
VOLUME /app
ARG version
ENV version_number=$version
COPY ./build/libs/jwt-token-service-$version_number.jar jwt-token-service.jar
ENTRYPOINT ["java", "-jar","/jwt-token-service.jar"]