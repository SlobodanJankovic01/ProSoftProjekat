/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package niti;

import db.DBbroker;
import domain.Mesto;
import domain.Musterija;
import domain.Proizvod;
import domain.RadnaSmena;
import domain.Radnik;
import java.io.IOException;
import java.net.Socket;
import java.sql.SQLException;
import java.util.List;
import komunikacija.Odgovor;
import komunikacija.Operacija;
import komunikacija.Receiver;
import komunikacija.Sender;
import komunikacija.Zahtev;

/**
 *
 * @author Slobodan
 */
public class Nit implements Runnable {

    private Socket soket;
    private DBbroker dbb;
    private Receiver receiver;
    private Sender sender;

    public Nit(Socket soket, DBbroker dbb) {
        this.soket = soket;
        this.dbb = dbb;
        receiver = new Receiver(soket);
        sender = new Sender(soket);
    }

    @Override
    public void run() {

        try {
            while (true) {
                try {
                    // Čitaj zahtev
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
                        try {
                            List<Proizvod> proizvodi = dbb.vratiListuSviProizvodi();
                            odgovor.setResult(proizvodi);
                        } catch (SQLException e) {
                            odgovor.setEx(e);
                        }
                    } else if (operacija == Operacija.VRATI_MESTA) {
                        try {
                            List<Mesto> mesta = dbb.vratiListuSviMesto();
                            odgovor.setResult(mesta);
                        } catch (SQLException e) {
                            odgovor.setEx(e);
                        }
                    } else if (operacija == Operacija.KREIRAJ_PROIZVOD) {
                        try {
                            if (dbb.kreirajProizvod((Proizvod) zahtev.getArgumenti())) {
                                odgovor.setResult(true);
                            }
                        } catch (SQLException e) {
                            odgovor.setEx(e);
                        }
                    } else if (operacija == Operacija.KREIRAJ_MESTO) {
                        try {
                            Mesto m = (Mesto) zahtev.getArgumenti();
                            if (dbb.kreirajMesto(m)) {
                                odgovor.setResult(true);
                            }
                        } catch (SQLException e) {
                            odgovor.setEx(e);
                        }
                    } else if (operacija == Operacija.KREIRAJ_MUSTERIJA) {
                        try {
                            Musterija m = (Musterija) zahtev.getArgumenti();
                            if (dbb.kreirajMusterija(m)) {
                                odgovor.setResult(true);
                            }
                        } catch (Exception e) {
                            odgovor.setEx(e);
                        }
                    } else if (operacija == Operacija.KREIRAJ_RADNUSMENU) {
                        try {
                            if (dbb.ubaciRadnuSmenu((RadnaSmena) zahtev.getArgumenti())) {
                                odgovor.setResult(true);
                            }
                        } catch (Exception e) {
                            odgovor.setEx(e);
                        }
                    } else if (operacija == Operacija.VRATI_RADNESMENE) {
                        try {
                            List<RadnaSmena> radneSmene = dbb.vratiListuSviRadnaSmena();
                            odgovor.setResult(radneSmene);
                        } catch (SQLException e) {
                            odgovor.setEx(e);
                        }
                    } else if (operacija == Operacija.OBRISI_RADNUSMENU) {
                        try {
                            odgovor.setResult(dbb.obrisiRadnaSmena((int) zahtev.getArgumenti()));
                        } catch (SQLException e) {
                            odgovor.setEx(e);
                        }
                    }else if (operacija == Operacija.OBRISI_PROIZVOD) {
                        try {
                            odgovor.setResult(dbb.obrisiProizvod((int)zahtev.getArgumenti()));
                        } catch (SQLException e) {
                            odgovor.setEx(e);
                        }
                    }

                    // Pošalji odgovor klijentu
                    sender.send(odgovor);

                } catch (Exception ex) {
                    System.out.println("Greska " + ex.getMessage());
                }
            }
        } finally {
            try {
                soket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
