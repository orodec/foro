package com.rode.foro.dto;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DiscusionDTO {

    PreguntasDTO preguntasDTO;
    List<RespuestaDTO> answer;

    public DiscusionDTO() {
    }

    public PreguntasDTO getPreguntasDTO() {
        return preguntasDTO;
    }

    public void setPreguntasDTO(PreguntasDTO preguntasDTO) {
        this.preguntasDTO = preguntasDTO;
    }

    public List<RespuestaDTO> getAnswer() {
        return answer;
    }

    public void setAnswer(List<RespuestaDTO> answer) {
        this.answer = answer;
    }
}
