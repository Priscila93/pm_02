package distancias;

import teclado.KeyboardLayout;

/**
 *
 *  Classe que calcular a distância Levenshtein
 * 
 *  @author marcella e priscila
 */
public class LevenshteinCalculator extends IDistanceCalculator {
	KeyboardLayout layout;

	public LevenshteinCalculator(KeyboardLayout layout) {
		this.layout = layout;
	}

	/**
	 * Calcula distância entre palavras pelo algoritmo de LevenshteinCalculator:
        Essa distância é calculada pelo mínimo de operações para transformar uma palavra na outra.
        As operações consideradas nesse algoritmo são: inserir, deletar ou substituir um caracter.
	 */
	public double distanciaEntrePalavras(String palavra_um, String palavra_dois) {

		CharSequence array_palavra_um = palavra_um;
		CharSequence array_palavra_dois = palavra_dois;

		double[][] matriz_calcular_distancia = new double[array_palavra_um.length() + 1][array_palavra_dois.length() + 1];

		for (int i = 0; i <= array_palavra_um.length(); i++) {
			matriz_calcular_distancia[i][0] = i;
		}

		for (int j = 1; j <= array_palavra_dois.length(); j++) {
			matriz_calcular_distancia[0][j] = j;

		}
		double deletar;
		double inserir;
		double substituir;

		for (int i = 1; i <= array_palavra_um.length(); i++) {
			for (int j = 1; j <= array_palavra_dois.length(); j++) {

				deletar = matriz_calcular_distancia[i - 1][j] + layout.getInsertDeleteDistance();

				inserir = matriz_calcular_distancia[i][j - 1] + layout.getInsertDeleteDistance();

				substituir = matriz_calcular_distancia[i - 1][j - 1] + ((array_palavra_um.charAt(i - 1) == array_palavra_dois.charAt(j - 1)) ? 0
						: layout.getRelativeDistance(array_palavra_um.charAt(i - 1), array_palavra_dois.charAt(j - 1)));

				matriz_calcular_distancia[i][j] = menorValor(deletar, inserir, substituir);
			}
		}
		return matriz_calcular_distancia[array_palavra_um.length()][array_palavra_dois.length()];
	}

	/**
	 * Calcula o menor valor entre deleção, inserção e substituição
	 */
	private double menorValor(double deletar, double inserir, double substituir) {
		double minimo = (deletar < inserir) ? deletar : inserir;
		return (minimo < substituir) ? minimo : substituir;

	}

	public boolean isKeyboardLayoutNeutro() {
		return layout.isNeutro();
	}

}
