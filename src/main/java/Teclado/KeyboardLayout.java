/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Teclado;

import java.util.ArrayList;


/**
 *
 * @author marce
 */
public class KeyboardLayout {
    private String model;
    private ArrayList<Line> lines = new ArrayList<>();
    private OrderedPair[] table;
    int width = 0;
    int height = 0;
    char teclasMatrix[][];
    final int tamanho_alfabeto = 26;
    double distanciasMatrix[][];
    
    //Construtor
    public KeyboardLayout(){
        lines = new ArrayList<Line>();
        table = new OrderedPair[tamanho_alfabeto];
	}
        
    //Get do modelo do teclado
    public String getModel() {
        return model;
    }

    //Set do modelo do teclado
    public void setModel(String model) {
        this.model = model;
    }

    //Get das linhas do teclado, incluindo offset
    public ArrayList<Line> getLines() {
        return lines;
    }

    //Set das linhas do teclado, incluindo offset
    public void setLines(ArrayList<Line> lines) {
        this.lines = lines;
    }
    
    //Adiciona uma nova linha ao teclado, incluindo offset, se houver
    public void addLine(Line linha){
	lines.add(linha);
    }

    //Get largura
    public int getWidth() {
        return width;
    }

    //Set largura
    public void setWidth(int width) {
        this.width = width;
    }

    //Get altura
    public int getHeight() {
        return height;
    }

    //Set altura
    public void setHeight(int height) {
        this.height = height;
    }

    //Get matriz
    public char[][] getTeclasMatrix() {
        return teclasMatrix;
    }

    //Set matriz
    public void setTeclasMatrix(char[][] teclasMatrix) {
        this.teclasMatrix = teclasMatrix;
    }

    //Get distâncias matriz
    public double[][] getDistanciasMatrix() {
        return distanciasMatrix;
    }

    //Set distâncias matriz
    public void setDistanciasMatrix(double[][] distanciasMatrix) {
        this.distanciasMatrix = distanciasMatrix;
    }
    
    /*public void getLayoutByName(){
       TO DO 
    }*/
    
    //Get da distância entre dois caracteres
    public double getNominalDistance(char letra_um, char letra_dois){
        letra_um = Character.toUpperCase(letra_um);
	letra_dois = Character.toUpperCase(letra_dois);
	
	double letra_umX = 0.0;
        double letra_umY = 0.0;
        double letra_doisX = 0.0;
        double letra_doisY = 0.0;

	for (int contador_largura = 0; contador_largura < height; contador_largura++){
            for (int contador_altura = 0; contador_altura < width; contador_altura++){
		if ((teclasMatrix[contador_altura][contador_largura]) == (letra_um)){
                    // System.out.println(teclasMatrix[contador_altura][contador_largura]);
                    letra_umX = contador_altura + getSomaDeOffSets(contador_largura);
                    letra_umY = contador_largura;
		}
		if ((teclasMatrix[contador_altura][contador_largura]) == (letra_dois)){
                    // System.out.println(teclasMatrix[contador_altura][contador_largura]);
                    letra_doisX = contador_altura + getSomaDeOffSets(contador_largura);
                    letra_doisY = contador_largura;
		}
            }
	}

	double diferencaX = 0.0;
	double diferencaY = 0.0;

	if (letra_umX >= letra_doisX)
            diferencaX = letra_umX - letra_doisX;
	else
            diferencaX = letra_doisX - letra_umX;

	if (letra_umY > letra_doisY)
            diferencaY = letra_umY - letra_doisY;
	else
            diferencaY = letra_doisY - letra_umY;

	double distancia_entre_letras = Math.sqrt((diferencaX * diferencaX) + (diferencaY * diferencaY));

	return distancia_entre_letras;
    }
    
    //Monta a matriz
    public void prepareDistances(){
        width = 0;
	height = lines.size();

	for (int contador_altura = 0; contador_altura < height; contador_altura++){
            if (width < lines.get(contador_altura).getLinha_caracteres().length())
		width = lines.get(contador_altura).getLinha_caracteres().length();
	}

	teclasMatrix = new char[width][height];

	for (int contador_altura = 0; contador_altura < height; contador_altura++){
            for (int contador_largura = 0; contador_largura < width; contador_largura++){
		try{
                    teclasMatrix[contador_largura][contador_altura] = lines.get(contador_altura).getLinha_caracteres().charAt(contador_largura);
		} catch (Exception e){
                    e.printStackTrace();
		}
            }
	}
    }
    
    //Soma de distâncias com relação ao teclado
    public Double getSomaDeOffSets(int tamanho){
        double soma = 0.0;

	for (int contador_tamanho = 0; contador_tamanho <= tamanho; contador_tamanho++){
            soma = soma + lines.get(contador_tamanho).getOffset();
	}

        return soma;
    }
    
    //Custo da inserção e deleção com relação aos teclados
    public double getInsertDeleteDistance(){
	double value = 0.25;
	double allOffsets = getSomaDeOffSets(lines.size()-1);
	//System.out.println(allOffsets);
		
	if(allOffsets==0){
            return 0;
	}	
		
	return value;
    }
    
    //Calcula a distância máxima entre dois caracteres em um teclado
    public double getMaximumDistance(){
	double maior = 0.0;

	for (int contador_altura = 0; contador_altura < height; contador_altura++){
            for (int contador_largura = 0; contador_largura < width; contador_largura++){
		for (int contador_altura_2 = 0; contador_altura_2 < height; contador_altura_2++){
                    for (int contador_largura_2 = 0; contador_largura_2 < width; contador_largura_2++){
			if ((teclasMatrix[contador_largura][contador_altura] != '\0')){
                            if ((teclasMatrix[contador_largura_2][contador_altura_2] != '\0')){
				if (maior < getNominalDistance(teclasMatrix[contador_largura][contador_altura], teclasMatrix[contador_largura_2][contador_altura_2])){
                                    maior = getNominalDistance(teclasMatrix[contador_largura][contador_altura], teclasMatrix[contador_largura_2][contador_altura_2]);
//                                  System.out.println(maior);
//                                  System.out.println(" " + teclasMatrix[contador_largura][contador_altura] + " " + teclasMatrix[contador_largura_2][contador_altura_2]);
				}
                            }
			}
                    }
		}
            }
	}
        return maior;
    }

    public double getRelativeDistance(char charAt, char charAt0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

