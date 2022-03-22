package com.rode.foro.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

// https://www.tutorialspoint.com/es/jpa/jpa_entity_relationships.htm
// usuario(id, nombre, email, password, rol, avatar)
@Entity
@Table(name = "usuarios")
public class User {

    // Attributes

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String username;

    @Column
    @JsonIgnore
    private String password;

    @Column
    private String email;

    @Column
    private String phone;

    @Column
    private String name;

    @Column
    private String avatar;


    // @ManyToMany(targetEntity=Course.class)
/*
   @ManyToMany(cascade = CascadeType.ALL)
   @JoinTable(name = "usuarios_cursos",
           joinColumns = @JoinColumn(name="usuarios_id"),
           inverseJoinColumns = @JoinColumn(name="cursos_id") )

 */

   @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
   @JoinTable(name = "usuarios_cursos",
           joinColumns = @JoinColumn(name="usuarios_id"),
           inverseJoinColumns = @JoinColumn(name="cursos_id") )
   private Set<Course> courseSet = new HashSet<>();

    @ManyToMany(targetEntity=Question.class)
    private Set questionSet;

    @ManyToMany(targetEntity=Notification.class)
    private Set NotificationSet;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "USER_ROLES",
            joinColumns = {
                    @JoinColumn(name = "USER_ID")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "ROLE_ID") })
    private Set<Role> roles;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "USER_PRUEBAS",
            joinColumns = {
                    @JoinColumn(name = "USER_ID")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "PRUEBA_ID") })
    private Set<Prueba> prueba;


    // getter y setter

    public Set<Prueba> getPrueba() {
        return prueba;
    }

    public void setPrueba(Set<Prueba> prueba) {
        this.prueba = prueba;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Set getCourseSet() {
        return courseSet;
    }

    public void setCourseSet(Set courseSet) {
        this.courseSet = courseSet;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

}

