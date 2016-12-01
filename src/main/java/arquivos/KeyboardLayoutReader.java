/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arquivos;

import Teclado.Line;
import Teclado.KeyboardLayout;
import Teclado.KeyboardLayoutList;
import java.io.File;
import java.io.IOException;
import org.w3c.dom.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

/**
 *
 * @author marce
 */
public class KeyboardLayoutReader {
    //Lê arquivo xml e guarda o conteúdo lido
    public KeyboardLayoutList loadFromFile(String string) throws SAXException, IOException, ParserConfigurationException {
	KeyboardLayoutList lista_tipos_teclado = new KeyboardLayoutList();

	try{
            //abertura e leitura do arquivo xml
            File file = new File("KeyboardLayouts.xml");
            DocumentBuilderFactory document_builder_factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder document_builder = document_builder_factory.newDocumentBuilder();
            Document documento = document_builder.parse(file);
            documento.getDocumentElement().normalize();
            NodeList objetos = documento.getElementsByTagName("layout");
            //Prepara e adiciona um teclado à lista
            for (int contador_objetos = 0; contador_objetos < objetos.getLength(); contador_objetos++){
                Node objeto = objetos.item(contador_objetos);
		if (objeto.getNodeType() == Node.ELEMENT_NODE){
                    KeyboardLayout tipo_teclado = new KeyboardLayout();
                    Element elemento = (Element) objeto;
                    tipo_teclado.setModel(elemento.getAttribute("model"));
                    // System.out.println("");
                    // System.out.println(tipo_teclado.getModel());
                    for (int contador_linhas_layout = 0; contador_linhas_layout < 3; contador_linhas_layout++){
			Line linha = new Line();
			String caracteres = elemento.getElementsByTagName("line").item(contador_linhas_layout).getTextContent();
			linha.setLinha_caracteres(caracteres);
			tipo_teclado.addLine(linha);
        		String offset = "" + elemento.getElementsByTagName("line").item(contador_linhas_layout).getAttributes().getNamedItem("offset");
			if (!offset.equals("null")){
                            offset = offset.substring(8, offset.length() - 1);
                            Double cont = Double.parseDouble(offset);
                            linha.setOffset(cont);
                        }
			lista_tipos_teclado.addLayouts(tipo_teclado);
			// System.out.println(tipo_teclado.getLines().get(contador_linhas_layout).getContent() + " offset :" +tipo_teclado.getLines().get(contador_linhas_layout).getOffset() );
                    }
		}
            }
	} catch (Exception e){
            e.printStackTrace();
	}
	return lista_tipos_teclado;
    }
}
