package edu.universidad.universidadbackend.services.impl;


import edu.universidad.universidadbackend.repositories.AlumnoRepository;
import edu.universidad.universidadbackend.services.Interfaces.IPersonaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)  //Para extender de la clase de Mockito
class PersonaServiceImplTest {

    /*ENFOQUE UTILIZANDO JUNIT Y MOCKITO*/

    IPersonaService IPersonaService;

    @Mock  //Simulamos el AlumnoRepository con la anotación @Mock
    private AlumnoRepository alumnoRepository;

    @BeforeEach
    void setUp() {
        IPersonaService = new PersonaServiceImpl(alumnoRepository);
    }

    @Test
    @DisplayName("Probando el método de buscar Nombre y apellido")
    void TestFindByNombreYApellido() {
        //No generamos el método given sino que pasamnos al when
        //When
        IPersonaService.findByNombreYApellido(anyString(), anyString()); //anyString es de mockito que indica que va a recinir algun string

        //Then
        verify(alumnoRepository).findByNombreYApellido(anyString(), anyString());
    }

    @Test
    @DisplayName("Probando el método de buscar por Dmi")
    void TestFindByDni() {
        //When
        IPersonaService.findByDni(anyString());

        //Then
        verify(alumnoRepository).findByDni(anyString());

    }

    @Test
    @DisplayName("Probando el método de buscar personas por apellido")
    void TestFindPersonaByApellido() {

        //When
        IPersonaService.findPersonaByApellido(anyString());

        //Then
        verify(alumnoRepository).findPersonaByApellido(anyString());

    }
}