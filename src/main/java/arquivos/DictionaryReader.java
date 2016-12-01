
package arquivos;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import Entidades.ListaDePalavras;
import java.util.ArrayList;
import tree.BurkhardKellerTree;

/**
 *
 *  Classe que lê o arquivo que contém o dicionário de palavras.
 * 
 *  @author marcella e priscila
 */
public class DictionaryReader
{
    /** 
    *   Lê o arquivo de palavras e monta a árvore
    */
    public BurkhardKellerTree loadFromFile(String NomeArquivo)
    {
        ListaDePalavras listaDePalavras = new ListaDePalavras();
        BurkhardKellerTree bkTree = new BurkhardKellerTree();
        try
        {
            FileReader arquivo = new FileReader(NomeArquivo);
            BufferedReader lerArquivo = new BufferedReader(arquivo);
            String linha = lerArquivo.readLine();
            while (linha != null)
            {
                listaDePalavras.addPalavra(linha);
                linha = lerArquivo.readLine();
            }
            arquivo.close();
        } catch (IOException e)
        {
            System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
        }
        ArrayList<String> lista = new ArrayList<>();
        for(int contadorPalavras = 0; contadorPalavras < lista.size(); contadorPalavras++)
        {
                    bkTree.adicionarPalavra(lista.get(contadorPalavras));
        
        }      
        return bkTree;
    }     
}