/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package server;

import db.DBbroker;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import niti.Nit;

/**
 *
 * @author Slobodan
 */
public class Server {

    private DBbroker dbb;
    
    
    public Server() {
        dbb = new DBbroker();
    }

    
    public void startServer() {

        try {
            //Kreiranje soketa
            ServerSocket serverSoket = new ServerSocket(9000);
            System.out.println("Server pokrenut cekam klijenta");

            while (true) {
                //Cekanje klijenta
                Socket soket = serverSoket.accept();
                System.out.println("Server:Klijent se povezao sa serverom");
                
                Nit nit=new Nit(soket, dbb);
                new Thread(nit).start();
            }

        } catch (IOException ex) {
            System.out.println("Greska"+ex.getMessage());
        }

    }

}
