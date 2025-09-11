package edu.universidad.universidadbackend.repositories;

import edu.universidad.universidadbackend.model.entities.Persona;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfesorRepository extends PersonaRepository {


    //Buscar profesores por nombre de carrera (a travez de Query nativas)
    @Query("select p from Profesor p join fetch p.carreras c where c.nombre = ?1")
    Iterable<Persona> findProfesoresByCarrera(String carrera);

}
