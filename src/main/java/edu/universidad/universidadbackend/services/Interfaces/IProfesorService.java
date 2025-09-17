package edu.universidad.universidadbackend.services.Interfaces;

import edu.universidad.universidadbackend.model.entities.Persona;

public interface IProfesorService extends IPersonaService {

    /**
     * Busca una lista de profesores por el nombre de la carrera a la que están asociados.
     *
     * @param carrera El nombre de la carrera a buscar.
     * @return Un Iterable de objetos Persona que representan a los profesores encontrados.
     */
    Iterable<Persona> findProfesoresByCarrera(String carrera);

}
