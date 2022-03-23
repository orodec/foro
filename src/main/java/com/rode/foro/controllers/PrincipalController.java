package com.rode.foro.controllers;
import com.rode.foro.dto.DiscusionDTO;
import com.rode.foro.dto.PreguntasDTO;
import com.rode.foro.dto.UserPrincipal;
import com.rode.foro.model.Question;
import com.rode.foro.services.PrincipalServiceImpl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class PrincipalController {
    PrincipalServiceImpl principalServiceImpl;

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
    @PostMapping("/foro/discusiones/{id_pregunta}")
    public DiscusionDTO nuevaRespuesta (@RequestBody String cuerpo, @PathVariable Long id_pregunta){

        return principalServiceImpl.nuevaRespuesta(cuerpo, id_pregunta);
    }

    // TODO metodo para escribir una nueva pregunta
    @PostMapping("/foro/nueva_pregunta/{id_modulo}")
    public DiscusionDTO nuevaPreegunta(@RequestBody Question pregunta, @PathVariable Long id_modulo){

        return principalServiceImpl.nuevaPregunta(pregunta, id_modulo);
    }


}
