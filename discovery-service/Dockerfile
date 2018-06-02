FROM openjdk:alpine
ADD target/discovery-service.jar discovery-service.jar
EXPOSE 8082
ENTRYPOINT ["java", "-jar","discovery-service.jar"]
