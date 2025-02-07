/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modeliTabela;
import domain.Proizvod;
import javax.swing.table.AbstractTableModel;
import java.util.List;

/**
 *
 * @author Slobodan
 */


public class TabelaObrisiProizvod extends AbstractTableModel {
    
    private List<Proizvod> proizvodi;
    private final String[] kolone = {"Naziv", "Cena"};

    public TabelaObrisiProizvod(List<Proizvod> proizvodi) {
        this.proizvodi = proizvodi;
    }

    @Override
    public int getRowCount() {
        return proizvodi.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Proizvod p = proizvodi.get(rowIndex);
        switch (columnIndex) {
            case 0: return p.getNaziv();
            case 1: return p.getJedinicnaCena();
            default: return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

    public Proizvod getProizvodAt(int rowIndex) {
        return proizvodi.get(rowIndex);
    }

    public void removeProizvod(int rowIndex) {
        proizvodi.remove(rowIndex);
        fireTableRowsDeleted(rowIndex, rowIndex);
    }

    public void setProizvodi(List<Proizvod> proizvodi) {
        this.proizvodi = proizvodi;
        fireTableDataChanged();
    }
}

