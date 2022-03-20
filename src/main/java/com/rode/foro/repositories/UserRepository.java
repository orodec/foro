package com.rode.foro.repositories;

import com.rode.foro.model.Course;
import com.rode.foro.model.Modules;
import com.rode.foro.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    User findByUsername(String username);
    boolean existsByEmail(String email);

}