/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.proizvod;

import db.DBbroker;
import domain.AbstractDomainObject;
import domain.Proizvod;
import java.util.ArrayList;
import java.util.List;
import so.AbstractSO;

/**
 *
 * @author Slobodan
 */
public class SoSearchProizvod extends AbstractSO {

    List<Proizvod> proizvodi;

    public List<Proizvod> getProizvod() {
        return proizvodi;
    }

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

        List<AbstractDomainObject> lista = DBbroker.getInstance().selectList(ado);
        proizvodi = (ArrayList<Proizvod>) (ArrayList<?>) lista;

    }
}
