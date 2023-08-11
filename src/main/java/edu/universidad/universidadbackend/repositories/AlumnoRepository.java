package edu.universidad.universidadbackend.repositories;

import edu.universidad.universidadbackend.entities.Persona;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;



//Extiende de PersonaRepository por der una clase hija de ella, heredando sus métodos como los de JpaRepository
@Repository//("repositorioAlumnos") //asi le cambio el nombre al Bean para que no se llame AlumnoRepository
public interface AlumnoRepository extends PersonaRepository {


    //Buscar alumnos por nombre de carrera
    @Query("select a from Persona a where a.carrera.nombre = ?1")
    Iterable<Persona> findAlumnoByNombreCarrera(String nombre);

}
