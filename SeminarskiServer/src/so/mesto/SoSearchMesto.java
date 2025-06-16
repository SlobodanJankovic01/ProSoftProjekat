/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.mesto;

import db.DBbroker;
import domain.AbstractDomainObject;
import domain.Mesto;
import java.util.ArrayList;
import java.util.List;
import so.AbstractSO;

/**
 *
 * @author Slobodan
 */
public class SoSearchMesto extends AbstractSO {

    private List<Mesto> mesta;

    @Override
    protected void validate(Object obj) throws Exception {

        AbstractDomainObject ado = (AbstractDomainObject) obj;

        if (ado == null || !(ado instanceof Mesto)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Mesto!");
        }
    }

    @Override
    protected void execute(Object obj) throws Exception {
        AbstractDomainObject ado = (AbstractDomainObject) obj;

        List<AbstractDomainObject> lista = DBbroker.getInstance().selectList(ado);
        mesta = (ArrayList<Mesto>) (ArrayList<?>) lista;
    }

    public List<Mesto> getMesta() {
        return mesta;
    }
}
