FROM openjdk:16-alpine
WORKDIR /app
ENV JAVA_HOME /opt/openjdk-16
COPY /app/target/sept-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]