package edu.universidad.universidadbackend.services.impl;

import edu.universidad.universidadbackend.data.DataDummy;
import edu.universidad.universidadbackend.model.entities.Persona;
import edu.universidad.universidadbackend.repositories.EmpleadoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EmpleadoDAOImplTest {


    @InjectMocks
    private EmpleadoServiceImpl empleadoDAOImpl  ;


    @Mock
    private EmpleadoRepository empleadoRepository;


    @BeforeEach
    void setUp() {
    }

    @Test
    @DisplayName("Probando el método buscar empelado por tipo de empleado")
    void findEmpleadoByTipoEmpleado() {
        //Given
        String tipoEmpleado1 = "Administrador";
        List<Persona> expectedPerson = Collections.singletonList(DataDummy.empleado01());

        //Configurando When
        when(empleadoRepository.findEmpleadoByTipoEmpleado(anyString())).thenReturn(expectedPerson);

        //When
        Iterable<Persona> result = empleadoDAOImpl.findEmpleadoByTipoEmpleado(tipoEmpleado1);

        //Then
        verify(empleadoRepository).findEmpleadoByTipoEmpleado(anyString());

    }
}