package com.example.desafio.services;

import com.example.desafio.entities.ItemMagico;
import com.example.desafio.repositories.ItemMagicoRepository;
import com.example.desafio.validations.ForcaDefesa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemMagicoService implements ForcaDefesa {

        @Autowired
        private ItemMagicoRepository repository;

        public ItemMagico create(ItemMagico itemMagico) {

                validaForcaDefesa(itemMagico.getForca(), itemMagico.getDefesa());

                return repository.save(itemMagico);


        }

        public List<ItemMagico> getAll(){
            return repository.findAll();
        }

        public ItemMagico update(Long id, ItemMagico item){
            ItemMagico itemMagico = repository.findById(id).get();

            itemMagico.setNome(item.getNome());
            itemMagico.setTipoItem(item.getTipoItem());
            validaForcaDefesa(item.getForca(), item.getDefesa());
            return repository.save(itemMagico);
        }

        public void delete(Long id){
            repository.deleteById(id);
        }

    @Override
    public void validaForcaDefesa(Integer forca, Integer defesa) {

         int soma = forca + defesa;
            try {
                if (soma > 10) {
                    throw new IllegalArgumentException("A soma de força e defesa não pode ser maior que 10");
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
    }

    @Override
    public void validaTipoArma(Integer tipoArma) {

    }
}


