package edu.universidad.universidadbackend.repositories;

import edu.universidad.universidadbackend.model.entities.Persona;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

//Extiende de PersonaRepository por ser una clase hija de ella, heredando sus métodos como los de JpaRepository
@Repository//("repositorioAlumnos") //asi le cambio el nombre al Bean para que no se llame AlumnoRepository
public interface AlumnoRepository extends PersonaRepository {

    /**
     * Busca una lista de alumnos por el nombre de la carrera a la que pertenecen.
     * <br>
     * Se utiliza una consulta JPQL con JOIN FETCH para traer la información de la carrera
     * en una sola consulta, optimizando el rendimiento.
     *
     * @param nombre El nombre de la carrera a buscar.
     * @return Un Iterable de objetos Persona que representan a los alumnos encontrados.
     */
    @Query("select a from Alumno a join fetch a.carrera c where c.nombre = ?1")
    Iterable<Persona> findAlumnoByNombreCarrera(String nombre);
}
