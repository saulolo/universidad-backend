package edu.universidad.universidadbackend.services.impl;

import edu.universidad.universidadbackend.model.entities.Aula;
import edu.universidad.universidadbackend.model.enums.Pizarron;
import edu.universidad.universidadbackend.repositories.AulaRepository;
import edu.universidad.universidadbackend.services.Interfaces.IAulaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class AulaServiceImpl extends GenericServiceImpl<Aula, AulaRepository> implements IAulaService {


    @Autowired
    public AulaServiceImpl(AulaRepository repository) {
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
