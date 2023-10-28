package com.fst.restaurantservice.repository;


import com.fst.restaurantservice.model.MenuRestaurant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MenuRestaurantRepository extends JpaRepository<MenuRestaurant, Long>{

}
