package com.rode.foro.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

// notificaciones(id, id_respuesta, dataTime, visto)
@Entity
public class Notification {

    // Attributes

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime createTime;
    private Boolean viewed;

    @ManyToOne
    private Answer answer;

    @ManyToMany(targetEntity=User.class)
    private Set userSet;

    // builders

    public Notification() {
    }

    public Notification(Long id, LocalDateTime createTime, Boolean viewed, Answer answer, Set userSet) {
        this.id = id;
        this.createTime = createTime;
        this.viewed = viewed;
        this.answer = answer;
        this.userSet = userSet;
    }

    // getter y setter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public Boolean getViewed() {
        return viewed;
    }

    public void setViewed(Boolean viewed) {
        this.viewed = viewed;
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
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
        return "Notification{" +
                "id=" + id +
                ", createTime=" + createTime +
                ", viewed=" + viewed +
                ", answer=" + answer +
                ", userSet=" + userSet +
                '}';
    }
}
