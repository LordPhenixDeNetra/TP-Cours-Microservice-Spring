package com.fst.commandeservice.api;

import com.fst.commandeservice.model.CommandeValidation;
import com.fst.commandeservice.utils.ServiceResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient("restaurant-service")
@CrossOrigin("*")
public interface RestaurantServiceApi {

    @CrossOrigin("*")
    @GetMapping("/api/restaurants/{id}")
    ServiceResponse getRestaurantById(@PathVariable("id") Long id);

    @CrossOrigin("*")
    @PostMapping("/api/restaurants/statistique/{id}")
    ServiceResponse updateStatistique(@PathVariable("id") Long id);

    @CrossOrigin("*")
    @PostMapping("/api/restaurants/commande")
    ServiceResponse validateCommande(@RequestBody CommandeValidation commandeValidation);

}
