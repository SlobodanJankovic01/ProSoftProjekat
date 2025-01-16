/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package komunikacija;

import java.io.Serializable;

/**
 *
 * @author Slobodan
 */
public class Zahtev implements Serializable {
    
    private Operacija operacija;
    private Object argumenti;

    public Zahtev(Operacija operacija, Object argumenti) {
        this.operacija = operacija;
        this.argumenti = argumenti;
    }

    public Operacija getOperacija() {
        return operacija;
    }

    public void setOperacija(Operacija operacija) {
        this.operacija = operacija;
    }

    public Object getArgumenti() {
        return argumenti;
    }

    public void setArgumenti(Object argumenti) {
        this.argumenti = argumenti;
    }
    
    
    
}
