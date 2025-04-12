package com.example.desafio.DTO;

import com.example.desafio.entities.ItemMagico;
import com.example.desafio.entities.Personagem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PersonagemDTO {
    private String nome;
    private String nomeAventureiro;
    private int level;
    private int forcaTotal;
    private int defesaTotal;
    private int total;
    private List<ItemMagico> itensMagicos;

    public PersonagemDTO(Personagem personagem) {
        this.nome = personagem.getNome();
        this.nomeAventureiro = personagem.getNomeAventureiro();
        this.level = personagem.getLevel();
        this.forcaTotal = personagem.getForca() + personagem.getItensMagicos().stream().mapToInt(ItemMagico::getForca).sum();
        this.defesaTotal = personagem.getDefesa() + personagem.getItensMagicos().stream().mapToInt(ItemMagico::getDefesa).sum();
        this.total = forcaTotal + defesaTotal;
        this.itensMagicos = personagem.getItensMagicos();
    }
}


