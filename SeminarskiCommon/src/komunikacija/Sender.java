/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package komunikacija;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 *
 * @author Slobodan
 */
public class Sender {
    
    //Ova klasa sluzi za slanje zahteva korisnika ili odgovora servera 
    //u svakom slucaju salje nesto u soket
    private final Socket soket;
    
    public Sender(Socket soket) {
        this.soket = soket;
    }
    
    public void send(Object objekat) throws Exception{
        
        try {
            ObjectOutputStream out=new ObjectOutputStream(soket.getOutputStream());
            out.writeObject(objekat);
            out.flush();
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new Exception("Greska kod slanja objekta"+ex.getMessage());
        }
        
    }
    
    
}
