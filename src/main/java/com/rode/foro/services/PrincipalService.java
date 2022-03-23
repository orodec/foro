package com.rode.foro.services;

import com.rode.foro.dto.DiscusionDTO;
import com.rode.foro.dto.PreguntasDTO;
import com.rode.foro.dto.UserPrincipal;
import com.rode.foro.model.Question;

import java.util.List;

public interface PrincipalService {



    UserPrincipal retornaPrincipal();

    List<PreguntasDTO> retornaPreguntasDTO(Long moduloId);

    DiscusionDTO retornaDiscusionDTO(Long preguntaId);

    DiscusionDTO nuevaRespuesta(String cuerpo, Long id);

    DiscusionDTO nuevaPregunta(Question pregunta, Long id_modulo);
}
