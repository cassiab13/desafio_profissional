package com.example.desafio.repositories;

import com.example.desafio.entities.ItemMagico;
import com.example.desafio.enums.TipoItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemMagicoRepository extends JpaRepository<ItemMagico, Long> {
    int countByTipoItem(TipoItem tipoItem);
}
