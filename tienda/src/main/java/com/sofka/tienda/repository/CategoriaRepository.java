package com.sofka.tienda.repository;

import com.sofka.tienda.domain.Categoria;
import org.springframework.data.repository.CrudRepository;

public interface CategoriaRepository extends CrudRepository<Categoria, Integer> {
}