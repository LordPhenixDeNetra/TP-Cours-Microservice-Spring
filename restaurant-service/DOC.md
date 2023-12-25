# Restaurant Service

Ce service joue le rôle de gestion des restaurants.
Il permet de créer un restaurant, de récupérer un restaurant, de modifier un restaurant et de supprimer un restaurant.
Il permet aussi de récupérer la liste des restaurants.

Pour le code source, avec l'importation de la dépendance spring-boot-starter-data-jpa,
spring effectue automatiquement la configuration de la base de données.

La base de données est créée automatiquement au démarrage du service dans
un conteneur Docker avec l'image mysql:latest (voir le fichier docker-compose.yaml).
On peut aussi utiliser une base de données MySQL déjà existante.
Pour cela, il suffit juste de modifier le fichier application.yaml du service restaurant-service.
EXEMPLE:
```
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/restaurant_db?createDatabaseIfNotExist=true
    username: root
    password: root
  jpa:
    hibernate:
      ddl-auto: update
    properties:
      hibernate:
        dialect: org.hibernate.dialect.MySQL5InnoDBDialect
```

