package com.rode.foro.model;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "pruebas")
public class Prueba implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String texto;

    public Prueba() {
    }

    public Prueba(Long id, String texto) {
        this.id = id;
        this.texto = texto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
}
