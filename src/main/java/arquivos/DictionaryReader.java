/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arquivos;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import Entidades.ListaDePalavras;
import java.util.ArrayList;
import tree.BurkhardKellerTree;
/**
 *
 * @author marce
 */
public class DictionaryReader {
    //Lê o arquivo de palavras e monta a árvore
    public BurkhardKellerTree loadFromFile(String NomeArquivo){
        System.out.printf("\nConteúdo do arquivo texto:\n");
        ListaDePalavras lista_de_palavras = new ListaDePalavras();
        BurkhardKellerTree bk_tree = new BurkhardKellerTree();
        try {
            FileReader arquivo = new FileReader(NomeArquivo);
            BufferedReader ler_arquivo = new BufferedReader(arquivo);
            String linha = ler_arquivo.readLine();
            while (linha != null) {
                lista_de_palavras.AddPalavra(linha);
                System.out.printf("%s\n", linha);
                linha = ler_arquivo.readLine();
            }
            arquivo.close();
        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
        }
        System.out.println();
        ArrayList<String> lista = new ArrayList<>();
        for(int contador_palavras = 0; contador_palavras < lista.size(); contador_palavras++){
                    bk_tree.AdicionarPalavra(lista.get(contador_palavras));
        }
        return bk_tree;
    }

      
}
