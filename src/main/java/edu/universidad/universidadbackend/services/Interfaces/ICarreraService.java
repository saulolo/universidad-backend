package edu.universidad.universidadbackend.services.Interfaces;

import edu.universidad.universidadbackend.model.entities.Carrera;


//Extendemos los métodos de GenericDAD y le pasamos Carrera que es nuestra entidad que manejara dicho DAO generico
public interface ICarreraService extends IGenericService<Carrera> {


    /**
     * Busca una lista de carreras cuyo nombre contenga el string proporcionado.
     * <br>
     * La búsqueda es sensible a mayúsculas y minúsculas.
     *
     * @param nombre El nombre o parte del nombre de la carrera a buscar.
     * @return Un iterable de objetos Carrera que cumplen con el criterio.
     */
    Iterable<Carrera> findCarrerasByNombreContains(String nombre);

    /**
     * Busca una lista de carreras cuyo nombre contenga el string proporcionado, ignorando mayúsculas y minúsculas.
     *
     * @param nombre El nombre o parte del nombre de la carrera a buscar.
     * @return Un iterable de objetos Carrera que cumplen con el criterio.
     */
    Iterable<Carrera> findCarrerasByNombreContainsIgnoreCase(String nombre);

    /**
     * Busca una lista de carreras que tienen una cantidad de años mayor a la especificada.
     *
     * @param cantidadAnios La cantidad de años mínima para la búsqueda.
     * @return Un iterable de objetos Carrera que cumplen con el criterio.
     */
    Iterable<Carrera> findCarrerasByCantidadAniosAfter(Integer cantidadAnios);

    /**
     * Busca una lista de carreras asociadas a un profesor por su nombre y apellido.
     * <br>
     * Se utiliza una consulta JPQL personalizada para realizar un JOIN entre Carrera y Profesor.
     *
     * @param nombre El nombre del profesor.
     * @param apellido El apellido del profesor.
     * @return Un iterable de objetos Carrera asociados al profesor.
     */
    Iterable<Carrera> findCarrerasByProfesorNombreYApellido(String nombre, String apellido);





}
