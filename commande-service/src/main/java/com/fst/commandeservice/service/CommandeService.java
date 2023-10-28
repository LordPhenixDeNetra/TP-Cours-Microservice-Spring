package com.fst.commandeservice.service;

import com.fst.commandeservice.api.RestaurantClientServiceApi;
import com.fst.commandeservice.api.RestaurantServiceApi;
import com.fst.commandeservice.model.Commande;
import com.fst.commandeservice.model.CommandeValidation;
import com.fst.commandeservice.model.EtatCommande;
import com.fst.commandeservice.repository.CommandeRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommandeService {

    // permet d'injecter le repository dans le service
    private final CommandeRepository commandeRepository;

    // permet d'injecter le restaurantServiceApi dans le service
    private final RestaurantServiceApi restaurantServiceApi;
    // permet d'injecter le restaurantClientServiceApi dans le service
    private final RestaurantClientServiceApi restaurantClientServiceApi;

    /**
     * Permet de supprimer une commande en fonction de son id
     * @param id id de la commande à supprimer
     */
    public void deleteCommande(Long id) {
        commandeRepository.deleteById(id);
    }

    /**
     * Permet de sauvegarder une commande
     * @param commande commande à sauvegarder
     * @return commande sauvegardée
     * @throws Exception si le restaurant n'existe pas ou si le client n'existe pas
     */
    public Commande saveCommande(@Valid Commande commande) throws Exception {
        // on verifie que le restaurant existe et que le client existe
        checkIfRestaurantOrClientExists(commande);

        // on calcule le prix total de la commande
        var getPriceResponse = restaurantServiceApi.validateCommande(
                CommandeValidation.builder()
                        .idMenu(commande.getIdMenu())
                        .idRestaurant(commande.getIdRestaurant())
                        .build()
        );

        // si on n'a pas pu calculer le prix de la commande, on lève une exception
        if (!getPriceResponse.isSuccess()) {
            throw new Exception("Menu not found");
        }

        commande.setPrice((Double) getPriceResponse.getData());
        // on met l'etat de la commande à EN_PREPARATION
        commande.setEtat(EtatCommande.EN_PREPARATION);
        // on sauvegarde la commande
        var result = commandeRepository.save(commande);

        // on met à jour les statistiques du restaurant et de son client
        updateClientInfoAndRestaurantInfo(commande);
        // on retourne la commande
        return result;
    }

    private void updateClientInfoAndRestaurantInfo(Commande commande) {
        restaurantClientServiceApi.updateStatistique(commande.getIdClient());
        restaurantServiceApi.updateStatistique(commande.getIdRestaurant());
    }

    private void checkIfRestaurantOrClientExists(Commande commande) throws Exception {
        var response = restaurantServiceApi.getRestaurantById(commande.getIdRestaurant());
        if (!response.isSuccess()) {
            throw new Exception("Restaurant not found");
        }

        response = restaurantClientServiceApi.getRestaurantClientById(commande.getIdClient());
        if (!response.isSuccess()) {
            throw new Exception("Client not found");
        }
    }

    /**
     * Permet de mettre à jour une commande (on ne modifie que l'etat de la commande)
     * @param commande commande à mettre à jour
     * @return commande mise à jour
     * @throws Exception si l'id de la commande est null ou si la commande n'existe pas
     */
    public Commande updateCommande(@Valid Commande commande) throws Exception {
        if (commande.getId() == null) {
            throw new Exception("Commande id is null");
        }
        if (!commandeRepository.existsById(commande.getId())) {
            throw new Exception("Commande id doesn't exist");
        }
        var oldCommande = commandeRepository.findById(commande.getId()).get();
        // on met a jour l'etat de la commande
        oldCommande.setEtat(commande.getEtat());
        return commandeRepository.save(oldCommande);
    }


    /**
     * permet de recuperer la liste des commandes
     * @return liste des commandes
     */
    public List<Commande> getAllCommandes() {
        return commandeRepository.findAll();
    }
}
