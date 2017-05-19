/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package epreuveia;

/**
 *
 * @author alice
 */
public class Labyrinthe {
    
    private int[][] tableau;
    int largeur;
    int hauteur;
    int x;
    int y;
    String infoJouers;
   
    /**
     * constructeur 
     * @param donnees chaine de caractère donnée
     */
    public Labyrinthe(String donnees, String numeroJoueur){
        String[] parties3 = donnees.split("/"); // coupe en 3 les données: taille, constitution du labyrinthe, info sur les joueurs
        String[] tailles = parties3[0].split("x"); // coupe en 2 la taille du labyrinthe: largeur, hauteur
        largeur=Integer.parseInt(tailles[0]);
        hauteur=Integer.parseInt(tailles[1]);
        System.out.println("l "+largeur);
        System.out.println("h "+hauteur);
        tableau= new int[largeur][hauteur];
        creerMatrice(parties3[1]);
        for (int l = 0; l <largeur; l++) {
            for (int c = 0; c < hauteur; c++) {
                //System.out.print(tableau[l][c]);
            }
        }
        infoJouers = "3-1,1-11,9-11,1";//parties3[2];//"3-1,1-11,9-11,1";
        String[] infos = infoJouers.split("-");
        String[] cooJoueur = infos[Integer.parseInt(numeroJoueur) +1].split(",");
        this.x = Integer.parseInt(cooJoueur[0]);
        this.y = Integer.parseInt(cooJoueur[1]);
        System.out.println("coordonnées du joueur :  x= " +  this.x + " y = " + this.y);
    
        
    }
    
    /**
     * permet de créer la matrice de base
     * @param constitutionLab constitution du labyrinthe
     */
    private void creerMatrice(String constitutionLab){
        int num=0;// numero du sommet
        String[] laCase= constitutionLab.split("-"); // récupère case par case
        for (int l = 0; l <largeur; l++) {
            for (int c = 0; c < hauteur; c++) { 
               if (laCase[num].charAt(0)=='D'){ // bordure
                   tableau[l][c]=0;
               } else{ // sable avec ou sans bonus et ou moule
                   tableau[l][c]=1;     
               }
            num=num+1;
            }
        }
    }
    
}
