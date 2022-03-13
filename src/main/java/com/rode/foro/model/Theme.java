package com.rode.foro.model;

import javax.persistence.*;

// tema(id, titulo, descripcion, id_foro)

@Entity
public class Theme {
    // Attributes

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    @ManyToOne
    private Forum forum;

    // builders

    public Theme() {
    }

    public Theme(Long id, String title, String description, Forum forum) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.forum = forum;
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

    public Forum getForum() {
        return forum;
    }

    public void setForum(Forum forum) {
        this.forum = forum;
    }

    // toString

    @Override
    public String toString() {
        return "Theme{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", forum=" + forum +
                '}';
    }
}
