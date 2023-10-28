package com.fst.commandeservice.repository;

import com.fst.commandeservice.model.Commande;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommandeRepository extends JpaRepository<Commande, Long> {

    /**
     * Permet de récupérer toutes les commandes d'un client
     * @param idClient l'id du client
     * @return la liste des commandes du client
     */
    List<Commande> findAllByIdClient(Long idClient);

    /**
     * Permet de récupérer toutes les commandes d'un restaurant
     * @param idRestaurant l'id du restaurant
     * @return la liste des commandes du restaurant
     */
    List<Commande> findAllByIdRestaurant(Long idRestaurant);
}
