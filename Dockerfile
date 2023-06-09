FROM maven:3.8.1-openjdk-17-slim AS MAVEN_BUILD
WORKDIR /build
COPY pom.xml /build/
COPY src /build/src/
RUN mvn package

FROM openjdk:17-alpine
WORKDIR /app

COPY --from=MAVEN_BUILD /build/target/*.jar /app/UserApp.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","UserApp.jar"]