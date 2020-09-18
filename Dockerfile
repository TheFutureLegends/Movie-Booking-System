FROM openjdk:8-slim
WORKDIR /app
COPY . ./
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "./target/sept-0.0.1-SNAPSHOT.jar"]
