# Ubuntu를 사용하지 않고 Maven과 OpenJDK를 사용하여 빌드 환경을 설정하는 첫 번째 단계입니다.
FROM maven:3.8.4-openjdk-17 as build
LABEL authors="shawn"
WORKDIR /code_rather_all
COPY code_rather_backend/pom.xml .
COPY code_rather_backend/src ./src
# Maven을 사용하여 Java 애플리케이션을 빌드합니다. 테스트를 건너뛰기 위해 -DskipTests 옵션을 사용합니다.
RUN mvn clean package -DskipTests

# 빌드된 애플리케이션을 실행하기 위한 두 번째 단계입니다.
# 여기서는 OpenJDK 17 JRE를 기반으로 하는 이미지를 사용합니다.
FROM openjdk:17-slim
COPY --from=build /code_rather_backend/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]
