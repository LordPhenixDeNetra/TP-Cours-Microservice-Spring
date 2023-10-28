package com.fst.commandeservice.utils;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ServiceResponse implements Serializable {
    private String message;
    private Object data;
    private boolean success;
}
