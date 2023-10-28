package com.fst.commandeservice.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum EtatCommande {

    EN_COURS("EN_COURS"),
    EN_PREPARATION("EN_PREPARATION"),
    PRETE("PRETE");
    final String etat;
}
