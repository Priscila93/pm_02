
package Teclado;

/**
 *
 *  Classe que...
 * 
 *  @author marcella e priscila
 */
public class OrderedPair
{
    private double largura;
    private double altura;

    /**
     * Par ordenado com largura e altura da posição de uma tecla(letra)
     */
    public OrderedPair(double largura, double altura)
    {
	this.largura = largura;
	this.altura = altura;
    }

    /** 
    *   
    */
    public double getLargura()
    {
	return largura;
    }

    /** 
    *   
    */
    public void setLargura(double largura)
    {
    	this.largura = largura;
    }

    /** 
    *   
    */
    public double getAltura()
    {
	return altura;
    }

    /** 
    *   
    */
    public void setAltura(double altura)
    {
	this.altura = altura;
    }
}