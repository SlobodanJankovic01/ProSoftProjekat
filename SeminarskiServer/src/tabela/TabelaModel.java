/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tabela;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Slobodan
 */
public class TabelaModel extends DefaultTableModel {

    public TabelaModel(String[] kolone) {
        setColumnIdentifiers(kolone);
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }

}
