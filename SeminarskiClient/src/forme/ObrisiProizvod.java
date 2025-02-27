/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/AWTForms/Dialog.java to edit this template
 */
package forme;

import domain.Proizvod;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import kontroler.Kontroler;
import modeliTabela.TabelProizvodiModel;
import modeliTabela.TabelaObrisiProizvod;

/**
 *
 * @author Slobodan
 */
public class ObrisiProizvod extends java.awt.Dialog {

    /**
     * Creates new form ObrisiProizvod
     */
    public ObrisiProizvod(java.awt.Frame parent, boolean modal) {
        super(parent, "Obrisi proizvod", modal);
        initComponents();

        this.setLocationRelativeTo(null);

        setVisible(true);

        popuniTabelu();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProizvodi = new javax.swing.JTable();
        btnObrisi = new javax.swing.JButton();
        btnOsvezi = new javax.swing.JButton();

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        jLabel1.setText("Izaberi proizvod");

        tblProizvodi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblProizvodi);

        btnObrisi.setText("Obrisi");
        btnObrisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrisiActionPerformed(evt);
            }
        });

        btnOsvezi.setText("Osvezi tabelu");
        btnOsvezi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOsveziActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnOsvezi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnObrisi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(37, 37, 37))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnOsvezi)
                        .addGap(103, 103, 103)
                        .addComponent(btnObrisi)))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Closes the dialog
     */
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        setVisible(false);
        dispose();
    }//GEN-LAST:event_closeDialog

    private void btnOsveziActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOsveziActionPerformed
        popuniTabelu();
    }//GEN-LAST:event_btnOsveziActionPerformed

    private void btnObrisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrisiActionPerformed

        if (tblProizvodi.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Nije izabran proizvod iz tabele");
            return;
        }

        int red = tblProizvodi.getSelectedRow();
        int idProizvoda = (int) tblProizvodi.getValueAt(red, 0);

        try {
            if (Kontroler.getInstance().obrisiProizvod(idProizvoda)) {
                JOptionPane.showMessageDialog(this, "Proizvod uspesno izbrisan iz baze");
                popuniTabelu();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Greska kod brisanja proizvoda");
            System.out.println(ex.getMessage());
        }

    }//GEN-LAST:event_btnObrisiActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ObrisiProizvod dialog = new ObrisiProizvod(new java.awt.Frame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnObrisi;
    private javax.swing.JButton btnOsvezi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblProizvodi;
    // End of variables declaration//GEN-END:variables

    private void popuniTabelu() {

        String[] kolone = {"Id", "Naziv", "Cena"};
        TabelProizvodiModel dt = new TabelProizvodiModel(kolone);

        // Postavljanje modela na tabelu
        tblProizvodi.setModel(dt);

        List<Proizvod> sviProizvodi;

        try {
            sviProizvodi = Kontroler.getInstance().vratiListuSviProizvodi();
        } catch (Exception ex) {
            System.out.println("Greska pri ucitavanju proizvoda " + ex.getMessage());
            sviProizvodi = null;
            return;
        }
        int brojac = 0;

        for (Proizvod proizvod : sviProizvodi) {
            dt.setRowCount(brojac + 1);

            dt.setValueAt(proizvod.getIdProizvod(), brojac, 0);
            dt.setValueAt(proizvod.getNaziv(), brojac, 1);
            dt.setValueAt(proizvod.getJedinicnaCena(), brojac, 2);

            brojac++;
        }

        tblProizvodi.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tblProizvodi.setRowSelectionAllowed(true);
        tblProizvodi.setColumnSelectionAllowed(false);

    }
}
