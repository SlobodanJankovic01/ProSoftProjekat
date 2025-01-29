/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package server;

import db.DBbroker;
import domain.Proizvod;
import domain.RadnaSmena;
import domain.Radnik;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.time.LocalTime;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import komunikacija.Odgovor;
import komunikacija.Operacija;
import komunikacija.Receiver;
import komunikacija.Sender;
import komunikacija.Zahtev;

/**
 *
 * @author Slobodan
 */
public class Server {

    private DBbroker dbb;
    private Receiver receiver;
    private Sender sender;

    public Server() {
        dbb = new DBbroker();
    }

    public void startServer() {

        try {
            //Kreiranje soketa
            ServerSocket serverSoket = new ServerSocket(9000);
            System.out.println("Server pokrenut cekam klijenta");

            //Cekanje klijenta
            Socket soket = serverSoket.accept();
            System.out.println("Server:Klijent se povezao sa serverom");

            receiver = new Receiver(soket);
            sender = new Sender(soket);

            while (true) {
                try {
                    //citaj zahtev
                    Zahtev zahtev = (Zahtev) receiver.receive();
                    Odgovor odgovor = new Odgovor();

                    Operacija operacija = zahtev.getOperacija();
                    if (operacija == Operacija.LOGIN) {
                        Radnik radnik = (Radnik) zahtev.getArgumenti();
                        try {
                            radnik = dbb.getRadnik(radnik);
                            odgovor.setResult(radnik);
                        } catch (SQLException e) {
                            odgovor.setEx(e);
                        }
                    } else if (operacija == Operacija.VRATI_PROIZVODE) {
                        // Logika za vracanje proizvoda
                        try {
                            List<Proizvod> proizvodi = dbb.vratiListuSviProizvodi();
                            odgovor.setResult(proizvodi);
                        } catch (SQLException e) {
                            odgovor.setEx(e);
                        }
                    } else if(operacija==Operacija.KREIRAJ_PROIZVOD){
                        
                        try {
                            
                            if(dbb.kreirajProizvod((Proizvod)zahtev.getArgumenti())){
                                odgovor.setResult(true);
                            }
                        } catch (SQLException e) {
                            odgovor.setEx(e);
                        }   
                    } else if(operacija==Operacija.KREIRAJ_RADNUSMENU){
                        
                        try {
                            
                            if(dbb.ubaciRadnuSmenu((RadnaSmena) zahtev.getArgumenti())){
                                odgovor.setResult(true);
                            }

                        } catch (Exception e) {
                            odgovor.setEx(e);
                        }
                        
                        
                    }
                    
                    //posalji odgovor
                    sender.send(odgovor);

                } catch (Exception ex) {
                    Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
