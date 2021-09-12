FROM openjdk:8-jdk-alpine
ENV APP_PORT=8072
EXPOSE $APP_PORT
COPY account-microservice/target/account-microservice-0.1.0.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
