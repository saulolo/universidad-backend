package edu.universidad.universidadbackend.services.implementations;


import edu.universidad.universidadbackend.entities.Persona;
import edu.universidad.universidadbackend.repositories.AlumnoRepository;
import edu.universidad.universidadbackend.repositories.PersonaRepository;
import edu.universidad.universidadbackend.services.contracts.AlumnoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;



@Service
public class AlumnoDAOImpl extends PersonaDAOImpl implements AlumnoDAO {

    @Autowired
    public AlumnoDAOImpl(@Qualifier("alumnoRepository") PersonaRepository repository) { //@Qualifier("repositortioAlumnos"): asi lo hubiera inyectado si hubira renombrado mi ALumnoRopository
        super(repository);
    }

    @Override
    public Iterable<Persona> findAlumnoByNombreCarrera(String nombre) {
        return ((AlumnoRepository)repository).findAlumnoByNombreCarrera(nombre);
    }
}
