FROM openjdk:alpine
ADD target/student-service.jar student-service.jar
EXPOSE 8083
ENTRYPOINT ["java", "-jar","student-service.jar"]
