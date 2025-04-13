package com.example.desafio.services;

import com.example.desafio.DTO.PersonagemDTO;
import com.example.desafio.entities.ItemMagico;
import com.example.desafio.entities.Personagem;
import com.example.desafio.enums.TipoItem;
import com.example.desafio.repositories.ItemMagicoRepository;
import com.example.desafio.repositories.PersonagemRepository;
import com.example.desafio.validations.ValidaPersonagem;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonagemService implements ValidaPersonagem {

    @Autowired
    private PersonagemRepository repository;

    @Autowired
    private ItemMagicoRepository itemMagicoRepository;

    @Autowired
    private ModelMapper modelMapper;

    public Personagem create(Personagem personagem) {
            validaPontos(personagem);
            return repository.save(personagem);
    }

    public List<PersonagemDTO> getAll(){
        return repository.findAll()
                .stream()
                .map(PersonagemDTO::new)
                .toList();
    }

    public PersonagemDTO findById(Long id){
        Personagem personagem = validaPersonagem(id);
        return new PersonagemDTO(personagem);
    }

    public List<ItemMagico> getItensMagicos(Long id){
        Personagem personagem = validaPersonagem(id);
        return personagem.getItensMagicos();
    }

    public ItemMagico getAmuleto(Long id){
        Personagem personagem = validaPersonagem(id);

        return personagem.getItensMagicos().stream()
                .filter(item -> item.getTipoItem() == TipoItem.AMULETO)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Este personagem não possui um amuleto"));
    }

    public Personagem update(Long id, Personagem personagem){
        Personagem personagemToUpdate = validaPersonagem(id);
        validaPontos(personagemToUpdate);
        modelMapper.map(personagem, personagemToUpdate);

        return repository.save(personagemToUpdate);
    }

    public Optional<Personagem> updateNomeAventureiro(Long id, String nomeAventureiro){
        Personagem personagem = validaPersonagem(id);

        personagem.setNomeAventureiro(nomeAventureiro);
        repository.save(personagem);

        return repository.findById(id);
    }

    public Optional<Personagem> addItemAoPersonagem(Long idPersonagem, Long idItem){
        Personagem personagem = validaPersonagem(idPersonagem);
        ItemMagico itemMagico = itemMagicoRepository.findById(idItem).orElseThrow(() -> new IllegalArgumentException("Item não encontrado"));
        if (itemMagico.getTipoItem() == TipoItem.AMULETO) {
            boolean jaTemAmuleto = personagem.getItensMagicos().stream()
                    .anyMatch(item -> item.getTipoItem() == TipoItem.AMULETO);
            if (jaTemAmuleto) {
                throw new IllegalStateException("Personagem já possui um amuleto");
            }
        }
        itemMagico.setPersonagem(personagem);
        personagem.getItensMagicos().add(itemMagico);
        repository.save(personagem);
        return repository.findById(idPersonagem);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

    public void deleteItemMagico(Long idPersonagem, Long idItemMagico){
        Personagem personagem = validaPersonagem(idPersonagem);
        ItemMagico itemMagico = itemMagicoRepository.findById(idItemMagico).orElseThrow(() -> new IllegalArgumentException("Item não encontrado"));

        personagem.getItensMagicos().remove(itemMagico);

        repository.save(personagem);
    }

    @Override
    public Personagem validaPersonagem(Long id) {
        return repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Personagem não encontrado"));
    }

    @Override
    public void validaPontos(Personagem personagem) {
        int pontosDisponiveis = 10;
        int total = personagem.getForca() + personagem.getDefesa();
        if(total > pontosDisponiveis)
            throw new IllegalArgumentException("Os pontos de força e defesa não podem ser maiores que 10");
    }
}
