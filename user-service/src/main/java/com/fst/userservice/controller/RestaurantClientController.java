package com.fst.userservice.controller;

import com.fst.userservice.model.RestaurantClient;
import com.fst.userservice.service.RestaurantClientService;
import com.fst.userservice.utils.ServiceResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


/**
 * Controller permettant de gérer les clients
 */
@RestController
@RequestMapping("/api/restaurant-client") // permet de définir le chemin de base pour toutes les méthodes de la classe
@RequiredArgsConstructor
public class RestaurantClientController {
    private final RestaurantClientService restaurantClientService;

    /**
     * Récupère tous les clients
     * @return un objet de type ServiceResponse contenant la liste des clients
     */

    @GetMapping("/all")
    public ResponseEntity<ServiceResponse> getAll() {
        try {
            return ResponseEntity.ok(
                    ServiceResponse.builder()
                    .success(true)
                    .data(restaurantClientService.getAll())
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

    /**
     * Récupère un client par son identifiant
     * @param id l'identifiant du client à récupérer
     * @return un objet de type ServiceResponse contenant le client récupéré
     */
    @GetMapping("/{id}")
    public ResponseEntity<ServiceResponse> getById(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(
                    ServiceResponse.builder()
                    .success(true)
                    .data(restaurantClientService.getById(id))
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

    /**
     * Enregistre un client
     * @param restaurantClient le client à enregistrer
     * @return un objet de type ServiceResponse contenant le client enregistré
     */
    @PostMapping
    public ResponseEntity<ServiceResponse> save(@RequestBody RestaurantClient restaurantClient) {
        try {
            return ResponseEntity.ok(
                    ServiceResponse.builder()
                    .success(true)
                    .data(restaurantClientService.save(restaurantClient))
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

    /**
     * Met à jour un client
     * @param restaurantClient le client à mettre à jour
     * @return un objet de type ServiceResponse contenant le client mis à jour
     */
    @PutMapping
    public ResponseEntity<ServiceResponse> update(@RequestBody RestaurantClient restaurantClient) {
        try {
            return ResponseEntity.ok(
                    ServiceResponse.builder()
                    .success(true)
                    .data(restaurantClientService.update(restaurantClient))
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

    /**
     * Supprime un client
     * @param id l'identifiant du client à supprimer
     * @return un objet de type ServiceResponse contenant un message de succès ou d'erreur
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<ServiceResponse> delete(@PathVariable("id") Long id) {
        try {
            restaurantClientService.delete(id);
            return ResponseEntity.ok(
                    ServiceResponse.builder()
                    .success(true)
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

    @PostMapping("/statistique/{id}")
    public ResponseEntity<ServiceResponse> getStatistique(@PathVariable("id") Long id) {
        try {
            restaurantClientService.updateStatistique(id);
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

}
