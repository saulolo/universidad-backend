package edu.universidad.universidadbackend.data;

import edu.universidad.universidadbackend.entities.Carrera;
import edu.universidad.universidadbackend.entities.Direccion;
import edu.universidad.universidadbackend.entities.Profesor;

import java.math.BigDecimal;


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


}
