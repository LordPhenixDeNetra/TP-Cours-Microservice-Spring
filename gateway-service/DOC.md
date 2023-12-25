# Gateway Service

Ce service joue le rôle de passerelle entre les différents services de l'application.
Il permet de rediriger les requêtes vers les différents services.
Dans notre cas, il redirige les requêtes vers le service restaurant-service, le service user-service et commande-service.
C'est pourquoi pour toutes les requêtes, on utilise l'URL suivante : http://localhost:9001 qui est l'URL du Gateway Service.
L'avantage de cette architecture est que l'on peut changer l'URL des services sans avoir à modifier le code source des autres services.
Il suffit juste de modifier le fichier application.yaml du Gateway Service.
Par exemple, si on veut changer l'URL du service restaurant-service, il suffit juste de modifier la ligne suivante :
```
- id: restaurant-service
  uri: http://localhost:9002
  predicates:
  - Path=/restaurants/**
```


Pour le code source, avec l'importation de la dépendance spring-cloud-starter-gateway,
spring effectue automatiquement la configuration du Gateway Service.
Il suffit juste d'ajouter l'annotation @EnableGateway sur la classe principale du projet
(C'est à dire celle qui contient la méthode main (ex: GatewayServiceApplication.java)).
On peut aussi ajouter des configurations supplémentaires dans le fichier application.yaml
pour le Gateway Service.
