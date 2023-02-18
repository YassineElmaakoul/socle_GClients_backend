FROM maven:3.9.0-eclipse-temurin-17-alpine

WORKDIR /app

COPY src src

COPY pom.xml .

RUN mvn clean package -DskipTests
ENTRYPOINT ["java", "-jar",  "./target/socle_user-0.0.1-SNAPSHOT.jar"]