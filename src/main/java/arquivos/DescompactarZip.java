/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template arquivo, choose Tools | Templates
 * and open the template in the editor.
 */
package arquivos;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;


/**
 *
 * @author marce
 */
public class DescompactarZip {
    
    //Descompacta o arquivo zip e salva ele no diretório
    public void ExtrairConteudoZip(String nome_arquivo){
        try {
            ZipFile arquivo_zip = new ZipFile(nome_arquivo);
            Enumeration<?> listagem_conteudo = arquivo_zip.entries();
            //Identifica se ainda há arquivos dentro do zip
            while (listagem_conteudo.hasMoreElements()) {
                ZipEntry conteudo = (ZipEntry) listagem_conteudo.nextElement();
                String nome_conteudo = conteudo.getName();
                System.out.printf("name: %-20s\n", nome_conteudo);
                //Identifica arquivo que pertence ao zip
                File arquivo = new File(nome_conteudo);
                if (nome_conteudo.endsWith("/")) {
                    arquivo.mkdirs();
                    continue;
		}
                //Identifica se o arquivo está dentro de um diretório no zip
		File arquivo_pai = arquivo.getParentFile();
		if (arquivo_pai != null) {
                    arquivo_pai.mkdirs();
		}
                //Lê arquivo e guarda
		InputStream leitor_dados = arquivo_zip.getInputStream(conteudo);
		FileOutputStream escritor_dados = new FileOutputStream(arquivo);
		byte[] bytes = new byte[1024];
		int tamanho;
		while ((tamanho = leitor_dados.read(bytes)) >= 0) {
                    escritor_dados.write(bytes, 0, tamanho);
		}
		leitor_dados.close();
		escritor_dados.close();

            }
            arquivo_zip.close();
	} catch (IOException e) {
            e.printStackTrace();
	}
    }
}
