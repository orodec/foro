package com.rode.foro.model;

// votoQuestion(id, like, id_usuario, id_question)

import javax.persistence.*;

@Entity
public class VoteQuestion {

    // Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Boolean like;

    @ManyToOne
    private User user;

    @ManyToOne
    private Question question;

    // buiders

    public VoteQuestion() {
    }

    public VoteQuestion(Long id, Boolean like, User user, Question question) {
        this.id = id;
        this.like = like;
        this.user = user;
        this.question = question;
    }

    // getter y setter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getLike() {
        return like;
    }

    public void setLike(Boolean like) {
        this.like = like;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    // toString

    @Override
    public String toString() {
        return "VoteQuestion{" +
                "id=" + id +
                ", like=" + like +
                ", user=" + user +
                ", question=" + question +
                '}';
    }
}
