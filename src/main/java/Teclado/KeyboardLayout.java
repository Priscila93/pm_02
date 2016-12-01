
package Teclado;

import java.util.ArrayList;

/** 
* 
*   Classe que define o layout de um teclado. Ao ler o xml, essa classe é utilizada para guardar a montagem de cada um dos layouts.
*   Cada layout tem modelo - nome, as linhas pertencentes - caracteres.
*   E, com isso, é possível saber outros atributos, como: altura e largura.
*   A matriz formada refere-se ao próprio layout.
* 
*   @author marcella e priscila
*/
public class KeyboardLayout
{
    private String model;
    private ArrayList<Line> lines = new ArrayList<>();
    private OrderedPair[] table;
    int width = 0;
    int height = 0;
    char teclasMatrix[][];
    final int tamanho_alfabeto = 26;
    double distanciasMatrix[][];
    
    /** 
    *   Construtor
    */
    public KeyboardLayout()
    {
        lines = new ArrayList<Line>();
        table = new OrderedPair[tamanho_alfabeto];
    }
        
    /** 
    *   Get do modelo do teclado
    */
    public String getModel()
    {
        return model;
    }

    /** 
    *   Set do modelo do teclado
    */
    public void setModel(String model)
    {
        this.model = model;
    }

    /** 
    *   Get das linhas do teclado, incluindo offset
    */
    public ArrayList<Line> getLines()
    {
        return lines;
    }

    /** 
    *   Set das linhas do teclado, incluindo offset
    */
    public void setLines(ArrayList<Line> lines)
    {
        this.lines = lines;
    }
    
    /** 
    *   Adiciona uma nova linha ao teclado, incluindo offset, se houver
    */
    public void addLine(Line linha)
    {
	lines.add(linha);
    }

    /** 
    *   Get largura
    */
    public int getWidth()
    {
        return width;
    }

    /** 
    *   Set largura
    */
    public void setWidth(int width)
    {
        this.width = width;
    }

    /** 
    *   Get altura
    */
    public int getHeight()
    {
        return height;
    }

    /** 
    *   Set altura
    */
    public void setHeight(int height)
    {
        this.height = height;
    }

    /** 
    *   Get matriz
    */
    public char[][] getTeclasMatrix()
    {
        return teclasMatrix;
    }

    /** 
    *   Set matriz
    */
    public void setTeclasMatrix(char[][] teclasMatrix)
    {
        this.teclasMatrix = teclasMatrix;
    }

    /** 
    *   Get distâncias matriz
    */
    public double[][] getDistanciasMatrix()
    {
        return distanciasMatrix;
    }

    /** 
    *   Set distâncias matriz
    */
    public void setDistanciasMatrix(double[][] distanciasMatrix)
    {
        this.distanciasMatrix = distanciasMatrix;
    }
    
    /** 
    *   Get da distância entre dois caracteres
    */
    public double getNominalDistance(char letra_um, char letra_dois)
    {
        letra_um = Character.toUpperCase(letra_um);
	letra_dois = Character.toUpperCase(letra_dois);
	
        //Guarda a distância de altura e largura de cada letra passada
	double letra_umX = 0.0;
        double letra_umY = 0.0;
        double letra_doisX = 0.0;
        double letra_doisY = 0.0;
        
        //Percorre a matriz do teclado
	for (int contador_largura = 0; contador_largura < height; contador_largura++)
        {
            for (int contador_altura = 0; contador_altura < width; contador_altura++)
            {
                
                //Verifica se a letra um corresponde ao ponto da matriz. Se sim, guardamos o lugar na qual está localizada - por altura e largura do teclado.
		if ((teclasMatrix[contador_altura][contador_largura]) == (letra_um))
                {
                    letra_umX = contador_altura + getSomaDeOffSets(contador_largura);
                    letra_umY = contador_largura;
		}
                
                //Verifica se a letra dois corresponde ao ponto da matriz. Se sim, guardamos o lugar na qual está localizada - por altura e largura do teclado.
		if ((teclasMatrix[contador_altura][contador_largura]) == (letra_dois))
                {
                    letra_doisX = contador_altura + getSomaDeOffSets(contador_largura);
                    letra_doisY = contador_largura;
		}
                
            }
	}

        //Guarda a diferenca das distâncias - altura e largura - entre as letras.
	double diferencaX = 0.0;
	double diferencaY = 0.0;
        
        //Verifica qual está localizada na maior posição de largura e qual está na menor, para verificar a diferença de forma que retorne um valor positivo.
	if (letra_umX >= letra_doisX)
            diferencaX = letra_umX - letra_doisX;
	else
            diferencaX = letra_doisX - letra_umX;

        //Verifica qual está localizada na maior posição de altura (de 1 a 3, sendo um a parte superior e três a inferior) e qual está na menor,
        //para verificar a diferença de forma que retorne um valor positivo.
	if (letra_umY > letra_doisY)
            diferencaY = letra_umY - letra_doisY;
	else
            diferencaY = letra_doisY - letra_umY;

        //Calcula a diferença das posições das letras
	double distancia_entre_letras = Math.sqrt((diferencaX * diferencaX) + (diferencaY * diferencaY));

	return distancia_entre_letras;
    }
    
