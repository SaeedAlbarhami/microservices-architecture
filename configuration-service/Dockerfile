FROM openjdk:alpine
ADD target/configuration-service.jar configuration-service.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar","configuration-service.jar"]
