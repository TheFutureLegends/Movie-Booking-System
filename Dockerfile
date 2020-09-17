FROM openjdk:8-slim
WORKDIR /app
COPY . ./
ENV JAVA_HOME /opt/openjdk-16
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "target/sept-0.0.1-SNAPSHOT.jar"]
