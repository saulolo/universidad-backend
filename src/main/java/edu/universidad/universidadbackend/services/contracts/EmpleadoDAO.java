package edu.universidad.universidadbackend.services.contracts;

import edu.universidad.universidadbackend.entities.Persona;
import edu.universidad.universidadbackend.enums.TipoEmpleado;

public interface EmpleadoDAO extends PersonaDAO {


    Iterable<Persona> findEmpleadoByTipoEmpleado(String tipoEmpleado);

}
