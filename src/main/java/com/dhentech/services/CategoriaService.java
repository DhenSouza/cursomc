package com.dhentech.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dhentech.domain.Categoria;
import com.dhentech.repositories.CategoriaRepository;
import com.dhentech.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repository;

	// Metodo de buscar categoria com tratamento de erro
	public Categoria find(Integer id) {
		Optional<Categoria> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! id: " + id + ", tipo: " + Categoria.class.getName()));
	}

	// Metodo com uma lista de retorno de todas as categorias
	public List<Categoria> findAll() {
		return repository.findAll();
	}

	// metodo post
	public Categoria insert(Categoria obj) {
		obj.setId(null);
		return repository.save(obj);
	}

}
