package com.rode.foro.model;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "votos_respuestas")
public class VoteAnswer implements Serializable {

    // Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Boolean vote;

    @ManyToOne
    private User user;

    @ManyToOne
    private Answer answer;

    // buiders

    public VoteAnswer() {
    }

    public VoteAnswer(Long id, Boolean vote, User user, Answer answer) {
        this.id = id;
        this.vote = vote;
        this.user = user;
        this.answer = answer;
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

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }

    // toString

    @Override
    public String toString() {
        return "voteAnswerRepository{" +
                "id=" + id +
                ", user=" + user +
                ", answer=" + answer +
                '}';
    }
}
