package com.rode.foro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.rode.foro.model.VoteAnswer;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;

@Repository
public interface VoteAnswerRepository extends JpaRepository<VoteAnswer,Long> {
}
