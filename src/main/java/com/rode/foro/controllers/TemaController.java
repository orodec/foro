package com.rode.foro.controllers;
import com.rode.foro.services.TemaServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TemaController {
    TemaServiceImpl temaServiceImpl;

    public TemaController(TemaServiceImpl temaServiceImpl) {
        this.temaServiceImpl = temaServiceImpl;
    }

    @GetMapping("/hola")
    public String holaMundo(){
        return "Hola mundo que tal vamos!!! Hasta luego!";
    }


    @GetMapping("/foro/temas")
    public List modulos(){
       return temaServiceImpl.retornaModulos();
    }


}
