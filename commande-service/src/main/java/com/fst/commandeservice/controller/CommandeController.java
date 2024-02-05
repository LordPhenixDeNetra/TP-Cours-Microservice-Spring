package com.fst.commandeservice.controller;

import com.fst.commandeservice.model.Commande;
import com.fst.commandeservice.service.CommandeService;
import com.fst.commandeservice.utils.ServiceResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/commandes")
@RequiredArgsConstructor
@Slf4j
@CrossOrigin("*")
public class CommandeController {
    // permet d'injecter le service CommandeService
    private final CommandeService commandeService;


    /**
     * permet de sauvegarder une commande
     * @param commande commande à sauvegarder
     * @return reponse contenant un message de succès ou d'erreur avec la commande sauvegardée
     */
    @PostMapping
    public ServiceResponse saveCommande(@RequestBody Commande commande) {
        try {
            return ServiceResponse.builder()
                    .success(true)
                    .message("Commande saved successfully")
                    .data(commandeService.saveCommande(commande))
                    .build();
        }catch (Exception e ) {
            return ServiceResponse.builder()
                    .success(false)
                    .message(e.getMessage())
                    .build();
        }
    }

    @DeleteMapping("/{id}")
    public ServiceResponse deleteCommande(@PathVariable("id") Long id) {
        try {
            commandeService.deleteCommande(id);
            return ServiceResponse.builder()
                    .success(true)
                    .message("Commande deleted successfully")
                    .build();
        }catch (Exception e ) {
            return ServiceResponse.builder()
                    .success(false)
                    .message(e.getMessage())
                    .build();
        }
    }

    /**
     * permet de mettre à jour une commande
     * @param commande commande à mettre à jour
     * @return reponse contenant un message de succès ou d'erreur avec la commande mise à jour
     */
    @PutMapping
    public ServiceResponse updateCommande(@RequestBody Commande commande) {
        try {
            return ServiceResponse.builder()
                    .success(true)
                    .message("Commande updated successfully")
                    .data(commandeService.updateCommande(commande))
                    .build();
        }catch (Exception e ) {
            return ServiceResponse.builder()
                    .success(false)
                    .message(e.getMessage())
                    .build();
        }
    }


    /**
     * permet de recuperer toutes les commandes
     * @return reponse contenant un message de succès ou d'erreur avec la liste des commandes
     */
    @GetMapping("/all")
    public ServiceResponse getAllCommandes() {
        try {
            return ServiceResponse.builder()
                    .success(true)
                    .message("Commandes fetched successfully")
                    .data(commandeService.getAllCommandes())
                    .build();
        }catch (Exception e ) {
            return ServiceResponse.builder()
                    .success(false)
                    .message(e.getMessage())
                    .build();
        }
    }

}
