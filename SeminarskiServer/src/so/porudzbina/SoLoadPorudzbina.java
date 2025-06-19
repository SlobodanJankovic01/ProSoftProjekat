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
public class SoLoadPorudzbina extends AbstractSO {

    private Porudzbina p;

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

        AbstractDomainObject object;
        object = DBbroker.getInstance().selectObject(ado);
        p = (Porudzbina) object;
    }

    public Porudzbina getPorudzbina() {
        return p;
    }
}
