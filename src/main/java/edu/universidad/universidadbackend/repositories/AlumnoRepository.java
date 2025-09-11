package edu.universidad.universidadbackend.repositories;

import edu.universidad.universidadbackend.model.entities.Persona;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;



//Extiende de PersonaRepository por der una clase hija de ella, heredando sus métodos como los de JpaRepository
@Repository//("repositorioAlumnos") //asi le cambio el nombre al Bean para que no se llame AlumnoRepository
public interface AlumnoRepository extends PersonaRepository {


                        /*BUSQUEDAS DE JPQL*/

    //Buscar alumnos por nombre de carrera (a travez de Query nativas)
    //Join fetch es por la carga peresosa
    @Query("select a from Alumno a join fetch a.carrera c where c.nombre = ?1")
    Iterable<Persona> findAlumnoByNombreCarrera(String nombre);
}
