FROM openjdk:8-jdk-alpine

RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring

ARG JAR_FILE=target/colaborae.jar
COPY ${JAR_FILE} app.jar
EXPOSE 8080


ENTRYPOINT ["java", "-Xmx512m","-jar", "/app.jar"]