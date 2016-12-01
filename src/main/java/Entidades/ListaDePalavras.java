
package Entidades;

import java.util.ArrayList;
import java.util.List;

/** 
*  
*   Usado na leitura do arquivo txt
* 
*   @author marcella e priscila
*/
public class ListaDePalavras
{
    List <String> listaPalavras = new ArrayList<>();

    /** 
    *   Construtor
    */
    public ListaDePalavras()
    {
    
    }
        
    /** 
    *   Get Lista de palavras
    */
    public List<String> getListaPalavras()
    {
        return listaPalavras;
    }

    /** 
    *   Set Lista de palavras
    */
    public void setListaPalavras(List<String> listaPalavras)
    {
        this.listaPalavras = listaPalavras;
    }
    
    /** 
    *   Adiciona palavra a lista já existente
    */
    public void addPalavra(String palavra)
    {
        listaPalavras.add(palavra);
    }
    
    /** 
    *   Adiciona lista de palavras a lista já existente
    */
    public void addListaPalavras(List<String> palavras)
    {
        listaPalavras.addAll(palavras);
    }
}
