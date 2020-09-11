FROM maven:3.6.3-openjdk-14
WORKDIR /app
ENV JAVA_HOME /usr/java/openjdk-14
ENV MAVEN_HOME /usr/share/maven
COPY . ./
RUN mvn clean install

RUN cp /root/.m2/repository/learn/thymeleaf/sept/0.0.1-SNAPSHOT/sept-0.0.1-SNAPSHOT.jar minhpro332/movie-booking:/var/lib/docker/tmp/docker-builder628415990/target/
CMD ["java", "-jar", "app.jar"]
