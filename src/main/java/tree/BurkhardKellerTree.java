package tree;

import distancias.IDistanceCalculator;

/**
 *
 *  Classe que define a BKTree.
 * 
 *  @author marcella e priscila
 */

public class BurkhardKellerTree {

	private Node raiz;

	private IDistanceCalculator calculator;

	public BurkhardKellerTree(IDistanceCalculator calculator) {
		this.calculator = calculator;
	}

	/**
	 * Adiciona no a partir de string passada e adiciona o no na árvore
	 */
	public void adicionaNo(String no) {

		if (no == null || no.isEmpty()) {
		} else {
			Node novoNo = new Node(no);
			if (raiz == null) {
				raiz = novoNo;
			} else {
				adiciona(raiz, novoNo);
			}
		}
	}

	/**
	 * Adiciona nó na árvore de acordo com a distancia do DistanceCalculator
	 */
	private void adiciona(Node srcNode, Node novoNo) {

		if (srcNode.equals(novoNo)) {
			return;
		}

		double distance = calculator.distanciaEntrePalavras(srcNode.getPalavra(), novoNo.getPalavra());

		if (!calculator.isKeyboardLayoutNeutro()) {
			int modificador = 100;
			distance = distance * modificador;
		}

		Node noBk = srcNode.filhoNumaDistancia((int) distance);
		if (noBk == null) {
			srcNode.adicionarNoFilho((int) distance, novoNo);
		}

		// senao adiciona nó como filho
		else {
			adiciona(noBk, novoNo);
		}
	}

	/**
	 * Funcao para busca de nó com uma distancia máxima
	 */
	public BurkhardKellerTreeSearchResult busca(String palavra, int distanciaMaximaPermitida, int maxWords) {
		return new BurkhardKellerTreeSearchResult(raiz.busca(palavra, distanciaMaximaPermitida, calculator));

	}

}
