package com.rode.foro.model;


import javax.persistence.*;
import java.time.LocalDateTime;

// https://www.oscarblancarteblog.com/2018/12/27/relaciones-manytomany/
// respuesta(id, cuerpo, dataTime,
//        fijada, util, id_pregunta, id_usuario)

@Entity
public class Answer {

    // Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String body;
    private LocalDateTime createTime;
    private Boolean fixed;
    private Boolean util;
    @ManyToOne
    private Question question;
    @ManyToOne
    private User user;

    // builders

    public Answer() {
    }

    public Answer(Long id, String body, LocalDateTime createTime, Boolean fixed, Boolean util, Question question, User user) {
        this.id = id;
        this.body = body;
        this.createTime = createTime;
        this.fixed = fixed;
        this.util = util;
        this.question = question;
        this.user = user;
    }

    // getter y setter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Boolean getUtil() {
        return util;
    }

    public void setUtil(Boolean util) {
        this.util = util;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    // toString


    @Override
    public String toString() {
        return "answer{" +
                "id=" + id +
                ", body='" + body + '\'' +
                ", createTime=" + createTime +
                ", fixed=" + fixed +
                ", util=" + util +
                ", question=" + question +
                ", user=" + user +
                '}';
    }
}
