package edu.universidad.universidadbackend.model.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "pabellones")
public class Pabellon implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pabellon_id")
    private Long id;

    @Column(name = "metros_cuadrado")
    private Integer mt2;

    @Column(name = "nombre_pabellon", unique = true, nullable = false)
    private String nombre;

    @Embedded //Anotacón que me indica que este atributo es un embebido (pertenece a una clase que no es una entidad)
    @AttributeOverrides({ //Para customizar los atributos, para que los nombres de los atributos de mi entidad Direccion:
            @AttributeOverride(name = "codigoPostal", column = @Column(name = "codigo_postal")), //se llamen de otra manera
            @AttributeOverride(name = "dpto", column = @Column(name = "departamento"))
    })
    private Direccion direccion;

    @Column(name = "fecha_alta")
    private LocalDateTime fechaAlta;

    @Column(name = "fecha_modificacion")
    private LocalDateTime fechaModificacion;

    /*fetch = FetchType.LAZY ==> Si trabajamos con esta propiedad, no nos ocupa tanto espacio en memoria,
    pero me trae un error de serialización, el cual para ignorarlo debo de poner la siguiente anotación:
    @JsonProperty(access = Access.WRITE_ONLY)*/
    @OneToMany(
            mappedBy = "pabellon",
            fetch = FetchType.LAZY  //Cuando la relación sea OneToMany se recomienda poner FetchType.LAZY para no tener tanta demanda a la BD
    )
    private Set<Aula> aulas;  //Nos permiote tener un unico objeto de la colección Set, no permite que dos objetos aulas esten duplicados, en cambio list si



    public Pabellon() {
    }

    public Pabellon(Long id, Integer mt2, String nombre, Direccion direccion) {
        this.id = id;
        this.mt2 = mt2;
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getMt2() {
        return mt2;
    }

    public void setMt2(Integer mt2) {
        this.mt2 = mt2;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public LocalDateTime getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(LocalDateTime fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public LocalDateTime getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(LocalDateTime fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public Set<Aula> getAulas() {
        return aulas;
    }

    public void setAulas(Set<Aula> aulas) {
        this.aulas = aulas;
    }


    @PrePersist
    private void antesDePersistir() {  //Metodo para indicar que antes de persistir genere la fecha con la actual
        this.fechaAlta = LocalDateTime.now();
    }

    @PreUpdate
    private void antesDelUpdate() {  //Metodo para indicar que antes de actualizar genere la fecha con la actual
        this.fechaModificacion = LocalDateTime.now();
    }



    @Override
    public String toString() {
        return "Pabellon{" +
                "id=" + id +
                ", mt2=" + mt2 +
                ", nombre='" + nombre + '\'' +
                ", direccion=" + direccion +
                ", fechaAlta=" + fechaAlta +
                ", fechaUltimaModificacion=" + fechaModificacion +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pabellon pabellon = (Pabellon) o;
        return Objects.equals(id, pabellon.id) && Objects.equals(nombre, pabellon.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre);
    }
}
