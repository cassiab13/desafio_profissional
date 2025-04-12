package com.example.desafio.validations;

import com.example.desafio.entities.Personagem;

public interface ValidaPersonagem {
    Personagem validaPersonagem(Long id);
    void validaPontos(Personagem personagem);
}
