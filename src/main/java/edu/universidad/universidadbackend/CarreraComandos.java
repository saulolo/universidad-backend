package edu.universidad.universidadbackend;


import edu.universidad.universidadbackend.entities.Carrera;
import edu.universidad.universidadbackend.services.contracts.CarreraDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
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
        //Instanciamos objetos de carreras
/*        Carrera IngSoftware = new Carrera(null, "Ingeniería de Software", 60, 5);
        Carrera IngAlimentos = new Carrera(null, "Ingeniería de Alimentos", 55, 5);
        Carrera IngIndustrial = new Carrera(null, "Ingeniería Industrial", 55, 5);
        Carrera IngElectronica = new Carrera(null, "Ingeniería Electrónica", 45, 5);
        Carrera licSistemas = new Carrera(null, "Licenciatura en Sistemas", 40, 4);
        Carrera licTurismo = new Carrera(null, "Licenciatura en Turismo", 42, 4);
        Carrera licYoga = new Carrera(null, "Licenciatura en Yoga", 25, 3);
        Carrera licRecursos = new Carrera(null, "Licenciatura en Recursos Humanos - RRHH", 33, 3);

        carreraDAO.save(IngSoftware);
        carreraDAO.save(IngAlimentos);
        carreraDAO.save(IngIndustrial);
        carreraDAO.save(IngElectronica);
        carreraDAO.save(licSistemas);
        carreraDAO.save(licTurismo);
        carreraDAO.save(licYoga);
        carreraDAO.save(licRecursos);*/


        //Método para listar carreras
         List<Carrera> carreraList = (List<Carrera>) carreraDAO.findCarrerasByNombreContains("Sistemas");
         carreraList.forEach(System.out::println);

        //Método para listar carreras por conincidencia y sin importar mayus o minus
         List<Carrera> carreraListUpper = (List<Carrera>) carreraDAO.findCarrerasByNombreContainsIgnoreCase("lic");
         carreraListUpper.forEach(System.out::println);

        //Método para listar carreras mayores a 4 años
         List<Carrera> carreraListByAnios = (List<Carrera>) carreraDAO.findCarrerasByCantidadAniosAfter(4);
         carreraListByAnios.forEach(System.out::println);



    }

}
