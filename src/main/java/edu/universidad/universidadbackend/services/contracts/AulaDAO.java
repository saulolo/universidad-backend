package edu.universidad.universidadbackend.services.contracts;

import edu.universidad.universidadbackend.entities.Aula;
import edu.universidad.universidadbackend.entities.Persona;
import edu.universidad.universidadbackend.enums.Pizarron;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface AulaDAO extends GenericDAO<Aula>{



    Iterable<Aula> findAulaByTipoPizarron(Pizarron tipoPizarron);

    Iterable<Aula> findAulaByNombrePabellon(String pabellon);
    Aula findAulaByNumero(int nroAula);


}


