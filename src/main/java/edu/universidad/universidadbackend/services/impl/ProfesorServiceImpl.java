package edu.universidad.universidadbackend.services.impl;


import edu.universidad.universidadbackend.model.entities.Persona;
import edu.universidad.universidadbackend.repositories.PersonaRepository;
import edu.universidad.universidadbackend.repositories.ProfesorRepository;
import edu.universidad.universidadbackend.services.Interfaces.IProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


@Service
public class ProfesorServiceImpl extends PersonaServiceImpl implements IProfesorService {


    @Autowired
    public ProfesorServiceImpl(@Qualifier("profesorRepository") PersonaRepository repository) {
        super(repository);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Persona> findProfesoresByCarrera(String carrera) {
        return ((ProfesorRepository)repository).findProfesoresByCarrera(carrera);
    }
}
