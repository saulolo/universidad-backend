package edu.universidad.universidadbackend.repositories;

import edu.universidad.universidadbackend.model.entities.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Optional;

/*@NoRepositoryBean: con esta anotación evitamos que se genere una implementación concreta para esa interfaz en
particular y la utilizamos como una plantilla para operaciones comunes en repositorios más específicos.
Es una forma de reutilizar lógica de repositorio común sin crear un repositorio completo para esa interfaz base*/
//Esta anotación hace que no genere un bean de este repositorio, ya que Persona es una clase Abstracta,
// pero si permite inyectar los beans necesarios de las clases hijas
@NoRepositoryBean
public interface PersonaRepository extends JpaRepository<Persona, Long> {

                            /*BUSQUEDAS DE JPQL*/

    //Buscar por nombre y apellido (a travez de Query nativas)
    @Query("select p from Persona p where p.nombre = ?1 and p.apellido = ?2")
    Optional<Persona> findByNombreYApellido(String nombre, String apellido);

    //Buscar por Dni (a travez de Query nativas)
    @Query("select p from Persona p where p.dni = ?1")
    Optional<Persona> findByDni(String dni);

    //Buscar personas por apellido  //like % (es para que encuentre las coincidencias) (a travez de Query nativas)
    @Query("select p from Persona p where p.apellido like %?1%")
    Iterable<Persona> findPersonaByApellido(String apellido);
}
