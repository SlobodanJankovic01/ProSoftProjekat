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
import java.util.List;
import so.mesto.SoAddMesto;
import so.mesto.SoDeleteMesto;
import so.mesto.SoGetListMesto;
import so.mesto.SoSearchMesto;
import so.mesto.SoUpdateMesto;
import so.musterija.SoAddMusterija;
import so.musterija.SoDeleteMusterija;
import so.musterija.SoGetListMusterija;
import so.musterija.SoUpdateMusterija;
import so.porudzbina.SoAddPorudzbina;
import so.porudzbina.SoDeletePorudzbina;
import so.porudzbina.SoGetListPorudzbina;
import so.porudzbina.SoUpdatePorudzbina;
import so.proizvod.SoAddProizvod;
import so.proizvod.SoDeleteProizvod;
import so.proizvod.SoGetListProizvod;
import so.proizvod.SoUpdateProizvod;
import so.radnasmena.SoAddRadnaSmena;
import so.radnasmena.SoDeleteRadnaSmena;
import so.radnasmena.SoGetListRadnaSmena;
import so.radnasmena.SoUpdateRadnaSmena;
import so.radnik.SoAddRadnik;
import so.radnik.SoDeleteRadnik;
import so.radnik.SoGetListRadnik;
import so.radnik.SoUpdateRadnik;
import so.rrs.SoAddRadnikRadnaSmena;
import so.rrs.SoDeleteRadnikRadnaSmena;
import so.rrs.SoGetListRadnikRadnaSmena;
import so.rrs.SoUpdateRadnikRadnaSmena;
import so.stavkaporudzbine.SoAddStavkaPorudzbine;
import so.stavkaporudzbine.SoDeleteStavkaPorudzbine;
import so.stavkaporudzbine.SoGetListStavkaPorudzbine;

/**
 *
 * @author Slobodan
 */
public class ServerKontroler {

    private static ServerKontroler instance;

    public static ServerKontroler getInstance() {

        if (instance == null) {
            instance = new ServerKontroler();
        }
        return instance;
    }

    public List<Mesto> vratiListuSviMesto() throws Exception {
        SoGetListMesto so = new SoGetListMesto();
        so.templateExecute(new Mesto());
        List<Mesto> mesta = so.getGradovi();
        if (mesta.isEmpty()) {
            throw new Exception("Sistem nije uspeo ucita sva mesta");
        }
        return mesta;
    }

    public int kreirajMesto(Mesto m) throws Exception {
        SoAddMesto so = new SoAddMesto();
        so.templateExecute(m);
        int id = so.getId();
        if (id == -1) {
            throw new Exception("Trener nije dodat!!!");
        }
        return id;
    }

    public void obrisiMesto(Mesto mesto) throws Exception {
        SoDeleteMesto so = new SoDeleteMesto();
        so.templateExecute(mesto);
        int affectedRows = so.getAffectedRows();
        if (affectedRows == 0) {
            throw new Exception("Sistem nije uspeo da izbrise mesto");
        }
    }

    public void promeniMesto(Mesto mesto) throws Exception {
        SoUpdateMesto so = new SoUpdateMesto();
        so.templateExecute(mesto);
        int affectedRows = so.getAffectedRows();
        if (affectedRows == 0) {
            throw new Exception("Sistem nije uspeo da izmeni mesto");
        }
    }

    public List<Mesto> pretraziMestoPoGradu(Mesto mesto) throws Exception {
        SoSearchMesto so = new SoSearchMesto();
        so.templateExecute(mesto);
        List<Mesto> mesta = so.getMesta();
        if (mesta.isEmpty()) {
            throw new Exception("Sistem nije uspeo da pronadje mesta po zadatim kriterijumima");
        }
        return mesta;
    }

    public int kreirajProizvod(Proizvod p) throws Exception {
        SoAddProizvod so = new SoAddProizvod();
        so.templateExecute(p);
        int id = so.getId();
        if (id == -1) {
            throw new Exception("Proizvod nije dodat!!!");
        }
        return id;
    }

    public void obrisiProizvod(Proizvod p) throws Exception {
        SoDeleteProizvod so = new SoDeleteProizvod();
        so.templateExecute(p);
        int affectedRows = so.getAffectedRows();
        if (affectedRows == 0) {
            throw new Exception("Sistem nije uspeo da izbrise proizvod");
        }
    }

    public List<Proizvod> vratiListuSviProizvod() throws Exception {
        SoGetListProizvod so = new SoGetListProizvod();
        so.templateExecute(new Proizvod());
        List<Proizvod> proizvodi = so.getProizvodi();
        if (proizvodi.isEmpty()) {
            throw new Exception("Sistem nije uspeo ucita sve proizvode");
        }
        return proizvodi;
    }

