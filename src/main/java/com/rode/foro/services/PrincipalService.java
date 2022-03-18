package com.rode.foro.services;

import com.rode.foro.model.Modules;

import java.util.List;

public interface PrincipalService {
    //metodo que retorne los modulos de un curso y el número de preguntas de ese curso(recibe por parametro el id del curso)
    //aproximacion metodo que retorne los modulos

    List<Modules> retornaModulos();


}
