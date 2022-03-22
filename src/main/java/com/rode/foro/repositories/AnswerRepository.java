package com.rode.foro.repositories;

import com.rode.foro.model.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long> {
    List<Answer> findByQuestion_idOrderByCreateTimeAsc(Long id);
}
