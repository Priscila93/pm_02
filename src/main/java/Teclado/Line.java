
package Teclado;

/** 
* 
*   Classe que define a linha lida no arquivo xml.
*   Sendo definida pelos caracteres presentes em uma linha do teclado e pelos offsets presentes.
* 
*   @author marcella e priscila
*/
public class Line
{
    private String linhaCaracteres;
    private double offset;

    /** 
    *   Construtor
    */
    public Line()
    {
        
    }

    /** 
    *   Get dos caracteres
    */
    public String getLinhaCaracteres()
    {
	return linhaCaracteres;
    }

    /** 
    *   Set dos caracteres
    */
    public void setLinhaCaracteres(String linha_caracteres)
    {
	this.linhaCaracteres = linha_caracteres;
    }

    /** 
    *   Get do offset
    */
    public double getOffset()
    {
	return offset;
    }

    /** 
    *   Set do offset
    */
    public void setOffset(double offset)
    {
	this.offset = offset;
    }
}
