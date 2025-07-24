/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.musterija;

import db.DBbroker;
import domain.AbstractDomainObject;
import domain.Musterija;
import so.AbstractSO;

/**
 *
 * @author Slobodan
 */
public class SoUpdateMusterija extends AbstractSO {

    private int affectedRows;

    public int getAffectedRows() {
        return affectedRows;
    }

    @Override
    protected void validate(Object obj) throws Exception {
        AbstractDomainObject ado = (AbstractDomainObject) obj;
        if (!(ado instanceof Musterija)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Musterija!");
        }

        Musterija m = (Musterija) ado;

        if (m.getIme().isEmpty() || m.getPrezime().isEmpty() || m.getBrojTelefona().isEmpty()) {
            throw new Exception("Niste popunili sva polja!!!");
        }

        if (!m.getBrojTelefona().matches("\\d{9,10}")) {
            throw new Exception("Broj telefona nije u ispravnom formatu!!!");
        }

        if (m.getIdMesto() == 0) {
            throw new Exception("Nije popunjeno mesto!!!");
        }
        
        if (!m.getIme().matches("[a-zA-Z]+")) {
            throw new Exception("Ime nije u dobrom formatu!!!");
        }

        if (!m.getPrezime().matches("[a-zA-Z]+") ) {
            throw new Exception("Prezime nije u dobrom formatu!!!");
        }

    }

    @Override
    protected void execute(Object obj) throws Exception {
        AbstractDomainObject ado = (AbstractDomainObject) obj;

        affectedRows = DBbroker.getInstance().update(ado);
    }
}
