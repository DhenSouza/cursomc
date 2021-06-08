package com.dhentech.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.dhentech.domain.Categoria;
import com.dhentech.repositories.CategoriaRepository;
import com.dhentech.services.exceptions.DataIntegrityException;
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

	// Meotod Put
	public Categoria update(Categoria obj) {
		find(obj.getId());
		return repository.save(obj);
	}

	public void delete(Integer id) {
		find(id);

		try {
			repository.deleteById(id);
		} catch (DataIntegrityViolationException  e) {
			throw new DataIntegrityException("Categoria não pode ser deletada! possui produtos associados");
		}
	}

}
