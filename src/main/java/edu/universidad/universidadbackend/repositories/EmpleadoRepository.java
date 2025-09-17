package edu.universidad.universidadbackend.repositories;

import edu.universidad.universidadbackend.model.entities.Persona;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadoRepository extends PersonaRepository {

    /**
     * Busca una lista de empleados por su tipo de empleado.
     *
     * @param tipoEmpleado El tipo de empleado a buscar (ej. ADMINISTRATIVO).
     * @return Un Iterable de objetos Persona que representan a los empleados encontrados.
     */
    @Query("select e from Empleado e where ?1 IN(e.tipoEmpleado)")
    Iterable<Persona> findEmpleadoByTipoEmpleado(String tipoEmpleado);
}
