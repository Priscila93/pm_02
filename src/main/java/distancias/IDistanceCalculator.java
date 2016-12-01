/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package distancias;

/**
 *
 * @author marce
 */
public interface IDistanceCalculator {
    public int DistanciaEntrePalavras(String palavra_um, String palavra_dois);

    public float distance(String word, String word0);
}
