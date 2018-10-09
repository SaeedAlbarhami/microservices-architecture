FROM openjdk:alpine
ADD target/api-gateway.jar api-gateway.jar
EXPOSE 8084
ENTRYPOINT ["java", "-jar","api-gateway.jar:v1"]
