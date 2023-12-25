# Commande Service

Ce service joue le rôle de gestion des commandes.
Il permet de créer une commande, de récupérer une commande, de modifier une commande et de supprimer une commande.

Pour le code source, avec l'importation de la dépendance spring-boot-starter-data-jpa,
spring effectue automatiquement la configuration de la base de données.

La base de données est créée automatiquement au démarrage du service dans
un conteneur Docker avec l'image mysql:latest (voir le fichier docker-compose.yaml).

L'application est divisée en 4 principales couches :
- La couche controller : qui contient les classes qui gèrent les requêtes HTTP.
- La couche service : qui contient les classes qui gèrent la logique métier.
- La couche repository : qui contient les classes qui gèrent les requêtes SQL.
- La couche model : qui contient les classes qui représentent les entités de la base de données.

Les couches utils et api sont des couches transverses qui sont utilisées par les autres couches.
La couche utils contient des classes utilitaires.
La couche api contient des classes qui permettent de faire la liaison entre les différentes couches à travers des appels HTTP.
