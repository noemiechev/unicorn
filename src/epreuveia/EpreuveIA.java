
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package epreuveia;

import java.io.IOException;
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
            numeroJoueur = s.recuperation();
            Labyrinthe l = new Labyrinthe(s.recuperation(),numeroJoueur ); 

            while(infoServ != "FIN"){
                infoServ = s.recuperation();  // recuperer les info du serveur
                String infos[] =  infoServ.split("/");
                System.out.println("Numero du joueur : " + numeroJoueur);
                
                if (!infoServ.equals("FIN")){
                    System.out.println("" + infos[0]);
                    System.out.println("" + infos[1]);
                    System.out.println("" + infos[2]);
                }
                // System.out.println(infoServ);
                
            }
        } catch (IOException ex) {
            System.out.println("Connexion au serveur refuséee !!!!!! Lance le serveur ");

        
        }
    
    }
}
