package br.mp.mpm.despachante.util;

import java.text.Normalizer;
import java.util.Random;
import java.util.regex.Pattern;

public class Util {

	// gera uma sequencia de caracters randomicos, apenas alfanumericos
	public static String geraSenhaAleatoria(int tamanho) {

		char[] letras = { '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'j', 'k', 'm',
				'n', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'J',
				'K', 'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };

		Random random = new Random();
		if (tamanho < 0)
			throw new IllegalArgumentException("O tamanho da string não pode ser negativo");
		if (tamanho < 4)
			throw new IllegalArgumentException("O tamanho da string não pode menor que 4 caracteres");

		char[] charSequence = new char[tamanho];
		for (int i = 0; i < tamanho; i++)
			charSequence[i] = letras[random.nextInt(letras.length)];
		return new String(charSequence);
	}

	public static String removeAcentos(String texto) {
		return Normalizer.normalize(texto, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
	}

	public static String formataCPF(String cpf) {
		String valor = "00000000000" + cpf.replaceAll("[^0123456789]", ""); // remove caracteres não numericos
		valor = valor.substring(valor.length() - 11, valor.length()); // cpf completado "0" a esquerda
		return Pattern.compile("(\\d{3})(\\d{3})(\\d{3})(\\d{2})").matcher(valor).replaceAll("$1.$2.$3-$4");
	}
}
