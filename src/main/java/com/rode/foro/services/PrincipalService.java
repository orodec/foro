package com.rode.foro.services;

import com.rode.foro.dto.DiscusionDTO;
import com.rode.foro.dto.PreguntasDTO;
import com.rode.foro.dto.UserPrincipal;
import com.rode.foro.dto.VotosDTO;
import com.rode.foro.model.Patata;
import com.rode.foro.model.Question;
import com.rode.foro.model.VoteAnswer;
import com.rode.foro.model.VoteQuestion;

import java.util.List;

public interface PrincipalService {



    UserPrincipal retornaPrincipal();

    List<PreguntasDTO> retornaPreguntasDTO(Long moduloId);

    DiscusionDTO retornaDiscusionDTO(Long preguntaId);

    DiscusionDTO nuevaRespuesta(String cuerpo, Long id);

    DiscusionDTO nuevaPregunta(Question pregunta, Long id_modulo);

    VotosDTO VotoPreegunta(VoteQuestion voto, Long id_pregunta);

    void guardarPatata(Patata patata);

    VotosDTO VotoRespuesta(VoteAnswer voto, Long id_respuesta);
}
