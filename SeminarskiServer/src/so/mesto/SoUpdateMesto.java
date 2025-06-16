/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.mesto;

import db.DBbroker;
import domain.AbstractDomainObject;
import domain.Mesto;
import so.AbstractSO;

/**
 *
 * @author Slobodan
 */
public class SoUpdateMesto extends AbstractSO {

    private int affectedRows;

    public int getAffectedRows() {
        return affectedRows;
    }

    @Override
    protected void validate(Object obj) throws Exception {
        AbstractDomainObject ado = (AbstractDomainObject) obj;
        if (!(ado instanceof Mesto)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Mesto!");
        }
    }

    @Override
    protected void execute(Object obj) throws Exception {
        AbstractDomainObject ado = (AbstractDomainObject) obj;

        affectedRows = DBbroker.getInstance().update(ado);
    }
}
