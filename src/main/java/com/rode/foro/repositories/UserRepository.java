package com.rode.foro.repositories;

import com.rode.foro.model.Question;
import com.rode.foro.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import java.util.Set;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    User findByUsername(String username);
    boolean existsByEmail(String email);

    User findByEmail(String email);



    Set<User> findByQuestionSet(Question pregunta);
}