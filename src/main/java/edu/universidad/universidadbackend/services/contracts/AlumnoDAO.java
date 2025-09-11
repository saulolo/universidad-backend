package edu.universidad.universidadbackend.services.contracts;

import edu.universidad.universidadbackend.model.entities.Persona;

public interface AlumnoDAO extends PersonaDAO {

    //Nota: Los metodos son de Persona porque Alumno hereda de Persona
    // por eso extendemos lo metodos de PersonaDAO, eso indica que herdaremos sun metodos para el CRUD

    Iterable<Persona> findAlumnoByNombreCarrera(String nombre);

}
