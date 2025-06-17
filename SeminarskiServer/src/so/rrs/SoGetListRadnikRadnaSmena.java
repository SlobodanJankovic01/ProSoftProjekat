/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.rrs;

import db.DBbroker;
import domain.AbstractDomainObject;
import domain.RadnikRadnaSmena;
import java.util.List;
import so.AbstractSO;

/**
 *
 * @author Slobodan
 */
public class SoGetListRadnikRadnaSmena extends AbstractSO{
    private List<RadnikRadnaSmena> rrs;

    public List<RadnikRadnaSmena> getRrs() {
        return rrs;
    }

    @Override
    protected void validate(Object obj) throws Exception {
        AbstractDomainObject ado = (AbstractDomainObject) obj;
        if (ado == null || !(ado instanceof RadnikRadnaSmena)) {
            throw new Exception("Prosledjeni objekat nije instanca klase RadnikRadnaSmena!");
        }
    }

    @Override
    protected void execute(Object obj) throws Exception {
        AbstractDomainObject ado = (AbstractDomainObject) obj;
        List<AbstractDomainObject> lista = DBbroker.getInstance().selectList(ado);
        rrs = (List<RadnikRadnaSmena>) (List<?>) lista;
    }
}
