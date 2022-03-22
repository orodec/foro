package com.rode.foro.model;

import javax.persistence.*;
import java.io.Serializable;

// tema(id, titulo, descripcion, id_foro)

@Entity
@Table(name = "modulos")
public class Modules implements Serializable {
    // Attributes

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    @Transient
    private Integer preguntas;
    @ManyToOne
    private Course course;

    // builders

    public Modules() {
    }

    public Modules(Long id, String title, String description, Course course) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.course = course;
    }

    // getter y setter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Integer getPreguntas() {
        return preguntas;
    }

    public void setPreguntas(Integer preguntas) {
        this.preguntas = preguntas;
    }
// toString

    @Override
    public String toString() {
        return "Theme{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", forum=" + course +
                '}';
    }
}
