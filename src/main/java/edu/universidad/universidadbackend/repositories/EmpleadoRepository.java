package edu.universidad.universidadbackend.repositories;

import edu.universidad.universidadbackend.model.entities.Persona;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadoRepository extends PersonaRepository {



    //Buscar Empleado por tipo de empleado
    @Query("select e from Empleado e where ?1 IN(e.tipoEmpleado)")
    Iterable<Persona> findEmpleadoByTipoEmpleado(String tipoEmpleado);
}
