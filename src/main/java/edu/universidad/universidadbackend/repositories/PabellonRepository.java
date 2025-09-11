package edu.universidad.universidadbackend.repositories;

import edu.universidad.universidadbackend.model.entities.Pabellon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface PabellonRepository extends JpaRepository<Pabellon, Long> {

    //Buscar Pabellon por localidad
    @Query("select p from Pabellon p join fetch p.direccion d where d.localidad = ?1")
    Iterable<Pabellon> findPabellonByLocalidad(String localidadPabellon);

    //Buscar Pabellon por nombre
    @Query("select p from Pabellon p where p.nombre = ?1")
    Iterable<Pabellon> findPabellonByNombre(String nombre);


}
