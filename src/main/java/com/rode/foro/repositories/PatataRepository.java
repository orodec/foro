package com.rode.foro.repositories;

import com.rode.foro.model.Patata;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatataRepository extends JpaRepository<Patata, Long> {
}
