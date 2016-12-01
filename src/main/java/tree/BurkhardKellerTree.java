package tree;
import java.util.List;
import distancias.IDistanceCalculator;





public class BurkhardKellerTree {



	private Node root;

	private IDistanceCalculator calculator;

	private BurkhardKellerTreeSearchResult result;



	public BurkhardKellerTree(IDistanceCalculator calculator) {

		this.calculator = calculator;

	}

    public BurkhardKellerTree() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }



	/**

	 * Adiciona no partir de string passada e adiciona o no arvore

	 */

	public void addNode(String no) {

		if (no == null || no.isEmpty()) {

		} else {

			Node newNode = new Node(no);

			if (root == null) {

				root = newNode;

			} else {

				add(root, newNode);

			}

		}

	}



	/**

	 * Adiciona lista de palavras na árvore

	 */

	public void addNodeList(List<String> nodes) {

		for (String node : nodes) {

			addNode(node);

		}

	}



	/**

	 * Adiciona nó na árvore de acordo com a distancia do DistanceCalculator

	 */

	private void add(Node srcNode, Node newNode) {

		if (srcNode.equals(newNode)) {

			return;

		}



		int distance = (int) Math.round(calculator.distance(srcNode.getWord(), newNode.getWord()));



		Node bkNode = srcNode.filhosNumaDistancia(distance);



		if (bkNode == null) {

			srcNode.addChildNode(distance, newNode);



		}

		// senao adiciona nó como filho

		else {

			add(bkNode, newNode);

		}

	}



	/**

	 * Funcao para busca de nó com uma distancia máxima

	 */

	public List<String> search(String word, int distanciaMaximaPermitida, IDistanceCalculator calculator) {

		return root.search(word.toUpperCase(), distanciaMaximaPermitida, calculator);

	}



	/**

	 * Busca que devolve arvore resultado da busca

	 * 

	 */

	public BurkhardKellerTreeSearchResult search(String word, int distanciaMaxima, int numeroMaximoDePalavras) {

		return root.search2(word.toUpperCase(), distanciaMaxima, calculator);



	}

    public void AdicionarPalavra(String get) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }



}