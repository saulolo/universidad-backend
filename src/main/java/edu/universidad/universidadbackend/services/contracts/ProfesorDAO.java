package edu.universidad.universidadbackend.services.contracts;

import edu.universidad.universidadbackend.model.entities.Persona;

public interface ProfesorDAO extends PersonaDAO {

    Iterable<Persona> findProfesoresByCarrera(String carrera);

}
