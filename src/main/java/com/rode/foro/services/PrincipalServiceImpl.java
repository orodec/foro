package com.rode.foro.services;

import com.rode.foro.dto.*;
import com.rode.foro.model.*;
import com.rode.foro.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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

    @Autowired
    private VoteQuestionRepository voteQuestionRepository;

    @Autowired
    private  VoteAnswerRepository voteAnswerRepository;

    @Autowired
    private AnswerRepository answerRepository;

    @Autowired
    private DiscusionDTO discusionDTO;

    @Autowired
    private RespuestaDTO respuestaDto;

    @Autowired
    private VotosDTO votosDTO;

    @Autowired
    private PatataRepository patataRepository;







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
            preguntasDTO.setId(pregunta.getId());
            preguntasDTO.setFixed(pregunta.getFixed());
            preguntasDTO.setTitle(pregunta.getTitle());
            preguntasDTO.setCreateTime((pregunta.getCreateTime()));
            preguntasDTO.setUsername( pregunta.getUser().getUsername() );
            // Recuperar los votos positivos de la pregunta
            List<VoteQuestion> votos = voteQuestionRepository.findByQuestion_idAndVote(pregunta.getId(), true);
            preguntasDTO.setVotosPositivos(votos.size());
            // recuperar el numero de respuestas
            List<Answer> respuestas = answerRepository.findByQuestion_idOrderByCreateTimeAsc(pregunta.getId());
            preguntasDTO.setNumeroRespuestas(respuestas.size());
            List <String> ListaAvatar = new ArrayList<>();
            ListaAvatar.add(pregunta.getUser().getAvatar());
            for (Answer respuesta:respuestas
                 ) {
                ListaAvatar.add(respuesta.getUser().getAvatar());
            }
            if(ListaAvatar.size() > 3){
                preguntasDTO.setAvatarUsuariosResponden(ListaAvatar.subList(0,3));
            }else preguntasDTO.setAvatarUsuariosResponden(ListaAvatar);

            listaPreguntasDTO.add(preguntasDTO);
        }



        return  listaPreguntasDTO ;
    }

    @Override
    public DiscusionDTO retornaDiscusionDTO(Long preguntaId) {
        // recuperar datos de la pregunta solicitada
        Optional preguntaOPT = questionRepository.findById(preguntaId);
        Question pregunta = null;
        if (preguntaOPT.isPresent()) { pregunta = (Question) preguntaOPT.get(); }
        preguntasDTO.setId(pregunta.getId());
        preguntasDTO.setFixed(pregunta.getFixed());
        preguntasDTO.setTitle(pregunta.getTitle());
        preguntasDTO.setCreateTime(pregunta.getCreateTime());
        preguntasDTO.setUsername(pregunta.getUser().getUsername());
        preguntasDTO.setAvatar(pregunta.getUser().getAvatar());
        preguntasDTO.setBody(pregunta.getBody());
        List<Answer> respuestasContador = answerRepository.findByQuestion_idOrderByCreateTimeAsc(pregunta.getId());
        preguntasDTO.setNumeroRespuestas(respuestasContador.size());
        List<VoteQuestion> votosPositivos = voteQuestionRepository.findByQuestion_idAndVote(pregunta.getId(), true);
        preguntasDTO.setVotosPositivos(votosPositivos.size());
        List<VoteQuestion> votosNegativos = voteQuestionRepository.findByQuestion_idAndVote(pregunta.getId(), false);
        preguntasDTO.setVotosNegativos(votosNegativos.size());
        discusionDTO.setPreguntasDTO(preguntasDTO);
        // recuperar datos de las respuestas asociadas
        List<Answer> respuestas = answerRepository.findByQuestion_idOrderByCreateTimeAsc(pregunta.getId());
        List<RespuestaDTO> ListaRespuestasDto = new ArrayList<>();
        for (Answer respuesta: respuestas
             ) {
            RespuestaDTO respuestaDtoTemporal = new RespuestaDTO();
            respuestaDtoTemporal.setId(respuesta.getId());
            respuestaDtoTemporal.setBody(respuesta.getBody());
            respuestaDtoTemporal.setCreateTime(respuesta.getCreateTime());
            respuestaDtoTemporal.setFixed(respuesta.getFixed());
            respuestaDtoTemporal.setUtil(respuesta.getUtil());
            respuestaDtoTemporal.setUser(respuesta.getUser().getUsername());
            respuestaDtoTemporal.setAvatar(respuesta.getUser().getAvatar());
            List<VoteAnswer> votosPositivosRespuesta = voteAnswerRepository.findByAnswer_idAndVote(respuesta.getId(), true);
            respuestaDtoTemporal.setVotosPositivos(votosPositivosRespuesta.size());
            List<VoteAnswer> votosNegativosRespuesta = voteAnswerRepository.findByAnswer_idAndVote(respuesta.getId(), false);
            respuestaDtoTemporal.setVotosNegativos(votosPositivosRespuesta.size());
            ListaRespuestasDto.add(respuestaDtoTemporal);
        }
        discusionDTO.setAnswer(ListaRespuestasDto);


        return discusionDTO;
    }

    @Override
    public DiscusionDTO nuevaRespuesta(String cuerpo, Long id) {
        Answer answer = new Answer();
        answer.setBody(cuerpo);
        /*
        LocalDateTime.now() para obtener la fecha y hora actual en Java
        ZonedDateTime.now() para obtener la fecha y hora actual con la zona horaria en Java
        Calendar.getinstance() para obtener la fecha y hora actual en Java
                */
        answer.setCreateTime(LocalDateTime.now());
        answer.setFixed(false);
        answer.setUtil(false);
        Optional<Question> preguntaOpt = questionRepository.findById(id);
        Question pregunta=null;
        if(preguntaOpt.isPresent()){pregunta = preguntaOpt.get();}
        answer.setQuestion(pregunta);
        String nombre = SecurityContextHolder.getContext().getAuthentication().getName();
        User usuario = userRepository.findByUsername(nombre);
        answer.setUser(usuario);
        answerRepository.save(answer);

        return retornaDiscusionDTO(id);

    }

    @Override
    public DiscusionDTO nuevaPregunta( Question pregunta, Long id_modulo) {
        pregunta.setCreateTime(LocalDateTime.now());
        pregunta.setFixed(false);
        Optional<Modules> miModuloOpt = modulesRepository.findById(id_modulo);
        Modules miModulo = miModuloOpt.get();
        pregunta.setModule(miModulo);
        String nombre = SecurityContextHolder.getContext().getAuthentication().getName();
        User usuario = userRepository.findByUsername(nombre);
        pregunta.setUser(usuario);
        questionRepository.save(pregunta);

        return retornaDiscusionDTO(pregunta.getId());
        // TODO revisar porque categoria viene a null
    }

    @Override
    public VotosDTO VotoPreegunta(VoteQuestion voto, Long id_pregunta) {
        String nombre = SecurityContextHolder.getContext().getAuthentication().getName();
        User usuario = userRepository.findByUsername(nombre);
        voto.setUser(usuario);
        Optional<Question> pregunaOpt = questionRepository.findById(id_pregunta);
        Question pregunta = pregunaOpt.get();
        voto.setQuestion(pregunta);
        voteQuestionRepository.save(voto);

        List<VoteQuestion> votosPositivos = voteQuestionRepository.findByQuestion_idAndVote(pregunta.getId(), true);
        votosDTO.setVotosPositivos(votosPositivos.size());
        List<VoteQuestion> votosNegativos = voteQuestionRepository.findByQuestion_idAndVote(pregunta.getId(), false);
        votosDTO.setVotosNegativos(votosNegativos.size());
        votosDTO.setItem("PREGUNTA");
        votosDTO.setId(id_pregunta);

        return votosDTO;
    }

    @Override
    public void guardarPatata(Patata patata) {
        System.out.println(patata);
        patataRepository.save(patata);
    }

    @Override
    public VotosDTO VotoRespuesta(VoteAnswer voto, Long id_respuesta) {
        String nombre = SecurityContextHolder.getContext().getAuthentication().getName();
        User usuario = userRepository.findByUsername(nombre);
        voto.setUser(usuario);
        Optional<Answer> respuestaOpt = answerRepository.findById(id_respuesta);
        Answer respuesta = respuestaOpt.get();
        voto.setAnswer(respuesta);
        voteAnswerRepository.save(voto);

        List<VoteAnswer> votosPositivos = voteAnswerRepository.findByAnswer_idAndVote(respuesta.getId(), true);
        votosDTO.setVotosPositivos(votosPositivos.size());
        List<VoteAnswer> votosNegativos = voteAnswerRepository.findByAnswer_idAndVote(respuesta.getId(), false);
        votosDTO.setVotosNegativos(votosNegativos.size());
        votosDTO.setItem("RESPUESTA");
        votosDTO.setId(id_respuesta);

        return votosDTO;
    }
}
