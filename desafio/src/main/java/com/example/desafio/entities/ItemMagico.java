package com.example.desafio.entities;

import com.example.desafio.enums.TipoItem;
import jakarta.persistence.*;
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

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private Enum<TipoItem> tipoItem;
    private int forca;
    private int defesa;


}
