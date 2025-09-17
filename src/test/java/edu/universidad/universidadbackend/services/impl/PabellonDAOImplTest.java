package edu.universidad.universidadbackend.services.impl;

import edu.universidad.universidadbackend.data.DataDummy;
import edu.universidad.universidadbackend.model.entities.Pabellon;
import edu.universidad.universidadbackend.repositories.PabellonRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PabellonDAOImplTest {

    @InjectMocks
    private PabellonServiceImpl pabellonDAOImpl;

    @Mock
    private PabellonRepository pabellonRepository;

    @BeforeEach
    void setUp() {
    }

    @Test
    @DisplayName("Probando el método mostrar Pabellón por localidad")
    void findPabellonByLocalidad() {
        //Given
        String localidadPabellon = "Comercial";
        List<Pabellon> expectedPabellon = Collections.singletonList(DataDummy.aula01().getPabellon());

        //Configurar el comportamiento del repositorio
        when(pabellonRepository.findPabellonByLocalidad(anyString())).thenReturn(expectedPabellon);

        //When
        Iterable<Pabellon> result = pabellonDAOImpl.findPabellonByLocalidad(localidadPabellon);

        //Then
        verify(pabellonRepository, times(1)).findPabellonByLocalidad(localidadPabellon);
        assertEquals(expectedPabellon, result);
        assertNotNull(result);

    }

    @Test
    @DisplayName("Probando el método mostrar Pabellón por nombre")
    void findPabellonByNombre() {
        //Given
        String nombre = "Once";
        List<Pabellon> expectedPabellon = Collections.singletonList(DataDummy.aula01().getPabellon());

        //Configurar el comportamiento del repositorio
        when(pabellonRepository.findPabellonByNombre(anyString())).thenReturn(expectedPabellon);

        //When
        Iterable<Pabellon> result = pabellonDAOImpl.findPabellonByNombre(nombre);

        //Then
        verify(pabellonRepository, times(1)).findPabellonByNombre(nombre);
        assertEquals(expectedPabellon, result);
        assertNotNull(result);

    }
}