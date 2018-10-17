package br.com.cognitio.estatisticas;

import java.util.TreeMap;

public class ContagemPalavras extends TreeMap<String, Integer> {

	private static final long serialVersionUID = -7808176314880765385L;

	public void adicionaPalavra(String palavra) {
		Integer contagem = get(palavra);
		if (contagem != null) {
			contagem++;
		} else {
			contagem = 1;
		}
		put(palavra, contagem);
	}
}
