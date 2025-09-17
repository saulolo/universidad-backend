package edu.universidad.universidadbackend.services.impl;

import edu.universidad.universidadbackend.model.entities.Persona;
import edu.universidad.universidadbackend.repositories.PersonaRepository;
import edu.universidad.universidadbackend.services.Interfaces.IPersonaService;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public class PersonaServiceImpl extends GenericServiceImpl<Persona, PersonaRepository> implements IPersonaService {


    public PersonaServiceImpl(PersonaRepository repository) {
        super(repository);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<Persona> findByNombreYApellido(String nombre, String apellido) {
        return repository.findByNombreYApellido(nombre, apellido);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<Persona> findByDni(String dni) {
        return repository.findByDni(dni);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public Iterable<Persona> findPersonaByApellido(String apellido) {
        return repository.findPersonaByApellido(apellido);
    }
}
