/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.porudzbina;

import db.DBbroker;
import domain.AbstractDomainObject;
import domain.Porudzbina;
import so.AbstractSO;

/**
 *
 * @author Slobodan
 */
public class SoAddPorudzbina extends AbstractSO {

    private int id;

    @Override
    protected void validate(Object obj) throws Exception {
        AbstractDomainObject ado = (AbstractDomainObject) obj;

        if (ado == null || !(ado instanceof Porudzbina)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Porudzbina!");
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
