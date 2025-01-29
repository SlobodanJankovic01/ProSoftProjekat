/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kontroler;

import domain.Proizvod;
import domain.RadnaSmena;
import domain.Radnik;
import java.io.IOException;
import java.net.Socket;
import java.time.LocalTime;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import komunikacija.Odgovor;
import komunikacija.Operacija;
import komunikacija.Receiver;
import komunikacija.Sender;
import komunikacija.Zahtev;

/**
 *
 * @author Slobodan
 */
public class Kontroler {

    static Kontroler instance;
    private final Socket soket;
    private final Sender sender;
    private final Receiver receiver;
    
    
    private Kontroler() throws IOException {
        soket =new Socket("127.0.0.1", 9000);
        sender=new Sender(soket);
        receiver=new Receiver(soket);
    }

    public static Kontroler getInstance() {

        if (instance == null) {
            try {
                instance = new Kontroler();
            } catch (IOException ex) {
                System.out.println("Nije moguce povezivanje klijenta sa serverom");
                Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return instance;
    }

    
    public Radnik prijaviRadnik(Radnik r) throws Exception{
        
        //posalji zahtev
        Zahtev zahtev=new Zahtev(Operacija.LOGIN, r);
        sender.send(zahtev);
        
        //primi odgovor 
        Odgovor odgovor=(Odgovor) receiver.receive();
        if(odgovor.getEx()==null){
            JOptionPane.showMessageDialog(null, "Korisnicko ime i sifra su ispravni");
            return (Radnik)odgovor.getResult();
        }
        
        JOptionPane.showMessageDialog(null, "Radnik sa unetim korisnickim imenom ne postoji!");
        throw new Exception(odgovor.getEx().getMessage());
    }
    
    public List<Proizvod> vratiListuSviProizvodi() throws Exception {
        
        Zahtev zahtev=new Zahtev(Operacija.VRATI_PROIZVODE, null);
        sender.send(zahtev);
        
        Odgovor odgovor=(Odgovor)receiver.receive();
        if(odgovor.getEx()==null){
            return (List<Proizvod>) odgovor.getResult();
        } 
       
        throw new Exception("Neuspelo ucitavanje proizvoda");
        
    }
    
    public boolean kreirajProizvod(String naziv, int cena) throws Exception {
        
        Proizvod p=new Proizvod();
        p.setJedinicnaCena(cena);
        p.setNaziv(naziv);
        
        Zahtev zahtev=new Zahtev(Operacija.KREIRAJ_PROIZVOD,p);
        sender.send(zahtev);
        
        Odgovor odgovor=(Odgovor)receiver.receive();
        if(odgovor.getEx()==null){
            return true;
        }
        
        throw odgovor.getEx();
        
    }
    
    
    public boolean ubaciRadnuSmenu(RadnaSmena rs) throws Exception {
        
        Zahtev zahtev=new Zahtev(Operacija.KREIRAJ_RADNUSMENU, rs);
        sender.send(zahtev);
        
        Odgovor odg=new Odgovor();
        odg=(Odgovor) receiver.receive();
        
        if(odg.getEx()==null){
            return true;
        }
        
        throw odg.getEx();
    }
    
    
    
    

    
    public List<Radnik> vratiListuSviRadnik() {        
        
        //return dbb.vratiListuSviRadnik();
        return null;
    }

    public void kreirajRadnika(String ime, String prezime, String korIme, String pass) {

       // dbb.kreirajRadnika(ime, prezime, korIme, pass);
       
    }

    
    

    

    public List<RadnaSmena> vratiListuSviRadnaSmena() {
        return null;
        //return dbb.vratiListuSviRadnaSmena();
    }

    public boolean obrisiRadnaSmena(int idRadneSmene) {
        return false;
        //return dbb.obrisiRadnaSmena(idRadneSmene);
    }

}
