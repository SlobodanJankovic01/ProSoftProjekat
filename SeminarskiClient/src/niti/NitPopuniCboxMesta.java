/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package niti;

import domain.Mesto;
import java.util.List;
import javax.swing.JComboBox;
import kontroler.Kontroler;

/**
 *
 * @author Slobodan
 */
public class NitPopuniCboxMesta extends Thread{
    
    private JComboBox<Mesto> cboxMesto;

    public NitPopuniCboxMesta(JComboBox<Mesto> svaMesta) {
        this.cboxMesto = svaMesta;
    }

    @Override
    public void run() {
        try {
                List<Mesto> mesta = Kontroler.getInstance().vratiListuSviMesta();
                
                cboxMesto.removeAllItems();
                
                for (Mesto mesto : mesta) {
                    cboxMesto.addItem(mesto);
                }

                cboxMesto.setSelectedIndex(-1);

            } catch (Exception ex) {
                System.out.println("Greška pri učitavanju mesta: " + ex.getMessage());
            }
    }
    
    
    
    
    
}
