package com.rode.foro.services;

import com.rode.foro.model.Modules;
import com.rode.foro.model.User;
import com.rode.foro.repositories.ModulesRepository;
import com.rode.foro.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class PrincipalServiceImpl implements PrincipalService {

    private ModulesRepository modulesRepository;

    @Autowired
    private UserRepository userRepository;

    public PrincipalServiceImpl(ModulesRepository modulesRepository) {
        this.modulesRepository = modulesRepository;
    }

    @Override
    public List<Modules> retornaModulos() {
        // TODO BUSCAR LOS MODULOS DE UN USUARIO CONCRETO
        String nombre = SecurityContextHolder.getContext().getAuthentication().getName();
        User usuarioTemporal = userRepository.findByUsername(nombre);
        Set cursosUsuario = usuarioTemporal.getCourseSet();

        System.out.println("Estos son los cursos del usuario: " + cursosUsuario);
        System.out.println("Este es el nombre del usuario temportal: " + usuarioTemporal.getUsername());
        return modulesRepository.findAll();

    }
}
