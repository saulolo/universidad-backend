package edu.universidad.universidadbackend.services.impl;

import edu.universidad.universidadbackend.model.entities.Persona;
import edu.universidad.universidadbackend.repositories.AlumnoRepository;
import edu.universidad.universidadbackend.repositories.PersonaRepository;
import edu.universidad.universidadbackend.services.Interfaces.IAlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class AlumnoServiceImpl extends PersonaServiceImpl implements IAlumnoService {

    @Autowired
    public AlumnoServiceImpl(@Qualifier("alumnoRepository") PersonaRepository repository) { //@Qualifier("repositortioAlumnos"): asi lo hubiera inyectado si hubira renombrado mi ALumnoRopository
        super(repository);
    }

    /**
     * Busca una lista de alumnos por el nombre de la carrera a la que están matriculados.
     *
     * @param nombre El nombre de la carrera a buscar.
     * @return Un Iterable de objetos Persona que representan a los alumnos encontrados.
     */
    @Override
    public Iterable<Persona> findAlumnoByNombreCarrera(String nombre) {
        return ((AlumnoRepository)repository).findAlumnoByNombreCarrera(nombre);
    }
}
