package calculadora;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TesteHistoricoDaCalculadora {

	private Calculadora calculadora;

	private Integer zero;
	private Integer um;

	@BeforeEach
	void configurar() {
		calculadora = new Calculadora();
		zero = 0;
		um = 1;
	}

	@Test
	void historicoVazio() throws Exception {
		List<String> historico = calculadora.obterHistorico();
		assertEquals(0, historico.size());
	}

	@Test
	void historicoComUmaSomaDeDoisTermos() throws Exception {
		calculadora.somar(um, zero);
		List<String> historico = calculadora.obterHistorico();
		assertEquals(1, historico.size());
		assertEquals("1 + 0 = 1", historico.get(0));
	}

	@Test
	void historicoComDuasSomasDeDoisTermos() throws Exception {
		calculadora.somar(um, zero);
		calculadora.somar(zero, um);
		List<String> historico = calculadora.obterHistorico();
		assertEquals(2, historico.size());
		assertEquals("0 + 1 = 1", historico.get(0));
		assertEquals("1 + 0 = 1", historico.get(1));
	}

	@Test
	void historicoComUmaSomaDeUmTermo() throws Exception {
		calculadora.somar(um);
		List<String> historico = calculadora.obterHistorico();
		assertEquals(1, historico.size());
		assertEquals("0 + 1 = 1", historico.get(0));
	}

	@Test
	void historicoComUmaSubtracaoDeDoisTermos() throws Exception {
		calculadora.subtrair(um, zero);
		List<String> historico = calculadora.obterHistorico();
		assertEquals(1, historico.size());
		assertEquals("1 - 0 = 1", historico.get(0));
	}

	@Test
	void historicoComUmaSubtracaoDeUmTermo() throws Exception {
		calculadora.subtrair(zero);
		List<String> historico = calculadora.obterHistorico();
		assertEquals(1, historico.size());
		assertEquals("0 - 0 = 0", historico.get(0));
	}

}
