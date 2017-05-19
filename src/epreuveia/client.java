/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package epreuveia;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    
    public String recuperation()
    {
        String res = "" ;
        DataInputStream din ;
        try {
            din = new DataInputStream(s.getInputStream());
            
            din.readUTF();
            System.out.println(din);
        } catch (IOException ex) {
            Logger.getLogger(client.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }
    
    public void envoyerNom(String nom) throws IOException
    {
       PrintStream ps = new PrintStream(this.s.getOutputStream());
       ps.println(nom);
       
       
    }
    
}
