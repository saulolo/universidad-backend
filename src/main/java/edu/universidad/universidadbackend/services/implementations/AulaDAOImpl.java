package edu.universidad.universidadbackend.services.implementations;

import edu.universidad.universidadbackend.entities.Aula;
import edu.universidad.universidadbackend.enums.Pizarron;
import edu.universidad.universidadbackend.repositories.AulaRepository;
import edu.universidad.universidadbackend.services.contracts.AulaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class AulaDAOImpl extends GenericDAOImpl<Aula, AulaRepository> implements AulaDAO {


    @Autowired
    public AulaDAOImpl(AulaRepository repository) {
        super(repository);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Aula> findAulaByTipoPizarron(Pizarron tipoPizarron) {
        return repository.findAulaByTipoPizarron(tipoPizarron);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Aula> findAulaByNombrePabellon(String pabellon) {
        return repository.findAulaByNombrePabellon(pabellon);
    }

    @Override
    @Transactional(readOnly = true)
    public Aula findAulaByNumero(int nroAula) {
        return repository.findAulaByNroAula(nroAula);
    }
}
