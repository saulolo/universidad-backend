package edu.universidad.universidadbackend.services.contracts;

import edu.universidad.universidadbackend.entities.Persona;
import edu.universidad.universidadbackend.entities.Profesor;

public interface ProfesorDAO extends PersonaDAO {

    Iterable<Persona> findProfesoresByCarrera(String carrera);

}
