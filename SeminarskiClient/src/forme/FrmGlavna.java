/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package forme;

import domain.Proizvod;
import domain.Radnik;
import javax.swing.table.DefaultTableModel;
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
        btnOsvezi = new javax.swing.JButton();
        btnObrisiProizvod = new javax.swing.JButton();
        jMenuBar = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuKrePro = new javax.swing.JMenuItem();
        jMenuKreMesto = new javax.swing.JMenuItem();
        jMenuKreMusterija = new javax.swing.JMenuItem();
        jMenuKreRadnaSmena = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuUrediPorudz = new javax.swing.JMenuItem();
        jMenuUrediProizvo = new javax.swing.JMenuItem();
        jMenuUrediMusterija = new javax.swing.JMenuItem();
        jMenuUrediMesto = new javax.swing.JMenuItem();
        jMenuUrediRadnik = new javax.swing.JMenuItem();
        jMenuUrediRS = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuObrProizvod = new javax.swing.JMenuItem();
        jMenuObrPorudz = new javax.swing.JMenuItem();
        jMenuObrMusterija = new javax.swing.JMenuItem();
        jMenuObrMesto = new javax.swing.JMenuItem();
        jMenuObrRS = new javax.swing.JMenuItem();
        jMenuObrRadnik = new javax.swing.JMenuItem();

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

        btnOsvezi.setText("Osvezi tabelu");
        btnOsvezi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOsveziActionPerformed(evt);
            }
        });

        btnObrisiProizvod.setText("Obrisi proizvod");
        btnObrisiProizvod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrisiProizvodActionPerformed(evt);
            }
        });

        jMenu1.setText("Kreiraj");
        jMenu1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jMenu1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });

        jMenuKrePro.setText("Proizvod");
        jMenuKrePro.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jMenuKrePro.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jMenuKrePro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuKreProActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuKrePro);

        jMenuKreMesto.setText("Mesto");
        jMenuKreMesto.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jMenuKreMesto.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jMenuKreMesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuKreMestoActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuKreMesto);

        jMenuKreMusterija.setText("Musterija");
        jMenuKreMusterija.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jMenuKreMusterija.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jMenuKreMusterija.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuKreMusterijaActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuKreMusterija);

        jMenuKreRadnaSmena.setText("Radna smena");
        jMenuKreRadnaSmena.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jMenuKreRadnaSmena.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jMenuKreRadnaSmena.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuKreRadnaSmenaActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuKreRadnaSmena);

        jMenuBar.add(jMenu1);

        jMenu2.setText("Uredi");

        jMenuUrediPorudz.setText("Porudzbina");
        jMenuUrediPorudz.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jMenuUrediPorudz.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jMenu2.add(jMenuUrediPorudz);

        jMenuUrediProizvo.setText("Proizvod");
        jMenuUrediProizvo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jMenuUrediProizvo.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jMenuUrediProizvo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuUrediProizvoActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuUrediProizvo);

        jMenuUrediMusterija.setText("Musterija");
        jMenuUrediMusterija.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jMenuUrediMusterija.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jMenu2.add(jMenuUrediMusterija);

        jMenuUrediMesto.setText("Mesto");
        jMenuUrediMesto.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jMenuUrediMesto.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jMenuUrediMesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuUrediMestoActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuUrediMesto);

        jMenuUrediRadnik.setText("Radnik");
        jMenuUrediRadnik.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jMenuUrediRadnik.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jMenu2.add(jMenuUrediRadnik);

        jMenuUrediRS.setText("Radna smena");
        jMenuUrediRS.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jMenuUrediRS.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jMenu2.add(jMenuUrediRS);

        jMenuBar.add(jMenu2);

        jMenu3.setText("Obrisi");

        jMenuObrProizvod.setText("Proizvod");
        jMenuObrProizvod.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jMenuObrProizvod.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jMenuObrProizvod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuObrProizvodActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuObrProizvod);

        jMenuObrPorudz.setText("Porudzbina");
        jMenuObrPorudz.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jMenuObrPorudz.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jMenu3.add(jMenuObrPorudz);

        jMenuObrMusterija.setText("Musterija");
        jMenuObrMusterija.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jMenuObrMusterija.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jMenuObrMusterija.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuObrMusterijaActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuObrMusterija);

        jMenuObrMesto.setText("Mesto");
        jMenuObrMesto.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jMenuObrMesto.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jMenuObrMesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuObrMestoActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuObrMesto);

        jMenuObrRS.setText("Radna smena");
        jMenuObrRS.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jMenuObrRS.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jMenuObrRS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuObrRSActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuObrRS);

        jMenuObrRadnik.setText("Radnik");
        jMenuObrRadnik.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jMenuObrRadnik.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jMenu3.add(jMenuObrRadnik);

        jMenuBar.add(jMenu3);

        setJMenuBar(jMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblKorIme, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnObrisiProizvod, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                            .addComponent(btnOsvezi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(lblKorIme, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(btnObrisiProizvod)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnOsvezi)
                        .addGap(166, 166, 166))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOsveziActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOsveziActionPerformed

        popuniTabelu();

    }//GEN-LAST:event_btnOsveziActionPerformed

    private void btnObrisiProizvodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrisiProizvodActionPerformed

        int red = tblProizvodi.getSelectedRow();

        if (red == -1) {
            JOptionPane.showMessageDialog(this, "Nema selektovanog proizvoda", "Greška", JOptionPane.ERROR_MESSAGE);
            return;
        }


    }//GEN-LAST:event_btnObrisiProizvodActionPerformed

    private void jMenuKreProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuKreProActionPerformed

        KreirajProizvod kp = new KreirajProizvod(this, true);
        popuniTabelu();

    }//GEN-LAST:event_jMenuKreProActionPerformed

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu1ActionPerformed

    private void jMenuKreRadnaSmenaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuKreRadnaSmenaActionPerformed
        KreirajRadnaSmena krs = new KreirajRadnaSmena(this, true);
    }//GEN-LAST:event_jMenuKreRadnaSmenaActionPerformed

    private void jMenuObrProizvodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuObrProizvodActionPerformed
        ObrisiProizvod op = new ObrisiProizvod(this, false);
    }//GEN-LAST:event_jMenuObrProizvodActionPerformed

    private void jMenuObrRSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuObrRSActionPerformed
        FrmSveRadneSmene radnesmene = new FrmSveRadneSmene();
    }//GEN-LAST:event_jMenuObrRSActionPerformed

    private void jMenuKreMestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuKreMestoActionPerformed

        KreirajMesto km = new KreirajMesto(this, true);

    }//GEN-LAST:event_jMenuKreMestoActionPerformed

    private void jMenuKreMusterijaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuKreMusterijaActionPerformed

        try {

            KreirajMusterija km = new KreirajMusterija(this, false);

        } catch (Exception ex) {
            Logger.getLogger(FrmGlavna.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jMenuKreMusterijaActionPerformed

    private void jMenuObrMusterijaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuObrMusterijaActionPerformed
        
        ObrisiMusterija om=new ObrisiMusterija(this, false);

    }//GEN-LAST:event_jMenuObrMusterijaActionPerformed

    private void jMenuObrMestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuObrMestoActionPerformed
        
        ObrisiMesto om=new ObrisiMesto(this, false);
        
    }//GEN-LAST:event_jMenuObrMestoActionPerformed

    private void jMenuUrediProizvoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuUrediProizvoActionPerformed

        UrediProizvode up=new UrediProizvode();
        
    }//GEN-LAST:event_jMenuUrediProizvoActionPerformed

    private void jMenuUrediMestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuUrediMestoActionPerformed
        
        UrediMesto um=new UrediMesto();
        
    }//GEN-LAST:event_jMenuUrediMestoActionPerformed

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
    private javax.swing.JButton btnObrisiProizvod;
    private javax.swing.JButton btnOsvezi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JMenuItem jMenuKreMesto;
    private javax.swing.JMenuItem jMenuKreMusterija;
    private javax.swing.JMenuItem jMenuKrePro;
    private javax.swing.JMenuItem jMenuKreRadnaSmena;
    private javax.swing.JMenuItem jMenuObrMesto;
    private javax.swing.JMenuItem jMenuObrMusterija;
    private javax.swing.JMenuItem jMenuObrPorudz;
    private javax.swing.JMenuItem jMenuObrProizvod;
    private javax.swing.JMenuItem jMenuObrRS;
    private javax.swing.JMenuItem jMenuObrRadnik;
    private javax.swing.JMenuItem jMenuUrediMesto;
    private javax.swing.JMenuItem jMenuUrediMusterija;
    private javax.swing.JMenuItem jMenuUrediPorudz;
    private javax.swing.JMenuItem jMenuUrediProizvo;
    private javax.swing.JMenuItem jMenuUrediRS;
    private javax.swing.JMenuItem jMenuUrediRadnik;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblKorIme;
    private javax.swing.JTable tblProizvodi;
    // End of variables declaration//GEN-END:variables

    private void popuniTabelu() {

        String[] kolone = {"Naziv", "Cena"};
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

            dt.setValueAt(proizvod.getNaziv(), brojac, 0);
            dt.setValueAt(proizvod.getJedinicnaCena(), brojac, 1);

            brojac++;
        }

        tblProizvodi.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tblProizvodi.setRowSelectionAllowed(true);
        tblProizvodi.setColumnSelectionAllowed(false);

    }

}
