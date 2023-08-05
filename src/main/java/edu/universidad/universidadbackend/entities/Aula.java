package edu.universidad.universidadbackend.entities;

import edu.universidad.universidadbackend.enums.Pizarron;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;


@Entity
@Table(name = "aulas")
public class Aula implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "aula_id")
    private Long id;

    @Column(name = "numero_aula", nullable = false)
    private Integer nroAula;

    @Column(name = "medidas_mtsxmts")
    private Integer medidas;

    @Column(name = "cantidad_pupitres")
    private Integer cantidadPupitres;

    @Column(name = "fecha_alta")
    private LocalDateTime fechaAlta;

    @Column(name = "fecha_modificacion")
    private LocalDateTime fechaModificacion;

    @Column(name = "tipo_pizarron")
    @Enumerated(EnumType.STRING) //Anotacion para poder persistir los Enums y se guardara como un string para que aparezca el texto
    private Pizarron pizarron;

    /*fetch = FetchType.LAZY ==> Si trabajamos con esta propiedad, no nos ocupa tanto espacio en memoria,
    pero me trae un error de serialización, el cual para ignorarlo debo de poner la siguiente anotación:
    @JsonProperty(access = Access.WRITE_ONLY)*/
    @ManyToOne(
            optional = true, //Indica que este atributo puede ser nulo, si fuera false, seria oblicatorio
            cascade = {
                    CascadeType.PERSIST, // si se crea una nueva instancia de Pabellon y se establece en el atributo pabellon de otra entidad, también se guardará la entidad referenciada si aún no existe en la base de datos.
                    CascadeType.MERGE //lo mismo que la porpiedad anterior pero aplica para la actualización
            }
    )
    @JoinColumn(
            name = "pabellon_id",
            foreignKey = @ForeignKey(name = "FK_PABELLON_ID")
    )
    private Pabellon pabellon;

    /*Cuando tengamos un atributo de @Onetone y pongamos el parametro a ese atributo de
    mappedBy = "[nombre de la otra entidad]" quiere decir que la otra entidad es la dueña de la relación:
    y si le ponemos el parámetro CascadeType.ALL esto nos va a permitir hacer el save completo de los objetos
    que si existe uno en un lado lo va a eliminar y lo va a persistir en caso de que no exista.*/



    public Aula() {
    }

    public Aula(Long id, Integer numero, Integer medidas, Integer cantidadPupitres, Pizarron pizarron, LocalDateTime fechaAlta, LocalDateTime fechaModificacion) {
        this.id = id;
        this.nroAula = nroAula;
        this.medidas = medidas;
        this.cantidadPupitres = cantidadPupitres;
        this.pizarron = pizarron;
        this.fechaAlta = fechaAlta;
        this.fechaModificacion = fechaModificacion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNroAula() {
        return nroAula;
    }

    public void setNroAula(Integer nroAula) {
        this.nroAula = nroAula;
    }

    public Integer getMedidas() {
        return medidas;
    }

    public void setMedidas(Integer medidas) {
        this.medidas = medidas;
    }

    public Integer getCantidadPupitres() {
        return cantidadPupitres;
    }

    public void setCantidadPupitres(Integer cantidadPupitres) {
        this.cantidadPupitres = cantidadPupitres;
    }

    public Pizarron getPizarron() {
        return pizarron;
    }

    public void setPizarron(Pizarron pizarron) {
        this.pizarron = pizarron;
    }

    public Pabellon getPabellon() {
        return pabellon;
    }

    public void setPabellon(Pabellon pabellon) {
        this.pabellon = pabellon;
    }

    @PrePersist //Anotación para indicar que este método se ejecuta antes de persistir a la BD
    private void antesDePersistir() {  //Metodo para indicar que antes de persistir genere la fecha con la actual
        this.fechaAlta = LocalDateTime.now();
    }


    @PreUpdate  //Anotación para indicar que este método se ejecuta antes de actualizar en la BD
    private void antesDelUpdate() {  //Metodo para indicar que antes de actualizar genere la fecha con la actual
        this.fechaModificacion = LocalDateTime.now();
    }


    @Override
    public String toString() {
        return "Aula{" +
                "id=" + id +
                ", numero=" + nroAula +
                ", medidas=" + medidas +
                ", cantidadPupitres=" + cantidadPupitres +
                ", pizarron=" + pizarron +
                ", fechaAlta=" + fechaAlta +
                ", fechaModificacion=" + fechaModificacion +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aula aula = (Aula) o;
        return Objects.equals(id, aula.id) && Objects.equals(nroAula, aula.nroAula);

    }
    @Override
    public int hashCode() {
        return Objects.hash(id, nroAula);
    }
}
