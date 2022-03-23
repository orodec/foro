package com.rode.foro.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "votos_preguntas")
public class VoteQuestion implements Serializable {

    // Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Boolean vote;

    @ManyToOne
    private User user;

    @ManyToOne
    private Question question;

    // buiders

    public VoteQuestion() {
    }

    public VoteQuestion(Long id, Boolean vote, User user, Question question) {
        this.id = id;
        this.vote = vote;
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

    public Boolean getVote() {
        return vote;
    }

    public void setVote(Boolean vote) {
        this.vote = vote;
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

    @Override
    public String toString() {
        return "VoteQuestion{" +
                "id=" + id +
                ", vote=" + vote +
                ", user=" + user +
                ", question=" + question +
                '}';
    }
}
