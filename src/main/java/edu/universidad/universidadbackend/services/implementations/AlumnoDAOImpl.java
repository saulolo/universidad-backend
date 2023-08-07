package edu.universidad.universidadbackend.services.implementations;

import edu.universidad.universidadbackend.entities.Carrera;
import edu.universidad.universidadbackend.entities.Persona;
import edu.universidad.universidadbackend.repositories.AlumnoRepository;
import edu.universidad.universidadbackend.repositories.CarreraRepository;
import edu.universidad.universidadbackend.repositories.PersonaRepository;
import edu.universidad.universidadbackend.services.contracts.AlumnoDAO;
import edu.universidad.universidadbackend.services.contracts.CarreraDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Transactional
@Service
public class AlumnoDAOImpl implements AlumnoDAO {

    @Autowired   //@Qualifier("repositortioAlumnos"): asi lo hubiera inyectado si hubira renombrado mi ALumnoRopository
    private PersonaRepository personaRepository;

    @Override
    @Transactional(readOnly = true)
    public Iterable<Persona> findAll() {
        return personaRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Persona> findById(Long id) {
        return personaRepository.findById(id);
    }

    @Override
    @Transactional
    public Persona save(Persona persona) {
        return null;
    }

    @Override
    @Transactional
    public void deleteById(Long id) {

    }


}
