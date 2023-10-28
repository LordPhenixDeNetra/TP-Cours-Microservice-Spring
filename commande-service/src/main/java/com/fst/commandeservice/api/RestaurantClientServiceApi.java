package com.fst.commandeservice.api;


import com.fst.commandeservice.utils.ServiceResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient("user-service")
public interface RestaurantClientServiceApi {

    @GetMapping("/api/restaurant-client/{id}")
    ServiceResponse getRestaurantClientById(@PathVariable("id") Long id);

    @PostMapping("/api/restaurant-client/statistique/{id}")
    ServiceResponse updateStatistique(@PathVariable("id") Long id);

}
