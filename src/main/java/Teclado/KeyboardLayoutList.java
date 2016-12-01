
package Teclado;

import java.util.ArrayList;

/**
 *
 *  Classe que guarda a lista dos layouts dos teclados e métodos referentes à essa lista, como: adicionar e procurar pelo nome do layout.
 * 
 *  @author marcella e priscila
 */
public class KeyboardLayoutList
{
    private ArrayList<KeyboardLayout> layouts = new ArrayList<>();
    
    /** 
    *   Construtor
    */
    public KeyboardLayoutList()
    {
    
    }

    /** 
    *   Get da lista de layouts
    */
    public ArrayList<KeyboardLayout> getLayouts()
    {
        return layouts;
    }

    /** 
    *   Set da lista de layouts
    */
    public void setLayouts(ArrayList<KeyboardLayout> layouts)
    {
        this.layouts = layouts;
    }

    /** 
    *   Adiciona um novo layout
    */
    public void addLayouts(KeyboardLayout novo_layout)
    {
	if (layouts.isEmpty())
        {
            layouts = new ArrayList<KeyboardLayout>();
        }
	layouts.add(novo_layout);
    }

    /** 
    *   Procura o teclado pelo nome
    */
    public KeyboardLayout getLayoutByName(String nomeLayout)
    {
	KeyboardLayout layout = new KeyboardLayout();
        
	for (KeyboardLayout keyboardLayout : layouts)
        {
            if (keyboardLayout.getModel().equals(nomeLayout))
            {
		layout = keyboardLayout;
		return layout;
            }
	}
	return null;
    }

    /** 
    *   Retorna a lista como string
    */
    @Override
    public String toString()
    {
        return "KeyboardLayoutList{" + "layouts=" + layouts + '}';
    }

}
