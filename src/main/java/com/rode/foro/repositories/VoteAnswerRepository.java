package com.rode.foro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.rode.foro.model.VoteAnswer;
import javax.persistence.Entity;

@Entity
public interface VoteAnswerRepository extends JpaRepository<VoteAnswer,Long> {
}
