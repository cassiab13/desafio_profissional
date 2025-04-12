package com.example.desafio.controllers;


import com.example.desafio.DTO.PersonagemDTO;
import com.example.desafio.entities.ItemMagico;
import com.example.desafio.entities.Personagem;
import com.example.desafio.services.PersonagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personagem")
public class PersonagemController {

    @Autowired
    private PersonagemService service;

    @PostMapping
    public ResponseEntity<Personagem> create(@RequestBody Personagem personagem){
        Personagem response = service.create(personagem);
        return ResponseEntity.status(201).body(response);
    }

    @GetMapping
    public ResponseEntity<List<PersonagemDTO>> getAll() {
        List<PersonagemDTO> personagens = service.getAll();
        return ResponseEntity.ok(personagens);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonagemDTO> findById(@PathVariable Long id){
        PersonagemDTO personagem = service.findById(id);
        return ResponseEntity.ok(personagem);
    }

    @GetMapping("/{id}/itens")
    public ResponseEntity<List<ItemMagico>> getItens(@PathVariable Long id){
        List<ItemMagico> itens = service.getItensMagicos(id);
        return ResponseEntity.ok(itens);
    }

    @GetMapping("/{id}/amuleto")
    public ResponseEntity<ItemMagico> getAmuleto(@PathVariable Long id){
        ItemMagico amuleto = service.getAmuleto(id);
        return ResponseEntity.ok(amuleto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Personagem> update(@PathVariable Long id, @RequestBody Personagem personagem){
        Personagem personagemAtualizado = service.update(id, personagem);
        return ResponseEntity.ok(personagemAtualizado);
    }

    @PutMapping("/{id}/nomeAventureiro")
    public ResponseEntity<Personagem> updateNomeAventureiro(@PathVariable Long id, @RequestBody String nomeAventureiro){
        Personagem personagemAtualizado = service.updateNomeAventureiro(id, nomeAventureiro);
        return ResponseEntity.ok(personagemAtualizado);
    }

    @PutMapping("/{idPersonagem}/itens/{idItem}")
    public ResponseEntity<Personagem> addItemAoPersonagem(@PathVariable Long idPersonagem, @PathVariable Long idItem){
        Personagem personagem = service.addItemAoPersonagem(idPersonagem, idItem);
        return ResponseEntity.ok(personagem);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{idPersonagem}/itens/{idItem}")
    public ResponseEntity<Void> deleteItemMagico(@PathVariable Long idPersonagem, @PathVariable Long idItem){
        service.deleteItemMagico(idPersonagem, idItem);
        return ResponseEntity.noContent().build();
    }

}
