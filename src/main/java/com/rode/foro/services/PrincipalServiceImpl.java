package com.rode.foro.services;

import com.rode.foro.dto.UserPrincipal;
import com.rode.foro.model.Course;
import com.rode.foro.model.Modules;
import com.rode.foro.model.User;
import com.rode.foro.repositories.ModulesRepository;
import com.rode.foro.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Service
public class PrincipalServiceImpl implements PrincipalService {

    private ModulesRepository modulesRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserPrincipal userPrincipal;

    public PrincipalServiceImpl(ModulesRepository modulesRepository) {
        this.modulesRepository = modulesRepository;
    }

    @Override
    public UserPrincipal  retornaPrincipal() {
        //  BUSCAR LOS cursos DE UN USUARIO CONCRETO
        String nombre = SecurityContextHolder.getContext().getAuthentication().getName();
        User usuarioTemporal = userRepository.findByUsername(nombre);
        Set <Course> cursosUsuario = usuarioTemporal.getCourseSet();
        // BUscar los modulos de cada curso
        Set <Modules> modulosUsuario = new HashSet<>();
        for (Course curso:cursosUsuario
             ) {
            Long miCurso = curso.getId();
            Set<Modules> moduloTemporal =  modulesRepository.findByCourse_id(miCurso);
            for (Modules moduloTemp: moduloTemporal
                 ) {
                modulosUsuario.add(moduloTemp);
            }
        }


        userPrincipal.setNombre(nombre);
        userPrincipal.setCursos(cursosUsuario);
        userPrincipal.setModulos(modulosUsuario);

        return userPrincipal;
    }
}
