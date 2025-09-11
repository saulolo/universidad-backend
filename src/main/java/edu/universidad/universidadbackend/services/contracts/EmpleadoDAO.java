package edu.universidad.universidadbackend.services.contracts;

import edu.universidad.universidadbackend.model.entities.Persona;

public interface EmpleadoDAO extends PersonaDAO {


    Iterable<Persona> findEmpleadoByTipoEmpleado(String tipoEmpleado);

}
