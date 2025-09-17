package edu.universidad.universidadbackend.services.Interfaces;

import edu.universidad.universidadbackend.model.entities.Aula;
import edu.universidad.universidadbackend.model.enums.Pizarron;

public interface IAulaService extends IGenericService<Aula> {



    Iterable<Aula> findAulaByTipoPizarron(Pizarron tipoPizarron);

    Iterable<Aula> findAulaByNombrePabellon(String pabellon);
    Aula findAulaByNumero(int nroAula);


}


