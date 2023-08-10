package edu.universidad.universidadbackend.services.contracts;


import java.util.Optional;

//Generamos una entidad generica DAO para poner los métodos generales de los servicios
//le pasamos la E de entidad
public interface GenericDAO<E> {

    /*
    El patrón DAO: nos ayuda a separar la lógica de negocio de la lógica de acceso a datos, lo que facilita
    la mantenibilidad y la escalabilidad de la aplicación. Además, proporciona una abstracción que nos permite
    cambiar la capa de persistencia sin afectar el resto del código.

    Nota: Orden de generación: 1. se genera los Contracts/DAO, en este caso el CarreraDAO,AlumnoDAO, etc
    y por segundo se generan los implementations//DAOImpl, e neste caso CarreraDAOImpl,AlumnoDAOImpl, r
*/

    //En general, el uso de Optional es una buena práctica en Java para mejorar la legibilidad, evitar errores
    // de nulidad y fomentar el manejo adecuado de valores opcionales en el código.
    //Al usar Optional, se evita la necesidad de manejar explícitamente el valor nulo y se comunica de manera
    // más clara la posibilidad de que la entidad no exista.
    //El optional es un recurso que se pone en lod métodos para que si no encuentra lo que debe de retornar
    //el codigo no se reviente, se utiliza por si regresa algo o no regresa nada, en este caso me controla que
    // si no encuestra el id, no se reviente y me muestre un null
    /*Nota: Es importante tener en cuenta que al usar Optional, es responsabilidad del cliente del método
    verificar si la entidad existe o no y manejar el caso adecuadamente. Esto puede hacerse usando métodos
    proporcionados por Optional, como isPresent(), ifPresent(), o mediante el uso de orElse() o orElseGet()
    para proporcionar un valor predeterminado en caso de que la entidad no exista.*/


    //Simplicidad: El uso de Iterable permite obtener todas las entidades en una sola llamada al método
    // findAll(). No es necesario especificar un tipo concreto de colección, como List o Set; este método tambien
    // es beneficioso cuando se trata de grandes conjuntos de datos, ya que permite carga perezosa Lazy,
    // En resumen, el uso de Iterable<E> en findAll() brinda simplicidad, flexibilidad y posibilidades de
    // carga perezosa para manejar y procesar conjuntos de datos de manera eficiente.




    /* -- VER TODAS LAS CARRERAS -- */
    Iterable<E> findAll();


    /* -- VER CARRERAS POR ID -- */
    Optional<E> findById(Long id);


    /* -- GUARDAR CARRERAS -- */
    E save(E entidad);


    /* -- ELIMINAR CARRERAS POR ID -- */
    void deleteById(Long id);
}
