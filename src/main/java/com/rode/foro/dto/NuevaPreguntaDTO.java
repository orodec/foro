package com.rode.foro.dto;

public class NuevaPreguntaDTO {
    private String body;
    private String title;

    public NuevaPreguntaDTO() {
    }

    public NuevaPreguntaDTO(String body) {
        this.body = body;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "NuevaPreguntaDTO{" +
                "body='" + body + '\'' +
                '}';
    }
}
