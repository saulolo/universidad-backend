package edu.universidad.universidadbackend.services.impl;

import edu.universidad.universidadbackend.model.entities.Pabellon;
import edu.universidad.universidadbackend.repositories.PabellonRepository;
import edu.universidad.universidadbackend.services.Interfaces.PabellonServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class PabellonServiceImpl extends GenericServiceImpl<Pabellon, PabellonRepository> implements PabellonServiceI {


    @Autowired
    public PabellonServiceImpl(PabellonRepository repository) {
        super(repository);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Pabellon> findPabellonByLocalidad(String localidadPabellon) {
        return repository.findPabellonByLocalidad(localidadPabellon);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Pabellon> findPabellonByNombre(String nombre) {
        return repository.findPabellonByNombre(nombre);
    }
}
