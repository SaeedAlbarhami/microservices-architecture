FROM openjdk:alpine
ADD target/monitoring-service.jar monitoring-service.jar
EXPOSE 8090
ENTRYPOINT ["java", "-jar","monitoring-service.jar"]
