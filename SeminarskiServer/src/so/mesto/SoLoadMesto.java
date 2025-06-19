/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.mesto;
import db.DBbroker;
import domain.Mesto;
import domain.AbstractDomainObject;
import so.AbstractSO;

/**
 *
 * @author Slobodan
 */
public class SoLoadMesto extends AbstractSO{

    private Mesto mesto;
    
    @Override
    protected void validate(Object obj) throws Exception {
        
        AbstractDomainObject ado=(AbstractDomainObject) obj;
        
         if (ado==null || !(ado instanceof Mesto)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Mesto!");
        }
    }

    @Override
    protected void execute(Object obj) throws Exception {
        
        AbstractDomainObject ado=(AbstractDomainObject) obj;
        
        AbstractDomainObject object;
        object=DBbroker.getInstance().selectObject(ado);
        mesto=(Mesto) object;
    }

    public Mesto getMesto() {
        return mesto;
    }

}
