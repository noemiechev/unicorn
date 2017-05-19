/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package epreuveia;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

/**
 *
 * @author Administrateur
 */
public class client {
    private int port;
    private String ip;
    private String nom;
    private Socket s;

    public client(String ip, int port) throws IOException {
        this.ip = ip;
        this.port = port;
        this.nom = nom;
        s = new Socket(ip, port);
        
    }
    
    /**
     * 
     * @return
     * @throws IOException 
     */
    public String recuperation() throws IOException
    {
        String res = "" ;
        BufferedReader ed = new BufferedReader(new InputStreamReader(this.s.getInputStream()));
        res = ed.readLine();

        return res;
    }
    
    /**
     * Envoie le nol au serveur 
     * @param nom le nom a envoyer
     * @throws IOException 
     */
    public void envoyerNom(String nom) throws IOException
    {
       PrintStream ps = new PrintStream(this.s.getOutputStream());
       ps.println(nom);  
    }
    
  
}
