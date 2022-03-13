package com.rode.foro.repositories;

import com.rode.foro.model.Theme;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.Entity;

@Entity
public interface ThemeRepository extends JpaRepository<Theme, Long> {
}
