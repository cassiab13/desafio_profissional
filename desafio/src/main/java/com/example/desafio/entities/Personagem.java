package com.example.desafio.entities;

import com.example.desafio.enums.Classe;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "personagem")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Personagem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String nomeAventureiro;
    private Enum<Classe> classe;
    private int level;
    private List<ItemMagico> itensMagicos;
    private int forca;
    private int defesa;
    

}
