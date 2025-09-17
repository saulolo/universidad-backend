package edu.universidad.universidadbackend.services.impl;

import edu.universidad.universidadbackend.data.DataDummy;
import edu.universidad.universidadbackend.model.entities.Persona;
import edu.universidad.universidadbackend.repositories.PersonaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class GenericServiceImplTest {


    @InjectMocks
    private GenericServiceImpl<Persona, PersonaRepository> genericDAOImpl;

    @Mock
    private PersonaRepository personaRepository;


    @BeforeEach
    void setUp() {
    }


    @Test
    @DisplayName("Probar el método de mostrar todos")
    void testFindAll() {
        //Given
        List<Persona> expectedPersonas = Collections.singletonList(DataDummy.empleado01());

        //Configurar el comportamiento del repositorio
        when(personaRepository.findAll()).thenReturn(expectedPersonas);

        //When
        Iterable<Persona> result = genericDAOImpl.findAll();

        //Then
        verify(personaRepository, times(1)).findAll();
        assertEquals(expectedPersonas, result);

    }


    @Test
    @DisplayName("Probar el método de mostrar por Id")
    void findById() {
        //Given
        Long id = 1L;
        Optional<Persona> expectedPersona = Optional.of(DataDummy.empleado01());

        //Configurar el comportamiento del repositorio
        when(personaRepository.findById(1L)).thenReturn(expectedPersona);

        //When
        Optional<Persona> result = genericDAOImpl.findById(1L);

        //Then
        verify(personaRepository, times(1)).findById(1L);
        assertEquals(expectedPersona, result);

    }

    @Test
    @DisplayName("Probar el método de guardar")
    void save() {
        //Given
        Persona expectedPersona = DataDummy.empleado01();

        //Configurar el comportamiento del repositorio
        when(personaRepository.save(expectedPersona)).thenReturn(expectedPersona);

        //When
        Persona result = genericDAOImpl.save(expectedPersona);

        //Then
        verify(personaRepository, times(1)).save(expectedPersona);
        assertNotNull(result);
        assertEquals(expectedPersona, result);
    }

    @Test
    @DisplayName("Probar el método de eliminar por Id")
    void deleteById() {
        //Given
        Long id = 1L;

        //Configurar el comportamiento del repositorio
        //No se necesita configurar when para deleteById, ya que es void

        //When
       genericDAOImpl.deleteById(1L);

        //Then
        verify(personaRepository, times(1)).deleteById(1L);

    }
}