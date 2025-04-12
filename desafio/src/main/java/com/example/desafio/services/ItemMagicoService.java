package com.example.desafio.services;

import com.example.desafio.entities.ItemMagico;
import com.example.desafio.enums.TipoItem;
import com.example.desafio.repositories.ItemMagicoRepository;
import com.example.desafio.repositories.PersonagemRepository;
import com.example.desafio.validations.ValidaItemMagico;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemMagicoService implements ValidaItemMagico {

        @Autowired
        private ItemMagicoRepository repository;

        @Autowired
        private PersonagemRepository personagemRepository;

        @Autowired
        private ModelMapper mapper;

        public ItemMagico create(ItemMagico itemMagico) {
                try {
                  validarItem(itemMagico);
                    return repository.save(itemMagico);
                } catch (Exception e) {
                    throw new IllegalArgumentException("Item mágico não atende às especificações");
                }
        }

      public List<ItemMagico> getAll(){
            return repository.findAll();
        }

        public ItemMagico getById(Long id){
            return repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Item não encontrado"));
        }

        public ItemMagico update(Long id, ItemMagico item){
            ItemMagico itemMagicoExiste = repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Item não encontrado"));
            validarItem(itemMagicoExiste);
            mapper.map(item, itemMagicoExiste);

            return repository.save(itemMagicoExiste);
        }

        public void delete(Long id){
            repository.deleteById(id);
        }

    private void validarItem(ItemMagico item) {
        validaTipoArma(item);
        validaForcaDefesa(item.getForca(), item.getDefesa());
    }

    @Override
    public void validaForcaDefesa(Integer forca, Integer defesa) {
            if(forca < 0 || forca > 10)
                throw new IllegalArgumentException("A força do item deve estar entre 0 e 10");
            if(defesa < 0 || defesa > 10)
                throw new IllegalArgumentException("A defesa do item deve estar entre 0 e 10");
            if(defesa == 0 && forca == 0)
                throw new IllegalArgumentException("A defesa e a força não podem ser 0 ao mesmo tempo");
    }

    @Override
    public void validaTipoArma(ItemMagico item) {
        TipoItem tipo = (TipoItem) item.getTipoItem();
        if (tipo == TipoItem.ARMA) {
            item.setDefesa(0);
        }
        if (tipo == TipoItem.ARMADURA) {
            item.setForca(0);
        }
    }
}


