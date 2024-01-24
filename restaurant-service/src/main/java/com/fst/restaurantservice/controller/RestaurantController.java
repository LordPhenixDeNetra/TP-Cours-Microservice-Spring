package com.fst.restaurantservice.controller;

import com.fst.restaurantservice.dto.CommandeValidation;
import com.fst.restaurantservice.model.Restaurant;
import com.fst.restaurantservice.service.RestaurantService;
import com.fst.restaurantservice.utils.ServiceResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/restaurants")
public class RestaurantController {
    private final RestaurantService restaurantService;

    /**
     * Permet de creer un restaurant
     * @return  reponse contenant un message de succès ou d'erreur avec le restaurant créé
     */
    @PostMapping
    public ResponseEntity<ServiceResponse> save(@RequestBody Restaurant restaurant) {
        try {
            return ResponseEntity.ok(ServiceResponse.builder()
                    .success(true)
                    .message("Restaurant saved successfully")
                    .data(restaurantService.save(restaurant))
                    .build());
        }catch (Exception e ) {
            return ResponseEntity.ok(ServiceResponse.builder()
                    .success(false)
                    .message(e.getMessage())
                    .build());
        }
    }


    /**
     * Permet de mettre à jour un restaurant
     * @param restaurant restaurant à mettre à jour
     * @return  reponse contenant un message de succès ou d'erreur avec le restaurant mis à jour
     */
    @PutMapping
    public ResponseEntity<ServiceResponse> update(@RequestBody Restaurant restaurant) {
        try {
            return ResponseEntity.ok(ServiceResponse.builder()
                    .success(true)
                    .message("Restaurant updated successfully")
                    .data(restaurantService.update(restaurant))
                    .build());
        }catch (Exception e ) {
            return ResponseEntity.ok(ServiceResponse.builder()
                    .success(false)
                    .message(e.getMessage())
                    .build());
        }
    }
    /**
     * Permet de supprimer un restaurant
     * @param id id du restaurant à supprimer
     * @return reponse contenant un message de succès ou d'erreur
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<ServiceResponse> delete(@PathVariable Long id) {
        try {
            restaurantService.delete(id);
            return ResponseEntity.ok(ServiceResponse.builder()
                    .success(true)
                    .message("Restaurant deleted successfully")
                    .build());
        }catch (Exception e ) {
            return ResponseEntity.ok(ServiceResponse.builder()
                    .success(false)
                    .message(e.getMessage())
                    .build());
        }
    }


    /**
     * Permet de récupérer un restaurant en fonction de son id
     * @param id id du restaurant
     * @return reponse contenant un objet de type restaurant
     */
    @GetMapping("/{id}")
    public ResponseEntity<ServiceResponse> findById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(ServiceResponse.builder()
                    .success(true)
                    .message("Restaurant found successfully")
                    .data(restaurantService.findById(id))
                    .build());
        }catch (Exception e ) {
            return ResponseEntity.ok(ServiceResponse.builder()
                    .success(false)
                    .message(e.getMessage())
                    .build());
        }
    }


    /**
     * Permet de mettre à jour le nombre de commandes d'un restaurant
     * @param id id du restaurant
     * @return reponse contenant un message de succès ou d'erreur
     */
    @PostMapping("/statistique/{id}")
    public ResponseEntity<ServiceResponse> updateCommandNumber(@PathVariable("id") Long id) {
        try {
            restaurantService.updateCommandNumber(id);
            return ResponseEntity.ok(
                    ServiceResponse.builder()
                    .success(true)
                    .message("Statistique updated")
                    .build()
            );
        } catch (Exception e) {
            return ResponseEntity.ok(
                    ServiceResponse.builder()
                    .success(false)
                    .message(e.getMessage())
                    .build()
            );
        }
    }

    @PostMapping("commande")
    public ResponseEntity<ServiceResponse> validateCommande(@RequestBody CommandeValidation commandeValidation) {
        try {
            return ResponseEntity.ok(
                    ServiceResponse.builder()
                    .success(true)
                    .message("Commande validated")
                    .data(restaurantService.validateCommande(commandeValidation))
                    .build()
            );
        } catch (Exception e) {
            return ResponseEntity.ok(
                    ServiceResponse.builder()
                    .success(false)
                    .message(e.getMessage())
                    .build()
            );
        }
    }

    @GetMapping("/all")
    public ResponseEntity<ServiceResponse> getAll() {
        try {
            return ResponseEntity.ok(
                    ServiceResponse.builder()
                    .success(true)
                    .message("All restaurants")
                    .data(restaurantService.getAll())
                    .build()
            );
        } catch (Exception e) {
            return ResponseEntity.ok(
                    ServiceResponse.builder()
                    .success(false)
                    .message(e.getMessage())
                    .build()
            );
        }
    }

}
