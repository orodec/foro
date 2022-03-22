package com.rode.foro.services;

import com.rode.foro.dto.PreguntasDTO;
import com.rode.foro.dto.UserPrincipal;
import com.rode.foro.model.Course;
import com.rode.foro.model.Modules;
import com.rode.foro.model.Question;
import com.rode.foro.model.User;
import com.rode.foro.repositories.CourseRepository;
import com.rode.foro.repositories.ModulesRepository;
import com.rode.foro.repositories.QuestionRepository;
import com.rode.foro.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PrincipalServiceImpl implements PrincipalService {

    private ModulesRepository modulesRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private UserPrincipal userPrincipal;

    @Autowired
    private PreguntasDTO preguntasDTO;



    public PrincipalServiceImpl(ModulesRepository modulesRepository) {
        this.modulesRepository = modulesRepository;
    }

    @Override
    public UserPrincipal  retornaPrincipal() {
        //  BUSCAR LOS cursos DE UN USUARIO CONCRETO
        String nombre = SecurityContextHolder.getContext().getAuthentication().getName();
        User usuarioTemporal = userRepository.findByUsername(nombre);
        Long idUser = usuarioTemporal.getId();
        List <Course> cursosUsuario = courseRepository.findByUsuarios_id(idUser);

        // Buscar los modulos de cada curso
        List<Modules> modulosUsuario = new ArrayList<>();
        for (Course curso:cursosUsuario
             ) {
            Long miCurso = curso.getId();
            Set<Modules> moduloTemporal =  modulesRepository.findByCourse_idOrderByIdAsc(miCurso);
            for (Modules moduloTemp: moduloTemporal
                 ) {
                modulosUsuario.add(moduloTemp);
            }
        }

        // Buscar el número de preguntas de cada modulo

        for (Modules modulo:modulosUsuario
        ) {
            Long miModulo = modulo.getId();
            Set<Question> pregunatasTemporal =  questionRepository.findByModule_id(miModulo);
            modulo.setPreguntas( pregunatasTemporal.size());
        }

        userPrincipal.setNombre(nombre);
        userPrincipal.setCursos(cursosUsuario);
        userPrincipal.setModulos(modulosUsuario);

        return userPrincipal;
    }

    @Override
    public  List<PreguntasDTO> retornaPreguntasDTO(Long moduloId){
        Set<Question> pregunatasTemporal =   questionRepository.findByModule_id(moduloId);
        List<PreguntasDTO> listaPreguntasDTO = new ArrayList<>();

        for (Question pregunta: pregunatasTemporal
             ) {
            preguntasDTO.setFixed(pregunta.getFixed());
            preguntasDTO.setTitle(pregunta.getTitle());
            preguntasDTO.setCreateTime((pregunta.getCreateTime()));
            listaPreguntasDTO.add(preguntasDTO);
        }



        return  listaPreguntasDTO ;
    }
}
