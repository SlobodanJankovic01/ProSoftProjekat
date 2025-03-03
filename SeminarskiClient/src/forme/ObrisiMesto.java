/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/AWTForms/Dialog.java to edit this template
 */
package forme;

import domain.Mesto;
import domain.Proizvod;
import java.awt.Color;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import kontroler.Kontroler;
import modeliTabela.TabelProizvodiModel;

/**
 *
 * @author Slobodan
 */
public class ObrisiMesto extends java.awt.Dialog {

    /**
     * Creates new form ObrisiMesto
     */
    public ObrisiMesto(java.awt.Frame parent, boolean modal) {
        super(parent, "Obrisi mesto", modal);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSvaMesta = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnObrisi = new javax.swing.JButton();
        btnOsvezi = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtIdMesta = new javax.swing.JTextField();
        btnPretraga = new javax.swing.JButton();
        lblPretraga = new javax.swing.JLabel();

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        tblSvaMesta.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblSvaMesta);

        jLabel1.setText("Izaberi mesto");

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

        jLabel2.setText("Unesi id mesta");

        btnPretraga.setText("Pretraga");
        btnPretraga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPretragaActionPerformed(evt);
            }
        });

        lblPretraga.setBackground(new java.awt.Color(255, 0, 0));
        lblPretraga.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnObrisi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnOsvezi, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE))
                        .addGap(25, 25, 25))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblPretraga, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(txtIdMesta, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(11, 11, 11)
                        .addComponent(btnPretraga)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtIdMesta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPretraga))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblPretraga, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnOsvezi)
                        .addGap(114, 114, 114)
                        .addComponent(btnObrisi)))
                .addGap(30, 30, 30))
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

    private void btnObrisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrisiActionPerformed

        if (tblSvaMesta.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Nije izabrano mesto iz tabele");
            return;
        }

        int red = tblSvaMesta.getSelectedRow();
        int idMesto = (int) tblSvaMesta.getValueAt(red, 0);

        try {
            if (Kontroler.getInstance().obrisiMesto(idMesto)) {
                JOptionPane.showMessageDialog(this, "Mesto uspesno izbrisano iz baze");
                popuniTabelu();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Greska kod brisanja mesta");
            System.out.println(ex.getMessage());
        }

    }//GEN-LAST:event_btnObrisiActionPerformed

    private void btnOsveziActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOsveziActionPerformed

        popuniTabelu();

    }//GEN-LAST:event_btnOsveziActionPerformed

    private void btnPretragaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPretragaActionPerformed

        if (txtIdMesta.getText() == "" || !txtIdMesta.getText().matches("^\\d+$")) {
            lblPretraga.setText("Unesi neki broj");
            lblPretraga.setForeground(Color.RED);
            return;
        }

        lblPretraga.setText("");

        int idMesta = Integer.parseInt(txtIdMesta.getText());

        System.out.println(idMesta);
        popuniTabelu(idMesta);
    }//GEN-LAST:event_btnPretragaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ObrisiMesto dialog = new ObrisiMesto(new java.awt.Frame(), true);
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
    private javax.swing.JButton btnPretraga;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblPretraga;
    private javax.swing.JTable tblSvaMesta;
    private javax.swing.JTextField txtIdMesta;
    // End of variables declaration//GEN-END:variables

    private void popuniTabelu() {
        String[] kolone = {"Id", "Grad", "Adresa"};
        TabelProizvodiModel dt = new TabelProizvodiModel(kolone);

        // Postavljanje modela na tabelu
        tblSvaMesta.setModel(dt);

        List<Mesto> svaMesta;

        try {
            svaMesta = Kontroler.getInstance().vratiListuSviMesta();
        } catch (Exception ex) {
            System.out.println("Greska pri ucitavanju proizvoda " + ex.getMessage());
            svaMesta = null;
            return;
        }
        int brojac = 0;

        for (Mesto mesto : svaMesta) {
            dt.setRowCount(brojac + 1);

            dt.setValueAt(mesto.getIdMesto(), brojac, 0);
            dt.setValueAt(mesto.getGrad(), brojac, 1);
            dt.setValueAt(mesto.getAdresa(), brojac, 2);

            brojac++;
        }

        tblSvaMesta.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tblSvaMesta.setRowSelectionAllowed(true);
        tblSvaMesta.setColumnSelectionAllowed(false);
    }

    private void popuniTabelu(int idMesta) {

        try {
            Mesto m = Kontroler.getInstance().pretraziMesta(idMesta);

            if (m.getAdresa()== null) {
                JOptionPane.showMessageDialog(this, "Ne postoji mesto sa unetim id-ijem, probaj opet");
                return;
            }

            String[] kolone = {"Id", "Grad", "Adresa"};
            TabelProizvodiModel dt = new TabelProizvodiModel(kolone);

            tblSvaMesta.setModel(dt);

            dt.setRowCount(1);

            dt.setValueAt(m.getIdMesto(), 0, 0);
            dt.setValueAt(m.getGrad(), 0, 1);
            dt.setValueAt(m.getAdresa(), 0, 2);

            tblSvaMesta.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            tblSvaMesta.setRowSelectionAllowed(true);
            tblSvaMesta.setColumnSelectionAllowed(false);

        } catch (Exception ex) {
            System.out.println("Neuspela pretraga mesta po idiju" + ex.getMessage());
        }
    }
}
