# docker for java 17 spring boot
FROM openjdk:17-jdk-alpine

# il faut que l'application soit buildée avant de lancer le docker
COPY target/*.jar app.jar
EXPOSE 9003

ENV EUREKA_CLIENT_SERVICEURL_DEFAULTZONE=http://discovery-service:9000/eureka
ENV DB_USER=etudiant
ENV DB_PASSWORD=etudiant
ENV DB_HOST=db_restaurant_service
ENV DB_PORT=3306
ENV DB_NAME=restaurant_service




ENTRYPOINT ["java","-jar","/app.jar"]