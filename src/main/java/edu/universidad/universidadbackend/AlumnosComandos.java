package edu.universidad.universidadbackend;

import edu.universidad.universidadbackend.entities.Alumno;
import edu.universidad.universidadbackend.entities.Carrera;
import edu.universidad.universidadbackend.entities.Persona;
import edu.universidad.universidadbackend.services.contracts.AlumnoDAO;
import edu.universidad.universidadbackend.services.contracts.CarreraDAO;
import edu.universidad.universidadbackend.services.contracts.PersonaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class AlumnosComandos implements CommandLineRunner {

    @Autowired
    @Qualifier("alumnoDAOImpl")
    private PersonaDAO personaDAO;

    @Autowired
    private CarreraDAO carreraDAO;
    @Override
    public void run(String... args) throws Exception {

/*        Optional<Carrera> ingSoftware = carreraDAO.findById(2L);

        //Asociando alumnos con las carreras
        Iterable<Persona> alumnos = personaDAO.findAll();
        alumnos.forEach(alumno -> ((Alumno)alumno).setCarrera(ingSoftware.get()));
        alumnos.forEach(alumno -> personaDAO.save(alumno));*/

        //Optional<Persona> alumno1 = personaDAO.findById(1L);

/*        Optional<Persona> personaNomApell = personaDAO.findByNombreYApellido(alumno1.get().getNombre(), alumno1.get().getApellido());
        System.out.println(personaNomApell.toString());

        Optional<Persona> personaDni = personaDAO.findByDni(alumno1.get().getDni());
        System.out.println(personaDni.toString());

        Iterable<Persona> personaApell = personaDAO.findPersonaByApellido(alumno1.get().getApellido());
        personaApell.forEach(System.out::println);*/

        Optional<Carrera> ingSoftware = carreraDAO.findById(2L);
        Iterable<Persona> alumnosCarrera = ((AlumnoDAO)personaDAO).findAlumnoByNombreCarrera(ingSoftware.get().getNombre());
        alumnosCarrera.forEach(System.out::println);








    }

}
