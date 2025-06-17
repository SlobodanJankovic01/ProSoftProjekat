/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.stavkaporudzbine;

import db.DBbroker;
import domain.AbstractDomainObject;
import domain.StavkaPorudzbina;
import so.AbstractSO;

/**
 *
 * @author Slobodan
 */
public class SoAddStavkaPorudzbine extends AbstractSO {

    private int id;

    @Override
    protected void validate(Object obj) throws Exception {
        AbstractDomainObject ado = (AbstractDomainObject) obj;

        if (ado == null || !(ado instanceof StavkaPorudzbina)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Stavka porudzbine!");
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
