package calculadora;

import java.util.ArrayList;
import java.util.List;

public class Calculadora {

	private Integer acumulado;
	private List<String> historico;

	public Calculadora() {
		acumulado = 0;
		historico = new ArrayList<>();
	}

	public Integer somar(Integer adendo, Integer augendo) {
		acumulado = adendo + augendo;
		registrarHistorico(adendo, "+", augendo, acumulado);
		return acumulado;
	}

	public Integer somar(Integer adendo) {
		Integer resultado = acumulado + adendo;
		registrarHistorico(acumulado, "+", adendo, resultado);
		acumulado = resultado;
		return acumulado;
	}

	public Integer subtrair(Integer minuendo, Integer subtraendo) {
		acumulado = minuendo - subtraendo;
		registrarHistorico(minuendo, "-", subtraendo, acumulado);
		return acumulado;
	}

	public Integer subtrair(Integer subtraendo) {
		Integer resultado = acumulado - subtraendo;
		registrarHistorico(acumulado, "-", subtraendo, resultado);
		acumulado = resultado;
		return acumulado;
	}

	private void registrarHistorico(Integer primeiro, String operacao, Integer segundo, Integer resultado) {
		String itemDoHistorico = String.format("%d %s %d = %d", primeiro, operacao, segundo, resultado);
		historico.add(0, itemDoHistorico);
	}

	public List<String> obterHistorico() {
		return historico;
	}

}
