/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kontroler;

import domain.Mesto;
import java.util.ArrayList;
import java.util.List;
import so.mesto.SoGetListMesto;

/**
 *
 * @author Slobodan
 */
public class ServerKontroler {

    private static ServerKontroler instance;

    public static ServerKontroler getInstance() {

        if (instance == null) {
            instance = new ServerKontroler();
        }
        return instance;
    }

    public List<Mesto> vratiListuSviMesto() throws Exception {
        SoGetListMesto so = new SoGetListMesto();
        so.templateExecute(new Mesto());
        List<Mesto> mesta = so.getGradovi();
        if (mesta.isEmpty()) {
            throw new Exception("Sistem nije uspeo ucita sva mesta");
        }
        return mesta;
    }

}
