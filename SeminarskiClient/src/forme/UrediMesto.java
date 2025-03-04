/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package forme;

import domain.Mesto;
import domain.Proizvod;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import kontroler.Kontroler;
import modeliTabela.TabelProizvodiModel;

/**
 *
 * @author Slobodan
 */
public class UrediMesto extends javax.swing.JFrame {

    /**
     * Creates new form UrediMesto
     */
    public UrediMesto() {
        initComponents();

        setVisible(true);

        setLocationRelativeTo(null);

        popuniTabelu();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnIzaberiMesto = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMesta = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblID = new javax.swing.JLabel();
        txtGrad = new javax.swing.JTextField();
        txtUlica = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        btnIzmeniMesto = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtPretraga = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btnPretraga = new javax.swing.JButton();
        lblGreska = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Uredi mesto");

        btnIzaberiMesto.setText("Izaberi mesto");
        btnIzaberiMesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIzaberiMestoActionPerformed(evt);
            }
        });

        jLabel1.setText("Id:");

        tblMesta.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblMesta);

        jLabel2.setText("Grad:");

        jLabel3.setText("Adresa:");

        lblID.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        jButton1.setText("Osvezi tabelu");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnIzmeniMesto.setText("Izmeni");
        btnIzmeniMesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIzmeniMestoActionPerformed(evt);
            }
        });

        jLabel4.setText("Pretraga po gradu");

        jLabel5.setText("Unesi naziv grada:");

        btnPretraga.setText("Pretraga");
        btnPretraga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPretragaActionPerformed(evt);
            }
        });

        lblGreska.setForeground(new java.awt.Color(255, 0, 0));
        lblGreska.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnIzaberiMesto))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtPretraga, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(btnPretraga))
                    .addComponent(lblGreska, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(btnIzmeniMesto)
                        .addGap(34, 34, 34))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblID, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(txtGrad, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtUlica, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addGap(33, 33, 33))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel4)
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPretraga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(btnPretraga))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(119, 119, 119)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblID, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtGrad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtUlica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(59, 59, 59)
                        .addComponent(btnIzmeniMesto)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblGreska, javax.swing.GroupLayout.DEFAULT_SIZE, 16, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnIzaberiMesto)
                            .addComponent(jButton1))
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIzaberiMestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzaberiMestoActionPerformed

        if (tblMesta.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Nije izabrano mesto iz tabele");
            return;
        }

        int red = tblMesta.getSelectedRow();
        int idMesto = (int) tblMesta.getValueAt(red, 0);

        List<Mesto> svaMesta = new ArrayList<>();

        try {
            svaMesta = Kontroler.getInstance().vratiListuSviMesta();
        } catch (Exception ex) {
            System.out.println("Greska pri ucitavanju liste" + ex.getMessage());
        }

        Mesto izabranoMesto = null;

        for (Mesto m : svaMesta) {
            if (m.getIdMesto() == idMesto) {
                izabranoMesto = m;
            }
        }

        lblID.setText(String.valueOf(izabranoMesto.getIdMesto()));
        txtGrad.setText(izabranoMesto.getGrad());
        txtUlica.setText(izabranoMesto.getAdresa());

    }//GEN-LAST:event_btnIzaberiMestoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        popuniTabelu();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnIzmeniMestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzmeniMestoActionPerformed

        if (lblID.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Nije izabrano mesto");
            return;
        }

        Mesto m = new Mesto(Integer.parseInt(lblID.getText()), txtGrad.getText(), txtUlica.getText());

        try {

            Kontroler.getInstance().promeniMesto(m);
            popuniTabelu();

            JOptionPane.showMessageDialog(this, "Uspesno izmenjeno mesto");

            lblID.setText("");
            txtGrad.setText("");
            txtUlica.setText("");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Neuspela promena mesta");
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_btnIzmeniMestoActionPerformed

    private void btnPretragaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPretragaActionPerformed

        String pretraga = txtPretraga.getText();

        List<Mesto> mesta = new ArrayList<>();
        try {
            mesta = Kontroler.getInstance().vratiListuMesto(pretraga);
            lblGreska.setText("");
            popuniTabelu(mesta);
        } catch (Exception ex) {
            lblGreska.setText("Nema mesta za uneti kriterijum");
            System.out.println("Greska kod vracanja mesta sa zadatim vrednostima" + ex.getMessage());
        }

        txtPretraga.setText("");

    }//GEN-LAST:event_btnPretragaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UrediMesto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UrediMesto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UrediMesto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UrediMesto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UrediMesto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIzaberiMesto;
    private javax.swing.JButton btnIzmeniMesto;
    private javax.swing.JButton btnPretraga;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblGreska;
    private javax.swing.JLabel lblID;
    private javax.swing.JTable tblMesta;
    private javax.swing.JTextField txtGrad;
    private javax.swing.JTextField txtPretraga;
    private javax.swing.JTextField txtUlica;
    // End of variables declaration//GEN-END:variables

    private void popuniTabelu() {
        String[] kolone = {"Id", "Grad", "Adresa"};
        TabelProizvodiModel dt = new TabelProizvodiModel(kolone);

        // Postavljanje modela na tabelu
        tblMesta.setModel(dt);

        List<Mesto> svaMesta;

        try {
            svaMesta = Kontroler.getInstance().vratiListuSviMesta();
        } catch (Exception ex) {
            System.out.println("Greska pri ucitavanju mesta" + ex.getMessage());
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

        tblMesta.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tblMesta.setRowSelectionAllowed(true);
        tblMesta.setColumnSelectionAllowed(false);
    }

    private void popuniTabelu(List<Mesto> mesta) {
        String[] kolone = {"Id", "Grad", "Adresa"};
        TabelProizvodiModel dt = new TabelProizvodiModel(kolone);

        // Postavljanje modela na tabelu
        tblMesta.setModel(dt);

        int brojac = 0;

        for (Mesto mesto : mesta) {
            dt.setRowCount(brojac + 1);

            dt.setValueAt(mesto.getIdMesto(), brojac, 0);
            dt.setValueAt(mesto.getGrad(), brojac, 1);
            dt.setValueAt(mesto.getAdresa(), brojac, 2);

            brojac++;
        }

        tblMesta.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tblMesta.setRowSelectionAllowed(true);
        tblMesta.setColumnSelectionAllowed(false);

    }
}
