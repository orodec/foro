package com.rode.foro.model;

import com.rode.foro.type.Category;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;
import javax.persistence.*;

// https://www.tutorialspoint.com/es/jpa/jpa_entity_relationships.htm
//pregunta(id, titulo, categoria, cuerpo, gusta, noGusta,
// dataTime, fijada, id_tema, id_usuario)
@Entity
@Table(name = "preguntas")
public class Question implements Serializable {

    // Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private Category category;
    private String body;
    private LocalDateTime createTime;
    private Boolean fixed;

    @ManyToOne
    private Modules module;
    @ManyToOne
    private User user;

    @ManyToMany(targetEntity=User.class)
    private Set userSet;

    // builders


    public Question() {
    }

    public Question(Long id, String title, Category category, String body, LocalDateTime createTime, Boolean fixed, Modules module, User user, Set userSet) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.body = body;
        this.createTime = createTime;
        this.fixed = fixed;
        this.module = module;
        this.user = user;
        this.userSet = userSet;
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public Boolean getFixed() {
        return fixed;
    }

    public void setFixed(Boolean fixed) {
        this.fixed = fixed;
    }

    public Modules getModule() {
        return module;
    }

    public void setModule(Modules theme) {
        this.module = theme;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set getUserSet() {
        return userSet;
    }

    public void setUserSet(Set userSet) {
        this.userSet = userSet;
    }

    // toString

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", category=" + category +
                ", body='" + body + '\'' +
                ", createTime=" + createTime +
                ", fixed=" + fixed +
                ", theme=" + module +
                ", user=" + user +
                ", userSet=" + userSet +
                '}';
    }
}
