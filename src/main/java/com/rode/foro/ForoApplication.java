package com.rode.foro;

import com.rode.foro.model.Prueba;
import com.rode.foro.model.User;
import com.rode.foro.model.type.Rol;
import com.rode.foro.repositories.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.rode.foro.repositories.PruebaRepository;

import java.io.*;
import java.util.ArrayList;


@SpringBootApplication
public class ForoApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(ForoApplication.class, args);
		UserRepository userRepository = context.getBean(UserRepository.class);
		User user = new User(null, "Primer usuario", "ejemplo@gmail.com", "1234", Rol.user, "www.google.com");
		userRepository.save(user);

		PruebaRepository pruebaRepository =  context.getBean(PruebaRepository.class);
		Prueba prueba = new Prueba(null, "a ver si sale esto");
		pruebaRepository.save(prueba);

		ArrayList usuarios = new ArrayList();


		String nombreFichero = "src" + File.separator + "main" + File.separator + "java" + File.separator + "fichero.txt";
		//Declarar una variable BufferedReader
		BufferedReader br = null;
		try {
			//Crear un objeto BufferedReader al que se le pasa
			//   un objeto FileReader con el nombre del fichero
			br = new BufferedReader(new FileReader(nombreFichero));
			//Leer la primera línea, guardando en un String
			String texto = br.readLine();
			//Repetir mientras no se llegue al final del fichero
			while (texto != null) {
				//Hacer lo que sea con la línea leída
				usuarios.add(texto);
				//System.out.println(texto);

				//Leer la siguiente línea
				texto = br.readLine();
			}
		} catch (FileNotFoundException e) {
			System.out.println("Error: Fichero no encontrado");
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println("Error de lectura del fichero");
			System.out.println(e.getMessage());
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (Exception e) {
				System.out.println("Error al cerrar el fichero");
				System.out.println(e.getMessage());
			}
		}

		System.out.println(usuarios);

		for (int i=0; i<usuarios.size(); i++){

				for (int j=0; j<usuarios.size(); j++){
					if(i != j) {
						String temp1 = (String) usuarios.get(i);
						String temp2 = (String) usuarios.get(j);
						if(temp1.equals(temp2)){
							System.err.println("1) Las siguientes lineas estan duplicadas " + i + " y " + j);
						}
					}
			}
		}



		System.out.println(" 3) Se han procesado: " + usuarios.size() + " lineas");

		register("oscar@gmail.com", "1234");
		register("osca2r@gmail.com", "1234");
		System.out.println("Login con exito: " + login("oscar@gmail.com", "1234"));
		System.out.println("Login fallo email: " + login("pepe@gmail.com", "1234"));
		System.out.println("Login fallo password: " + login("oscar@gmail.com", "123499"));





	}





	static	ArrayList users = new ArrayList();

	public static int login(String email, String password){
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

		int resultado=0;
		boolean existeCorreo=false;
		boolean passwordCorrecto=false;

		if(!users.isEmpty()){
			for(int i=0; i < users.size(); i++){
				String [] SacarusuarioDelArray = (String[]) users.get(i);
				String correoComprobar = SacarusuarioDelArray[0];
				String passwordComprobar = SacarusuarioDelArray[1];
				if(correoComprobar == email){
					existeCorreo=true;
					if (passwordEncoder.matches(password, passwordComprobar)){
						passwordCorrecto = true;
						resultado= 1;
					}
				}

			}
			if(!existeCorreo){ resultado = -1; }
			if(existeCorreo && !passwordCorrecto){ resultado = -2;}
		}else{resultado=-1;};


		return resultado;
	}

	public static boolean register(String email, String password){
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

		String [] unUsuarioNuevo = {email, password};
		boolean repetido=false;

		if(!users.isEmpty()){

			for(int i=0; i < users.size(); i++){
				String [] SacarusuarioDelArray = (String[]) users.get(i);
				String correoComprobar = SacarusuarioDelArray[0];


				if ( correoComprobar.equals(unUsuarioNuevo[0])  ) {
					repetido = true;
				}
			}
		}



		if(repetido == false){
			unUsuarioNuevo[1] = passwordEncoder.encode(unUsuarioNuevo[1]);
			users.add(unUsuarioNuevo);
			System.out.println("El usuario ha sido registrado correctamente");
			for(int i=0; i < users.size(); i++){
				System.out.println("lista: " + ((String[]) users.get(i))[0] +"  " + ((String[]) users.get(i))[1] );
			}
			return true;
		}else{
			System.out.println("El usuario ya existe");
			return false;
		}


	}


}
