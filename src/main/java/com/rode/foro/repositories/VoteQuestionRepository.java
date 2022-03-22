package com.rode.foro.repositories;

import com.rode.foro.model.VoteQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VoteQuestionRepository extends JpaRepository<VoteQuestion, Long> {
    List<VoteQuestion> findByQuestion_idAndVote(Long id, Boolean vote);
}
