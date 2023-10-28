package com.fst.restaurantservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommandeValidation implements Serializable {

    private Long idRestaurant;
    private Long idMenu;
}
