FROM openjdk:21-jdk-slim
ARG JAR_FILE=target/gasolineraspring-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app_gasolinera.jar
EXPOSE 8088
ENTRYPOINT ["java", "-jar", "app_gasolinera.jar"]