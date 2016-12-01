
package distancias;

/**
 *
 *  Interface para as calculadoras existentes - Damerau e Levenshtein.
 * 
 *  @author marcella e priscila
 */
public interface IDistanceCalculator
{
    public int DistanciaEntrePalavras(String palavra_um, String palavra_dois);
    public float distance(String word, String word0);
}
