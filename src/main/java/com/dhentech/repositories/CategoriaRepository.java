package com.dhentech.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dhentech.domain.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

}
