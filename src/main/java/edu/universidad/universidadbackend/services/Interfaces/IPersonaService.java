package edu.universidad.universidadbackend.services.Interfaces;

import edu.universidad.universidadbackend.model.entities.Persona;

import java.util.Optional;

public interface IPersonaService extends IGenericService<Persona> {

    //Hacemos un refactor ya que todos los metodos que heredan los hijos son de persona en nuestro IGeneric


    /**
     * Busca una persona por su nombre y apellido.
     *
     * @param nombre   El nombre de la persona.
     * @param apellido El apellido de la persona.
     * @return Un objeto Optional que puede contener la persona si se encuentra.
     */
    Optional<Persona> findByNombreYApellido(String nombre, String apellido);

    /**
     * Busca una persona por su número de DNI.
     *
     * @param dni El número de DNI de la persona.
     * @return Un objeto Optional que puede contener la persona si se encuentra.
     */
    Optional<Persona> findByDni(String dni);

    /**
     * Busca un listado de personas cuyo apellido coincida con el valor proporcionado.
     *
     * @param apellido El apellido o parte del apellido a buscar.
     * @return Un Iterable de objetos Persona que cumplen con el criterio.
     */
    Iterable<Persona> findPersonaByApellido(String apellido);
}


