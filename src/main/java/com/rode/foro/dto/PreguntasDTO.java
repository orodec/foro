package com.rode.foro.dto;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class PreguntasDTO {
// necesario para preguntas
    private Long id;
    private Boolean fixed;
    private String title;
    private LocalDateTime createTime;
    private String username;
    private int votosPositivos;
    private int numeroRespuestas;
    private List<String> avatarUsuariosResponden;
// necesario para la discusion
    private int votosNegativos;
    private String body;
    private String avatar;


    public PreguntasDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getFixed() {
        return fixed;
    }

    public void setFixed(Boolean fixed) {
        this.fixed = fixed;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getVotosPositivos() {
        return votosPositivos;
    }

    public void setVotosPositivos(int votosPositivos) {
        this.votosPositivos = votosPositivos;
    }

    public int getNumeroRespuestas() {
        return numeroRespuestas;
    }

    public void setNumeroRespuestas(int numeroRespuestas) {
        this.numeroRespuestas = numeroRespuestas;
    }

    public List<String> getAvatarUsuariosResponden() {
        return avatarUsuariosResponden;
    }

    public void setAvatarUsuariosResponden(List<String> avatarUsuariosResponden) {
        this.avatarUsuariosResponden = avatarUsuariosResponden;
    }

    public int getVotosNegativos() {
        return votosNegativos;
    }

    public void setVotosNegativos(int votosNegativos) {
        this.votosNegativos = votosNegativos;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}

