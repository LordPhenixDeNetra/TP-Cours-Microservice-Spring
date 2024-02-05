package com.fst.commandeservice.api;


import com.fst.commandeservice.utils.ServiceResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient("user-service")
@CrossOrigin("*")
public interface RestaurantClientServiceApi {

    @CrossOrigin("*")
    @GetMapping("/api/restaurant-client/{id}")
    ServiceResponse getRestaurantClientById(@PathVariable("id") Long id);

    @CrossOrigin("*")
    @PostMapping("/api/restaurant-client/statistique/{id}")
    ServiceResponse updateStatistique(@PathVariable("id") Long id);

}
