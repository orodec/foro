package com.rode.foro.repositories;

import com.rode.foro.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
    Set<Question> findByModule_id(Long modulo);

}
