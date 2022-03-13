package com.rode.foro.repositories;

import com.rode.foro.model.VoteQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface voteQuestionRepository extends JpaRepository<VoteQuestion, Long> {
}
