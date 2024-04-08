#FROM openjdk:11
FROM adoptopenjdk/openjdk11:latest
#VOLUME /tmp
RUN mkdir -p /app/
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} /app/app_api.jar
#ADD dualhealthcare-careroom-java-springboot-0.0.1-SNAPSHOT.jar /app/app.jar
EXPOSE 8001
ENV TZ Asia/Seoul
ENTRYPOINT ["java", "-jar", "/app/app_api.jar"]
#ENTRYPOINT ["java", "-jar", "-Dspring.profiles.default=prod", "/app/app_api.jar"]
