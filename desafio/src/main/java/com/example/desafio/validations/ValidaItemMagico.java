package com.example.desafio.validations;


import com.example.desafio.entities.ItemMagico;
import com.example.desafio.enums.TipoItem;

public interface ValidaItemMagico {
    void validaForcaDefesa(Integer forca, Integer defesa);
    void validaTipoArma(ItemMagico item);
}
