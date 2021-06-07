package com.dhentech.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dhentech.domain.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer>{

}
