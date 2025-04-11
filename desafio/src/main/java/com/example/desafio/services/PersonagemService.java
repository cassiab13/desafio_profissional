package com.example.desafio.services;

import com.example.desafio.entities.Personagem;
import com.example.desafio.repositories.PersonagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonagemService {

    @Autowired
    private PersonagemRepository repository;

    public Personagem create(Personagem personagem) {
            return repository.save(personagem);
    }

    public List<Personagem> getAll(){
        return repository.findAll();
    }

    public Personagem update(Long id, Personagem personagem){
        Personagem personagem1 = repository.findById(id).get();

        personagem1.setNome(personagem.getNome());
        personagem1.setNomeAventureiro(personagem.getNomeAventureiro());
        personagem1.setClasse(personagem.getClasse());
        personagem1.setLevel(personagem.getLevel());
        personagem1.setItensMagicos(personagem.getItensMagicos());
        personagem1.setForca(personagem.getForca());
        personagem1.setDefesa(personagem.getDefesa());

        return repository.save(personagem1);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }
}
