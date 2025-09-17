package edu.universidad.universidadbackend.services.impl;

import edu.universidad.universidadbackend.data.DataDummy;
import edu.universidad.universidadbackend.model.entities.Persona;
import edu.universidad.universidadbackend.repositories.ProfesorRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class ProfesorDAOImplTest {


    @InjectMocks
    private ProfesorServiceImpl profesorDAOImpl;


    @Mock
    private ProfesorRepository profesorRepository;



    @Test
    @DisplayName("Probando el método encontrar profesores por carrera")
    void findProfesoresByCarrera() {
        //Given
        String carrera = "Ingenieria de Software";
        Iterable<Persona> expectedProfesor = Collections.singletonList(DataDummy.profesor01());

        //Configurar el comportamiento del repositorio
        when(profesorRepository.findProfesoresByCarrera(carrera)).thenReturn(expectedProfesor);

        //When
        Iterable<Persona> result = profesorDAOImpl.findProfesoresByCarrera(carrera);

        //Then
        assertEquals(expectedProfesor, result);
        verify(profesorRepository, times(1)).findProfesoresByCarrera(carrera);
        assertNull(result);

    }
}