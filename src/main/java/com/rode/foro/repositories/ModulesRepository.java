package com.rode.foro.repositories;

import com.rode.foro.model.Modules;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;

@Repository
public interface ModulesRepository extends JpaRepository<Modules, Long> {
}
