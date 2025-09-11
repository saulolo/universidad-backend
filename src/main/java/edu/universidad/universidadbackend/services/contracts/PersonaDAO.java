package edu.universidad.universidadbackend.services.contracts;

import edu.universidad.universidadbackend.model.entities.Persona;

import java.util.Optional;

public interface PersonaDAO extends GenericDAO<Persona>{

    //Hacemos un refactor ya que todos los metodos que heredan los hijos son de persona ne nustro generico DAO


    /*BUSQUEDAS DE JPQL*/

    //Buscar por nombre y apellido
    Optional<Persona> findByNombreYApellido(String nombre, String apellido);

    //Buscar por Dni
    Optional<Persona> findByDni(String dni);

    //Buscar personas por apellido
    Iterable<Persona> findPersonaByApellido(String apellido);
}


