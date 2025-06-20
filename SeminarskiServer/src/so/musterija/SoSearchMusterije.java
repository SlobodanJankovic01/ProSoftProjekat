/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.musterija;

import db.DBbroker;
import domain.AbstractDomainObject;
import java.util.ArrayList;
import domain.Musterija;
import java.util.List;
import so.AbstractSO;

/**
 *
 * @author Slobodan
 */
public class SoSearchMusterije extends AbstractSO {

    List<Musterija> musterije;

    public List<Musterija> getMusterija() {
        return musterije;
    }

    @Override
    protected void validate(Object obj) throws Exception {

        AbstractDomainObject ado = (AbstractDomainObject) obj;

        if (ado == null || !(ado instanceof Musterija)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Musterija!");
        }
       
    }

    @Override
    protected void execute(Object obj) throws Exception {

        AbstractDomainObject ado = (AbstractDomainObject) obj;

        List<AbstractDomainObject> lista = DBbroker.getInstance().selectList(ado);
        musterije = (ArrayList<Musterija>) (ArrayList<?>) lista;

    }
}
