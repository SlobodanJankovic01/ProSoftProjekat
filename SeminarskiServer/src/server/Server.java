/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Slobodan
 */
public class Server {
    
    public void startServer(){
        
        try {
            //Kreiranje soketa
            ServerSocket serverSoket=new ServerSocket(9000);
            System.out.println("Server pokrenut cekam klijenta");
            
            //Cekanje klijenta
            Socket socket= serverSoket.accept();
            System.out.println("Server:Klijent se povezao sa serverom");
            
            
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
