package edu.universidad.universidadbackend.data;

import edu.universidad.universidadbackend.entities.*;
import edu.universidad.universidadbackend.enums.TipoEmpleado;

import java.math.BigDecimal;

import static edu.universidad.universidadbackend.enums.TipoEmpleado.ADMINISTRATIVO;
import static edu.universidad.universidadbackend.enums.TipoEmpleado.MANTENIMIENTO;


public class DataDummy {

    public static Carrera carrera01() {
        return new Carrera(null, "Ingeniería de Software", 50,5);
    }


    public static Carrera carrera02() {
        return new Carrera(null, "ingeniería de Alimentos", 55,5);
    }


    public static Carrera carrera03() {
        return new Carrera(null, "Tecnología en Desarrollo de Software", 30,3);
    }


    public static Profesor profesor01() {
        return new Profesor(null, "Manolo", "Gaitan", "7098787", new Direccion(), new BigDecimal("100.000"));
    }

    public static Profesor profesor02() {
        return new Profesor(null, "Diego", "Perez", "7194287", new Direccion(), new BigDecimal("200.000"));
    }

    public static Profesor profesor03() {
        return new Profesor(null, "Leidy", "Zapata", "43987444", new Direccion(), new BigDecimal("450.000"));
    }


    public static Persona empleado01() {
        return new Empleado(null, "Felipe", "Vasquez", "71322675", new Direccion(), new BigDecimal( 1000000.70), ADMINISTRATIVO);
    }


    public static Persona empleado02() {
        return new Empleado(null, "Alejandra", "Arenas", "42322995", new Direccion(), new BigDecimal( 990000.70), MANTENIMIENTO);
    }


    public static Persona alumno01() {
        return new Alumno(null, "Jeronimo", "Duque", "100017553", new Direccion());
    }

    public static Persona alumno02() {
        return new Alumno(null, "Milena", "Mira", "2303144e53", new Direccion());
    }

    public static Persona alumno03() {
        return new Alumno(null, "Diego", "Duque", "198717553", new Direccion());
    }

    public static Persona alumno04() {
        return new Alumno();
    }



}
