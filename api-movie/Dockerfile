FROM openjdk:17
MAINTAINER VICTORIARAMIREZ
ARG JAR_FILE=target/api-movie.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","app.jar"]
EXPOSE 9001