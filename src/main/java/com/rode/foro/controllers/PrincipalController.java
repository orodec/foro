package com.rode.foro.controllers;
import com.rode.foro.dto.DiscusionDTO;
import com.rode.foro.dto.PreguntasDTO;
import com.rode.foro.dto.UserPrincipal;
import com.rode.foro.services.PrincipalServiceImpl;
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
    @GetMapping("/foro/principal/{id}")
    public List<PreguntasDTO> retornaPreguntasDTO(@PathVariable Long id){
    return principalServiceImpl.retornaPreguntasDTO(id);
    }


    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping("/foro/discusiones/{id}")
    public DiscusionDTO retornaDiscusionDTO(@PathVariable Long id){

        return principalServiceImpl.retornaDiscusionDTO(id);

    }

  
    @PostMapping("/foro/discusiones/{id}")
    public DiscusionDTO nuevaRespuesta (@RequestBody String cuerpo, @PathVariable Long id){

        return principalServiceImpl.nuevaRespuesta(cuerpo, id);
    }

    // TODO metodo para escribir una nueva pregunta

}
