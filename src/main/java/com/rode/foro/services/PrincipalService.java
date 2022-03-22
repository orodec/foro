package com.rode.foro.services;

import com.rode.foro.dto.DiscusionDTO;
import com.rode.foro.dto.PreguntasDTO;
import com.rode.foro.dto.UserPrincipal;

import java.util.List;

public interface PrincipalService {



    UserPrincipal retornaPrincipal();

    List<PreguntasDTO> retornaPreguntasDTO(Long moduloId);

    DiscusionDTO retornaDiscusionDTO(Long preguntaId);

    DiscusionDTO nuevaRespuesta(String cuerpo, Long id);
}
