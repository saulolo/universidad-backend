package edu.universidad.universidadbackend.repositories;

import edu.universidad.universidadbackend.entities.Carrera;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarreraRepository extends JpaRepository<Carrera, Long> {


}
