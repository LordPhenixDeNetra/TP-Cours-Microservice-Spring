# Discovery Service

Ce service joue dans un premier temps le rôle de serveur Eureka.
(il faut importer la dépendance spring-cloud-starter-netflix-eureka-server.voir le pom.xml)
Il permet aux autres services de s'enregistrer et de se découvrir entre eux.
À chaque fois qu'un service est démarré, il s'enregistre auprès du serveur Eureka.
ET il est possible de consulter la liste des services enregistrés sur le serveur Eureka.
Pour cela, il suffit d'aller sur l'URL suivante : http://localhost:9000


Pour le code source, avec l'importation de la dépendance spring-cloud-starter-netflix-eureka-server,
spring effectue automatiquement la configuration du serveur Eureka.
Il suffit juste d'ajouter l'annotation @EnableEurekaServer sur la classe principale du projet
(C'est à dire celle qui contient la méthode main (ex: DiscoveryServiceApplication.java)).

On peut aussi ajouter des configurations supplémentaires dans le fichier application.properties
pour le serveur Eureka.

EXEMPLE:
```
server.port=9000 # port du serveur Eureka

spring.application.name=discovery-service # nom du service
eureka.client.register-with-eureka=${EUREKA_REGISTER:false} # permet de s'enregistrer auprès du serveur Eureka
eureka.client.fetch-registry=${EUREKA_FETCH:false} # permet de récupérer la liste des services enregistrés sur le serveur Eureka
eureka.client.service-url.defaultZone=${EUREKA_URI:http://localhost:9000/eureka} # URL du serveur Eureka
eureka.instance.hostname=${EUREKA_INSTANCE_HOSTNAME:localhost} # nom de l'hôte
```
