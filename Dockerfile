# 빌드 스테이지
FROM openjdk:17-slim AS build
WORKDIR /app

# Gradle wrapper와 소스 코드 복사
COPY gradlew .
COPY gradle gradle
COPY build.gradle .
COPY settings.gradle .
COPY src src

# 실행 권한 부여 및 애플리케이션 빌드
RUN chmod +x ./gradlew && ./gradlew clean && ./gradlew bootJar

# 런타임 스테이지
FROM openjdk:17-slim
WORKDIR /app

#ARG JAR_FILE=build/libs/*.jar
#COPY ${JAR_FILE} /app/app_api.jar

# 빌드 스테이지에서 생성된 JAR 파일 복사
COPY --from=build /app/build/libs/*.jar app_api.jar

# 애플리케이션 포트 노출
EXPOSE 8008
ENV TZ=Asia/Seoul
# 애플리케이션 실행
ENTRYPOINT ["java", "-jar","-Dspring.profiles.default=dual", "/app/app_api.jar"]
