/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modeliTabela;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Slobodan
 */
public class TabelProizvodiModel extends DefaultTableModel{
    
    
    // Konstruktor koji postavlja kolone
    public TabelProizvodiModel(String[] kolone) {
        
        this.setColumnIdentifiers(kolone);

    }

    // Onemogući uređivanje ćelija
    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }
    
    
    
}
