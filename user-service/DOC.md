# User Service

Ce service joue le rôle de gestion des utilisateurs.
Il permet de créer un utilisateur, de récupérer un utilisateur, de modifier un utilisateur et de supprimer un utilisateur.
Il permet aussi de récupérer la liste des utilisateurs.

Pour le code source, avec l'importation de la dépendance spring-boot-starter-data-jpa,
spring effectue automatiquement la configuration de la base de données.


Pour la base de données, on utilise MySQL.
La base de données est créée automatiquement au démarrage du service dans 
un conteneur Docker avec l'image mysql:latest (voir le fichier docker-compose.yaml).
On peut aussi utiliser une base de données MySQL déjà existante.
Pour cela, il suffit juste de modifier le fichier application.yaml du service user-service.
EXEMPLE:
```
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/user_db?createDatabaseIfNotExist=true
    username: root
    password: root
  jpa:
    hibernate:
      ddl-auto: update
    properties:
      hibernate:
        dialect: org.hibernate.dialect.MySQL5InnoDBDialect
```
