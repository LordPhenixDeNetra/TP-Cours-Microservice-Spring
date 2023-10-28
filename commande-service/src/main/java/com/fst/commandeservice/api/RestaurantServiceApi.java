package com.fst.commandeservice.api;

import com.fst.commandeservice.model.CommandeValidation;
import com.fst.commandeservice.utils.ServiceResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("restaurant-service")
public interface RestaurantServiceApi {

    @GetMapping("/api/restaurants/{id}")
    ServiceResponse getRestaurantById(@PathVariable("id") Long id);

    @PostMapping("/api/restaurants/statistique/{id}")
    ServiceResponse updateStatistique(@PathVariable("id") Long id);

    @PostMapping("/api/restaurants/commande")
    ServiceResponse validateCommande(@RequestBody CommandeValidation commandeValidation);

}
