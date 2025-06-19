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
public class SoLoadRadnaSmena extends AbstractSO {

    private RadnaSmena rs;

    @Override
    protected void validate(Object obj) throws Exception {

        AbstractDomainObject ado = (AbstractDomainObject) obj;

        if (ado == null || !(ado instanceof RadnaSmena)) {
            throw new Exception("Prosledjeni objekat nije instanca klase RadnaSmena!");
        }
    }

    @Override
    protected void execute(Object obj) throws Exception {

        AbstractDomainObject ado = (AbstractDomainObject) obj;

        AbstractDomainObject object;
        object = DBbroker.getInstance().selectObject(ado);
        rs = (RadnaSmena) object;
    }

    public RadnaSmena getRadnaSmena() {
        return rs;
    }
}
