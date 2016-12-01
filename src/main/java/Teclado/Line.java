/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Teclado;

/**
 *
 * @author marce
 */
public class Line {
    private String linha_caracteres;
    private double offset;

    //Construtor
    public Line(){
    }

    //Get dos caracteres
    public String getLinha_caracteres(){
	return linha_caracteres;
    }

    //Set dos caracteres
    public void setLinha_caracteres(String linha_caracteres){
	this.linha_caracteres = linha_caracteres;
    }

    //Get do offset
    public double getOffset(){
	return offset;
    }

    //Set do offset
    public void setOffset(double offset){
	this.offset = offset;
    }
}
