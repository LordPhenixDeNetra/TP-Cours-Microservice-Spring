# docker for java 17 spring boot
FROM openjdk:17-jdk-alpine


# il faut que l'application soit buildée avant de lancer le docker
COPY target/*.jar app.jar
EXPOSE 9001
ENV EUREKA_URI=http://discovery-service:9000/eureka
ENV SERVER_PORT=9001
ENV USER_SERVICE_URI=http://user-service:9002
ENV COMMAND_SERVICE_URI=http://commande-service:9004
ENV RESTAURANT_SERVICE_URI=http://restaurant-service:9003
ENTRYPOINT ["java","-jar","/app.jar"]