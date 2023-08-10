package edu.universidad.universidadbackend.services.implementations;


import edu.universidad.universidadbackend.entities.Persona;
import edu.universidad.universidadbackend.repositories.PersonaRepository;
import edu.universidad.universidadbackend.services.contracts.AlumnoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Service
public class AlumnoDAOImpl extends GenericDAOImpl<Persona, PersonaRepository > implements AlumnoDAO {

    @Autowired
    public AlumnoDAOImpl(PersonaRepository repository) { //@Qualifier("repositortioAlumnos"): asi lo hubiera inyectado si hubira renombrado mi ALumnoRopository
        super(repository);
    }
}