    public void promeniProizvod(Proizvod proizvod) throws Exception {
        SoUpdateProizvod so = new SoUpdateProizvod();
        so.templateExecute(proizvod);
        int affectedRows = so.getAffectedRows();
        if (affectedRows == 0) {
            throw new Exception("Sistem nije uspeo da izmeni proizvod");
        }
    }

    public int kreirajMusterija(Musterija musterija) throws Exception {
        SoAddMusterija so = new SoAddMusterija();
        so.templateExecute(musterija);
        int id = so.getId();
        if (id == -1) {
            throw new Exception("Musterija nije dodata!!!");
        }
        return id;
    }

    public List<Musterija> vratiListuSviMusterija() throws Exception {
        SoGetListMusterija so = new SoGetListMusterija();
        so.templateExecute(new Musterija());
        List<Musterija> musterije = so.getMusterije();
        if (musterije.isEmpty()) {
            throw new Exception("Sistem nije uspeo ucita sve musterije");
        }
        return musterije;
    }

    public void obrisiMusterija(Musterija musterija) throws Exception {
        SoDeleteMusterija so = new SoDeleteMusterija();
        so.templateExecute(musterija);
        int affectedRows = so.getAffectedRows();
        if (affectedRows == 0) {
            throw new Exception("Sistem nije uspeo da izbrise musteriju");
        }
    }

    public void promeniMusterija(Musterija musterija) throws Exception {
        SoUpdateMusterija so = new SoUpdateMusterija();
        so.templateExecute(musterija);
        int affectedRows = so.getAffectedRows();
        if (affectedRows == 0) {
            throw new Exception("Sistem nije uspeo da izmeni musteriju");
        }
    }

    public int kreirajRadnik(Radnik radnik) throws Exception {
        SoAddRadnik so = new SoAddRadnik();
        so.templateExecute(radnik);
        int id = so.getId();
        if (id == -1) {
            throw new Exception("Radnik nije dodat!!!");
        }
        return id;
    }

    public void obrisiRadnik(Radnik radnik) throws Exception {
        SoDeleteRadnik so = new SoDeleteRadnik();
        so.templateExecute(radnik);
        int affectedRows = so.getAffectedRows();
        if (affectedRows == 0) {
            throw new Exception("Sistem nije uspeo da izbrise radnika");
        }
    }

    public List<Radnik> vratiListuSviRadnik() throws Exception {
        SoGetListRadnik so = new SoGetListRadnik();
        so.templateExecute(new Radnik());
        List<Radnik> radnici = so.getRadnici();
        if (radnici.isEmpty()) {
            throw new Exception("Sistem nije uspeo ucita sve radnike");
        }
        return radnici;
    }

    public void promeniRadnik(Radnik radnik) throws Exception {
        SoUpdateRadnik so = new SoUpdateRadnik();
        so.templateExecute(radnik);
        int affectedRows = so.getAffectedRows();
        if (affectedRows == 0) {
            throw new Exception("Sistem nije uspeo da izmeni radnika");
        }
    }

    public int kreirajRadnaSmena(RadnaSmena radnaSmena) throws Exception {
        SoAddRadnaSmena so = new SoAddRadnaSmena();
        so.templateExecute(radnaSmena);
        int id = so.getId();
        if (id == -1) {
            throw new Exception("Radna smena nije dodata!!!");
        }
        return id;
    }

    public void obrisiRadnaSmena(RadnaSmena radnaSmena) throws Exception {
        SoDeleteRadnaSmena so = new SoDeleteRadnaSmena();
        so.templateExecute(radnaSmena);
        int affectedRows = so.getAffectedRows();
        if (affectedRows == 0) {
            throw new Exception("Sistem nije uspeo da izbrise radnu smenu");
        }
    }

    public List<RadnaSmena> vratiListuSviRadnaSmena() throws Exception {
        SoGetListRadnaSmena so = new SoGetListRadnaSmena();
        so.templateExecute(new RadnaSmena());
        List<RadnaSmena> radneSmene = so.getRadneSmene();
        if (radneSmene.isEmpty()) {
            throw new Exception("Sistem nije uspeo ucita sve radne smene");
        }
        return radneSmene;
    }

    public void promeniRadnaSmena(RadnaSmena radnaSmena) throws Exception {
        SoUpdateRadnaSmena so = new SoUpdateRadnaSmena();
        so.templateExecute(radnaSmena);
        int affectedRows = so.getAffectedRows();
        if (affectedRows == 0) {
            throw new Exception("Sistem nije uspeo da izmeni radnu smenu");
        }
    }

