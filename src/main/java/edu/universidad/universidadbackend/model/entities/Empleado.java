package edu.universidad.universidadbackend.model.entities;


import edu.universidad.universidadbackend.model.enums.TipoEmpleado;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "empleados")
@PrimaryKeyJoinColumn(name = "persona_id")   //Anotacineón para ponerle el nombre a la columna con la cual va a ser el join con la tabla
public class Empleado extends Persona {

    private BigDecimal sueldo; //BigDecimal se recomienda para el manejo de monedas con decimales

    @Column(name = "tipo_empleado")
    @Enumerated(EnumType.STRING)
    private TipoEmpleado tipoEmpleado;

    @OneToOne(
            optional = true,
            cascade = CascadeType.ALL //Cuando la relación es uno a uno se recomienda CascadeType.ALL
    )
    @JoinColumn(
            name = "pabellon_id",
            foreignKey = @ForeignKey(name = "fk_pabellon_id")
    )
    private Pabellon pabellon;


    public Empleado() {
    }

    public Empleado(Long id, String nombre, String apellido, String dni, Direccion direccion, BigDecimal sueldo, TipoEmpleado tipoEmpleado) {
        super(id, nombre, apellido, dni, direccion);
        this.sueldo = sueldo;
        this.tipoEmpleado = tipoEmpleado;
    }

    public BigDecimal getSueldo() {
        return sueldo;
    }

    public void setSueldo(BigDecimal sueldo) {
        this.sueldo = sueldo;
    }

    public TipoEmpleado getTipoEmpleado() {
        return tipoEmpleado;
    }

    public void setTipoEmpleado(TipoEmpleado tipoEmpleado) {
        this.tipoEmpleado = tipoEmpleado;
    }

    public Pabellon getPabellon() {
        return pabellon;
    }

    public void setPabellon(Pabellon pabellon) {
        this.pabellon = pabellon;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\tEmpleado{" +
                "sueldo=" + sueldo +
                ", tipoEmpleado=" + tipoEmpleado +
                ", pabellon=" + pabellon +
                '}';
    }
}

