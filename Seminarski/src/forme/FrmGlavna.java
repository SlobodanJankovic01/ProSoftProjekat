/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package forme;

import domain.Proizvod;
import domain.Radnik;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import javax.swing.ListSelectionModel;
import kontroler.Kontroler;

/**
 *
 * @author Slobodan
 */
public class FrmGlavna extends javax.swing.JFrame {

    /**
     * Creates new form FrmGlavna
     */
    public FrmGlavna() {
        initComponents();
        setVisible(true);
        setLocationRelativeTo(null);
    }

    FrmGlavna(Radnik radnik) {
        initComponents();
        setVisible(true);
        setLocationRelativeTo(null);
        lblKorIme.setText(radnik.getKorIme());
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

        jLabel1 = new javax.swing.JLabel();
        lblKorIme = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProizvodi = new javax.swing.JTable();
        btnKreirajProizvod = new javax.swing.JButton();
        btnOsvezi = new javax.swing.JButton();
        btnRadnaSmena = new javax.swing.JButton();
        btnUrediRadneSmene = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Glavna forma");

        jLabel1.setText("Radnik:");

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

        btnKreirajProizvod.setText("Kreiraj proizvod");
        btnKreirajProizvod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKreirajProizvodActionPerformed(evt);
            }
        });

        btnOsvezi.setText("Osvezi tabelu");
        btnOsvezi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOsveziActionPerformed(evt);
            }
        });

        btnRadnaSmena.setText("Ubaci radnu smenu");
        btnRadnaSmena.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRadnaSmenaActionPerformed(evt);
            }
        });

        btnUrediRadneSmene.setText("Uredi radne smene");
        btnUrediRadneSmene.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUrediRadneSmeneActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblKorIme, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnKreirajProizvod, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnOsvezi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(24, 24, 24))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnUrediRadneSmene, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnRadnaSmena, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(15, 15, 15))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblKorIme, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(16, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(btnKreirajProizvod)
                        .addGap(81, 81, 81)
                        .addComponent(btnOsvezi)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRadnaSmena)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnUrediRadneSmene)
                        .addGap(28, 28, 28))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnKreirajProizvodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKreirajProizvodActionPerformed
        
        FrmKreirajProizvod frmP=new FrmKreirajProizvod();

    }//GEN-LAST:event_btnKreirajProizvodActionPerformed

    private void btnOsveziActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOsveziActionPerformed

        popuniTabelu();

    }//GEN-LAST:event_btnOsveziActionPerformed

    private void btnRadnaSmenaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRadnaSmenaActionPerformed

        FrmUnosRadnaSmena radnaSmena=new FrmUnosRadnaSmena();

    }//GEN-LAST:event_btnRadnaSmenaActionPerformed

    private void btnUrediRadneSmeneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUrediRadneSmeneActionPerformed

        FrmSveRadneSmene radnesmene=new FrmSveRadneSmene();

    }//GEN-LAST:event_btnUrediRadneSmeneActionPerformed

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
            java.util.logging.Logger.getLogger(FrmGlavna.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmGlavna.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmGlavna.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmGlavna.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmGlavna().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnKreirajProizvod;
    private javax.swing.JButton btnOsvezi;
    private javax.swing.JButton btnRadnaSmena;
    private javax.swing.JButton btnUrediRadneSmene;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblKorIme;
    private javax.swing.JTable tblProizvodi;
    // End of variables declaration//GEN-END:variables

    private void popuniTabelu() {

        // DefaultTableModel koji onemogućava uređivanje ćelija
        DefaultTableModel dt = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        // Postavljanje modela na tabelu
        tblProizvodi.setModel(dt);
        
        dt.setColumnCount(2);
        dt.setRowCount(0);
        
        String[] kolone = {"Naziv", "Cena"};
        dt.setColumnIdentifiers(kolone);

        List<Proizvod> sviProizvodi = Kontroler.getInstance().vratiListuSviProizvodi();
        int brojac = 0;
        
        if (sviProizvodi == null || sviProizvodi.isEmpty()) {
            System.out.println("Lista proizvoda je prazna");
            return;
        }
        
        for (Proizvod proizvod : sviProizvodi) {
            dt.setRowCount(brojac + 1);

            dt.setValueAt(proizvod.getNaziv(), brojac, 0);
            dt.setValueAt(proizvod.getJedinicnaCena(), brojac, 1);

            brojac++;
        }

        tblProizvodi.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tblProizvodi.setRowSelectionAllowed(true);
        tblProizvodi.setColumnSelectionAllowed(false);
        
    }
    
    
    
    
    
}
