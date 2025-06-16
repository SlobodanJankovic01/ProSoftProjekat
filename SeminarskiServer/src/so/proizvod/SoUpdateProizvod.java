/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.proizvod;

import db.DBbroker;
import domain.AbstractDomainObject;
import domain.Proizvod;
import so.AbstractSO;

/**
 *
 * @author Slobodan
 */
public class SoUpdateProizvod extends AbstractSO{
    private int affectedRows;

    public int getAffectedRows() {
        return affectedRows;
    }

    @Override
    protected void validate(Object obj) throws Exception {
        AbstractDomainObject ado = (AbstractDomainObject) obj;
        if (!(ado instanceof Proizvod)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Proizvod!");
        }
    }

    @Override
    protected void execute(Object obj) throws Exception {
        AbstractDomainObject ado = (AbstractDomainObject) obj;

        affectedRows = DBbroker.getInstance().update(ado);
    }
}
