/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kontroler;

import db.DBbroker;
import domain.Proizvod;
import domain.Radnik;
import java.util.List;

/**
 *
 * @author Slobodan
 */
public class Kontroler {
    
    static Kontroler instance;

    DBbroker dbb;
    
    public Kontroler() {
    
        dbb=new DBbroker();
        
    }

    
    public static Kontroler getInstance() {
        
        if(instance==null){
            instance=new Kontroler();
        }
        
        return instance;
    }

    public List<Radnik> vratiListuSviRadnik() {

        return dbb.vratiListuSviRadnik();
    }

    public void kreirajRadnika(String ime, String prezime, String korIme, String pass) {

        dbb.kreirajRadnika(ime,prezime,korIme,pass);
        
    }

    public List<Proizvod> vratiListuSviProizvodi() {
        return dbb.vratiListuSviProizvodi();
    }

    public boolean kreirajProizvod(String naziv, int cena) {
        
        return dbb.kreirajProizvod(naziv,cena);

    }

    
    
    
    
}
