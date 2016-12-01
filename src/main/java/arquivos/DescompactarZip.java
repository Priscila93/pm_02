
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
 *  Classe que descompacta o zip e salva ele no diretório.
 * 
 *  @author marcella e priscila
 */
public class DescompactarZip
{
    //Descompacta o arquivo zip e salva ele no diretório. É preciso passar o nome do arquuivo que está zipado.
    public void ExtrairConteudoZip(String nome_arquivo) throws IOException
    {
        ZipFile arquivoZip = new ZipFile(nome_arquivo);
        Enumeration<?> listagemConteudo = arquivoZip.entries();
            
        //Identifica se ainda há arquivos dentro do zip
        while (listagemConteudo.hasMoreElements())
        {
            ZipEntry conteudo = (ZipEntry) listagemConteudo.nextElement();
            String nomeConteudo = conteudo.getName();
                
            //Identifica arquivo que pertence ao zip e se ele é um diretório
            File arquivo = new File(nomeConteudo);
            if (nomeConteudo.endsWith("/"))
            {
                arquivo.mkdirs();
                continue;
            }
                
            //Identifica se o arquivo está dentro de um diretório no zip
            File arquivoPai = arquivo.getParentFile();
            if (arquivoPai != null)
            {
                arquivoPai.mkdirs();
            }
                
            //Lê arquivo e o guarda
            InputStream leitorDados = arquivoZip.getInputStream(conteudo);
            FileOutputStream escritorDados = new FileOutputStream(arquivo);
            byte[] bytes = new byte[1024];
            int tamanho;
            while ((tamanho = leitorDados.read(bytes)) >= 0)
            {
                escritorDados.write(bytes, 0, tamanho);
            }
            
            //Fecha-se tudo o que é necessário
            leitorDados.close();
            escritorDados.close();
        }
        arquivoZip.close();
    }
}
