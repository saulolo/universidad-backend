package edu.universidad.universidadbackend.repositories;

import edu.universidad.universidadbackend.entities.Aula;
import edu.universidad.universidadbackend.entities.Pabellon;
import edu.universidad.universidadbackend.entities.Persona;
import edu.universidad.universidadbackend.enums.Pizarron;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface AulaRepository extends JpaRepository<Aula, Long> {


    
    //Buscar Aulas por tipo de pizarron
    @Query("select a from Aula a where a.pizarron = ?1")
    Iterable<Aula> findAulaByTipoPizarron(Pizarron tipoPizarron);

    //Buscar Aulas por nombre de pabellón
    @Query("select a from Aula a, Pabellon p where p.nombre = ?1 ")
    Iterable<Aula> findAulaByNombrePabellon(String pabellon);

    //Buscar Aula por numero de aula
    //@Query("select a from Aula a where a.nroAula = ?1")
    Aula findAulaByNumero(int nroAula);

}
