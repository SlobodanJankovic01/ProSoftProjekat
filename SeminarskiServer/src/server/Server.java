/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package server;

import db.DBbroker;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;
import niti.Nit;

/**
 *
 * @author Slobodan
 */
public class Server {

    private DBbroker dbb;
    private boolean running;
    private ServerSocket serverSoket;
    List<Nit> niti=new ArrayList<>();

    public Server() {
        dbb = DBbroker.getInstance();
    }

    public void startServer() {

        running = true;

        try {
            //Kreiranje soketa
            serverSoket = new ServerSocket(9000);
            System.out.println("Server pokrenut cekam klijenta");

            while (running) {
                //Cekanje klijenta
                try {
                    Socket soket = serverSoket.accept();
                    System.out.println("Server:Klijent se povezao sa serverom");

                    Nit nit = new Nit(soket, dbb);
                    niti.add(nit);
                    new Thread(nit).start();
                } catch (SocketException e) {
                    if (!running) {
                        System.out.println("Server zaustavljen.");
                    } else {
                        e.printStackTrace();
                    }
                }

            }

        } catch (IOException ex) {
            System.out.println("Greska" + ex.getMessage());
        }
    }
    
    public void stopServer() {
        running = false;
        try {
            if (serverSoket != null && !serverSoket.isClosed()) {
                serverSoket.close();
                
                for (Nit nit : niti) {
                    nit.prekiniNit();
                }
                
            }
        } catch (IOException ex) {
            System.out.println("Greška pri zatvaranju server soketa: " + ex.getMessage());
        }
    }
    

}
