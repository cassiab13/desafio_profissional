package com.example.desafio.enums;

public enum TipoItem {
    ARMA(1),
    ARMADURA(2),
    AMULETO(3);

    private int value;

    TipoItem(int value) {
        this.value = value;
    }
}
