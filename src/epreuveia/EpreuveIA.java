/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package epreuveia;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

/**
 *
 * @author Armen
 */
public class EpreuveIA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        //InetAddress ip = new InetAddress();
        client s = new client("127.0.0.1", 1337);
        s.envoyerNom("DeletePackages");
        while(1==1){
            s.recuperation();
            System.out.println(s.recuperation());
        }
    }
    
}
