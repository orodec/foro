package com.rode.foro.model;

import com.rode.foro.type.Rol;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

// https://www.tutorialspoint.com/es/jpa/jpa_entity_relationships.htm
// usuario(id, nombre, email, password, rol, avatar)
@Entity
@Table(name = "usuarios")
public class User implements Serializable {

    // Attributes

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String password;
    private Rol rol;
    private String avatar;

    @ManyToMany(targetEntity=Question.class)
    private Set questionSet;

    @ManyToMany(targetEntity=Notification.class)
    private Set NotificationSet;

    // builders

    public User() {
    }

    public User(Long id, String name, String email, String password, Rol rol, String avatar, Set questionSet, Set notificationSet) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.rol = rol;
        this.avatar = avatar;
        this.questionSet = questionSet;
        NotificationSet = notificationSet;
    }

    public User(Long id, String name, String email, String password, Rol rol, String avatar) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.rol = rol;
        this.avatar = avatar;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Set getQuestionSet() {
        return questionSet;
    }

    public void setQuestionSet(Set questionSet) {
        this.questionSet = questionSet;
    }

    public Set getNotificationSet() {
        return NotificationSet;
    }

    public void setNotificationSet(Set notificationSet) {
        NotificationSet = notificationSet;
    }

    // toString

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", rol=" + rol +
                ", avatar='" + avatar + '\'' +
                ", questionSet=" + questionSet +
                ", NotificationSet=" + NotificationSet +
                '}';
    }
}

