FROM openjdk:alpine
ADD target/booking-service.jar booking-service.jar
EXPOSE 8085
ENTRYPOINT ["java", "-jar","booking-service.jar"]
