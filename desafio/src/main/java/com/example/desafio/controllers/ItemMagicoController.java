package com.example.desafio.controllers;


import com.example.desafio.entities.ItemMagico;
import com.example.desafio.services.ItemMagicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RestController
@RequestMapping("/itens")
public class ItemMagicoController {
    @Autowired
    private ItemMagicoService service;

    @PostMapping
    public ResponseEntity<ItemMagico> create(@RequestBody ItemMagico itemMagico){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(itemMagico));
    }

    @GetMapping
    public ResponseEntity<List<ItemMagico>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemMagico> getById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ItemMagico> update(@PathVariable Long id, @RequestBody ItemMagico itemMagico){
        return ResponseEntity.status(HttpStatus.OK).body(service.update(id, itemMagico));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
