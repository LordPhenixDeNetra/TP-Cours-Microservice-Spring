package com.fst.restaurantservice.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull @NotEmpty // permet de valider que l'attribut n'est pas null ou vide
    private String name;
    @NotNull @NotEmpty
    private String address;
    @NotNull @NotEmpty
    private String phoneNumber;
    @OneToMany(cascade = CascadeType.ALL) // permet de définir la relation entre les deux entités
    private List<MenuRestaurant> menusRestaurant;
    private int commandNumber;
}
