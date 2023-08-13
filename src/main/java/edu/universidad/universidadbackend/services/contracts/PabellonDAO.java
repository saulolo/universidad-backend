package edu.universidad.universidadbackend.services.contracts;

import edu.universidad.universidadbackend.entities.Aula;
import edu.universidad.universidadbackend.entities.Pabellon;
import edu.universidad.universidadbackend.enums.Pizarron;
import org.springframework.data.jpa.repository.Query;

public interface PabellonDAO extends GenericDAO<Pabellon>{


    Iterable<Pabellon> findPabellonByLocalidad(String localidadPabellon);

    Iterable<Pabellon> findPabellonByNombre(String nombre);



}


