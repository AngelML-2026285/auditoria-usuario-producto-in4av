/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package org.josemejia.system.utils;

/**
 *
 * @author informatica
 */
public class Validations {
    
    
    public Validations(){
    
    }
    
    public Boolean validateTextFieldEmpty(String text){
        boolean isEmpty = false;
        
        if(text.isEmpty()== true|| text.isBlank() == true)
            isEmpty = true;
        return isEmpty;
    
    
    }
    
    public Boolean validateTextLength(String text, int textMax){
//        boolean isValid = false;
//        
//        if(text.length() == textMax )
//            isValid = true;
//        if(text.length() < textMax)
//            isValid = true;
//        
//        return isValid;
        return text.length()<= textMax;
    }
    
    public Boolean equalsText(String textOriginal, String textCompare){
        return textOriginal.equals(textCompare);
    
    }
    
    public Boolean validateEmail(String email){
        
        //validar cantidad de puntos
        
        int dotCount = 0;//contar el punto
        for(int index = 0;  index<email.length(); index++){
            if(email.charAt(index) == '.')
                dotCount++;
            if (dotCount >1)
                return false;
        }
        
        
        //Validar cantidad de Arrobas @
        int atSymbolCount = 0;
        for(int atSymbolIndex = 0; atSymbolIndex< email.length(); atSymbolIndex++ )
            if(email.charAt(atSymbolIndex) == '@')
                atSymbolCount++;
            if (atSymbolCount != 1)
                return false;
            
        return true;    
    }
    
    
    
}
