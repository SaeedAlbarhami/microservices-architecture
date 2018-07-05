FROM openjdk:alpine
ADD target/customer-service.jar customer-service.jar
EXPOSE 8083
ENTRYPOINT ["java", "-jar","customer-service.jar"]