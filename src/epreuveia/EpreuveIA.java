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
            String nomEquipe = "127.0.0.1";
            String infoServ = "";
            String numeroJoueur;
            client s = new client(nomEquipe, 1337);
            s.envoyerNom("DeletePackages");
            
            numeroJoueur = s.recuperation();

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
