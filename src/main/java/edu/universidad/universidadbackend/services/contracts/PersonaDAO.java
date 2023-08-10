package edu.universidad.universidadbackend.services.contracts;

import edu.universidad.universidadbackend.entities.Persona;

import java.util.Optional;

public interface PersonaDAO {

    //Hacemos un refactor ya que todos los metodos que herean los hijos son de persona

    /* -- VER TODAS LAS PERSONAS -- */
    Iterable<Persona> findAll();


    /* -- VER PERSONA POR ID -- */
    Optional<Persona> findById(Long id);


    /* -- GUARDAR PERSONA -- */
    Persona save(Persona persona);


    /* -- ELIMINAR PERSONA POR ID -- */
    void deleteById(Long id);



}
