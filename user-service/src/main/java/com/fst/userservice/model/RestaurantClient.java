package com.fst.userservice.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serializable;

@Entity
@Data
public class RestaurantClient implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull @NotBlank // permet de valider que l'attribut n'est pas null ou vide
    private String name;
    @Email // permet de valdier que l'attribut est un email
    @Column(unique = true) // permet de valider que l'attribut est unique
    private String email;
    private String phoneNumber;
    private String address;
    // nombre de commandes effectuées par le client; sera mis à jour à chaque fois qu'une commande est effectuée
    private int commandCount;
}
