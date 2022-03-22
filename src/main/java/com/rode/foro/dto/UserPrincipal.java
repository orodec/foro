package com.rode.foro.dto;

import com.rode.foro.model.Course;
import com.rode.foro.model.Modules;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
public class UserPrincipal {

    String nombre;
    List <Course> cursos;
    List <Modules> modulos;

    public UserPrincipal() {
    }

    public UserPrincipal(String nombre, List cursos, List modulos) {
        this.nombre = nombre;
        this.cursos = cursos;
        this.modulos = modulos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List getCursos() {
        return cursos;
    }

    public void setCursos(List cursos) {
        this.cursos = cursos;
    }

    public List getModulos() {
        return modulos;
    }

    public void setModulos(List modulos) {
        this.modulos = modulos;
    }
}