    public int kreirajRadnikRadnaSmena(RadnikRadnaSmena radnikRadnaSmena) throws Exception {
        SoAddRadnikRadnaSmena so = new SoAddRadnikRadnaSmena();
        so.templateExecute(radnikRadnaSmena);
        int id = so.getId();
        if (id == -1) {
            throw new Exception("Raspored nije azuriran!!!");
        }
        return id;
    }

    public void obrisiRadnikRadnaSmena(RadnikRadnaSmena radnikRadnaSmena) throws Exception {
        SoDeleteRadnikRadnaSmena so = new SoDeleteRadnikRadnaSmena();
        so.templateExecute(radnikRadnaSmena);
        int affectedRows = so.getAffectedRows();
        if (affectedRows == 0) {
            throw new Exception("Sistem nije uspeo da izbrise smenu iz rasporeda");
        }
    }

    public void promeniRadnikRadnaSmena(RadnikRadnaSmena radnikRadnaSmena) throws Exception {
        SoUpdateRadnikRadnaSmena so = new SoUpdateRadnikRadnaSmena();
        so.templateExecute(radnikRadnaSmena);
        int affectedRows = so.getAffectedRows();
        if (affectedRows == 0) {
            throw new Exception("Sistem nije uspeo da izmeni smenu u rasporedu");
        }
    }

    public List<RadnikRadnaSmena> vratiListuSviRadnikRadnaSmena() throws Exception {
        SoGetListRadnikRadnaSmena so = new SoGetListRadnikRadnaSmena();
        so.templateExecute(new RadnikRadnaSmena());
        List<RadnikRadnaSmena> rrs = so.getRrs();
        if (rrs.isEmpty()) {
            throw new Exception("Sistem nije uspeo ucita ceo raspored");
        }
        return rrs;
    }

    public int kreirajStavkaPorudzbine(StavkaPorudzbina stavkaPorudzbina) throws Exception {
        SoAddStavkaPorudzbine so = new SoAddStavkaPorudzbine();
        so.templateExecute(stavkaPorudzbina);
        int id = so.getId();
        if (id == -1) {
            throw new Exception("Stavka porudzbine nije dodata!!!");
        }
        return id;
    }

    public void obrisiStavkaPorudzbine(StavkaPorudzbina stavkaPorudzbina) throws Exception {
        SoDeleteStavkaPorudzbine so = new SoDeleteStavkaPorudzbine();
        so.templateExecute(stavkaPorudzbina);
        int affectedRows = so.getAffectedRows();
        if (affectedRows == 0) {
            throw new Exception("Sistem nije uspeo da izbrise stavku porudzbine.");
        }
    }

    public List<StavkaPorudzbina> vratiListuSviStavkePorudzbine(int i) throws Exception {
        SoGetListStavkaPorudzbine so = new SoGetListStavkaPorudzbine();
        so.templateExecute(new StavkaPorudzbina(i, 0, 0, 0, 0));
        List<StavkaPorudzbina> stavke = so.getStavke();
        if (stavke.isEmpty()) {
            throw new Exception("Sistem nije uspeo da ucita stavke");
        }
        return stavke;
    }

    public int kreirajPorudzbina(Porudzbina porudzbina) throws Exception {
        SoAddPorudzbina so = new SoAddPorudzbina();
        so.templateExecute(porudzbina);
        int id = so.getId();
        if (id == -1) {
            throw new Exception("Porudzbine nije kreirana!!!");
        }
        return id;
    }

    public void promeniPorudzbina(Porudzbina porudzbina) throws Exception {
        SoUpdatePorudzbina so = new SoUpdatePorudzbina();
        so.templateExecute(porudzbina);
        int affectedRows = so.getAffectedRows();
        if (affectedRows == 0) {
            throw new Exception("Sistem nije uspeo da izmeni porudzbinu");
        }
    }

    public void obrisiPorudzbina(Porudzbina porudzbina) throws Exception {
        SoDeletePorudzbina so = new SoDeletePorudzbina();
        so.templateExecute(porudzbina);
        int affectedRows = so.getAffectedRows();
        if (affectedRows == 0) {
            throw new Exception("Sistem nije uspeo da izbrise Porudzbinu.");
        }
    }

    public List<Porudzbina> vratiListuSviPorudzbina() throws Exception {
        SoGetListPorudzbina so = new SoGetListPorudzbina();
        so.templateExecute(new Porudzbina());
        List<Porudzbina> porudzbine = so.getPorudzbine();
        if (porudzbine.isEmpty()) {
            throw new Exception("Sistem nije uspeo da ucita porudzbine");
        }
        return porudzbine;
    }

}
