package edu.universidad.universidadbackend.repositories;

import edu.universidad.universidadbackend.model.entities.Pabellon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface PabellonRepository extends JpaRepository<Pabellon, Long> {

    /**
     * Busca una lista de pabellones por la localidad de su dirección.
     *
     * @param localidadPabellon La localidad a buscar.
     * @return Un Iterable de objetos Pabellon que cumplen con el criterio.
     */
    @Query("select p from Pabellon p join fetch p.direccion d where d.localidad = ?1")
    Iterable<Pabellon> findPabellonByLocalidad(String localidadPabellon);

    /**
     * Busca un pabellón por su nombre.
     *
     * @param nombre El nombre del pabellón a buscar.
     * @return Un Iterable de objetos Pabellon si se encuentra.
     */
    @Query("select p from Pabellon p where p.nombre = ?1")
    Iterable<Pabellon> findPabellonByNombre(String nombre);
}
