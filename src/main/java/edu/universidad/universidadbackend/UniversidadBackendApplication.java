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

@SpringBootApplication
public class UniversidadBackendApplication {

	@Autowired
	private AlumnoDAO alumnoDAO;

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
	@Bean
	public CommandLineRunner runner() {
		return args -> {
			//Para que no quede tan grande el constructor, genero una variable con direccion y la llamo en el constructor de alumno
			Direccion direccion =  new Direccion("Calle la jeta", "#65", "1455", "Antioquia", "2", "Calatrava");
			Persona alumno = new Alumno(null, "Saul", "Echeverri", "784357745", direccion);

			Persona save = alumnoDAO.save(alumno);
			System.out.println(save.toString());
		};
	}

}
