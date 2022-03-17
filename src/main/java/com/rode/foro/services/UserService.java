package com.rode.foro.services;


import com.rode.foro.model.User;
import com.rode.foro.dto.UserDto;

import java.util.List;

public interface UserService {
    User save(UserDto user);
    List<User> findAll();
    User findOne(String username);
}
