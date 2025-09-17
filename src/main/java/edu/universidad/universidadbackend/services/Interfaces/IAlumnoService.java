package edu.universidad.universidadbackend.services.Interfaces;

import edu.universidad.universidadbackend.model.entities.Persona;

public interface IAlumnoService extends IPersonaService {

    //Nota: Los metodos son de Persona porque Alumno hereda de Persona
    // por eso extendemos lo metodos de IPersonaService, eso indica que herdaremos sun metodos para el CRUD

    /**
     * Busca una lista de alumnos por el nombre de la carrera a la que están matriculados.
     *
     * @param nombre El nombre de la carrera a buscar.
     * @return Un Iterable de objetos Persona que representan a los alumnos encontrados.
     */
    Iterable<Persona> findAlumnoByNombreCarrera(String nombre);

}
