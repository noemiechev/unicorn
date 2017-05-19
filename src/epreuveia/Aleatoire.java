/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package epreuveia;

import java.util.Random;

/**
 *
 * @author Noémie
 */
public class Aleatoire {
    
    public static String rando() {
        Random random = new Random();
        int alea = random.nextInt(3);
        int i = alea;
        String res;
        
        
        switch (i) {
            case 0 :
                res = "O";
                break;
            case 1 :
                res = "E";
                break;
            case 2 :
                res = "S";
                break;
            default :
                res = "N";
        }
        return res;
    }    
}
