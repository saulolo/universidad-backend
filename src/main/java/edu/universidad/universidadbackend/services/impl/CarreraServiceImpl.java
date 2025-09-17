package edu.universidad.universidadbackend.services.impl;

import edu.universidad.universidadbackend.model.entities.Carrera;
import edu.universidad.universidadbackend.repositories.CarreraRepository;
import edu.universidad.universidadbackend.services.Interfaces.ICarreraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Transactional //Como este servicio trabaja con transacciones contra BD, debemos de decorarlos con esta anotación, y que derive de SpringFramework y no de jakarta
@Service
public class CarreraServiceImpl extends GenericServiceImpl<Carrera, CarreraRepository> implements ICarreraService {

    @Autowired
    public CarreraServiceImpl(CarreraRepository repository) {
        super(repository);  //implementamos lo metodos del constructor padre
    }


    @Override
    @Transactional(readOnly = true)
    public Iterable<Carrera> findCarrerasByNombreContains(String nombre) {
        return repository.findCarrerasByNombreContains(nombre);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Carrera> findCarrerasByNombreContainsIgnoreCase(String nombre) {
        return repository.findCarrerasByNombreContainsIgnoreCase(nombre);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Carrera> findCarrerasByCantidadAniosAfter(Integer cantidadAnios) {
        return repository.findCarrerasByCantidadAniosAfter(cantidadAnios);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Carrera> findCarrerasByProfesorNombreYApellido(String nombre, String apellido) {
        return repository.findCarrerasByProfesorNombreYApellido(nombre, apellido);
    }
}
