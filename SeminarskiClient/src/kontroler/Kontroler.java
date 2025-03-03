/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kontroler;

import domain.Mesto;
import domain.Musterija;
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
        soket = new Socket("127.0.0.1", 9000);
        sender = new Sender(soket);
        receiver = new Receiver(soket);
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

    public Radnik prijaviRadnik(Radnik r) throws Exception {

        //posalji zahtev
        Zahtev zahtev = new Zahtev(Operacija.LOGIN, r);
        sender.send(zahtev);

        //primi odgovor 
        Odgovor odgovor = (Odgovor) receiver.receive();
        if (odgovor.getEx() == null) {
            JOptionPane.showMessageDialog(null, "Korisnicko ime i sifra su ispravni");
            return (Radnik) odgovor.getResult();
        }

        JOptionPane.showMessageDialog(null, "Radnik sa unetim korisnickim imenom ne postoji!");
        throw new Exception(odgovor.getEx().getMessage());
    }

    public List<Proizvod> vratiListuSviProizvodi() throws Exception {

        Zahtev zahtev = new Zahtev(Operacija.VRATI_PROIZVODE, null);
        sender.send(zahtev);

        Odgovor odgovor = (Odgovor) receiver.receive();
        if (odgovor.getEx() == null) {
            return (List<Proizvod>) odgovor.getResult();
        }
        throw new Exception("Neuspelo ucitavanje proizvoda");
    }

    public List<Mesto> vratiListuSviMesta() throws Exception {

        Zahtev z = new Zahtev(Operacija.VRATI_MESTA, null);
        sender.send(z);

        Odgovor odg = (Odgovor) receiver.receive();
        if (odg.getEx() == null) {
            return (List<Mesto>) odg.getResult();
        }

        throw odg.getEx();
    }

    public List<RadnaSmena> vratiListuSviRadnaSmena() throws Exception {

        Zahtev zahtev = new Zahtev(Operacija.VRATI_RADNESMENE, null);
        sender.send(zahtev);

        Odgovor odgovor = (Odgovor) receiver.receive();
        if (odgovor.getEx() == null) {
            return (List<RadnaSmena>) odgovor.getResult();
        }
        throw new Exception("Neuspelo ucitavanje radnih smena");

    }

    public List<Musterija> vratiListuSviMusterija() throws Exception {
        Zahtev zahtev = new Zahtev(Operacija.VRATI_MUSTERIJE, null);
        sender.send(zahtev);

        Odgovor odgovor = (Odgovor) receiver.receive();
        if (odgovor.getEx() == null) {
            return (List<Musterija>) odgovor.getResult();
        }
        throw new Exception("Neuspelo ucitavanje musterija");
    }

    public List<Radnik> vratiListuSviRadnik() throws Exception {
        Zahtev zahtev = new Zahtev(Operacija.VRATI_RADNIKE, null);
        sender.send(zahtev);

        Odgovor odgovor = (Odgovor) receiver.receive();
        if (odgovor.getEx() == null) {
            return (List<Radnik>) odgovor.getResult();
        }
        throw new Exception("Neuspelo ucitavanje radnika");

    }

    public boolean kreirajProizvod(String naziv, int cena) throws Exception {

        Proizvod p = new Proizvod();
        p.setJedinicnaCena(cena);
        p.setNaziv(naziv);

        Zahtev zahtev = new Zahtev(Operacija.KREIRAJ_PROIZVOD, p);
        sender.send(zahtev);

        Odgovor odgovor = (Odgovor) receiver.receive();
        if (odgovor.getEx() == null) {
            return true;
        }

        throw odgovor.getEx();

    }

    public boolean kreirajMesto(Mesto grad) throws Exception {

        Zahtev z = new Zahtev(Operacija.KREIRAJ_MESTO, grad);
        sender.send(z);

        Odgovor odg = (Odgovor) receiver.receive();

        if (odg.getEx() == null) {
            return true;
        }

        throw odg.getEx();
    }

    public boolean kreirajRadnika(Radnik r) throws Exception {
        Zahtev z = new Zahtev(Operacija.KREIRAJ_RADNIKA, r);
        sender.send(z);

        Odgovor odg = (Odgovor) receiver.receive();

        if (odg.getEx() == null) {
            return true;
        }

        throw odg.getEx();
    }

    public boolean kreirajMusterija(Musterija m) throws Exception {

        Zahtev z = new Zahtev(Operacija.KREIRAJ_MUSTERIJA, m);
        sender.send(z);

        Odgovor odg = (Odgovor) receiver.receive();
        if (odg.getEx() == null) {
            return true;
        }

        throw odg.getEx();
    }

    public boolean ubaciRadnuSmenu(RadnaSmena rs) throws Exception {

        Zahtev zahtev = new Zahtev(Operacija.KREIRAJ_RADNUSMENU, rs);
        sender.send(zahtev);

        Odgovor odg = new Odgovor();
        odg = (Odgovor) receiver.receive();

        if (odg.getEx() == null) {
            return true;
        }

        throw odg.getEx();
    }

    public boolean obrisiRadnaSmena(int idRadneSmene) throws Exception {

        Zahtev zahtev = new Zahtev(Operacija.OBRISI_RADNUSMENU, idRadneSmene);
        sender.send(zahtev);

        Odgovor odg = new Odgovor();
        odg = (Odgovor) receiver.receive();

        if (odg.getEx() == null) {
            return true;

        }
        throw odg.getEx();

    }

    public boolean obrisiProizvod(int idProizvoda) throws Exception {

        Zahtev z = new Zahtev(Operacija.OBRISI_PROIZVOD, idProizvoda);
        sender.send(z);

        Odgovor odg = (Odgovor) receiver.receive();
        if (odg.getEx() == null) {
            return true;
        }

        throw odg.getEx();
    }

    public boolean obrisiMesto(int idMesto) throws Exception {

        Zahtev z = new Zahtev(Operacija.OBRISI_MESTO, idMesto);
        sender.send(z);

        Odgovor odg = (Odgovor) receiver.receive();
        if (odg.getEx() == null) {
            return true;
        }

        throw odg.getEx();

    }

    public boolean obrisiMusterija(int idMusterija) throws Exception {
        Zahtev z = new Zahtev(Operacija.OBRISI_MUSTERIJU, idMusterija);
        sender.send(z);

        Odgovor odg = (Odgovor) receiver.receive();
        if (odg.getEx() == null) {
            return true;
        }

        throw odg.getEx();
    }

    public boolean obrisiRadnik(int idRadnika) throws Exception {
        Zahtev z = new Zahtev(Operacija.OBRISI_RADNIKA, idRadnika);
        sender.send(z);

        Odgovor odg = (Odgovor) receiver.receive();
        if (odg.getEx() == null) {
            return true;
        }

        throw odg.getEx();
    }

    public boolean promeniProizvod(Proizvod proizvod) throws Exception {

        Zahtev z = new Zahtev(Operacija.PROMENI_PROIZVOD, proizvod);
        sender.send(z);

        Odgovor odg = (Odgovor) receiver.receive();
        if (odg.getEx() == null) {
            return true;
        }

        throw odg.getEx();

    }

    public boolean promeniMesto(Mesto m) throws Exception {

        Zahtev z = new Zahtev(Operacija.PROMENI_MESTO, m);
        sender.send(z);

        Odgovor odg = (Odgovor) receiver.receive();
        if (odg.getEx() == null) {
            return true;
        }

        throw odg.getEx();
    }

    public boolean promeniRadnuSmenu(RadnaSmena rs) throws Exception {

        Zahtev z = new Zahtev(Operacija.PROMENI_RADNU_SMENU, rs);
        sender.send(z);

        Odgovor odg = (Odgovor) receiver.receive();
        if (odg.getEx() == null) {
            return true;
        }

        throw odg.getEx();

    }

    public void promeniMusterija(Musterija m) throws Exception {
        Zahtev z = new Zahtev(Operacija.PROMENI_MUSTERIJU, m);
        sender.send(z);

        Odgovor odg = (Odgovor) receiver.receive();
        if (odg.getEx() == null) {
            return;
        }

        throw odg.getEx();
    }

    public void promeniRadnika(Radnik r) throws Exception {
        Zahtev z = new Zahtev(Operacija.PROMENI_RADNIKA, r);
        sender.send(z);

        Odgovor odg = (Odgovor) receiver.receive();
        if (odg.getEx() == null) {
            return;
        }

        throw odg.getEx();
    }

    public Proizvod pretraziProizvod(int idProizvoda) throws Exception {
        Zahtev z = new Zahtev(Operacija.PRETRAGA_PROIZVODA, (int) idProizvoda);
        sender.send(z);

        Odgovor odg = (Odgovor) receiver.receive();
        if (odg.getEx() == null) {
            return (Proizvod) odg.getResult();
        }

        throw odg.getEx();
    }

    public Mesto pretraziMesta(int idMesta) throws Exception {
        Zahtev z = new Zahtev(Operacija.PRETRAGA_MESTA, (int) idMesta);
        sender.send(z);

        Odgovor odg = (Odgovor) receiver.receive();
        if (odg.getEx() == null) {
            return (Mesto) odg.getResult();
        }

        throw odg.getEx();
    }

    public Musterija pretraziMusterija(int idMusterije) throws Exception {
        Zahtev z = new Zahtev(Operacija.PRETRAGA_MUSTERIJA, (int) idMusterije);
        sender.send(z);

        Odgovor odg = (Odgovor) receiver.receive();
        if (odg.getEx() == null) {
            return (Musterija) odg.getResult();
        }

        throw odg.getEx();
    }

}
