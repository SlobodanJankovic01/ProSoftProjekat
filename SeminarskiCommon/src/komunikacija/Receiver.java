/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package komunikacija;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Slobodan
 */
public class Receiver {
    
    private final Socket soket;

    public Receiver(Socket soket) {
        this.soket = soket;
    }
    
    public Object receive() throws Exception{
        ObjectInputStream in;
        try {
            in = new ObjectInputStream(soket.getInputStream());
            return in.readObject();

        } catch (IOException ex) {
            ex.printStackTrace();
            throw new Exception("Greska kod citanja objekta "+ex.getMessage());
        }
    }
    
}
