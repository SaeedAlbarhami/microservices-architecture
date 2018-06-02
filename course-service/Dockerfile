FROM openjdk:alpine
ADD target/course-service.jar course-service.jar
EXPOSE 8087
ENTRYPOINT ["java", "-jar","course-service.jar"]