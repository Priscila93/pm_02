/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author marce
 */
//Usado na leitura do arquivo txt
public class ListaDePalavras {
    List <String> lista_palavras = new ArrayList<>();

    //Construtor
    public ListaDePalavras() {
    
    }
        
    //Get Lista de palavras
    public List<String> getLista_palavras() {
        return lista_palavras;
    }

    //Set Lista de palavras
    public void setLista_palavras(List<String> lista_palavras) {
        this.lista_palavras = lista_palavras;
    }
    
    //Adiciona palavra a lista já existente
    public void AddPalavra(String palavra){
        lista_palavras.add(palavra);
    }
    
    //Adiciona lista de palavras a lista já existente
    public void AddListaPalavras(List<String> palavras){
        lista_palavras.addAll(palavras);
    }
}
