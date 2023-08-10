package edu.universidad.universidadbackend;


import edu.universidad.universidadbackend.entities.Carrera;
import edu.universidad.universidadbackend.services.contracts.CarreraDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Optional;

//Se creó esta clase para probar el service de Carrera ya que al momento no teniamos implementación web aún

/*La interfaz CommandLineRunner es parte del framework Spring Boot y se utiliza para ejecutar código específico
 al iniciar una aplicación Spring Boot desde la línea de comandos. Cuando una clase implementa la interfaz
 CommandLineRunner, debe proporcionar una implementación del método run. Para que funcione se debe de decorar
  con la anotación @Componet*/
@Component
public class CarreraComandos implements CommandLineRunner {

    @Autowired
    private CarreraDAO carreraDAO; //Inyecto el DAO
    @Override
    public void run(String... args) throws Exception { //Metodo para instanciar el objeto y probar
       /* Carrera IngSoftware = new Carrera(null, "Ingeniería de Software", 50, 5);
        Carrera IngAlimentos = new Carrera(null, "Ingeniería de Alimentos", 55, 5);
        Carrera saveSof = carreraDAO.save(IngSoftware);
        Carrera saveAlim = carreraDAO.save(IngAlimentos);
        System.out.println(saveSof.toString());
        System.out.println(saveAlim.toString());*/

        Optional<Carrera> oCarrera = carreraDAO.findById(1L); //oCarrera para identificar que es un optional
        if (oCarrera.isPresent()) {
            Carrera carrera = oCarrera.get();
            System.out.println(carrera.toString());
        } else {
            System.out.println("Carrera bi encontrada");
        }
    }
}
