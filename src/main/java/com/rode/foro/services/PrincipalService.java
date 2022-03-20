package com.rode.foro.services;

import com.rode.foro.dto.UserPrincipal;
import com.rode.foro.model.Modules;

import java.util.List;
import java.util.Set;

public interface PrincipalService {
    //metodo que retorne los modulos de un curso y el número de preguntas de ese curso(recibe por parametro el id del curso)
    //aproximacion metodo que retorne los modulos

    UserPrincipal retornaPrincipal();
}
