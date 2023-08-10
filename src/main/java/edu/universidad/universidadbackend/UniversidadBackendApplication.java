package edu.universidad.universidadbackend;

import edu.universidad.universidadbackend.entities.Alumno;
import edu.universidad.universidadbackend.entities.Direccion;
import edu.universidad.universidadbackend.entities.Persona;
import edu.universidad.universidadbackend.services.contracts.AlumnoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class UniversidadBackendApplication {

/*	@Autowired
	private AlumnoDAO alumnoDAO;*/ //La comentamos porque ya vamos a relizar un CRUD a la BD

	//agregamos getBeanDefinitionNames nos retona un arreglo de beans definidos (Alumno, Empleado, etc)
	//esto para poder imprimir por consola los objetos creados
	public static void main(String[] args) {
		String[] beanDefinitionNames = SpringApplication.run(UniversidadBackendApplication.class, args).getBeanDefinitionNames();

		//Hacemos un for each para poder recorre cada uno de los Beans generados y asi imprimirlos por consola
/*		for (String str : beanDefinitionNames) {
			System.out.println(str);

		}*/
	}

	//Otro metodo para imprimir los Beans creados en la misma clase del main y no generar una clase
	// AlumnoComandos como lo hicimos con CarreraComanods
	/*@Bean
	public CommandLineRunner runner() {
		return args -> {
			//Para que no quede tan grande el constructor, genero una variable con direccion y la llamo en el constructor de alumno
*//*			Direccion direccion =  new Direccion("La Palma", "#98", "1221", "Antioquia", "1", "Belen");
			Persona alumno = new Alumno(null, "Alejandra", "Arenas", "43546678", direcciong);

			Persona save = alumnoDAO.save(alumno);
			System.out.println(save.toString());*//*

			//Método para ver por consola la persistencia de alumnos
*//*			List<Persona> alumnos = (List<Persona>) alumnoDAO.findAll();//Retorna un iterable según nuestro método
			alumnos.forEach(System.out::println); //asi imprimimos con expresión lambda*//*
		};
	}*///La comentamos porque ya vamos hacer un CRUD a BD

}
