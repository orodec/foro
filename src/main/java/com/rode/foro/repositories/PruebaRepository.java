package com.rode.foro.repositories;

import com.rode.foro.model.Prueba;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PruebaRepository extends JpaRepository <Prueba, Long> {
}
