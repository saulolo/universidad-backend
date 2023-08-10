package edu.universidad.universidadbackend.services.contracts;

public interface AlumnoDAO extends PersonaDAO {

    //Nota: Los metodos son de Persona porque Alumno hereda de Persona
    // por eso extendemos lo metodos de PersonaDAO, eso indica que herdaremos sun metodos para el CRUD

}
