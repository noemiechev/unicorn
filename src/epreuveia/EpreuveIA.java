
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package epreuveia;

import java.io.IOException;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Armen
 */
public class EpreuveIA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // 
            String adressIp = "127.0.0.1";
            String nomEquipe = "Equipe 6";
            int port = 1337;
            String infoServ = "";
            String numeroJoueur;
            
            client s = new client(adressIp, port);
            s.envoyerNom(nomEquipe);
            numeroJoueur = s.recuperation(); // recuperer le numero de notre joueur
            

            //Labyrinthe l = new Labyrinthe(s.recuperation(),numeroJoueur ); 
            Matrice m = new Matrice(s.recuperation());

           // Labyrinthe l = new Labyrinthe(s.recuperation(),numeroJoueur ); 


            while(infoServ != "FIN"){
                infoServ = s.recuperation();  // recuperer les info du serveur
                //String infos[] =  infoServ.split("/");
               // System.out.println("Numero du joueur : " + numeroJoueur);
           /*
              s.deplacerJoueur(l.joueur.allerBas());
                System.out.println(l.joueur.allerBas());
              */
           
           s.deplacerJoueur();
                
                // System.out.println(infoServ);
                
            }
        } catch (IOException ex) {
            System.out.println("Connexion au serveur refuséee !!!!!! Lance le serveur ");

        
        }
    
    }
}
