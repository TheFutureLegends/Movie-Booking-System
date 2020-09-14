FROM maven:3.6.3-openjdk-14
WORKDIR /app
ENV JAVA_HOME /usr/java/openjdk-14
ENV MAVEN_HOME /usr/share/maven
COPY . ./
RUN mvn clean install
EXPOSE 8080
CMD ["java", "-jar", "/app/target/sept-0.0.1-SNAPSHOT.jar"]