package com.rode.foro.services;


import com.rode.foro.model.Role;

public interface RoleService {
    Role findByName(String name);
}
