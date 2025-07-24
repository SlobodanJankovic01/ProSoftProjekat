/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.radnik;

import db.DBbroker;
import domain.AbstractDomainObject;
import domain.Radnik;
import so.AbstractSO;

/**
 *
 * @author Slobodan
 */
public class SoAddRadnik extends AbstractSO{
    
    private int id;

    @Override
    protected void validate(Object obj) throws Exception {
        AbstractDomainObject ado = (AbstractDomainObject) obj;

        if (ado == null || !(ado instanceof Radnik)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Radnik!");
        }
        
        Radnik r = (Radnik) ado;
        
        if (r.getIme().isEmpty() || r.getPrezime().isEmpty() || r.getKorIme().isEmpty()
                || r.getLoznika().isEmpty()) {
            throw new Exception("Niste popunili sva polja!!!");
        }
        
        if (!r.getIme().matches("[a-zA-Z]+")) {
            throw new Exception("Ime nije u dobrom formatu!!!");
        }

        if (!r.getPrezime().matches("[a-zA-Z]+") ) {
            throw new Exception("Prezime nije u dobrom formatu!!!");
        }
        
    }

    @Override
    protected void execute(Object obj) throws Exception {

        AbstractDomainObject ado = (AbstractDomainObject) obj;

        id = DBbroker.getInstance().insert(ado);
    }

    public int getId() {
        return id;
    }
    
}
