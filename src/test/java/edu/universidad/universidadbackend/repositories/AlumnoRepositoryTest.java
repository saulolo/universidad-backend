package edu.universidad.universidadbackend.repositories;

import edu.universidad.universidadbackend.data.DataDummy;
import edu.universidad.universidadbackend.entities.Alumno;
import edu.universidad.universidadbackend.entities.Carrera;
import edu.universidad.universidadbackend.entities.Persona;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;



@DataJpaTest
class AlumnoRepositoryTest {


    @Autowired
    PersonaRepository alumnoRepository;

    @Autowired
    CarreraRepository carreraRepository;


    @Test
    @DisplayName("Probando el método de buscar alumnos por Nombre de carrera")
    void findAlumnoByNombreCarrera() {

        //Given
        Iterable<Persona> personas = alumnoRepository.saveAll(
                Arrays.asList(
                        DataDummy.alumno01(),
                        DataDummy.alumno02(),
                        DataDummy.alumno03()
                )
        );

        Carrera save = carreraRepository.save(DataDummy.carrera01());

        personas.forEach(alumno ->((Alumno)alumno).setCarrera(save));

        alumnoRepository.saveAll(personas);

        //When
        String carreraNombre = "Ingeniería de Software";
        List<Persona> expected = (List<Persona>) ((AlumnoRepository)alumnoRepository).findAlumnoByNombreCarrera(carreraNombre);

        //Then
        assertThat(expected.size() == 3).isTrue(); //para comprobar que la la extenxión de la lista sea 3
        assertThat(expected.isEmpty()).isFalse(); // para comprobar que no este vacia (que no encuentre elementos)

    }


    @Test
    @DisplayName("Probando el método de buscar alumnos por Nombre de carrera sin valores")
    void findAlumnoByNombreCarreraSinValores() {

        //Given
        Iterable<Persona> personas = alumnoRepository.saveAll(
                Arrays.asList(
                        DataDummy.alumno01(),
                        DataDummy.alumno02(),
                        DataDummy.alumno03()
                )
        );

        Carrera save = carreraRepository.save(DataDummy.carrera01());

        personas.forEach(alumno ->((Alumno)alumno).setCarrera(save));

        alumnoRepository.saveAll(personas);

        //When
        String carreraNombre = "ingeniería de Alimentos";
        List<Persona> expected = (List<Persona>) ((AlumnoRepository)alumnoRepository).findAlumnoByNombreCarrera(carreraNombre);

        //Then
        assertThat(expected.isEmpty()).isTrue(); // para comprobar que la lista este vacia

    }


}