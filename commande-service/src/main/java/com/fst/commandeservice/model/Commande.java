package com.fst.commandeservice.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serializable;

@Entity
@Data
public class Commande implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private Long idRestaurant;
    @NotNull
    private Long idMenu;
    @NotNull
    private Long idClient;
    @Enumerated(EnumType.STRING) // pour stocker le nom de l'enum dans la base de données ex: EN_COURS au lieu de 1 car c'est plus lisible
    private EtatCommande etat;
    private double price;
}
