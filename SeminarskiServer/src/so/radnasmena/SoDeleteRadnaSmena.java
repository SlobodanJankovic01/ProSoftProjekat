/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.radnasmena;

import db.DBbroker;
import domain.AbstractDomainObject;
import domain.RadnaSmena;
import so.AbstractSO;

/**
 *
 * @author Slobodan
 */
public class SoDeleteRadnaSmena extends AbstractSO {

    int affectedRows;

    public int getAffectedRows() {
        return affectedRows;
    }

    @Override
    protected void validate(Object obj) throws Exception {
        AbstractDomainObject ado = (AbstractDomainObject) obj;

        if (!(ado instanceof RadnaSmena)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Radna smena!");
        }
    }

    @Override
    protected void execute(Object obj) throws Exception {

        AbstractDomainObject ado = (AbstractDomainObject) obj;

        affectedRows = DBbroker.getInstance().delete(ado);
    }
}
