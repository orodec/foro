package com.rode.foro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.rode.foro.model.VoteAnswer;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;
import java.util.List;

@Repository
public interface VoteAnswerRepository extends JpaRepository<VoteAnswer,Long> {
    List<VoteAnswer> findByAnswer_idAndVote(Long id, boolean vote);
}
