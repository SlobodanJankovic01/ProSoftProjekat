/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.rrs;

import db.DBbroker;
import domain.AbstractDomainObject;
import domain.RadnikRadnaSmena;
import so.AbstractSO;

/**
 *
 * @author Slobodan
 */
public class SoDeleteRadnikRadnaSmena extends AbstractSO {

    int affectedRows;

    public int getAffectedRows() {
        return affectedRows;
    }

    @Override
    protected void validate(Object obj) throws Exception {
        AbstractDomainObject ado = (AbstractDomainObject) obj;

        if (!(ado instanceof RadnikRadnaSmena)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Radnik radna smena!");
        }
    }

    @Override
    protected void execute(Object obj) throws Exception {

        AbstractDomainObject ado = (AbstractDomainObject) obj;

        affectedRows = DBbroker.getInstance().delete(ado);
    }
}
