
package distancias;

import Teclado.KeyboardLayout;

/**
 *
 *  Classe define a calculadora de Damerau - Levenshtein
 * 
 *  @author marcella e priscila
 */
public class DamerauLevenshteinCalculator
{
    private KeyboardLayout layout;

    public DamerauLevenshteinCalculator(KeyboardLayout layout)
    {
	this.layout = layout;
    }

    /**
     * Implementação do calculo da distancia com Damerou-Levenshtein
     */
    public double distance(String palavraUm, String palavraDois)
    {
    	CharSequence sequenciaPalavraUm = palavraUm;
	CharSequence sequenciaPalavraDois = palavraDois;
        
        double delecao = 0.0;
	double insercao = 0.0;
	double substituicao = 0.0;
	double transposicao = 0.0;

        double[][] distance = new double[sequenciaPalavraUm.length() + 1][sequenciaPalavraDois.length() + 1];
        
	for (int i = 0; i <= sequenciaPalavraUm.length(); i++)
        {
            distance[i][0] = i;
	}

	for (int j = 1; j <= sequenciaPalavraDois.length(); j++)
        {
            distance[0][j] = j;
	}

	for (int i = 1; i <= sequenciaPalavraUm.length(); i++)
        {
            for (int j = 1; j <= sequenciaPalavraDois.length(); j++)
            {
		delecao = distance[i - 1][j] + layout.getInsertDeleteDistance();
		insercao = distance[i][j - 1] + layout.getInsertDeleteDistance();
		substituicao = distance[i - 1][j - 1] + ((sequenciaPalavraUm.charAt(i - 1) == sequenciaPalavraDois.charAt(j - 1)) ? 0 : layout.getRelativeDistance(sequenciaPalavraUm.charAt(i - 1), sequenciaPalavraDois.charAt(j - 1)));

		// Verifica se é transponivel - Damerou
		if (isTransposable(sequenciaPalavraUm, sequenciaPalavraDois, i, j))
                {
                    transposicao = distance[i - 2][j - 2] + layout.getNominalDistance(sequenciaPalavraUm.charAt(i - 1), sequenciaPalavraDois.charAt(j - 2));
                    distance[i][j] = lowestValue(delecao, insercao, substituicao, transposicao);
		}
                else
                {
                    distance[i][j] = lowestValue(delecao, insercao, substituicao);
		}
            }
	}
	return distance[sequenciaPalavraUm.length()][sequenciaPalavraDois.length()];
    }

    /**
     * Verifica se troca de letra com a letra seguinte
     */
    private boolean isTransposable(CharSequence lhs, CharSequence rhs, int i, int j)
    {
	return ((i > 1) && (j > 1) && (lhs.charAt(i - 1) == rhs.charAt(j - 2)) && (lhs.charAt(i - 2) == rhs.charAt(j - 1)));
    }

    /**
     * Calcula o menor valor entre deleção, inserção e substituição
     */
    private double lowestValue(double deletion, double insertion, double substitution)
    {
	double min = (deletion < insertion) ? deletion : insertion;

        min = (min < substitution) ? min : substitution;

	return min;
    }

    /**
     * Calcula o menor valor entre deleção, inserção , substituição e troca pela letra seguinte
     */
    private double lowestValue(double deletion, double insertion, double substitution, double transposition)
    {
	double minor = (deletion < insertion) ? deletion : insertion;

	minor = (minor < substitution) ? minor : substitution;

	minor = (minor < transposition) ? minor : transposition;

	return minor;
    }
}