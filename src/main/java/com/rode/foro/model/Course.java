package com.rode.foro.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

// Foro(id, nombre)

@Entity
@Table(name = "cursos")
public class Course implements Serializable {

    // Attributes

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String logo;

    @ManyToMany( mappedBy = "courseSet")
    @JsonIgnore // TODO si quitas esto se produce un json infinito, revisar porque sucede
    // @ManyToMany(targetEntity=User.class)
    private Set <User> usuarios = new HashSet<>();

    // builders

    public Course() {
    }

    public Course(Long id, String name, Set usuarios) {
        this.id = id;
        this.name = name;
        this.usuarios = usuarios;
    }

    // getter y setter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Set usuarios) {
        this.usuarios = usuarios;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }
    // toString

    @Override
    public String toString() {
        return "Forum{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
