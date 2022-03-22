package com.rode.foro.repositories;

import com.rode.foro.model.Modules;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;
import java.util.List;
import java.util.Set;

@Repository
public interface ModulesRepository extends JpaRepository<Modules, Long> {
    Set<Modules> findByCourse_id(Long course_id);
    Set<Modules> findByCourse_idOrderByIdAsc(Long course_id);
    Set<Modules> findByCourse_idOrderByIdDesc(Long course_id);

}
