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
public class SoLoadProizvod extends AbstractSO {

    private Proizvod p;

    @Override
    protected void validate(Object obj) throws Exception {

        AbstractDomainObject ado = (AbstractDomainObject) obj;

        if (ado == null || !(ado instanceof Proizvod)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Proizvod!");
        }
    }

    @Override
    protected void execute(Object obj) throws Exception {

        AbstractDomainObject ado = (AbstractDomainObject) obj;

        AbstractDomainObject object;
        object = DBbroker.getInstance().selectObject(ado);
        p = (Proizvod) object;
    }

    public Proizvod getProizvod() {
        return p;
    }
}
