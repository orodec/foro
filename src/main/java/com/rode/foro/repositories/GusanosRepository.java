package com.rode.foro.repositories;

import com.rode.foro.model.Gusanos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GusanosRepository extends JpaRepository <Gusanos, Long> {
}
