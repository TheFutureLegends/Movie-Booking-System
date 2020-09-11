FROM maven:3.6.3-openjdk-11
WORKDIR /app
ENV JAVA_HOME /usr/java/openjdk-11
ENV MAVEN_HOME /usr/share/maven
COPY . ./
RUN mvn clean install

# RUN cp /root/.m2/repository/learn/thymeleaf/sept/0.0.1-SNAPSHOT/sept-0.0.1-SNAPSHOT.jar /app/
ENTRYPOINT ["java", "-jar", "/app/target/sept-0.0.1-SNAPSHOT.jar"]
