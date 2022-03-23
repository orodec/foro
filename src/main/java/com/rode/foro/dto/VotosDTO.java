package com.rode.foro.dto;

import org.springframework.stereotype.Component;

@Component
public class VotosDTO {
    String item;
    Long id;
    int votosPositivos;
    int votosNegativos;

    public VotosDTO() {
    }

    public int getVotosPositivos() {
        return votosPositivos;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setVotosPositivos(int votosPositivos) {
        this.votosPositivos = votosPositivos;
    }

    public int getVotosNegativos() {
        return votosNegativos;
    }

    public void setVotosNegativos(int votosNegativos) {
        this.votosNegativos = votosNegativos;
    }
}
