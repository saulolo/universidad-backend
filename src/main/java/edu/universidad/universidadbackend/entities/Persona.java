package edu.universidad.universidadbackend.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;



/*SINGLE.TABLE: una única tabla con todos los atributos de nuestras clases hijas, tiene mejor rendimiento ya
que esta en una tabla lo único malo es que los atributos de las clases hijas tienen que permitir valores nulos
y si tenemos esas restricciones entonces no la podemos utilizar
JOINED: Genera una tabla con los datos comunes, o sea que por cada clase hija, genera una tabla distinta, la ventaja
es que es mas normalizado y es mas flexible, la desventaja es que para hacer una consulta debemos de hacer un join
con nuestra tabla padre.
TABLE_PER_CLASS: presenta redundancia de datos, por lo tanto se desaconceja, se duplican los datos
*/

@Entity
@Table(name = "personas")
@Inheritance(strategy = InheritanceType.JOINED)//Anotación para hacer la persistencia a través de las clases de herencia
public abstract class Persona implements Serializable { //Al agregar la palabra abstract quiere decir que no podemos instanciar
    // objetos de la clase Persona pero si de sus derivados y sus clases derivadss deben de incluir
    // en su denominación la palabra extends y la clase heredada no es necesario que la serialicemos
    //Para traer los atributos en la otra clase, de la clase heredada  lo hago con los constructores

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "persona_id")
    private Long id;
    @Column(name = "nombre", nullable = false, length = 60)
    private String nombre;

    @Column(name = "apellido", nullable = false, length = 60)
    private String apellido;

    @Column(name = "dni", nullable = false,unique = true, length = 10)
    private String dni;

    @Column(name = "fecha_alta")
    private LocalDateTime fechaAlta;
    @Column(name = "fecha_modificacion")
    private LocalDateTime fechaModificacion;


    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "codigoPostal", column = @Column(name = "codigo_postal")),
            @AttributeOverride(name = "dpto", column = @Column(name = "departamento"))
    })
    private Direccion direccion;


    public Persona() {
    }

    //Se genera constructor sin tomar las fechas
    public Persona(Long id, String nombre, String apellido, String dni, Direccion direccion) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.direccion = direccion;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
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

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
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
        return "Persona{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", dni='" + dni + '\'' +
                ", fechaAlta=" + fechaAlta +
                ", fechaModificacion=" + fechaModificacion +
                ", direccion=" + direccion +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Persona persona = (Persona) o;
        return Objects.equals(id, persona.id) && Objects.equals(dni, persona.dni);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dni);
    }
}