    /** 
    *   Monta a matriz
    */
    public void prepareDistances()
    {
        width = 0;
	height = lines.size(); //Define a altura pela qtd de linhas na lista do teclado
        
        //Define qual é a maior largura entre as linhas do teclado
	for (int contador_altura = 0; contador_altura < height; contador_altura++)
        {
            if (width < lines.get(contador_altura).getLinhaCaracteres().length())
		width = lines.get(contador_altura).getLinhaCaracteres().length();
	}

        //Monta a matriz conforme seu tamanho de largura e altura, sem preenchê-la
	teclasMatrix = new char[width][height];

        //Preenche a matriz conforme as linhas lidas e pertencentes ao teclado
	for (int contador_altura = 0; contador_altura < height; contador_altura++)
        {
            for (int contador_largura = 0; contador_largura < width; contador_largura++)
            {
                    teclasMatrix[contador_largura][contador_altura] = lines.get(contador_altura).getLinhaCaracteres().charAt(contador_largura);
            }
	}
    }
    
    /** 
    *   Soma de distâncias com relação ao teclado
    */
    public Double getSomaDeOffSets(int tamanho)
    {
        double soma = 0.0;

        //Calcula a distância entre pontos a partir do tamanho entre eles e do offset
	for (int contador_tamanho = 0; contador_tamanho <= tamanho; contador_tamanho++)
        {
            soma = soma + lines.get(contador_tamanho).getOffset();
	}

        return soma;
    }
    
    /** 
    *   Custo da inserção e deleção com relação aos teclados
    */
    public double getInsertDeleteDistance()
    {
	double value = 0.25; //Valor para deleção
	double allOffsets = getSomaDeOffSets(lines.size()-1);
		
	if(allOffsets==0)
        {
            return 0;
	}	
		
	return value;
    }
    
    /** 
    *   Calcula a distância máxima entre dois caracteres em um teclado
    */
    public double getMaximumDistance()
    {
	double maior = 0.0;

        //Considera a matriz do teclado
	for (int contador_altura = 0; contador_altura < height; contador_altura++)
        {
            for (int contador_largura = 0; contador_largura < width; contador_largura++)
            {
                
                //Considera novamente a matriz do teclado, para fazer uma comparação das teclas dele com ele mesmo
		for (int contador_altura_2 = 0; contador_altura_2 < height; contador_altura_2++)
                {
                    for (int contador_largura_2 = 0; contador_largura_2 < width; contador_largura_2++)
                    {
                        
			if ((teclasMatrix[contador_largura][contador_altura] != '\0'))
                        {
                            if ((teclasMatrix[contador_largura_2][contador_altura_2] != '\0'))
                            {
                                
                                //Verifica se a distância entre as teclas é maior do que a distância que está guardada no momento. Se sim, recebe a nova distância.
				if (maior < getNominalDistance(teclasMatrix[contador_largura][contador_altura], teclasMatrix[contador_largura_2][contador_altura_2]))
                                {
                                    maior = getNominalDistance(teclasMatrix[contador_largura][contador_altura], teclasMatrix[contador_largura_2][contador_altura_2]);
				}
                            }
			}
                    }
		}
            }
	}
        return maior;
    }
}

