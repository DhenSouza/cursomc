package com.dhentech.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dhentech.domain.Categoria;
import com.dhentech.services.CategoriaService;

@RestController
@RequestMapping(value = "/categorias", method = RequestMethod.GET)
public class CategoriaResources {
	
	@Autowired
	private CategoriaService repository;
	
	@GetMapping("/{id}")
	public ResponseEntity<Categoria> findById(@PathVariable Integer id) {
		Categoria obj = repository.find(id);
		return ResponseEntity.ok().body(obj);
	}

	
}
