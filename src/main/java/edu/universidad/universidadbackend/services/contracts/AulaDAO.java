package edu.universidad.universidadbackend.services.contracts;

import edu.universidad.universidadbackend.model.entities.Aula;
import edu.universidad.universidadbackend.model.enums.Pizarron;

public interface AulaDAO extends GenericDAO<Aula>{



    Iterable<Aula> findAulaByTipoPizarron(Pizarron tipoPizarron);

    Iterable<Aula> findAulaByNombrePabellon(String pabellon);
    Aula findAulaByNumero(int nroAula);


}


