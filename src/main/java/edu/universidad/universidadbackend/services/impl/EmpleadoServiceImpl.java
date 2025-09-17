package edu.universidad.universidadbackend.services.impl;

import edu.universidad.universidadbackend.model.entities.Persona;
import edu.universidad.universidadbackend.repositories.EmpleadoRepository;
import edu.universidad.universidadbackend.repositories.PersonaRepository;
import edu.universidad.universidadbackend.services.Interfaces.IEmpleadoService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


@Service
public class EmpleadoServiceImpl extends PersonaServiceImpl implements IEmpleadoService {


    public EmpleadoServiceImpl(@Qualifier("empleadoRepository") PersonaRepository repository) {
        super(repository);
    }

    @Override
    public Iterable<Persona> findEmpleadoByTipoEmpleado(String tipoEmpleado) {
        return ((EmpleadoRepository)repository).findEmpleadoByTipoEmpleado(tipoEmpleado);
    }
}
