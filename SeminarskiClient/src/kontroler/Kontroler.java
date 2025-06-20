/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kontroler;

import domain.Mesto;
import domain.Musterija;
import domain.Porudzbina;
import domain.Proizvod;
import domain.RadnaSmena;
import domain.Radnik;
import domain.RadnikRadnaSmena;
import domain.StavkaPorudzbina;
import java.io.IOException;
import java.net.Socket;
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

    public List<RadnikRadnaSmena> vratiListuSviRadnikRadnaSmena() throws Exception {

        Zahtev zahtev = new Zahtev(Operacija.VRATI_RADNIK_RADNA_SMENA, null);
        sender.send(zahtev);

        Odgovor odgovor = (Odgovor) receiver.receive();
        if (odgovor.getEx() == null) {
            return (List<RadnikRadnaSmena>) odgovor.getResult();
        }
        throw new Exception("Neuspelo ucitavanje rasporeda");
    }

    public boolean kreirajProizvod(Proizvod p) throws Exception {

        Zahtev zahtev = new Zahtev(Operacija.KREIRAJ_PROIZVOD, p);
        sender.send(zahtev);

        Odgovor odgovor = (Odgovor) receiver.receive();
        if (odgovor.getEx() == null) {
            return true;
        }

        throw odgovor.getEx();

    }

    public boolean kreirajMesto(Mesto mesto) throws Exception {

        Zahtev z = new Zahtev(Operacija.KREIRAJ_MESTO, mesto);
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

    public boolean kreirajRadnikRadnaSmena(RadnikRadnaSmena rrs) throws Exception {
        Zahtev z = new Zahtev(Operacija.KREIRAJ_RADNIK_RADNA_SMENA, rrs);
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

    public boolean obrisiRadnaSmena(RadnaSmena rs) throws Exception {

        Zahtev zahtev = new Zahtev(Operacija.OBRISI_RADNUSMENU, rs);
        sender.send(zahtev);

        Odgovor odg = new Odgovor();
        odg = (Odgovor) receiver.receive();

        if (odg.getEx() == null) {
            return true;

        }
        throw odg.getEx();

    }

    public boolean obrisiRadnikRadnaSmena(RadnikRadnaSmena rrs) throws Exception {
        Zahtev zahtev = new Zahtev(Operacija.OBRISI_RADNIK_RADNA_SMENA, rrs);
        sender.send(zahtev);

        Odgovor odg = (Odgovor) receiver.receive();
        if (odg.getEx() == null) {
            return true;
        }
        throw odg.getEx();
    }

    public boolean obrisiProizvod(Proizvod p) throws Exception {

        Zahtev z = new Zahtev(Operacija.OBRISI_PROIZVOD, p);
        sender.send(z);

        Odgovor odg = (Odgovor) receiver.receive();
        if (odg.getEx() == null) {
            return true;
        }

        throw odg.getEx();
    }

    public boolean obrisiMesto(Mesto mesto) throws Exception {

        Zahtev z = new Zahtev(Operacija.OBRISI_MESTO, mesto);
        sender.send(z);

        Odgovor odg = (Odgovor) receiver.receive();
        if (odg.getEx() == null) {
            return true;
        }

        throw odg.getEx();

    }

    public boolean obrisiMusterija(Musterija m) throws Exception {
        Zahtev z = new Zahtev(Operacija.OBRISI_MUSTERIJU, m);
        sender.send(z);

        Odgovor odg = (Odgovor) receiver.receive();
        if (odg.getEx() == null) {
            return true;
        }

        throw odg.getEx();
    }

    public boolean obrisiRadnik(Radnik r) throws Exception {
        Zahtev z = new Zahtev(Operacija.OBRISI_RADNIKA, r);
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

    public boolean promeniRadnikRadnaSmena(RadnikRadnaSmena rrs) throws Exception {
        Zahtev z = new Zahtev(Operacija.PROMENI_RADNIK_RADNA_SMENA, rrs);
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

    public Proizvod pretraziProizvod(Proizvod p) throws Exception {
        Zahtev z = new Zahtev(Operacija.PRETRAGA_PROIZVODA, p);
        sender.send(z);

        Odgovor odg = (Odgovor) receiver.receive();
        if (odg.getEx() == null) {
            return (Proizvod) odg.getResult();
        }

        throw odg.getEx();
    }

    public Mesto pretraziMesta(Mesto m) throws Exception {
        Zahtev z = new Zahtev(Operacija.PRETRAGA_MESTA, m);
        sender.send(z);

        Odgovor odg = (Odgovor) receiver.receive();
        if (odg.getEx() == null) {
            return (Mesto) odg.getResult();
        }

        throw odg.getEx();
    }

    public Musterija pretraziMusterija(Musterija m) throws Exception {
        Zahtev z = new Zahtev(Operacija.PRETRAGA_MUSTERIJA, m);
        sender.send(z);

        Odgovor odg = (Odgovor) receiver.receive();
        if (odg.getEx() == null) {
            return (Musterija) odg.getResult();
        }

        throw odg.getEx();
    }

    public RadnaSmena pretraziRadnaSmena(RadnaSmena rs) throws Exception {
        Zahtev z = new Zahtev(Operacija.PRETRAGA_RADNIH_SMENA, rs);
        sender.send(z);

        Odgovor odg = (Odgovor) receiver.receive();
        if (odg.getEx() == null) {
            return (RadnaSmena) odg.getResult();
        }

        throw odg.getEx();
    }

    public Radnik pretraziRadnik(Radnik r) throws Exception {
        Zahtev z = new Zahtev(Operacija.PRETRAGA_RADNIKA, r);
        sender.send(z);

        Odgovor odg = (Odgovor) receiver.receive();
        if (odg.getEx() == null) {
            return (Radnik) odg.getResult();
        }

        throw odg.getEx();
    }

    public List<Mesto> vratiListuMesto(Mesto m) throws Exception {
        Zahtev z = new Zahtev(Operacija.VRATI_MESTA_PO_GRADU, m);
        sender.send(z);

        Odgovor odg = (Odgovor) receiver.receive();
        if (odg.getEx() == null) {
            return (List<Mesto>) odg.getResult();
        }

        throw odg.getEx();
    }

    public List<Musterija> vratiListuMusterija(Musterija m) throws Exception {
        Zahtev z = new Zahtev(Operacija.VRATI_MUSTERIJU_PO_KRITERIJUMU, m);
        sender.send(z);

        Odgovor odg = (Odgovor) receiver.receive();
        if (odg.getEx() == null) {
            return (List<Musterija>) odg.getResult();
        }

        throw odg.getEx();
    }

    /*public List<Musterija> vratiListuMusterija(Mesto izabranoMesto) throws Exception {
        Zahtev z = new Zahtev(Operacija.VRATI_MUSTERIJU_PO_MESTU, izabranoMesto);
        sender.send(z);

        Odgovor odg = (Odgovor) receiver.receive();
        if (odg.getEx() == null) {
            return (List<Musterija>) odg.getResult();
        }

        throw odg.getEx();
    }*/

    public List<Proizvod> vratiListuProizvod(Proizvod p) throws Exception {
        Zahtev z = new Zahtev(Operacija.VRATI_PROIZVOD_PO_NAZIVU, p);
        sender.send(z);

        Odgovor odg = (Odgovor) receiver.receive();
        if (odg.getEx() == null) {
            return (List<Proizvod>) odg.getResult();
        }

        throw odg.getEx();
    }

    public List<Radnik> vratiListuRadnik(Radnik r) throws Exception {
        Zahtev z = new Zahtev(Operacija.VRATI_RADNIKE_PO_IMENU, r);
        sender.send(z);

        Odgovor odg = (Odgovor) receiver.receive();
        if (odg.getEx() == null) {
            return (List<Radnik>) odg.getResult();
        }

        throw odg.getEx();
    }

    public List<Radnik> vratiListuRadnik(RadnaSmena rs) throws Exception {
        Zahtev z = new Zahtev(Operacija.VRATI_RADNIKE_PO_SMENI, rs);
        sender.send(z);

        Odgovor odg = (Odgovor) receiver.receive();
        if (odg.getEx() == null) {
            return (List<Radnik>) odg.getResult();
        }

        throw odg.getEx();
    }

    public List<RadnaSmena> vratiListuRadnaSmena(RadnaSmena rs) throws Exception {
        Zahtev z = new Zahtev(Operacija.VRATI_RADNE_SMENE_PO_NAZIVU, rs);
        sender.send(z);

        Odgovor odg = (Odgovor) receiver.receive();
        if (odg.getEx() == null) {
            return (List<RadnaSmena>) odg.getResult();
        }

        throw odg.getEx();
    }

    public int kreirajPorudzbina(Porudzbina p) throws Exception {

        Zahtev z = new Zahtev(Operacija.KREIRAJ_PORUDZBINU, p);
        sender.send(z);

        Odgovor odg = (Odgovor) receiver.receive();

        if (odg.getEx() == null) {
            return (int) odg.getResult();
        }

        throw odg.getEx();

    }

    public void promeniPorudzbina(Porudzbina p) throws Exception {
        Zahtev z = new Zahtev(Operacija.PROMENI_PORUDZBINA, p);
        sender.send(z);

        Odgovor odg = (Odgovor) receiver.receive();
        if (odg.getEx() == null) {
            return;
        }

        throw odg.getEx();
    }

    public void kreirajStavkaPorudzbina(StavkaPorudzbina sp) throws Exception {

        Zahtev z = new Zahtev(Operacija.KREIRAJ_STAVKU_PORUDZBINE, sp);
        sender.send(z);

        Odgovor odg = (Odgovor) receiver.receive();

        if (odg.getEx() == null) {
            return;
        }

        throw odg.getEx();

    }

    public void obrisiStavkaPorudzbine(StavkaPorudzbina stavka) throws Exception {
        Zahtev z = new Zahtev(Operacija.OBRISI_STAVKA_PORUDZBINE, stavka);
        sender.send(z);

        Odgovor odg = (Odgovor) receiver.receive();
        if (odg.getEx() == null) {
            return;
        }

        throw odg.getEx();
    }

    public List<StavkaPorudzbina> vratiListuSviStavkePorudzbine(int idPorudzbine) throws Exception {

        Zahtev z = new Zahtev(Operacija.VRATI_LISTU_STAVKE_PORUDZBINE, idPorudzbine);
        sender.send(z);

        Odgovor odg = (Odgovor) receiver.receive();

        if (odg.getEx() == null) {
            return (List<StavkaPorudzbina>) odg.getResult();
        }

        throw odg.getEx();

    }

    public List<Porudzbina> vratiListuSviPorudzbina() throws Exception {

        Zahtev z = new Zahtev(Operacija.VRATI_LISTU_SVE_PORUDZBINE, null);
        sender.send(z);

        Odgovor odg = (Odgovor) receiver.receive();

        if (odg.getEx() == null) {
            return (List<Porudzbina>) odg.getResult();
        }

        throw odg.getEx();
    }

    public void obrisiPorudzbina(Porudzbina p) throws Exception {

        Zahtev z = new Zahtev(Operacija.OBRISI_PORUDZBINA, p);
        sender.send(z);

        Odgovor odg = (Odgovor) receiver.receive();
        if (odg.getEx() == null) {
            return;
        }

        throw odg.getEx();

    }

    public Porudzbina pretraziPorudzbina(Porudzbina p) throws Exception {
        Zahtev z = new Zahtev(Operacija.PRETRAGA_PORUDZBINA, p);
        sender.send(z);

        Odgovor odg = (Odgovor) receiver.receive();
        if (odg.getEx() == null) {
            return (Porudzbina) odg.getResult();
        }

        throw odg.getEx();
    }

    public List<Porudzbina> vratiListuPorudzbinaPoKriterijumu(Porudzbina p) throws Exception {
        Zahtev z = new Zahtev(Operacija.VRATI_LISTU_PORUDZBINE_PO_KRITERIJUMU, (Porudzbina) p);
        sender.send(z);

        Odgovor odg = (Odgovor) receiver.receive();
        if (odg.getEx() == null) {
            return (List<Porudzbina>) odg.getResult();
        }

        throw odg.getEx();
    }


    public List<Porudzbina> vratiListuPorudzbina(Proizvod p) throws Exception {
        Zahtev z = new Zahtev(Operacija.VRATI_LISTU_PORUDZBINE_PO_PROIZVODU, (Proizvod) p);
        sender.send(z);

        Odgovor odg = (Odgovor) receiver.receive();
        if (odg.getEx() == null) {
            return (List<Porudzbina>) odg.getResult();
        }

        throw odg.getEx();
    }

    /*public List<Porudzbina> vratiListuPorudzbina(String nacinIsporuke) throws Exception {
        Zahtev z = new Zahtev(Operacija.VRATI_LISTU_PORUDZBINE_PO_NACINU_ISPORUKE, (String) nacinIsporuke);
        sender.send(z);

        Odgovor odg = (Odgovor) receiver.receive();
        if (odg.getEx() == null) {
            return (List<Porudzbina>) odg.getResult();
        }

        throw odg.getEx();
    }*/
    
   /* public List<Porudzbina> vratiListuPorudzbina(Radnik r) throws Exception {
        Zahtev z = new Zahtev(Operacija.VRATI_LISTU_PORUDZBINE_PO_RADNIKU, (Radnik) r);
        sender.send(z);

        Odgovor odg = (Odgovor) receiver.receive();
        if (odg.getEx() == null) {
            return (List<Porudzbina>) odg.getResult();
        }

        throw odg.getEx();
    }*/

}
