FROM maven:3.6.3-openjdk-14
VOLUME [ "/app" ]
WORKDIR /app
ENV JAVA_HOME /usr/java/openjdk-14
ENV MAVEN_HOME /usr/share/maven
COPY . ./
RUN mvn test
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/target/sept-0.0.1-SNAPSHOT.jar"]