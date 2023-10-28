package com.fst.commandeservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommandeValidation implements Serializable {

    private Long idRestaurant;
    private Long idMenu;
}
