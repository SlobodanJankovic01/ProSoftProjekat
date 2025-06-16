/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kontroler;

import domain.Mesto;
import domain.Proizvod;
import java.util.List;
import so.mesto.SoAddMesto;
import so.mesto.SoDeleteMesto;
import so.mesto.SoGetListMesto;
import so.mesto.SoSearchMesto;
import so.mesto.SoUpdateMesto;
import so.proizvod.SoAddProizvod;
import so.proizvod.SoDeleteProizvod;
import so.proizvod.SoGetListProizvod;
import so.proizvod.SoUpdateProizvod;

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

}
