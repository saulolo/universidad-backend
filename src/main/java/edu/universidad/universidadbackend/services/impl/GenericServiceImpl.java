package edu.universidad.universidadbackend.services.impl;

import edu.universidad.universidadbackend.services.Interfaces.IGenericService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

//Hacemos una clase generica GenericServiceImpl que resivira por parámetros la entidad E y R de JpaRepository
//ese asu vez resibira la entidad E como parametro y su tipo de varibla de Id
public class GenericServiceImpl<E, R extends JpaRepository<E, Long>> implements IGenericService<E> {

    //generamos un tipo de variable protected ya que puede ser utilizado a travez de herencia sin necesidad
    // de acceder a su getter, lo declaramos final para que lo podamos instanciar através del constructor
    //y del tipo repository R y generamos su constructor
    protected final R repository;

    public GenericServiceImpl(R repository) {
        this.repository = repository;
    }


    //Establecemos los métodos genericos los cuales generaran nuestros hijos DAOIml
    /**
     * {@inheritDoc}
     */
    @Override                     //Implementamos de ICarreraService y hacemos Override de todos los métodos
    @Transactional(readOnly = true)  //Esto significa que el métod solo leerá datos de la base de datos y no realizará ninguna operación de escritura o modificación de datos mejora el rendimiento de la BD
    public Iterable<E> findAll() {
        return repository.findAll();   //Cambiamos el Optional.empty() para que extienda del repository
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<E> findById(Long id) {
        return repository.findById(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public E save(E entidad) {
        return repository.save(entidad);
    }

    /**
     *{@inheritDoc}
     */
    @Override
    @Transactional
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
