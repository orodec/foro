package com.rode.foro.controllers;

import com.rode.foro.config.TokenProvider;
import com.rode.foro.dto.AuthToken;
import com.rode.foro.dto.LoginUser;
import com.rode.foro.dto.UserDto;
import com.rode.foro.model.Course;
import com.rode.foro.model.User;
import com.rode.foro.repositories.CourseRepository;
import com.rode.foro.repositories.UserRepository;
import com.rode.foro.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/users")
public class UserController {


    private AuthenticationManager authenticationManager;
    private TokenProvider jwtTokenUtil;
    private UserService userService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    CourseRepository courseRepository;

    public UserController(AuthenticationManager authenticationManager, TokenProvider jwtTokenUtil, UserService userService) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenUtil = jwtTokenUtil;
        this.userService = userService;
    }

    @PostMapping("/authenticate")
    public ResponseEntity<?> generateToken(@RequestBody LoginUser loginUser) throws AuthenticationException {
       //__ Con estas lineas logueo por email en lugar de por usuario____
        User usuario = userRepository.findByEmail(loginUser.getEmail());
        String name="";
        if(usuario != null){name = usuario.getUsername();}
            loginUser.setUsername(name);
       //______________________________________________________________
        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginUser.getUsername(),
                        loginUser.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        final String token = jwtTokenUtil.generateToken(authentication);
        return ResponseEntity.ok(new AuthToken(token));
    }

    // @RequestMapping(value="/register", method = RequestMethod.POST)
    @PostMapping("/register")
    public User saveUser(@RequestBody UserDto user){
        // prueba a lanzar excepción customizada
        // throw new EmailAlreadyExistsException("Email ocupado");
        List<Course> cursosTodosLista = courseRepository.findAll();
        Set<Course> cursosTodosSet = new HashSet<>(cursosTodosLista);
        user.setCursosSet(cursosTodosSet);
        return userService.save(user);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/hello-admin")
    public String adminPing(){
        return "Only Admins Can Read This";
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping("/hello-admin-user")
    public String adminUser(){
        return "Only Admins and Users Can Read This";
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/hello-user")
    public String userPing(){
        return "Any User Can Read This";
    }

    @GetMapping("/hola")
    public String welcome(){
        return "Bienvenido!!";
    }

    @PostMapping("/recibe")
    public String recibe(@RequestBody String entra){
        return "esto me ha llegado: " + entra;
    }

}
