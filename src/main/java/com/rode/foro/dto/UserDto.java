package com.rode.foro.dto;

import com.rode.foro.model.Course;
import com.rode.foro.model.User;

import java.util.Set;

public class UserDto {
    
    private String username;
    private String password;
    private String email;
    private String phone;
    private String name;
    private String avatar;
    private Set<Course> cursosSet;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Set<Course> getCursosSet() {
        return cursosSet;
    }

    public void setCursosSet(Set<Course> cursosSet) {
        this.cursosSet = cursosSet;
    }

    public User getUserFromDto(){
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setPhone(phone);
        user.setName(name);
        user.setAvatar(avatar);
        user.setCourseSet(cursosSet);
        
        return user;
    }
    
}