package com.rode.foro.repositories;

import com.rode.foro.model.Course;
import com.rode.foro.model.Modules;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    // List<Course> findByUser_id(Long user_id);
    List<Course> findByUsuarios_idOrderByIdAsc(Long usuarios_id);
    List<Course> findByUsuarios_id(Long usuarios_id);
    // Set<Modules> findByCourse_idOrderByIdAsc(Long course_id);


}
