
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
 *  Classe que lê o arquivo xml e guarda o conteúdo lido
 * 
 *  @author marcella e priscila
 */
public class KeyboardLayoutReader
{
    /** 
    *   Lê arquivo xml e guarda o conteúdo lido
    */
    public KeyboardLayoutList loadFromFile(String string) throws SAXException, IOException, ParserConfigurationException
    {
	KeyboardLayoutList listaTiposTeclado = new KeyboardLayoutList();

	try
        {
            //abertura e leitura do arquivo xml
            File file = new File("KeyboardLayouts.xml");
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document documento = documentBuilder.parse(file);
            documento.getDocumentElement().normalize();
            NodeList objetos = documento.getElementsByTagName("layout");
            
            //Prepara e adiciona um teclado à lista
            for (int contadorObjetos = 0; contadorObjetos < objetos.getLength(); contadorObjetos++)
            {
                Node objeto = objetos.item(contadorObjetos);
		if (objeto.getNodeType() == Node.ELEMENT_NODE)
                {
                    KeyboardLayout tipoTeclado = new KeyboardLayout();
                    Element elemento = (Element) objeto;
                    tipoTeclado.setModel(elemento.getAttribute("model"));

                    for (int contadorLinhasLayout = 0; contadorLinhasLayout < 3; contadorLinhasLayout++)
                    {
			Line linha = new Line();
			String caracteres = elemento.getElementsByTagName("line").item(contadorLinhasLayout).getTextContent();
			linha.setLinhaCaracteres(caracteres);
			tipoTeclado.addLine(linha);
        		String offset = "" + elemento.getElementsByTagName("line").item(contadorLinhasLayout).getAttributes().getNamedItem("offset");
                        
			if (!offset.equals("null"))
                        {
                            offset = offset.substring(8, offset.length() - 1);
                            Double cont = Double.parseDouble(offset);
                            linha.setOffset(cont);
                        }
                        
			listaTiposTeclado.addLayouts(tipoTeclado);
                    }
		}
            }
	} catch (Exception e){
            e.printStackTrace();
	}
	return listaTiposTeclado;
    }
}
