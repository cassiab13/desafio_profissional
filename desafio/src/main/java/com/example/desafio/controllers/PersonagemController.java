package com.example.desafio.controllers;


import com.example.desafio.entities.Personagem;
import com.example.desafio.services.PersonagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/personagem")
public class PersonagemController {

    @Autowired
    private PersonagemService service;

    @RequestMapping("/create")
    public ResponseEntity<Personagem> create(@RequestBody Personagem personagem){
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(personagem.getId()).toUri();
        Personagem response = service.create(personagem);
        return ResponseEntity.created(uri).body(response);
    }

}
