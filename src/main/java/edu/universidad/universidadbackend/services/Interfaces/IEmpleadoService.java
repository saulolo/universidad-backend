package edu.universidad.universidadbackend.services.Interfaces;

import edu.universidad.universidadbackend.model.entities.Persona;

public interface IEmpleadoService extends IPersonaService {


    /**
     * Busca una lista de empleados por el tipo de empleado (e.g., Administrativo, Mantenimiento).
     *
     * @param tipoEmpleado El tipo de empleado a buscar.
     * @return Un Iterable de objetos Persona que representan a los empleados encontrados.
     */
    Iterable<Persona> findEmpleadoByTipoEmpleado(String tipoEmpleado);

}
