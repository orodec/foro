package com.rode.foro.dto;

public class NuevaRespuestaDTO {
    private String respuesta;

    public NuevaRespuestaDTO() {
    }

    public NuevaRespuestaDTO(String respuesta) {
        this.respuesta = respuesta;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    @Override
    public String toString() {
        return "NuevaRespuestaDTO{" +
                "respuesta='" + respuesta + '\'' +
                '}';
    }
}
