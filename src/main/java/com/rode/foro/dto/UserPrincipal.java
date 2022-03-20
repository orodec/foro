package com.rode.foro.dto;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
public class UserPrincipal {

    String nombre;
    Set cursos;
    Set modulos;

    public UserPrincipal() {
    }

    public UserPrincipal(String nombre, Set cursos, Set modulos) {
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

    public Set getCursos() {
        return cursos;
    }

    public void setCursos(Set cursos) {
        this.cursos = cursos;
    }

    public Set getModulos() {
        return modulos;
    }

    public void setModulos(Set modulos) {
        this.modulos = modulos;
    }
}
