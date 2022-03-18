package com.rode.foro.controllers;
import com.rode.foro.services.PrincipalServiceImpl;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PrincipalController {
    PrincipalServiceImpl temaServiceImpl;

    public PrincipalController(PrincipalServiceImpl temaServiceImpl) {
        this.temaServiceImpl = temaServiceImpl;
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping("/hola")
    public String holaMundo(){
        return "Hola mundo que tal vamos!!! Hasta luego!";
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping("/foro/principal")

    public List modulos(){

        return temaServiceImpl.retornaModulos();
    }


}
