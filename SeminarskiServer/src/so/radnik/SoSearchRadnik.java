/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.radnik;

import db.DBbroker;
import domain.AbstractDomainObject;
import domain.Radnik;
import java.util.ArrayList;
import java.util.List;
import so.AbstractSO;

/**
 *
 * @author Slobodan
 */
public class SoSearchRadnik extends AbstractSO {

    List<Radnik> radnici;

    public List<Radnik> getRadnik() {
        return radnici;
    }

    @Override
    protected void validate(Object obj) throws Exception {

        AbstractDomainObject ado = (AbstractDomainObject) obj;

        if (ado == null || !(ado instanceof Radnik)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Radnik!");
        }

    }

    @Override
    protected void execute(Object obj) throws Exception {

        AbstractDomainObject ado = (AbstractDomainObject) obj;

        List<AbstractDomainObject> lista = DBbroker.getInstance().selectList(ado);
        radnici = (ArrayList<Radnik>) (ArrayList<?>) lista;

    }
}
