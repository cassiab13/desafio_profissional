package com.example.desafio;

import com.example.desafio.entities.ItemMagico;
import com.example.desafio.entities.Personagem;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DesafioApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesafioApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.typeMap(ItemMagico.class, ItemMagico.class).addMappings(mapper -> mapper.skip(ItemMagico::setId));
		modelMapper.typeMap(Personagem.class, Personagem.class).addMappings(mapper -> mapper.skip(Personagem::setId));
		return modelMapper;
	}

}
