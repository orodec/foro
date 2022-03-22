package com.rode.foro.dto;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class PreguntasDTO {
    private Boolean fixed;
    private String title;
    private LocalDateTime createTime;
 // En segunda fase porque son mas dificiles de obtener
    private String username;
    private Long votosPositivos;
    private Long numeroRespuestas;
    private List<String> avatarUsuariosResponden;

    public PreguntasDTO() {
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

    public Long getVotosPositivos() {
        return votosPositivos;
    }

    public void setVotosPositivos(Long votosPositivos) {
        this.votosPositivos = votosPositivos;
    }

    public Long getNumeroRespuestas() {
        return numeroRespuestas;
    }

    public void setNumeroRespuestas(Long numeroRespuestas) {
        this.numeroRespuestas = numeroRespuestas;
    }

    public List<String> getAvatarUsuariosResponden() {
        return avatarUsuariosResponden;
    }

    public void setAvatarUsuariosResponden(List<String> avatarUsuariosResponden) {
        this.avatarUsuariosResponden = avatarUsuariosResponden;
    }
}

