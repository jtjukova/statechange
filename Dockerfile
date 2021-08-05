FROM openjdk:11-jre-slim
COPY ./target/statechange-0.0.1-SNAPSHOT.jar /usr/src/demo/
WORKDIR /usr/src/demo
EXPOSE 9000
CMD ["java", "-jar", "statechange-0.0.1-SNAPSHOT.jar"]