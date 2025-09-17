package edu.universidad.universidadbackend.services.impl;

import edu.universidad.universidadbackend.repositories.AlumnoRepository;
import edu.universidad.universidadbackend.services.Interfaces.IAlumnoService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;


@SpringBootTest  //Anotación para indicar que es una clase Test de spring boot
class AlumnoDAOImplTest {

    /*ENFOQUE UTILIZANDO SPRING BOOT Y MOCKS*/

    @MockBean  //Anotación de spring
    AlumnoRepository alumnoRepository;

    @Autowired
    IAlumnoService alumnoDAO;


    @Test
    @DisplayName("Probando el método de buscar almuno por Nombre de carrera")
    void findAlumnoByNombreCarrera() {

        //When
        alumnoDAO.findAlumnoByNombreCarrera(anyString());

        //Then
        verify(alumnoRepository).findAlumnoByNombreCarrera(anyString());

    }
}