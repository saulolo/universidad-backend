package edu.universidad.universidadbackend;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class UniversidadBackendApplicationTests {

	Calculadora calculadora = new Calculadora();


	@Test  //Anotación necesaria para ejecutar un test
	@DisplayName("Suma de valorA y de valorB") //Personalizar el nombre del test
	void sumaDeValores() {

		/* ARRENGE */

		//Given: Definimos nuestro contexto (precondición)
		int valorA = 2;
		int valorB = 3;

		//when: Ejecutamos lo que queremos probar
		int expectativa = calculadora.sumar(valorA, valorB);

		//then: Las validadciones
		int resultadoExperado = 5;
		/* ASSERT */
		assertThat(expectativa).isEqualTo(resultadoExperado);

	}

	@Test
	@DisplayName("Test deprecado")
	@Disabled("Test deprecado") //Apara indicar que este test esta desactivado
	void testDesactivado() {

	}

	class Calculadora{
		int sumar(int valor_a, int valor_b){
			return valor_a + valor_b;
		}
	}

}
