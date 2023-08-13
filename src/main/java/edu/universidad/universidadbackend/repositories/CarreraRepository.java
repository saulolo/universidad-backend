package edu.universidad.universidadbackend.repositories;

import edu.universidad.universidadbackend.entities.Carrera;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CarreraRepository extends JpaRepository<Carrera, Long> {

                        /*BUSQUEDAS DE UTILZANDO MÉTODOS*/

    //Buscar Carreras por nombre que contenga el string que le vammos a pasar (nombre)
    //@Query("select c from Carrera c where c.nombre like %?1%") ==> son equivalentes
    Iterable<Carrera> findCarrerasByNombreContains(String nombre);

    //Buscar Carreras por nombre que contenga el string que le vammos a pasar (nombre)
    //El mimso metodo que el anterior pero ignorando mayusculas y minusculas
    //@Query("select c from Carrera c where upper(c.nombre) like upper(%?1%)") ==> son equivalentes
    Iterable<Carrera> findCarrerasByNombreContainsIgnoreCase(String nombre);

    //Buscar carreras por cantidad de años que sean mayores a
    //@Query("select c from Carrera c where c.cantidadAnios > ?1") ==> son equivalentes
    Iterable<Carrera> findCarrerasByCantidadAniosAfter(Integer cantidadAnios);


    //Buscar Carrera por profesor por nombre y apellido
    @Query("select c from Carrera c where c.profesores = (select p from Profesor p where p.nombre = ?1 and p.apellido = ?2)")
    Iterable<Carrera> findCarrerasByProfesorNombreYApellido(String nombre, String apellido);


}