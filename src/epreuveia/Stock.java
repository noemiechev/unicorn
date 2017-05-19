/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package epreuveia;

/**
 *
 * @author Noémie
 */
public class Stock {
    private int nbB; //Le nombre de bières possédées par l'équipe
    private int nbF; //Le nombre de frites possédées par l'équipe
    
    /**
     * 
     * @return le nombre de frites
     */
    public int getFrites() {
        return this.nbF;
    }
    
    /**
     * 
     * @return le nombre de bières
     */
    public int getBieres() {
        return this.nbB;
    }
    
    /**
     * @param s :
     * Si en paramètre 0 = nbFrites -= 1, on utilise une frite
     * Si en paramètre 1 = nbFrites += 1, on gagne une frite
     */
    public void setFrites(int s) {
        this.nbF += s;
    }
    
    /**
     * @param s :
     * Si en paramètre 0 = nbBieres -= 1, on utilise une bière
     * Si en paramètre 1 = nbBieres += 1, on gagne une bière
     */
    public void setBieres(int s) {
        this.nbB += s;
    }
    
}
