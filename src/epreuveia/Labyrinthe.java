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
    Joueur joueur = new Joueur();  // a modifier pour ajouter les coordonnee
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

        //pos du joueur
        infoJouers = parties3[2];//"3-1,1-11,9-11,1";
        String[] infos = infoJouers.split("-");
        String[] cooJoueur = infos[Integer.parseInt(numeroJoueur) +1].split(",");
        this.x = Integer.parseInt(cooJoueur[0]);
        this.y = Integer.parseInt(cooJoueur[1]);
        System.out.println("coordonnées du joueur :  x= " +  this.x + " y = " + this.y);
        creerTabJoueur(this.x,this.y,parties3[1]); //changer pos du joueur
        
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
    
    public boolean estValide(int i, int j) {
        return ((i > 0) && (i <= largeur) && (j > 0) && (j <= hauteur));
    }
    
    public int sommet(int i, int j) {
        return (i*largeur)+j;
    }
    
    private void creerTabJoueur(int x, int y, String constitutionLab ) {
        String[][] tableauInit= new String[7][7];
        
        for (int i =0; i<7; i++)
        {
            for (int j =0; j<7; j++)
            {
                tableauInit[i][j] = "_";
            }

        }
        
        String[] laCase= constitutionLab.split("-"); // récupère case par case
        tableauInit[3][3]=laCase[sommet(x, y)];
        if (estValide(x,y-3)) {
            tableauInit[3][0]=laCase[sommet(x, y-3)];
            tableauInit[3][1]=laCase[sommet(x,y-2)];
            tableauInit[3][2]=laCase[sommet(x, y-1)];
        }
            
        if (estValide(x-3,y)) {
            tableauInit[0][3]=laCase[sommet(x-3, y)];
            tableauInit[1][3]=laCase[sommet(x-2, y)];
            tableauInit[2][3]=laCase[sommet(x-1, y)];            
        }
            
        if (estValide(x+3,y)) {
            tableauInit[4][3]=laCase[sommet(x+1, y)];
            tableauInit[5][3]=laCase[sommet(x+2, y)];
            tableauInit[6][3]=laCase[sommet(x+3, y)];
        }
        
        if (estValide(x,y+3)) {
            tableauInit[3][6]=laCase[sommet(x,y+3)];
            tableauInit[3][5]=laCase[sommet(x, y+2)];
            tableauInit[3][4]=laCase[sommet(x, y+1)];
        }
        
        if (estValide(x-1, y-2)) {
            tableauInit[2][1]=laCase[sommet(x-1,y-2)];
            tableauInit[2][2]=laCase[sommet(x-1,y-1)];
        }
        
        if (estValide(x+1,y-2)) {
            tableauInit[4][1]=laCase[sommet(x+1,y-2)];
            tableauInit[4][2]=laCase[sommet(x+1, y-1)];
        }
        
        if (estValide(x-1,y+2)) {
            tableauInit[2][5]=laCase[sommet(x-1, y+2)];       
            tableauInit[2][4]=laCase[sommet(x-1, y+1)];
        }
        
        if (estValide(x+1,y+2)) {
            tableauInit[4][5]=laCase[sommet(x+1, y+2)];
            tableauInit[4][4]=laCase[sommet(x+1, y+1)];
        }
        
        if (estValide(x-2,y-1)){
            tableauInit[1][2]=laCase[sommet(x-2, y-1)];
        }
            
        if (estValide(x-2,y-1)){
            tableauInit[5][2]=laCase[sommet(x+2, y-1)];
        }
             
        if (estValide(x-2,y+1)){
            tableauInit[1][4]=laCase[sommet(x-2, y+1)];
        }
        
        if (estValide(x+2,y+1)) {
            tableauInit[5][4]=laCase[sommet(x+2, y+1)];
        }
        

    }   
    
}
