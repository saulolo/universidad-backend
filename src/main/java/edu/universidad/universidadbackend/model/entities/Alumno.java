package edu.universidad.universidadbackend.model.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "alumnos")
@PrimaryKeyJoinColumn(name = "persona_id")
public class Alumno extends Persona { //Le ponemos extends para indicar que esta clase va a heredar de la
    // clase Persona y la clase heredada no es necesario que la serialicemos



    @ManyToOne(optional = true, cascade =
            {CascadeType.PERSIST, CascadeType.MERGE},
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "carrera_id")
    private Carrera carrera;


    //Y para traer los atributos de la clase heredada (Persona) lo hago con los constrctores
    public Alumno() {
    }

    public Alumno(Long id, String nombre, String apellido, String dni, Direccion direccion) {
        super(id, nombre, apellido, dni, direccion);
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }


    @Override
    public String toString() {
        return super.toString() +
                "Alumno{}";
    }
}
