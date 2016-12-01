package tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import distancias.IDistanceCalculator;

/**
 * Classe que define os nós da BKTree.
 * 
 * @author marcella e priscila
 *
 */

public class Node {

	private final String palavra;
	private final Map<Integer, Node> filhos;

	public Node(String palavra) {
		this.palavra = palavra;
		this.filhos = new HashMap<Integer, Node>();

	}

        /**
	 * Pega o filho na posição distanciaEntrePalavras no hashMap
	 */
	public String getPalavra() {
		return palavra;
	}

	/**
	 * Pega o filho na posição distanciaEntrePalavras no hashMap
	 */
	public Node filhoNumaDistancia(int distancia) {
		return filhos.get(distancia);
	}

	/**
	 * Método usado pela árvore para adicionar o nó na posição do hash
	 */
	public void adicionarNoFilho(int posicao, Node Nofilho) {
		filhos.put(posicao, Nofilho);
	}

	/**
	 * Busca por palavras na árvore
	 */
	public ArrayList<Palavra> busca(String no, int distanciaMaxima, IDistanceCalculator calculator) {

		ArrayList<Palavra> palavraCompativel = new ArrayList<Palavra>();

		double distancia = (int) calculator.distanciaEntrePalavras(palavra, no);

		double modificador = 1;

		if (!calculator.isKeyboardLayoutNeutro()) {
			modificador = 100;
		}

		distancia = distancia * modificador;
		distanciaMaxima = (int) (distanciaMaxima * modificador);

		if (distancia <= distanciaMaxima) {
			palavraCompativel.add(new Palavra(palavra, distancia / modificador));
		}

		if (filhos.size() == 0) {
			return palavraCompativel;
		}

		for (int i = Math.max(1, (int) distancia - distanciaMaxima); i <= distancia + distanciaMaxima; i++) {

			Node filho = filhos.get(i);
			if (filho != null) {
				palavraCompativel.addAll(filho.busca(no, distanciaMaxima / (int) modificador, calculator));
			}
		}
		return palavraCompativel;

	}
}
