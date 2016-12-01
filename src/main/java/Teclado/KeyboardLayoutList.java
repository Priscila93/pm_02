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
public class KeyboardLayoutList {
    private ArrayList<KeyboardLayout> layouts = new ArrayList<>();
    
    //Construtor
    public KeyboardLayoutList(){
    
    }

    //Get da lista de layouts
    public ArrayList<KeyboardLayout> getLayouts() {
        return layouts;
    }

    //Set da lista de layouts
    public void setLayouts(ArrayList<KeyboardLayout> layouts) {
        this.layouts = layouts;
    }

    //Adiciona um novo layout
    public void addLayouts(KeyboardLayout novo_layout){
	if (layouts.isEmpty()){
            layouts = new ArrayList<KeyboardLayout>();
        }
	layouts.add(novo_layout);
    }

    //Procura o teclado pelo nome
    public KeyboardLayout getLayoutByName(String nomeLayout){
	KeyboardLayout layout = new KeyboardLayout();
        
	for (KeyboardLayout keyboardLayout : layouts){
            if (keyboardLayout.getModel().equals(nomeLayout)){
		layout = keyboardLayout;
		return layout;
            }
	}
	return null;
    }

    //Retorna a lista como string
    @Override
    public String toString() {
        return "KeyboardLayoutList{" + "layouts=" + layouts + '}';
    }

}
