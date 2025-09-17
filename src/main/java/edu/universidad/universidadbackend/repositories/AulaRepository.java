package edu.universidad.universidadbackend.repositories;

import edu.universidad.universidadbackend.model.entities.Aula;
import edu.universidad.universidadbackend.model.enums.Pizarron;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface AulaRepository extends JpaRepository<Aula, Long> {

    /**
     * Busca una lista de aulas por el tipo de pizarrón.
     *
     * @param tipoPizarron El tipo de pizarrón a buscar (ej. PIZARRA_BLANCA).
     * @return Un Iterable de objetos Aula que cumplen con el criterio.
     */
    @Query("select a from Aula a where a.pizarron = ?1")
    Iterable<Aula> findAulaByTipoPizarron(Pizarron tipoPizarron);

    /**
     * Busca una lista de aulas por el nombre del pabellón al que pertenecen.
     *
     * @param pabellon El nombre del pabellón.
     * @return Un Iterable de objetos Aula asociados al pabellón.
     */
    @Query("select a from Aula a, Pabellon p where p.nombre = ?1 ")
    Iterable<Aula> findAulaByNombrePabellon(String pabellon);


    //@Query("select a from Aula a where a.nroAula = ?1")
    /**
     * Busca un aula por su número de aula.
     *
     * @param nroAula El número de aula a buscar.
     * @return Un objeto Aula si se encuentra, de lo contrario, null.
     */
    Aula findAulaByNroAula(Integer nroAula);

}
