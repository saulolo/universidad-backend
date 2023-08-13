package edu.universidad.universidadbackend.services.contracts;

import edu.universidad.universidadbackend.entities.Carrera;

import java.util.Optional;


//Extendemos los métodos de GenericDAD y le pasamos Carrera que es nuestra entidad que manejara dicho DAO generico
public interface CarreraDAO extends GenericDAO<Carrera>{


    Iterable<Carrera> findCarrerasByNombreContains(String nombre);

    Iterable<Carrera> findCarrerasByNombreContainsIgnoreCase(String nombre);

    Iterable<Carrera> findCarrerasByCantidadAniosAfter(Integer cantidadAnios);

    Iterable<Carrera> findCarrerasByProfesorNombreYApellido(String nombre, String apellido);





}
