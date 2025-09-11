package edu.universidad.universidadbackend.services.implementations;


import edu.universidad.universidadbackend.model.entities.Persona;
import edu.universidad.universidadbackend.repositories.PersonaRepository;
import edu.universidad.universidadbackend.repositories.ProfesorRepository;
import edu.universidad.universidadbackend.services.contracts.ProfesorDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


@Service
public class ProfesorDAOImpl extends PersonaDAOImpl implements ProfesorDAO {


    @Autowired
    public ProfesorDAOImpl(@Qualifier("profesorRepository") PersonaRepository repository) {
        super(repository);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Persona> findProfesoresByCarrera(String carrera) {
        return ((ProfesorRepository)repository).findProfesoresByCarrera(carrera);
    }
}
