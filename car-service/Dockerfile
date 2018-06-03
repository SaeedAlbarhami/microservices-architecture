FROM openjdk:alpine
ADD target/car-service.jar car-service.jar
EXPOSE 8087
ENTRYPOINT ["java", "-jar","car-service.jar"]