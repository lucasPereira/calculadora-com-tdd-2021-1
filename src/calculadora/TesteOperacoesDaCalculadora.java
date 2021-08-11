package calculadora;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TesteOperacoesDaCalculadora {

	private Calculadora calculadora;

	private Integer zero;
	private Integer um;
	private Integer dois;
	private Integer quatro;
	private Integer menosUm;

	@BeforeEach
	void configurar() {
		calculadora = new Calculadora();
		zero = 0;
		um = 1;
		dois = 2;
		quatro = 4;
		menosUm = -1;
	}

	@Test
	void somarZeroMaisZero() throws Exception {
		Integer resultado = calculadora.somar(zero, zero);
		assertEquals(zero, resultado);
	}

	@Test
	void somarUmMaisZero() throws Exception {
		Integer resultado = calculadora.somar(um, zero);
		assertEquals(um, resultado);
	}

	@Test
	void somarUmMaisUm() throws Exception {
		Integer resultado = calculadora.somar(um, um);
		assertEquals(dois, resultado);
	}

	@Test
	void somarTresPrimeirosTermosDeFibonacci() throws Exception {
		calculadora.somar(zero, um);
		Integer resultado = calculadora.somar(um);
		assertEquals(dois, resultado);
	}

	@Test
	void somarQuatroPrimeirosTermosDeFibonacci() throws Exception {
		calculadora.somar(zero, um);
		calculadora.somar(um);
		Integer resultado = calculadora.somar(dois);
		assertEquals(quatro, resultado);
	}

	@Test
	void somarUmTermoSemSomarAntesDoisTermos() throws Exception {
		Integer resultado = calculadora.somar(um);
		assertEquals(um, resultado);
	}

	@Test
	void somarDoisTermosDepoisSomarDoisTermosNovamente() throws Exception {
		calculadora.somar(zero, um);
		Integer resultado = calculadora.somar(um, um);
		assertEquals(dois, resultado);
	}

	@Test
	void subtrairDoisMenosUm() throws Exception {
		Integer resultado = calculadora.subtrair(dois, um);
		assertEquals(um, resultado);
	}

	@Test
	void subtrairDoisMenosUmMenosDois() throws Exception {
		calculadora.subtrair(dois, um);
		Integer resultado = calculadora.subtrair(dois);
		assertEquals(menosUm, resultado);
	}

	@Test
	void somarUmMaisZeroMenosDois() throws Exception {
		calculadora.somar(um, zero);
		Integer resultado = calculadora.subtrair(dois);
		assertEquals(menosUm, resultado);
	}

}
