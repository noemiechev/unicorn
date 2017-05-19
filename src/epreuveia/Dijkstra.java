/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package epreuveia;

import epreuveia.Labyrinthe;
import java.util.ArrayList;

/**
 *
 * @author bv359806
 */
public class Dijkstra {
        
    //Sommet visite ou non
    private boolean[] mark;
    
    //Distance progressivement calculee a partir du sommet de depart
    private int[] d;
    
    //PrÃ©decesseur d'un sommet dans le chemin optimal
    private int[] pi;

    
    public Dijkstra() {
        
        mark = new boolean[Matrice.getNbSommets()];
        d = new int[Matrice.getNbSommets()];
        pi = new int[Matrice.getNbSommets()];
        
    }
    
    
    //-------------
    // Utilitaires
    //-------------
    
    public boolean sommetsNonMarques() {
        boolean b = false;
        
        for (int i = 0; i < Matrice.getNbSommets(); i++) {
            if (mark[i] == false) b = true;
        }
        
        return b;
    }
    
    public int sommetMinimum() {
        
        int temp = 99999+1;
        int tempP = -1;
        
        for (int i = 0; i < Matrice.getNbSommets(); i++){
            
            if (d[i] < temp && mark[i] == false){
                temp = d[i];
                tempP = i;
            }
        }
        return tempP;
        
    }
    
    public ArrayList<Integer> inverserArrayList(ArrayList<Integer> liste) {
        
        ArrayList<Integer> inverse = new ArrayList<>();
        
        for (int i = liste.size()-1; i >= 0; i--) {
            inverse.add(liste.get(i));
        }
        
        return inverse;
    }
    
    //-------------
    // Algorithme
    //-------------
    
    public void initialiser(int sommetDepart) {
        
        for (int i = 0; i < Matrice.getNbSommets(); i++) {
            mark[i] = false;
            pi[i] = -1;
            d[i] = 99999;       
        }
        
        d[sommetDepart] = 0;
        
    }
    
    public void relachement(int depart, int arrivee) {
        
        if ( (d[arrivee] > d[depart] + Matrice.getAdjacence()[depart][arrivee]) && (Matrice.getAdjacence()[depart][arrivee] != 0)) {
            d[arrivee] = d[depart] + Matrice.getAdjacence()[depart][arrivee];
            pi[arrivee] = depart;
        }
        
    }
    
    public void calculer(int depart) {
        initialiser(depart);       
        int a;        
        //Tant qu'il y a des sommets non marques
        while(sommetsNonMarques()) {           
            a = sommetMinimum();            
            mark[a] = true;           
            for (int i = 0; i < Matrice.getNbSommets(); i++) {
                relachement(a,i);
            }           
        } 
        
    }
    
    public ArrayList<Integer> cheminLePlusCourt(int depart, int arrivee) {
        return inverserArrayList(itineraire(depart, arrivee));    
    }
    
    public ArrayList<Integer> itineraire(int x, int y) {
        ArrayList<Integer> itineraire = new ArrayList<>();
        int i = y;
        itineraire.add(y);      
        boolean sortie = false;
        while (!sortie) {
            if (i == x) {
                sortie = true;
            }
            else if (i == -1) {
                itineraire.clear();
                itineraire.add(-1);
                sortie = true;
            }
            else {
                i = pi[i];
                itineraire.add(i);
            }
        }
        return itineraire;
    }

    public int getD(int sommet){
        return d[sommet];
    }
    
}
