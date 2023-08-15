package edu.universidad.universidadbackend.repositories;

import edu.universidad.universidadbackend.data.DataDummy;
import edu.universidad.universidadbackend.entities.Carrera;
import edu.universidad.universidadbackend.entities.Profesor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;



@DataJpaTest  //Esta anotación indica que estás realizando una prueba de repositorio con Spring Data JPA.
class CarreraRepositoryTest {

    @Autowired
    CarreraRepository carreraRepository;

    @Autowired
    ProfesorRepository profesorRepository;

    //Uso de otros Métodos
    @BeforeEach //Indica que esto se va a ejecutar antes de cada test
    void setUp() { //Podria poner lo que se repite en cada metodo
/*        carreraRepository.save(DataDummy.carrera01());
        carreraRepository.save(DataDummy.carrera02());
        carreraRepository.save(DataDummy.carrera03());*/

    }

    @AfterEach //Metodo que se pone para que se ejecute despues de cada test
    void tearDown() {
        carreraRepository.deleteAll(); //ponemos este metodo para que borre toda la basura que ingrese a las pruebas
    }

    @Test
    @DisplayName("Probando el método de Buscar carrera por nombre")
    void findCarrerasByNombreContains() {

        //Given: Definimos nuestro contexto (precondición)
        carreraRepository.save(DataDummy.carrera01());
        carreraRepository.save(DataDummy.carrera02());
        carreraRepository.save(DataDummy.carrera03());

        //when: Ejecutamos lo que queremos probar
        Iterable<Carrera> expectativa = carreraRepository.findCarrerasByNombreContains("Software");

        //then:
        assertThat(((List<Carrera>)expectativa).size() == 2).isTrue(); //Hacemos un casteo a List

    }


    @Test
    @DisplayName("Probando el método de Buscar carrera por nombre No case sensitive")
    void findCarrerasByNombreContainsIgnoreCase() {

        //Given: Definimos nuestro contexto (precondición)
        carreraRepository.save(DataDummy.carrera01());
        carreraRepository.save(DataDummy.carrera02());
        carreraRepository.save(DataDummy.carrera03());

        //when: Ejecutamos lo que queremos probar
        List<Carrera> expectativa = (List<Carrera>) carreraRepository.findCarrerasByNombreContainsIgnoreCase("ingeniería"); //Otra forma de castear

        //then
        assertThat(expectativa.size() == 2).isTrue();

    }


    @Test
    @DisplayName("Probando el método de Buscar carrera por mayor a N de años")
    void findCarrerasByCantidadAniosAfter() {

        //Given
        carreraRepository.save(DataDummy.carrera01());
        carreraRepository.save(DataDummy.carrera02());
        carreraRepository.save(DataDummy.carrera03());

        //when: Ejecutamos lo que queremos probar
        List<Carrera> expectativa = (List<Carrera>) carreraRepository.findCarrerasByCantidadAniosAfter(2);

        //then
        assertThat(expectativa.size() == 3).isTrue();

    }


    @Test
    @DisplayName("Probando el método de Buscar carrera por profesor segun nombre y apellido")
    void findCarrerasByProfesorNombreYApellido() {

        // Given: Preparar el escenario (contexto)
        Profesor profesor = DataDummy.profesor01();
        Carrera carrera1 = DataDummy.carrera01();
        Carrera carrera2 = DataDummy.carrera02();

        // Asociar las carreras al profesor (si corresponde)
        profesor.setCarreras(new HashSet<>(Arrays.asList(carrera1, carrera2)));

        // Guardar las carreras y el profesor en la base de datos
        carreraRepository.saveAll(Arrays.asList(carrera1, carrera2));
        profesorRepository.save(profesor);

        // When: Ejecutar la búsqueda y obtener el resultado
        List<Carrera> expectativa =  (List<Carrera>) carreraRepository.findCarrerasByProfesorNombreYApellido("Manolo", "Gaitan");

        //then
        assertThat(expectativa.size() == 2).isTrue();
        //assertThat(expectativa.size()).isEqualTo(2);


    }
}