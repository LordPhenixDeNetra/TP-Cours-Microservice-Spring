package com.fst.userservice.repository;


import com.fst.userservice.model.RestaurantClient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantClientRepository extends JpaRepository<RestaurantClient, Long> {

}
