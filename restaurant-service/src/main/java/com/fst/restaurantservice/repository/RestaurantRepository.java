package com.fst.restaurantservice.repository;

import com.fst.restaurantservice.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
    /**
     * Permet de récupérer un restaurant en fonction de son nom
     * @param name nom du restaurant
     * @return restaurant
     */
    Restaurant findByName(String name);

    /**
     * Permet de récupérer la liste des restaurants qui proposent un menu dont le nom est passé en paramètre
     * @param name nom du menu
     * @return liste des restaurants qui proposent le menu
     */
    @Query("select r from Restaurant r join r.menusRestaurant m where m.name = ?1")
    List<Restaurant> findByMenusRestaurantName(String name);

}
