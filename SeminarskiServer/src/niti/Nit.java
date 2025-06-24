/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package niti;

import db.DBbroker;
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
import java.sql.SQLException;
import java.util.List;
import komunikacija.Odgovor;
import komunikacija.Operacija;
import static komunikacija.Operacija.KREIRAJ_MUSTERIJA;
import static komunikacija.Operacija.KREIRAJ_PORUDZBINU;
import static komunikacija.Operacija.KREIRAJ_PROIZVOD;
import static komunikacija.Operacija.KREIRAJ_RADNIKA;
import static komunikacija.Operacija.KREIRAJ_RADNIK_RADNA_SMENA;
import static komunikacija.Operacija.KREIRAJ_RADNUSMENU;
import static komunikacija.Operacija.KREIRAJ_STAVKU_PORUDZBINE;
import static komunikacija.Operacija.OBRISI_MESTO;
import static komunikacija.Operacija.OBRISI_MUSTERIJU;
import static komunikacija.Operacija.OBRISI_PORUDZBINA;
import static komunikacija.Operacija.OBRISI_PROIZVOD;
import static komunikacija.Operacija.OBRISI_RADNIKA;
import static komunikacija.Operacija.OBRISI_RADNIK_RADNA_SMENA;
import static komunikacija.Operacija.OBRISI_RADNUSMENU;
import static komunikacija.Operacija.OBRISI_STAVKA_PORUDZBINE;
import static komunikacija.Operacija.PRETRAGA_MESTA;
import static komunikacija.Operacija.PRETRAGA_MUSTERIJA;
import static komunikacija.Operacija.PRETRAGA_PORUDZBINA;
import static komunikacija.Operacija.PRETRAGA_PROIZVODA;
import static komunikacija.Operacija.PRETRAGA_RADNIH_SMENA;
import static komunikacija.Operacija.PRETRAGA_RADNIKA;
import static komunikacija.Operacija.PROMENI_MESTO;
import static komunikacija.Operacija.PROMENI_MUSTERIJU;
import static komunikacija.Operacija.PROMENI_PORUDZBINA;
import static komunikacija.Operacija.PROMENI_PROIZVOD;
import static komunikacija.Operacija.PROMENI_RADNIKA;
import static komunikacija.Operacija.PROMENI_RADNIK_RADNA_SMENA;
import static komunikacija.Operacija.PROMENI_RADNU_SMENU;
import static komunikacija.Operacija.VRATI_LISTU_PORUDZBINE_PO_KRITERIJUMU;
import static komunikacija.Operacija.VRATI_LISTU_STAVKE_PORUDZBINE;
import static komunikacija.Operacija.VRATI_LISTU_SVE_PORUDZBINE;
import static komunikacija.Operacija.VRATI_MESTA;
import static komunikacija.Operacija.VRATI_MESTA_PO_GRADU;
import static komunikacija.Operacija.VRATI_MUSTERIJE;
import static komunikacija.Operacija.VRATI_MUSTERIJU_PO_KRITERIJUMU;
import static komunikacija.Operacija.VRATI_PROIZVODE;
import static komunikacija.Operacija.VRATI_PROIZVOD_PO_NAZIVU;
import static komunikacija.Operacija.VRATI_RADNESMENE;
import static komunikacija.Operacija.VRATI_RADNE_SMENE_PO_NAZIVU;
import static komunikacija.Operacija.VRATI_RADNIKE;
import static komunikacija.Operacija.VRATI_RADNIKE_PO_IMENU;
import static komunikacija.Operacija.VRATI_RADNIK_RADNA_SMENA;
import komunikacija.Receiver;
import komunikacija.Sender;
import komunikacija.Zahtev;
import kontroler.ServerKontroler;

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
                    switch (operacija) {
                        case LOGIN: {
                            Radnik radnik = (Radnik) zahtev.getArgumenti();
                            try {
                                radnik = ServerKontroler.getInstance().getRadnik(radnik);
                                odgovor.setResult(radnik);
                            } catch (SQLException e) {
                                odgovor.setEx(e);
                            }
                            break;
                        }
                        ////
                        case KREIRAJ_MESTO: {
                            try {
                                Mesto m = (Mesto) zahtev.getArgumenti();
                                if (ServerKontroler.getInstance().kreirajMesto(m) != -1) {
                                    odgovor.setResult(true);
                                }
                            } catch (Exception e) {
                                odgovor.setEx(e);
                            }
                            break;
                        }
                        case KREIRAJ_PROIZVOD: {
                            try {
                                if (ServerKontroler.getInstance().kreirajProizvod((Proizvod) zahtev.getArgumenti()) != -1) {
                                    odgovor.setResult(true);
                                }
                            } catch (Exception e) {
                                odgovor.setEx(e);
                            }
                            break;
                        }
                        case KREIRAJ_MUSTERIJA: {
                            try {
                                if (ServerKontroler.getInstance().kreirajMusterija((Musterija) zahtev.getArgumenti()) != -1) {
                                    odgovor.setResult(true);
                                }
                            } catch (Exception e) {
                                odgovor.setEx(e);
                            }
                            break;
                        }
                        case KREIRAJ_RADNIKA: {
                            try {
                                if (ServerKontroler.getInstance().kreirajRadnik((Radnik) zahtev.getArgumenti()) != -1) {
                                    odgovor.setResult(true);
                                }
                            } catch (Exception e) {
                                odgovor.setEx(e);
                            }
                            break;
                        }
                        case KREIRAJ_RADNUSMENU: {
                            try {
                                if (ServerKontroler.getInstance().kreirajRadnaSmena((RadnaSmena) zahtev.getArgumenti()) != -1) {
                                    odgovor.setResult(true);
                                }
                            } catch (Exception e) {
                                odgovor.setEx(e);
                            }
                            break;
                        }
                        case KREIRAJ_RADNIK_RADNA_SMENA: {
                            try {
                                if (ServerKontroler.getInstance().kreirajRadnikRadnaSmena((RadnikRadnaSmena) zahtev.getArgumenti()) != -1) {
                                    odgovor.setResult(true);
                                }
                            } catch (SQLException e) {
                                odgovor.setEx(e);
                            }
                            break;
                        }
                        case KREIRAJ_STAVKU_PORUDZBINE: {
                            try {
                                if (ServerKontroler.getInstance().kreirajStavkaPorudzbine((StavkaPorudzbina) zahtev.getArgumenti()) != -1) {
                                    odgovor.setResult(true);
                                }
                            } catch (SQLException e) {
                                odgovor.setEx(e);
                            }
                            break;
                        }
                        case KREIRAJ_PORUDZBINU: {
                            try {
                                int idPorudzbine = ServerKontroler.getInstance().kreirajPorudzbina((Porudzbina) zahtev.getArgumenti());
                                if (idPorudzbine != -1) {
                                    odgovor.setResult(idPorudzbine);
                                }
                            } catch (Exception e) {
                                odgovor.setEx(e);
                            }
                            break;
                        }
                        case OBRISI_PROIZVOD: {
                            try {
                                ServerKontroler.getInstance().obrisiProizvod((Proizvod) zahtev.getArgumenti());
                            } catch (SQLException e) {
                                odgovor.setEx(e);
                            }
                            break;
                        }
                        case OBRISI_MESTO: {
                            try {
                                ServerKontroler.getInstance().obrisiMesto((Mesto) zahtev.getArgumenti());
                                odgovor.setResult(true);

                            } catch (Exception e) {
                                odgovor.setEx(e);
                            }
                            break;
                        }
                        case OBRISI_MUSTERIJU: {
                            try {
                                ServerKontroler.getInstance().obrisiMusterija((Musterija) zahtev.getArgumenti());
                                odgovor.setResult(true);
                            } catch (Exception e) {
                                odgovor.setEx(e);
                            }
                            break;
                        }
                        case OBRISI_RADNIKA: {
                            try {
                                ServerKontroler.getInstance().obrisiRadnik((Radnik) zahtev.getArgumenti());
                                odgovor.setResult(true);
                            } catch (SQLException e) {
                                odgovor.setEx(e);
                            }
                            break;
                        }
                        case OBRISI_RADNUSMENU: {
                            try {
                                ServerKontroler.getInstance().obrisiRadnaSmena((RadnaSmena) zahtev.getArgumenti());
                                odgovor.setResult(true);
                            } catch (SQLException e) {
                                odgovor.setEx(e);
                            }
                            break;
                        }
                        case OBRISI_RADNIK_RADNA_SMENA: {
                            try {
                                ServerKontroler.getInstance().obrisiRadnikRadnaSmena((RadnikRadnaSmena) zahtev.getArgumenti());
                                odgovor.setResult(true);
                            } catch (SQLException e) {
                                odgovor.setEx(e);
                            }
                            break;
                        }
                        case OBRISI_STAVKA_PORUDZBINE: {
                            try {
                                ServerKontroler.getInstance().obrisiStavkaPorudzbine((StavkaPorudzbina) zahtev.getArgumenti());
                                odgovor.setResult(true);
                            } catch (Exception e) {
                                odgovor.setEx(e);
                            }
                            break;
                        }
                        case OBRISI_PORUDZBINA: {
                            try {
                                ServerKontroler.getInstance().obrisiPorudzbina((Porudzbina) zahtev.getArgumenti());
                                odgovor.setResult(true);
                            } catch (Exception e) {
                                odgovor.setEx(e);
                            }
                            break;
                        }
                        case PROMENI_MESTO: {
                            try {
                                ServerKontroler.getInstance().promeniMesto((Mesto) zahtev.getArgumenti());
                                odgovor.setResult(true);
                            } catch (Exception e) {
                                odgovor.setEx(e);
                            }
                            break;
                        }
                        case PROMENI_PROIZVOD: {
                            try {
                                ServerKontroler.getInstance().promeniProizvod((Proizvod) zahtev.getArgumenti());
                                odgovor.setResult(true);
                            } catch (Exception e) {
                                odgovor.setEx(e);
                            }
                            break;
                        }
                        case PROMENI_MUSTERIJU: {
                            try {
                                ServerKontroler.getInstance().promeniMusterija((Musterija) zahtev.getArgumenti());
                                odgovor.setResult(true);
                            } catch (Exception e) {
                                odgovor.setEx(e);
                            }
                            break;
                        }
                        case PROMENI_RADNIKA: {
                            try {
                                ServerKontroler.getInstance().promeniRadnik((Radnik) zahtev.getArgumenti());
                                odgovor.setResult(true);
                            } catch (Exception e) {
                                odgovor.setEx(e);
                            }
                            break;
                        }
                        case PROMENI_RADNU_SMENU: {
                            try {
                                ServerKontroler.getInstance().promeniRadnaSmena((RadnaSmena) zahtev.getArgumenti());
                                odgovor.setResult(true);
                            } catch (SQLException e) {
                                odgovor.setEx(e);
                            }
                            break;
                        }
                        case PROMENI_RADNIK_RADNA_SMENA: {
                            try {
                                ServerKontroler.getInstance().promeniRadnikRadnaSmena((RadnikRadnaSmena) zahtev.getArgumenti());
                                odgovor.setResult(true);
                            } catch (SQLException e) {
                                odgovor.setEx(e);
                            }
                            break;
                        }
                        case PROMENI_PORUDZBINA: {
                            try {
                                ServerKontroler.getInstance().promeniPorudzbina((Porudzbina) zahtev.getArgumenti());
                                odgovor.setResult(true);
                            } catch (SQLException e) {
                                odgovor.setEx(e);
                            }
                            break;
                        }
                        case PRETRAGA_MESTA: {
                            try {
                                Mesto m = ServerKontroler.getInstance().pretraziMestoPoId((Mesto) zahtev.getArgumenti());
                                odgovor.setResult(m);
                            } catch (Exception e) {
                                odgovor.setEx(e);
                            }
                            break;
                        }
                        case PRETRAGA_PROIZVODA: {
                            try {
                                Proizvod p = ServerKontroler.getInstance().pretraziProizvodPoId((Proizvod) zahtev.getArgumenti());
                                odgovor.setResult(p);
                            } catch (Exception e) {
                                odgovor.setEx(e);
                            }
                            break;
                        }
                        case PRETRAGA_MUSTERIJA: {
                            try {
                                Musterija m = ServerKontroler.getInstance().pretraziMusterijuPoId((Musterija) zahtev.getArgumenti());
                                odgovor.setResult(m);
                            } catch (Exception e) {
                                odgovor.setEx(e);
                            }
                            break;
                        }
                        case PRETRAGA_RADNIKA: {
                            try {
                                Radnik r = ServerKontroler.getInstance().pretraziRadnikaPoId((Radnik) zahtev.getArgumenti());
                                odgovor.setResult(r);
                            } catch (Exception e) {
                                odgovor.setEx(e);
                            }
                            break;
                        }
                        case PRETRAGA_RADNIH_SMENA: {
                            try {
                                RadnaSmena rs = ServerKontroler.getInstance().pretraziRadnuSmenuPoId((RadnaSmena) zahtev.getArgumenti());
                                odgovor.setResult(rs);
                            } catch (Exception e) {
                                odgovor.setEx(e);
                            }
                            break;
                        }
                        case PRETRAGA_PORUDZBINA: {
                            try {
                                Porudzbina p = ServerKontroler.getInstance().pretraziPorudzbinuPoId((Porudzbina) zahtev.getArgumenti());
                                odgovor.setResult(p);
                            } catch (Exception e) {
                                odgovor.setEx(e);
                            }
                            break;
                        }
                        case VRATI_MESTA: {
                            try {
                                List<Mesto> mesta = ServerKontroler.getInstance().vratiListuSviMesto();
                                odgovor.setResult(mesta);
                            } catch (SQLException e) {
                                odgovor.setEx(e);
                            }
                            break;
                        }
                        case VRATI_PROIZVODE: {
                            try {
                                List<Proizvod> proizvodi = ServerKontroler.getInstance().vratiListuSviProizvod();
                                odgovor.setResult(proizvodi);
                            } catch (Exception e) {
                                odgovor.setEx(e);
                            }
                            break;
                        }
                        case VRATI_MUSTERIJE: {
                            try {
                                List<Musterija> musterije = ServerKontroler.getInstance().vratiListuSviMusterija();
                                odgovor.setResult(musterije);
                            } catch (Exception e) {
                                odgovor.setEx(e);
                            }
                            break;
                        }
                        case VRATI_RADNIKE: {
                            try {
                                List<Radnik> radnici = ServerKontroler.getInstance().vratiListuSviRadnik();
                                odgovor.setResult(radnici);
                            } catch (Exception e) {
                                odgovor.setEx(e);
                            }
                            break;
                        }
                        case VRATI_RADNESMENE: {
                            try {
                                List<RadnaSmena> radneSmene = ServerKontroler.getInstance().vratiListuSviRadnaSmena();
                                odgovor.setResult(radneSmene);
                            } catch (SQLException e) {
                                odgovor.setEx(e);
                            }
                            break;
                        }
                        case VRATI_RADNIK_RADNA_SMENA: {
                            try {
                                List<RadnikRadnaSmena> raspored = ServerKontroler.getInstance().vratiListuSviRadnikRadnaSmena();
                                odgovor.setResult(raspored);
                            } catch (SQLException e) {
                                odgovor.setEx(e);
                            }
                            break;
                        }
                        case VRATI_LISTU_STAVKE_PORUDZBINE: {
                            try {
                                List<StavkaPorudzbina> stavke = ServerKontroler.getInstance().vratiListuSviStavkePorudzbine((int) zahtev.getArgumenti());
                                odgovor.setResult(stavke);
                            } catch (Exception e) {
                                odgovor.setEx(e);
                            }
                            break;
                        }
                        case VRATI_LISTU_SVE_PORUDZBINE: {
                            try {
                                List<Porudzbina> porudzbine = ServerKontroler.getInstance().vratiListuSviPorudzbina();
                                odgovor.setResult(porudzbine);
                            } catch (SQLException e) {
                                odgovor.setEx(e);
                            }
                            break;
                        }
                        case VRATI_MESTA_PO_GRADU: {
                            try {
                                List<Mesto> mesta = ServerKontroler.getInstance().pretraziMestoPoGradu((Mesto) zahtev.getArgumenti());
                                odgovor.setResult(mesta);
                            } catch (SQLException e) {
                                odgovor.setEx(e);
                            }
                            break;
                        }
                        case VRATI_PROIZVOD_PO_NAZIVU: {
                            try {
                                List<Proizvod> proizvodi = ServerKontroler.getInstance().pretraziProizvodPoNazivu((Proizvod) zahtev.getArgumenti());
                                odgovor.setResult(proizvodi);
                            } catch (Exception e) {
                                odgovor.setEx(e);
                            }
                            break;
                        }
                        case VRATI_RADNIKE_PO_IMENU: {
                            try {
                                List<Radnik> radnici = ServerKontroler.getInstance().pretraziRadnikePoImenu((Radnik) zahtev.getArgumenti());
                                odgovor.setResult(radnici);
                            } catch (Exception e) {
                                odgovor.setEx(e);
                            }
                            break;
                        }
                        case VRATI_RADNE_SMENE_PO_NAZIVU: {
                            try {
                                List<RadnaSmena> radneSmene = ServerKontroler.getInstance().pretraziRadneSmenePoNazivu((RadnaSmena) zahtev.getArgumenti());
                                odgovor.setResult(radneSmene);
                            } catch (Exception e) {
                                odgovor.setEx(e);
                            }
                            break;
                        }
                        case VRATI_MUSTERIJU_PO_KRITERIJUMU: {
                            try {
                                List<Musterija> musterije = ServerKontroler.getInstance().vratiListuSveMusterijePoKriterijumu((Musterija) zahtev.getArgumenti());
                                odgovor.setResult(musterije);
                            } catch (Exception e) {
                                odgovor.setEx(e);
                            }
                            break;
                        }
                        case VRATI_LISTU_PORUDZBINE_PO_KRITERIJUMU: {
                            try {
                                List<Porudzbina> porudzbine = ServerKontroler.getInstance().vratiListuSvePorudzbinePoKriterijumu((Porudzbina) zahtev.getArgumenti());
                                odgovor.setResult(porudzbine);
                            } catch (Exception e) {
                                odgovor.setEx(e);
                            }
                            break;
                        }
                        ///////
                        
                        case VRATI_RADNIKE_PO_SMENI: {
                            try {
                                List<Radnik> radnici = dbb.vratiListuRadnikPoSmeni((RadnaSmena) zahtev.getArgumenti());
                                odgovor.setResult(radnici);
                            } catch (SQLException e) {
                                odgovor.setEx(e);
                            }
                            break;
                        }
                        case VRATI_LISTU_PORUDZBINE_PO_PROIZVODU: {
                            try {
                                List<Porudzbina> porudzbine = dbb.vratiListuPorudzbinaPoProizvodu((Proizvod) zahtev.getArgumenti());
                                odgovor.setResult(porudzbine);
                            } catch (SQLException e) {
                                odgovor.setEx(e);
                            }
                            break;
                        }
                        /*case VRATI_LISTU_PORUDZBINE_PO_NACINU_ISPORUKE: {
                            try {
                                List<Porudzbina> porudzbine = dbb.vratiListuPorudzbinaPoNacinuIsporuke((String) zahtev.getArgumenti());
                                odgovor.setResult(porudzbine);
                            } catch (SQLException e) {
                                odgovor.setEx(e);
                            }
                            break;
                        }*/

                        /*case VRATI_MUSTERIJU_PO_MESTU: {
                            try {
                                List<Musterija> musterije = dbb.vratiListuMusterijaMesto((Mesto) zahtev.getArgumenti());
                                odgovor.setResult(musterije);
                            } catch (SQLException e) {
                                odgovor.setEx(e);
                            }
                            break;
                        }*/
                        /*case VRATI_LISTU_PORUDZBINE_PO_RADNIKU: {
                            try {
                                List<Porudzbina> porudzbine = dbb.vratiListuPorudzbinaPoRadniku((Radnik) zahtev.getArgumenti());
                                odgovor.setResult(porudzbine);
                            } catch (SQLException e) {
                                odgovor.setEx(e);
                            }
                            break;
                        }*/
                        default: {
                            odgovor.setEx(new UnsupportedOperationException("Nepoznata operacija: " + operacija));
                        }
                    }

                    // Slanje odgovora klijentu
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
