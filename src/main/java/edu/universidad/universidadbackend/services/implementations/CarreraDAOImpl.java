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
public class CarreraDAOImpl extends GenericDAOImpl <Carrera, CarreraRepository> implements CarreraDAO  {

    @Autowired
    public CarreraDAOImpl(CarreraRepository repository) {
        super(repository);  //implementamos lo metodos del constructor padre
    }



}
