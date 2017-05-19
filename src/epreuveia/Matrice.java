/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package epreuveia;

import java.util.ArrayList;

/**
 *
 * @author basti
 */
public class Matrice {
    
    private static int [][] matrice;
    private static String [][] obj;
    private static int length;
    private static int colonnes;
    private static int lignes;
    private static int joueurX;
    private static int joueurY;
    String infoJouers;
    
     public Matrice (String donnees, String numeroJoueur){
        
        String[] parties3 = donnees.split("/"); // coupe en 3 les données: taille, constitution du labyrinthe, info sur les joueurs
        String[] sommet = parties3[1].split("-");
        String[] tailles = parties3[0].split("x"); // coupe en 2 la taille du labyrinthe: largeur, hauteur
         infoJouers = parties3[2];//"3-1,1-11,9-11,1";
            String[] infos = infoJouers.split("-");
            String[] cooJoueur = infos[Integer.parseInt(numeroJoueur) +1].split(",");
            joueurX = Integer.parseInt(cooJoueur[0]);
            joueurY = Integer.parseInt(cooJoueur[1]);
        colonnes=Integer.parseInt(tailles[0]);
        // System.out.println(lignes);
        lignes=Integer.parseInt(tailles[1]);
       //  System.out.println(colonnes);
         obj = new String[lignes][colonnes] ;
        
        
        
        matrice = new int[colonnes*lignes][lignes*colonnes];
        length = lignes*colonnes;
        //lignes = a;
        //colonnes = b;
        
        for(int i=0;i<lignes;i++){
            for(int j=0;j<colonnes;j++){    
                if (i!=0){
                    matrice [sommet(i,j)][sommet(i-1,j)]=1;
                }
                if (i+1<lignes){
                    matrice [sommet(i,j)][sommet(i+1,j)]=1;
                }
                if (j!=0){
                    matrice [sommet(i,j)][sommet(i,j-1)]=1;
                }
                if (j+1<colonnes){
                    matrice [sommet(i,j)][sommet(i,j+1)]=1;
                }
            }
        }
        
        for(int i=0;i<lignes;i++){
            for(int j=0;j<colonnes;j++){
                if (sommet[(i*colonnes)+j] == "D"){
                   matrice[i][j] = 0;
                   matrice[j][i] = 0;
                }
                   
            }
        }
        
    }
     
      private ArrayList<String> listAction(ArrayList<Integer> chemin){
        ArrayList<String> liste = new ArrayList<>();
        for(int i = 1; i < chemin.size(); i++){
            if(chemin.get(i) == chemin.get(i-1)-1){
                liste.add("O");
            }
            else if(chemin.get(i) == chemin.get(i-1)+1){
                liste.add("E");
            }
            else if(chemin.get(i) == chemin.get(i-1)+colonnes){
                liste.add("S");
            }
            else if(chemin.get(i) == chemin.get(i-1)-colonnes){
                liste.add("N");
            }
            else
            {liste.add("C");} 
            
        }
        System.out.println(liste);
        return liste;
        
    }  
    public static int getNbSommets(){
        return length;
    }
    
    public static int[][] getAdjacence(){
        return matrice;
    }
    
    public static int sommet(int i, int j){
        return (i*colonnes)+j;
    }
    public int[] getMoules()
    {
        ArrayList<Integer> moules = new ArrayList();
        for (int i=0; i<lignes;i++)
        {
            for(int j=0; j<colonnes; j++)
            {}
        }
        return null;
    }
    public int getjX(){
        return joueurX;
    }
    
    public int grtjY(){
        return joueurY;
    }
    
    public int getSommetJ(){
        return sommet(joueurX, joueurY);
    }
}
