package edu.universidad.universidadbackend.services.contracts;

import edu.universidad.universidadbackend.model.entities.Pabellon;

public interface PabellonDAO extends GenericDAO<Pabellon>{


    Iterable<Pabellon> findPabellonByLocalidad(String localidadPabellon);

    Iterable<Pabellon> findPabellonByNombre(String nombre);



}


