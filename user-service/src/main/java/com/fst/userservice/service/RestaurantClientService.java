package com.fst.userservice.service;

import com.fst.userservice.model.RestaurantClient;
import com.fst.userservice.repository.RestaurantClientRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.bouncycastle.jcajce.provider.asymmetric.ec.KeyFactorySpi;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Service permettant de gérer les clients
 */
@Service
@RequiredArgsConstructor
public class RestaurantClientService {

    private final RestaurantClientRepository restaurantClientRepository;


    /**
     * Permet de supprimer un client par son id
     * @param id l'id du client à supprimer
     */
    public void delete(Long id) {
        restaurantClientRepository.deleteById(id);
    }

    /**
     * Permet de sauvegarder un client
     * @param restaurantClient le client à sauvegarder
     * @return le client sauvegardé
     */
    public RestaurantClient save(@Valid RestaurantClient restaurantClient) {
        return restaurantClientRepository.save(restaurantClient);
    }

    public RestaurantClient update(@Valid RestaurantClient restaurantClient) throws Exception {
        if ( !restaurantClientRepository.existsById(restaurantClient.getId())) {
            throw new Exception("Client not found");
        }
        return restaurantClientRepository.save(restaurantClient);
    }

    /**
     * Permet de récupérer un client par son id
     * @param id l'id du client à récupérer
     * @return le client récupéré
     */
    public RestaurantClient getById(Long id) throws Exception {
        return restaurantClientRepository
                .findById(id)
                .orElseThrow(() -> new Exception("Client not found"));
    }

    /**
     * Permet de récupérer tous les clients
     * @return la liste des clients
     */
    public List<RestaurantClient> getAll() {
        return restaurantClientRepository.findAll();
    }

    /**
     * Permet de mettre à jour les statistiques d'un client
     * @param id l'id du client
     * @throws Exception si le client n'existe pas
     */
    public void updateStatistique(Long id) throws Exception {
        if ( restaurantClientRepository.existsById(id)) {
            RestaurantClient restaurantClient = restaurantClientRepository.findById(id).get();
            restaurantClient.setCommandCount(restaurantClient.getCommandCount() + 1);
            restaurantClientRepository.save(restaurantClient);
        } else throw new Exception("Client not found");
    }

}
