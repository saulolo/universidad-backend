package edu.universidad.universidadbackend.services.implementations;

import edu.universidad.universidadbackend.data.DataDummy;
import edu.universidad.universidadbackend.entities.Aula;
import edu.universidad.universidadbackend.enums.Pizarron;
import edu.universidad.universidadbackend.repositories.AulaRepository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class) //1.Decirle a la calse Test que vamos a utilizar mockito
class AulaDAOImplTest {

    /*ENFOQUE UTILIZANDO JUNIT Y MOCKITO*/
    /*Método: Given (Dado) - When (Cuando) - Then (Entonces)*/


    @Mock  //2. Abstraer la llamada al repositorio o tambie lo puedo hacer como en el punto 2.1
    private AulaRepository aulaRepository;

    @InjectMocks  //3. Inyectar nuestro objeto simulado o mock a la clase o servicio que queremos testear (otra forma 3.1)
    AulaDAOImpl aulaDAOImpl;


/*    @BeforeEach
    void setUp() {
        //2.1 AulaRepository mock = Mockito.mock(AulaRepository.class);
        //3.1 aulaDAO = new AulaDAOImpl(aulaRepository);
    }*/

    @Test
    @DisplayName("Probando el método de buscar aula por tipo de pizarrón")
    void testFindAulaByTipoPizarron() {

        //4. When cuando llame al repositorio traigame mejor el objeto (Dummy) simulado
        // Configurar el comportamiento esperado del repositorio
        when(aulaRepository.findAulaByTipoPizarron(Pizarron.PIZARRA_BLANCA)).thenReturn(Collections.singletonList(DataDummy.aula01()));
        /*
        thenReturn(Collections.singletonList(DataDummy.aula01())): Esto establece que cuando se llame al método findAulaByTipoPizarron()
        con el argumento Pizarron.PIZARRA_BLANCA, se debe devolver una lista inmutable que contiene un solo elemento. El elemento en
        este caso es el resultado de DataDummy.aula01(), que es una instancia simulada de la clase Aula.
        */


        //5. Llamar al método en el servicio
        Iterable<Aula> expected = aulaDAOImpl.findAulaByTipoPizarron(Pizarron.PIZARRA_BLANCA);

        //6. Verificar que el método del repositorio fue llamado con los parámetros correctos
        verify(aulaRepository).findAulaByTipoPizarron(Pizarron.PIZARRA_BLANCA);

    }

    @Test
    @DisplayName("Probando el método de buscar aula por nombre de pabellón")
    void testFindAulaByNombrePabellon() {

        String pabellon1 = "pabellon";

        // Simulando el expected y el result
        List<Aula> expected = Collections.singletonList(DataDummy.aula01());
        when(aulaRepository.findAulaByNombrePabellon(pabellon1)).thenReturn(expected);

        //When
        Iterable<Aula> result = aulaDAOImpl.findAulaByNombrePabellon(pabellon1);

        //Then
        verify(aulaRepository).findAulaByNombrePabellon(pabellon1);
        assertEquals(expected, result);

    }

    @Test
    @DisplayName("Probando el método de buscar aula por número")
    void testFindAulaByNumero() {
        //Given
        int nroAula = 1;
        Aula expectedAula = DataDummy.aula01();

        //CConfigurar el comportamiento del repositorio
        when(aulaRepository.findAulaByNroAula(nroAula)).thenReturn(expectedAula);

        //When
        Aula result = aulaDAOImpl.findAulaByNumero(nroAula);

        //Then
        verify(aulaRepository, times(1)).findAulaByNroAula(nroAula);
        assertEquals(expectedAula, result);

    }
}