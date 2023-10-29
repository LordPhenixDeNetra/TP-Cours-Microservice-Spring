# docker for java 17 spring boot
FROM openjdk:17-jdk-alpine

# il faut que l'application soit buildée avant de lancer le docker
COPY target/*.jar app.jar
EXPOSE 9000
ENV SERVER_PORT=9000
ENV EUREKA_CLIENT_SERVICEURL_DEFAULTZONE=http://discovery-service:9000/eureka
ENV EUREKA_URI=http://discovery-service:9000/eureka
ENV EUREKA_REGISTER=false
ENV EUREKA_FETCH=false
ENV EUREKA_INSTANCE_HOSTNAME=discovery-service
ENTRYPOINT ["java","-jar","/app.jar"]