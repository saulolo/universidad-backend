package edu.universidad.universidadbackend.services.implementations;

import edu.universidad.universidadbackend.entities.Persona;
import edu.universidad.universidadbackend.repositories.PersonaRepository;
import edu.universidad.universidadbackend.services.contracts.PersonaDAO;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public class PersonaDAOImpl extends GenericDAOImpl <Persona, PersonaRepository> implements PersonaDAO {


    public PersonaDAOImpl(PersonaRepository repository) {
        super(repository);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Persona> findByNombreYApellido(String nombre, String apellido) {
        return repository.findByNombreYApellido(nombre, apellido);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Persona> findByDni(String dni) {
        return repository.findByDni(dni);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Persona> findPersonaByApellido(String apellido) {
        return repository.findPersonaByApellido(apellido);
    }
}
