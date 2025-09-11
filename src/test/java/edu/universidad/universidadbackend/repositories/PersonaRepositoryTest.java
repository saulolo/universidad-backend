package edu.universidad.universidadbackend.repositories;

import edu.universidad.universidadbackend.data.DataDummy;
import edu.universidad.universidadbackend.model.entities.Empleado;
import edu.universidad.universidadbackend.model.entities.Persona;
import edu.universidad.universidadbackend.model.entities.Profesor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@DataJpaTest
class PersonaRepositoryTest {


    //Se nombran segun sus repsoitorios heredados
    @Autowired
    PersonaRepository alumnoRepository;

    @Autowired
    PersonaRepository empleadoRepository;

    @Autowired
    PersonaRepository profesorRepository;



    @Test
    @DisplayName("Probando el método de Buscar por nombre y apellido")
    void findByNombreYApellido() {
        //Given
        Persona personaSave = empleadoRepository.save(DataDummy.empleado01());

        //When
        Optional<Persona> expected = empleadoRepository.findByNombreYApellido(DataDummy.empleado01().getNombre(),DataDummy.empleado01().getApellido());

        //Then (isInstanceOf para decir que es una instancia de la clase empleado
        assertThat(expected.get()).isInstanceOf(Empleado.class);
        assertThat(expected.get()).isEqualTo(personaSave);
    }


    @Test
    @DisplayName("Probando el método de Buscar por Dni")
    void findByDni() {
        //Given
        Persona personaSave = profesorRepository.save(DataDummy.profesor01());

        //When
        Optional<Persona> expected = profesorRepository.findByDni(DataDummy.profesor01().getDni());

        //Then
        assertThat(expected.get()).isInstanceOf(Profesor.class);
        assertThat(expected.get()).isEqualTo(personaSave);
        assertThat(expected.get().getDni()).isEqualTo(personaSave.getDni());
    }

    @Test
    @DisplayName("Probando el método de Buscar Personas por apellido")
    void findPersonaByApellido() {
        //Given
        Iterable<Persona> personas = alumnoRepository.saveAll(
                Arrays.asList(
                        DataDummy.alumno01(),
                        DataDummy.alumno02(),
                        DataDummy.alumno03()
                )
        );

        //When
        String apellido = "Duque";
        List<Persona> expected = (List<Persona>) alumnoRepository.findPersonaByApellido(apellido);

        //Then
        assertThat(expected.size() == 2).isTrue();
        //assertThat(expected.getClass()).isInstanceOf(Alumno.class);

    }
}