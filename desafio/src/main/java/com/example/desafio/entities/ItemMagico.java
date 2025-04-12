package com.example.desafio.entities;

import com.example.desafio.enums.TipoItem;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "item_magico")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ItemMagico {

    @ManyToOne
    @JoinColumn(name = "personagem_id")
    @JsonBackReference
    private Personagem personagem;

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome do item não pode ser vazio")
    private String nome;

    @NotNull(message = "O tipo do item não estar vazia")
    @Enumerated(EnumType.STRING)
    private TipoItem tipoItem;

    @NotNull(message = "A força do item não pode estar vazia")
    private int forca;

    @NotNull(message = "A defesa do item não pode estar vazia")
    private int defesa;

}
