package edu.universidad.universidadbackend.services.Interfaces;

import edu.universidad.universidadbackend.model.entities.Pabellon;

public interface PabellonServiceI extends IGenericService<Pabellon> {


    Iterable<Pabellon> findPabellonByLocalidad(String localidadPabellon);

    Iterable<Pabellon> findPabellonByNombre(String nombre);



}


