package edu.universidad.universidadbackend.services.implementations;

import edu.universidad.universidadbackend.data.DataDummy;
import edu.universidad.universidadbackend.entities.Carrera;
import edu.universidad.universidadbackend.repositories.CarreraRepository;
import edu.universidad.universidadbackend.services.contracts.CarreraDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;


class CarreraDAOImplTest {


    CarreraDAO carreraDAO;


    CarreraRepository carreraRepository;


    //Simulamos el repositorio a travex del mock
    @BeforeEach
    void setUp() {
        carreraRepository = mock(CarreraRepository.class);
        carreraDAO = new CarreraDAOImpl(carreraRepository);
    }

    @Test
    @DisplayName("Probando el método de buscar carreras por Nombre")
    void testFindCarrerasByNombreContains() {
        //Given
        String nombre = "Ingenieria";

        //Simular un llamado a la base de datos para traer los datos de carrera
        when(carreraRepository.findCarrerasByNombreContains(nombre)).thenReturn(Arrays.asList(DataDummy.carrera01(), DataDummy.carrera02()));

        //When
        List<Carrera> expected = (List<Carrera>) carreraDAO.findCarrerasByNombreContains(nombre);

        //Then
        assertThat(expected.get(0)).isEqualTo(DataDummy.carrera01());
        assertThat(expected.get(1)).isEqualTo(DataDummy.carrera02());

        //Verfy
        verify(carreraRepository).findCarrerasByNombreContains(nombre);
    }

    @Test
    @DisplayName("Probando el método de buscar carreras por Nombre ignore sensitive")
    void testCarrerasByNombreContainsIgnoreCase() {

        //Given
        String nombre = "ingeniería";

        //Simular un llamado a la base de datos para traer los datos de carrera
        when(carreraRepository.findCarrerasByNombreContainsIgnoreCase(nombre)).thenReturn(Arrays.asList(DataDummy.carrera02()));

        //When
        List<Carrera> expected = (List<Carrera>) carreraDAO.findCarrerasByNombreContainsIgnoreCase(nombre);

        //Then
        assertThat(expected.get(0)).isEqualTo(DataDummy.carrera02());

        //Verify
        verify(carreraRepository).findCarrerasByNombreContainsIgnoreCase(nombre);

    }

    @Test
    @DisplayName("Probando el método de buscar carreras por canttdad de años")
    void testFindCarrerasByCantidadAniosAfter() {
        //Given
        int cantidadAnios = 4;

        //Simular un llamado a la base de datos para traer los datos de carrera
        when(carreraRepository.findCarrerasByCantidadAniosAfter(cantidadAnios)).thenReturn(Arrays.asList(DataDummy.carrera01(), DataDummy.carrera03()));

        //When
        List<Carrera> expected = (List<Carrera>) carreraDAO.findCarrerasByCantidadAniosAfter(cantidadAnios);

        //Then
        assertThat(expected.get(0)).isEqualTo(DataDummy.carrera01());

        //Verify
        verify(carreraRepository).findCarrerasByCantidadAniosAfter(cantidadAnios);

    }

    @Test
    @DisplayName("Probando el método de buscar carreras de profesor por nombre y apellido")
    void testFindCarrerasByProfesorNombreYApellido() {

        //Given
        String nombre = "Manolo";
        String apellido = "Gaitan";

        //Simular un llamado a la base de datos para traer los datos de carrera
        when(carreraRepository.findCarrerasByProfesorNombreYApellido(nombre, apellido)).thenReturn(Arrays.asList(DataDummy.carrera01()));

       //When
        List<Carrera> expected = (List<Carrera>) carreraDAO.findCarrerasByProfesorNombreYApellido(nombre, apellido);

        //Verify
        verify(carreraRepository).findCarrerasByProfesorNombreYApellido(nombre, apellido);

    }
}