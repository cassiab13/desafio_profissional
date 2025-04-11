package com.example.desafio.enums;


public enum Classe {
    GUERREIRO(1),
    MAGO(2),
    ARQUEIRO(3),
    LADINO(4),
    BARDO(5);

    private int value;

    Classe(int value) {
        this.value = value;
    }

}
