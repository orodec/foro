package com.rode.foro.model;

import javax.persistence.*;


@Entity
public class VoteAnswer {

    // Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Answer answer;

    // buiders

    public VoteAnswer() {
    }

    public VoteAnswer(Long id, User user, Answer answer) {
        this.id = id;
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
