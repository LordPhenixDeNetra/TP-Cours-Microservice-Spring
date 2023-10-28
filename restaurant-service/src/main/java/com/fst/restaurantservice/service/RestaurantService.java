package com.fst.restaurantservice.service;

import com.fst.restaurantservice.dto.CommandeValidation;
import com.fst.restaurantservice.model.Restaurant;
import com.fst.restaurantservice.repository.RestaurantRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 *  Service permettant de gérer les restaurants
 */
@Service
@RequiredArgsConstructor // permet de générer un constructeur avec les attributs final
public class RestaurantService {
    // permet d'injecter le repository dans le service
    private final RestaurantRepository restaurantRepository;

    /**
     * Permet de supprimer un restaurant en fonction de son id
     * @param id id du restaurant à supprimer
     */
    public void delete(Long id) {
        restaurantRepository.deleteById(id);
    }

    /**
     * Permet de sauvegarder un restaurant
     * @param restaurant restaurant à sauvegarder
     * @return restaurant sauvegardé
     */
    public Restaurant save(@Valid Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    /**
     * Permet de mettre à jour un restaurant
     * @param restaurant restaurant à mettre à jour
     * @return restaurant mis à jour
     * @throws Exception si l'id du restaurant est null ou si le restaurant n'existe pas
     */
    public Restaurant update(@Valid Restaurant restaurant) throws Exception {
        if (restaurant.getId() == null) {
            throw new Exception("Restaurant id is null");
        }
        if (!restaurantRepository.existsById(restaurant.getId())) {
            throw new Exception("Restaurant id doesn't exist");
        }

        return restaurantRepository.save(restaurant);
    }

    /**
     * Permet de récupérer un restaurant en fonction de son id
     * @param id id du restaurant
     * @return restaurant
     * @throws Exception si le restaurant n'existe pas
     */
    public Restaurant findById(Long id) throws Exception {
        return restaurantRepository
                .findById(id)
                .orElseThrow(() -> new Exception("Restaurant not found"));
    }


    /**
     * permet de mettre à jour le nombre de commandes d'un restaurant
     * @param id id du restaurant
     * @throws Exception si le restaurant n'existe pas
     */
    public void updateCommandNumber(Long id) throws Exception {
        var restaurant = findById(id);
        restaurant.setCommandNumber(restaurant.getCommandNumber() + 1);
        restaurantRepository.save(restaurant);
    }

    /**
     * permet de valider une commande et de retourner le prix du menu
     * @param commandeValidation commande à valider
     * @return prix du menu
     * @throws Exception si le restaurant n'existe pas ou si le menu n'existe pas
     */
    public double validateCommande(CommandeValidation commandeValidation) throws Exception {
        var restaurant = findById(commandeValidation.getIdRestaurant());
        // on vérifie que le menu existe
        if (restaurant.getMenusRestaurant().stream().noneMatch(menu -> menu.getId().equals(commandeValidation.getIdMenu()))) {
            throw new Exception("Menu not found");
        }
        // on recupère le prix du menu
        var menu = restaurant.getMenusRestaurant().stream().filter(m -> m.getId().equals(commandeValidation.getIdMenu())).findFirst().get();
        return menu.getPrice();

    }

}
