package edu.universidad.universidadbackend.services.implementations;

import edu.universidad.universidadbackend.entities.Persona;
import edu.universidad.universidadbackend.repositories.EmpleadoRepository;
import edu.universidad.universidadbackend.repositories.PersonaRepository;
import edu.universidad.universidadbackend.services.contracts.EmpleadoDAO;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


@Service
public class EmpleadoDAOImpl extends PersonaDAOImpl implements EmpleadoDAO {


    public EmpleadoDAOImpl(@Qualifier("empleadoRepository") PersonaRepository repository) {
        super(repository);
    }

    @Override
    public Iterable<Persona> findEmpleadoByTipoEmpleado(String tipoEmpleado) {
        return ((EmpleadoRepository)repository).findEmpleadoByTipoEmpleado(tipoEmpleado);
    }
}
