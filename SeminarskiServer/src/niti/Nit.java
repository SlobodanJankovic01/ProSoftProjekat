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
import domain.RadnikRadnaSmena;
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
                    } else if (operacija == Operacija.VRATI_MUSTERIJE) {
                        try {
                            List<Musterija> musterije = dbb.vratiListuSviMusterija();
                            odgovor.setResult(musterije);
                        } catch (SQLException e) {
                            odgovor.setEx(e);
                        }
                    } else if (operacija == Operacija.VRATI_RADNESMENE) {
                        try {
                            List<RadnaSmena> radneSmene = dbb.vratiListuSviRadnaSmena();
                            odgovor.setResult(radneSmene);
                        } catch (SQLException e) {
                            odgovor.setEx(e);
                        }
                    } else if (operacija == Operacija.VRATI_RADNIKE) {
                        try {
                            List<Radnik> radnici = dbb.vratiListuSviRadnik();
                            odgovor.setResult(radnici);
                        } catch (SQLException e) {
                            odgovor.setEx(e);
                        }
                    } else if (operacija == Operacija.VRATI_RADNIK_RADNA_SMENA) {
                        try {
                            List<RadnikRadnaSmena> raspored = dbb.vratiListuSviRadnikRadnaSmena();
                            odgovor.setResult(raspored);
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
                    } else if (operacija == Operacija.KREIRAJ_RADNIKA) {
                        try {
                            Radnik r = (Radnik) zahtev.getArgumenti();
                            if (dbb.kreirajRadnik(r)) {
                                odgovor.setResult(true);
                            }
                        } catch (SQLException e) {
                            odgovor.setEx(e);
                        }
                    } else if (operacija == Operacija.KREIRAJ_RADNIK_RADNA_SMENA) {
                        try {
                            RadnikRadnaSmena rrs = (RadnikRadnaSmena) zahtev.getArgumenti();
                            if (dbb.kreirajRadnikRadnaSmena(rrs)) {
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
                    } else if (operacija == Operacija.OBRISI_RADNUSMENU) {
                        try {
                            odgovor.setResult(dbb.obrisiRadnaSmena((int) zahtev.getArgumenti()));
                        } catch (SQLException e) {
                            odgovor.setEx(e);
                        }
                    } else if (operacija == Operacija.OBRISI_PROIZVOD) {
                        try {
                            odgovor.setResult(dbb.obrisiProizvod((int) zahtev.getArgumenti()));
                        } catch (SQLException e) {
                            odgovor.setEx(e);
                        }
                    } else if (operacija == Operacija.OBRISI_MESTO) {
                        try {
                            odgovor.setResult(dbb.obrisiMesto((int) zahtev.getArgumenti()));
                        } catch (SQLException e) {
                            odgovor.setEx(e);
                        }
                    } else if (operacija == Operacija.OBRISI_MUSTERIJU) {
                        try {
                            odgovor.setResult(dbb.obrisiMusteriju((int) zahtev.getArgumenti()));
                        } catch (SQLException e) {
                            odgovor.setEx(e);
                        }
                    } else if (operacija == Operacija.OBRISI_RADNIKA) {
                        try {
                            odgovor.setResult(dbb.obrisiRadnik((int) zahtev.getArgumenti()));
                        } catch (SQLException e) {
                            odgovor.setEx(e);
                        }
                    } else if (operacija == Operacija.OBRISI_RADNIK_RADNA_SMENA) {
                        try {
                            odgovor.setResult(dbb.obrisiRadnikRadnaSmena((int) zahtev.getArgumenti()));
                        } catch (SQLException e) {
                            odgovor.setEx(e);
                        }
                    } else if (operacija == Operacija.PROMENI_PROIZVOD) {
                        try {
                            odgovor.setResult(dbb.promeniProizvod((Proizvod) zahtev.getArgumenti()));
                        } catch (SQLException e) {
                            odgovor.setEx(e);
                        }
                    } else if (operacija == Operacija.PROMENI_MESTO) {
                        try {
                            odgovor.setResult(dbb.promeniMesto((Mesto) zahtev.getArgumenti()));
                        } catch (SQLException e) {
                            odgovor.setEx(e);
                        }
                    } else if (operacija == Operacija.PROMENI_RADNU_SMENU) {
                        try {
                            odgovor.setResult(dbb.promeniRadnuSmenu((RadnaSmena) zahtev.getArgumenti()));
                        } catch (SQLException e) {
                            odgovor.setEx(e);
                        }
                    } else if (operacija == Operacija.PROMENI_RADNIK_RADNA_SMENA) {
                        try {
                            odgovor.setResult(dbb.promeniRadnikRadnaSmena((RadnikRadnaSmena) zahtev.getArgumenti()));
                        } catch (SQLException e) {
                            odgovor.setEx(e);
                        }
                    } else if (operacija == Operacija.PROMENI_MUSTERIJU) {
                        try {
                            odgovor.setResult(dbb.promeniMusteriju((Musterija) zahtev.getArgumenti()));
                        } catch (Exception e) {
                            odgovor.setEx(e);
                        }
                    } else if (operacija == Operacija.PROMENI_RADNIKA) {
                        try {
                            odgovor.setResult(dbb.promeniRadnika((Radnik) zahtev.getArgumenti()));
                        } catch (Exception e) {
                            odgovor.setEx(e);
                        }
                    } else if (operacija == Operacija.PRETRAGA_PROIZVODA) {
                        try {
                            odgovor.setResult(dbb.pretraziProizvod((int) zahtev.getArgumenti()));
                        } catch (Exception e) {
                            odgovor.setEx(e);
                        }
                    } else if (operacija == Operacija.PRETRAGA_MESTA) {
                        try {
                            odgovor.setResult(dbb.pretraziMesto((int) zahtev.getArgumenti()));
                        } catch (Exception e) {
                            odgovor.setEx(e);
                        }
                    } else if (operacija == Operacija.PRETRAGA_MUSTERIJA) {
                        try {
                            odgovor.setResult(dbb.pretraziMusterija((int) zahtev.getArgumenti()));
                        } catch (Exception e) {
                            odgovor.setEx(e);
                        }
                    } else if (operacija == Operacija.PRETRAGA_RADNIH_SMENA) {
                        try {
                            odgovor.setResult(dbb.pretraziRadnaSmena((int) zahtev.getArgumenti()));
                        } catch (Exception e) {
                            odgovor.setEx(e);
                        }
                    } else if (operacija == Operacija.PRETRAGA_RADNIKA) {
                        try {
                            odgovor.setResult(dbb.pretraziRadnik((int) zahtev.getArgumenti()));
                        } catch (Exception e) {
                            odgovor.setEx(e);
                        }
                    } else if (operacija == Operacija.VRATI_MESTA_PO_GRADU) {
                        try {
                            List<Mesto> mesta = dbb.vratiListuMesto((String) zahtev.getArgumenti());
                            odgovor.setResult(mesta);
                        } catch (SQLException e) {
                            odgovor.setEx(e);
                        }
                    } else if (operacija == Operacija.VRATI_MUSTERIJU_PO_IMENU) {
                        try {
                            List<Musterija> musterije = dbb.vratiListuMusterija((String) zahtev.getArgumenti());
                            odgovor.setResult(musterije);
                        } catch (SQLException e) {
                            odgovor.setEx(e);
                        }
                    } else if (operacija == Operacija.VRATI_PROIZVOD_PO_NAZIVU) {
                        try {
                            List<Proizvod> proizvodi = dbb.vratiListuProizvod((String) zahtev.getArgumenti());
                            odgovor.setResult(proizvodi);
                        } catch (SQLException e) {
                            odgovor.setEx(e);
                        }
                    } else if (operacija == Operacija.VRATI_RADNIKE_PO_IMENU) {
                        try {
                            List<Radnik> radnici = dbb.vratiListuRadnik((String) zahtev.getArgumenti());
                            odgovor.setResult(radnici);
                        } catch (SQLException e) {
                            odgovor.setEx(e);
                        }
                    } else if (operacija == Operacija.VRATI_RADNE_SMENE_PO_NAZIVU) {
                        try {
                            List<RadnaSmena> radneSmene = dbb.vratiListuRadnaSmena((String) zahtev.getArgumenti());
                            odgovor.setResult(radneSmene);
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
