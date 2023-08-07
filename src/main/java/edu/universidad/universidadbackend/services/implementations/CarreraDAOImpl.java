package edu.universidad.universidadbackend.services.implementations;

import edu.universidad.universidadbackend.entities.Carrera;
import edu.universidad.universidadbackend.repositories.CarreraRepository;
import edu.universidad.universidadbackend.services.contracts.CarreraDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Transactional //Como este servicio trabaja con transacciones contra BD, debemos de decorarlos con esta anotación, y que derive de SpringFramework y no de jakarta
@Service
public class CarreraDAOImpl implements CarreraDAO  {  //Implementamos de CarreraDAO y hacemos Override de todos los métodos

    @Autowired
    private CarreraRepository carreraRepository;

    @Override
    @Transactional(readOnly = true) //Implementamos de CarreraDAO y hacemos Override de todos los métodos
    public Iterable<Carrera> findAll() { //Esto significa que el método solo leerá datos de la base de datos y no realizará ninguna operación de escritura o modificación de datos mejora el rendimiento de la BD
        return carreraRepository.findAll(); //Cambiamos el Optional.empty() para que extienda del carreraRepository
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Carrera> findById(Long id) {
        return carreraRepository.findById(id);
    }

    @Override
    @Transactional
    public Carrera save(Carrera carrera) {
        return carreraRepository.save(carrera); //lo mismo
    }

    @Override
    @Transactional
    public void deleteById(Long id) {

    }
}
