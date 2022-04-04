package com.rode.foro.controllers;
import com.rode.foro.dto.*;
import com.rode.foro.model.*;
import com.rode.foro.repositories.QuestionRepository;
import com.rode.foro.repositories.UserRepository;
import com.rode.foro.services.PrincipalServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class PrincipalController {
    PrincipalServiceImpl principalServiceImpl;

    @Autowired
    QuestionRepository questionRepository;
    @Autowired
    UserRepository userRepository;

    public PrincipalController(PrincipalServiceImpl temaServiceImpl) {
        this.principalServiceImpl = temaServiceImpl;
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping("/hola")
    public String holaMundo(){
        return "Hola mundo que tal vamos!!! Hasta luego!";
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping("/foro/principal")
    public UserPrincipal userPrincipal(){ return principalServiceImpl.retornaPrincipal(); }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping("/foro/principal/{id_modulo}")
    public List<PreguntasDTO> retornaPreguntasDTO(@PathVariable Long id_modulo){
    return principalServiceImpl.retornaPreguntasDTO(id_modulo);
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping("/foro/discusiones/{id_pregunta}")
    public DiscusionDTO retornaDiscusionDTO(@PathVariable Long id_pregunta){

        return principalServiceImpl.retornaDiscusionDTO(id_pregunta);
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping("/foro/discusiones-seguir/{id_pregunta}")
    public void seguir(@PathVariable Long id_pregunta){
        String nombre = SecurityContextHolder.getContext().getAuthentication().getName();
        User usuarioTemporal = userRepository.findByUsername(nombre);

        Set<Question> questionSet = usuarioTemporal.getQuestionSet();

        Optional preguntaOPT = questionRepository.findById(id_pregunta);
        Question pregunta = null;
        if (preguntaOPT.isPresent()) { pregunta = (Question) preguntaOPT.get(); }

        questionSet.add(pregunta);
        usuarioTemporal.setQuestionSet(questionSet);
        userRepository.save(usuarioTemporal);
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @PostMapping("/foro/discusiones/{id_pregunta}")
    public DiscusionDTO nuevaRespuesta (@RequestBody NuevaRespuestaDTO cuerpo, @PathVariable Long id_pregunta){

        return principalServiceImpl.nuevaRespuesta(cuerpo, id_pregunta);
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @PostMapping("/foro/nueva_pregunta/{id_modulo}")
    public DiscusionDTO nuevaPreegunta(@RequestBody NuevaPreguntaDTO pregunta, @PathVariable Long id_modulo){

        return principalServiceImpl.nuevaPregunta(pregunta, id_modulo);
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @PostMapping("/foro/voto_pregunta/{id_pregunta}")
    public VotosDTO VotoPreegunta(@RequestBody VoteQuestion voto, @PathVariable Long id_pregunta){

        return principalServiceImpl.VotoPreegunta(voto, id_pregunta);
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @PostMapping("/foro/voto_respuesta/{id_respuesta}")
    public VotosDTO VotoRespuesta(@RequestBody VoteAnswer voto, @PathVariable Long id_respuesta){

        return principalServiceImpl.VotoRespuesta(voto, id_respuesta);
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @PostMapping("/foro/patata")
    public void guardarPatata(@RequestBody Patata patata){

         principalServiceImpl.guardarPatata(patata);

    }
}
