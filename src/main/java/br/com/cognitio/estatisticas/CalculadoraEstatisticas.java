package br.com.cognitio.estatisticas;

import java.text.Normalizer;
import java.text.Normalizer.Form;
import java.util.HashMap;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import cotuba.domain.Capitulo;
import cotuba.domain.Ebook;
import cotuba.plugin.Plugin;

public class CalculadoraEstatisticas implements Plugin {

	@Override
	public String cssDoTema() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void aposGeracao(Ebook ebook) {
		for (Capitulo capitulo : ebook.getCapitulos()) {
			String html = capitulo.getConteudoHTML();
			Document doc = Jsoup.parse(html);
			String textoDoCapitulo = doc.body().text();
			String textoDoCapituloSemPontuacao = textoDoCapitulo.replaceAll("\\p{Punct}", " ");
			String textoDoCapituloSemAcentos = Normalizer.normalize(textoDoCapituloSemPontuacao, Form.NFD)
					.replaceAll("[^\\p{ASCII}]", "");

			String[] palavras = textoDoCapituloSemAcentos.split("\\s+");
			ContagemPalavras contagemPalavras = new ContagemPalavras();

			for (String palavra : palavras) {
				String emMaiusculas = palavra.toUpperCase();
				contagemPalavras.adicionaPalavra(emMaiusculas);;
			}

			for (Map.Entry<String, Integer> contagem : contagemPalavras.entrySet()) {
				String palavra = contagem.getKey();
				Integer ocorrencias = contagem.getValue();
				System.out.println(palavra + ": " + ocorrencias);
			}
		}

	}

}
