package edu.universidad.universidadbackend.services.implementations;

import edu.universidad.universidadbackend.model.entities.Pabellon;
import edu.universidad.universidadbackend.repositories.PabellonRepository;
import edu.universidad.universidadbackend.services.contracts.PabellonDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class PabellonDAOImpl extends GenericDAOImpl <Pabellon, PabellonRepository> implements PabellonDAO {


    @Autowired
    public PabellonDAOImpl(PabellonRepository repository) {
        super(repository);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Pabellon> findPabellonByLocalidad(String localidadPabellon) {
        return repository.findPabellonByLocalidad(localidadPabellon);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Pabellon> findPabellonByNombre(String nombre) {
        return repository.findPabellonByNombre(nombre);
    }
}
