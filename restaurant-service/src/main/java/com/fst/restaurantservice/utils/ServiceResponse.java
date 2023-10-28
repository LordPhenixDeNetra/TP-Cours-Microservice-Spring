package com.fst.restaurantservice.utils;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Builder // permet de créer un builder pour la classe; un builder est un design pattern qui permet de créer des objets en utilisant des paramètres nommés
@AllArgsConstructor
@NoArgsConstructor
@Data // permet de générer les getters et setters
public class ServiceResponse implements Serializable {
    private String message;
    private Object data;
    private boolean success;
}
