package com.sofka.tienda.repository;

import com.sofka.tienda.domain.Session;
import org.springframework.data.repository.CrudRepository;

public interface SessionRepository extends CrudRepository<Session, Integer> {
}