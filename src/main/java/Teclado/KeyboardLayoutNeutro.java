
package Teclado;

/**
 *
 *  Classe que...
 * 
 *  @author marcella e priscila
 */
public class KeyboardLayoutNeutro extends KeyboardLayout {
    private static final double VALOR_DEFAULT = 1.0;

    /** 
    *   
    */
    public String getModel()
    {
	return "NEUTRO";
    }

    /** 
    *   
    */
    public double getInsertDeleteDistance()
    {
	return VALOR_DEFAULT;
    }

    /** 
    *   
    */
    public double getNominalDistance(char letra_um, char letra_dois)
    {
	return VALOR_DEFAULT;
    }

    /** 
    *   
    */
    public double getRelativeDistance(char caracter_um, char caracter_dois)
    {
	return VALOR_DEFAULT;
    }
}
