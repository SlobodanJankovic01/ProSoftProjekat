/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.stavkaporudzbine;

import db.DBbroker;
import domain.AbstractDomainObject;
import domain.StavkaPorudzbina;
import so.AbstractSO;

/**
 *
 * @author Slobodan
 */
public class SoDeleteStavkaPorudzbine extends AbstractSO {

    int affectedRows;

    public int getAffectedRows() {
        return affectedRows;
    }

    @Override
    protected void validate(Object obj) throws Exception {
        AbstractDomainObject ado = (AbstractDomainObject) obj;

        if (!(ado instanceof StavkaPorudzbina)) {
            throw new Exception("Prosledjeni objekat nije instanca klase StavkaPorudzbine!");
        }
    }

    @Override
    protected void execute(Object obj) throws Exception {

        AbstractDomainObject ado = (AbstractDomainObject) obj;

        affectedRows = DBbroker.getInstance().delete(ado);
    }
}
