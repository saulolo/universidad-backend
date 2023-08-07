package edu.universidad.universidadbackend.repositories;

import edu.universidad.universidadbackend.entities.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

/*@NoRepositoryBean: con esta anotación evitamos que se genere una implementación concreta para esa interfaz en
particular y la utilizamos como una plantilla para operaciones comunes en repositorios más específicos.
Es una forma de reutilizar lógica de repositorio común sin crear un repositorio completo para esa interfaz base*/
//Esta anotación hace que no genere un bean de este repositorio, ya que Persona es una clase Abstracta,
// pero si permite inyectar los beans necesarios de las clases hijas
@NoRepositoryBean
public interface PersonaRepository extends JpaRepository<Persona, Long> {

}
