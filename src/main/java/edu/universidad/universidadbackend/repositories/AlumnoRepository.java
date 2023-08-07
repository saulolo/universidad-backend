package edu.universidad.universidadbackend.repositories;

import org.springframework.stereotype.Repository;



//Extiende de PersonaRepository por der una clase hija de ella, heredando sus métodos como los de JpaRepository
@Repository//("repositorioAlumnos") //asi le cambio el nombre al Bean para que no se llame AlumnoRepository
public interface AlumnoRepository extends PersonaRepository {
}
