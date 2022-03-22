package com.rode.foro.controllers;
import com.rode.foro.dto.PreguntasDTO;
import com.rode.foro.dto.UserPrincipal;
import com.rode.foro.services.PrincipalServiceImpl;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;


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

    // TODO hacer tambien un Get by id que llame a otro metodo retornarDiscusiones
    /**
     * Buscar un libro por id
     * http://localhost:8080/api/books/1
     * http://localhost:8080/api/books/2
     * @param id
     * @return
     */

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping("/foro/principal/{id}")
    public List<PreguntasDTO> retornaPreguntasDTO(@PathVariable Long id){

    return principalServiceImpl.retornaPreguntasDTO(id);

    }

}
