package br.com.cognitio.estatisticas;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class ContagemPalavras {

	private Map<String, Integer> map = new TreeMap<>();

	public void adicionaPalavra(String palavra) {
		Integer contagem = this.map.get(palavra);
		if (contagem != null) {
			contagem++;
		} else {
			contagem = 1;
		}
		this.map.put(palavra, contagem);
	}

	public Set<Entry<String, Integer>> entrySet() {
		return map.entrySet();
	}
}
