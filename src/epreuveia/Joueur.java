/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package epreuveia;

import java.io.IOException;
import java.io.PrintStream;

/**
 *
 * @author Armen
 */
public class Joueur {

 
     private int x;
     private int y;
       
     public Joueur(String infoJouers) {
        
    }
     
    /**
     * Donner l'ordre de se deplacer vers le haut
     * @return N
     */
     public String allerHaut()
    {
        return "N";
    }
       
    /**
     * Donner l'ordre de se deplacer vers le bas
     * @return S
    */
    public String allerBas()
    {
        return "S"; 
    }
     
    /**
     * Donner l'ordre de se deplacer vers le droite
     * @return E
     */
    public String allerDroite()
    {
        return "E";
    }
     
    /**
     * Donner l'ordre de se deplacer vers le gauche
     * @return O
     */
    public String allerGauche()
    {
       return "O"; 
    }
    
    /**
     * Donner l'ordre de se rester sur place
     * @return C
     */
    public String waitAndSC()
    {
       return "C"; 
    }    
   
        
}
