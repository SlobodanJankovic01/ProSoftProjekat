/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package forme;

import domain.Porudzbina;
import domain.Proizvod;
import domain.Radnik;
import java.time.LocalDateTime;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
     * 
     */
    
    Radnik radnik;
    
    public FrmGlavna() {
        initComponents();
        setVisible(true);
        setLocationRelativeTo(null);
    }

    FrmGlavna(Radnik r) {
        initComponents();
        setVisible(true);
        setLocationRelativeTo(null);
        lblKorIme.setText(r.getKorIme());

        Radnik admin = new Radnik(3, "Slobodan", "Jankovic", "Admin", "admin123");

        if (!r.equals(admin)) {
            blokirajOpcije();
        }
        
        radnik=r;

        //popuniTabelu();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblKorIme = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnPregledPoru = new javax.swing.JButton();
        btnKreirajPoru = new javax.swing.JButton();
        jMenuBar = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuKrePro = new javax.swing.JMenuItem();
        jMenuKreMesto = new javax.swing.JMenuItem();
        jMenuKreMusterija = new javax.swing.JMenuItem();
        jMenuKreRadnaSmena = new javax.swing.JMenuItem();
        jMenuKreRadnika = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuUrediProizvo = new javax.swing.JMenuItem();
        jMenuUrediMusterija = new javax.swing.JMenuItem();
        jMenuUrediMesto = new javax.swing.JMenuItem();
        jMenuUrediRadnik = new javax.swing.JMenuItem();
        jMenuUrediRS = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuObrProizvod = new javax.swing.JMenuItem();
        jMenuObrMusterija = new javax.swing.JMenuItem();
        jMenuObrMesto = new javax.swing.JMenuItem();
        jMenuObrRS = new javax.swing.JMenuItem();
        jMenuObrRadnik = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Kreiraj porudzbinu");

        jLabel1.setText("Radnik:");

        btnPregledPoru.setText("Pregled porudzbina");
        btnPregledPoru.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPregledPoruActionPerformed(evt);
            }
        });

        btnKreirajPoru.setText("Kreiraj porudzbinu");
        btnKreirajPoru.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKreirajPoruActionPerformed(evt);
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

        jMenuKreRadnika.setText("Radnik");
        jMenuKreRadnika.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jMenuKreRadnika.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jMenuKreRadnika.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuKreRadnikaActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuKreRadnika);

        jMenuBar.add(jMenu1);

        jMenu2.setText("Uredi");

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
        jMenuUrediMusterija.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuUrediMusterijaActionPerformed(evt);
            }
        });
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
        jMenuUrediRadnik.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuUrediRadnikActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuUrediRadnik);

        jMenuUrediRS.setText("Radna smena");
        jMenuUrediRS.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jMenuUrediRS.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jMenuUrediRS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuUrediRSActionPerformed(evt);
            }
        });
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
        jMenuObrRadnik.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuObrRadnikActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuObrRadnik);

        jMenuBar.add(jMenu3);

        jMenu5.setText("Raspored");

        jMenuItem1.setText("Uredjivanje");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem1);

        jMenuBar.add(jMenu5);

        setJMenuBar(jMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblKorIme, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(335, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnKreirajPoru, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPregledPoru, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(315, 315, 315))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(lblKorIme, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 86, Short.MAX_VALUE)
                .addComponent(btnKreirajPoru, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(btnPregledPoru, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(132, 132, 132))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuKreProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuKreProActionPerformed

        KreirajProizvod kp = new KreirajProizvod(this, true);
        //popuniTabelu();

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
        ObrisiRadnaSmena radnesmene = new ObrisiRadnaSmena();
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
        ObrisiMusterija om = new ObrisiMusterija(this, false);
    }//GEN-LAST:event_jMenuObrMusterijaActionPerformed

    private void jMenuObrMestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuObrMestoActionPerformed
        ObrisiMesto om = new ObrisiMesto(this, false);
    }//GEN-LAST:event_jMenuObrMestoActionPerformed

    private void jMenuUrediProizvoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuUrediProizvoActionPerformed
        UrediProizvode up = new UrediProizvode();
    }//GEN-LAST:event_jMenuUrediProizvoActionPerformed

    private void jMenuUrediMestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuUrediMestoActionPerformed
        UrediMesto um = new UrediMesto();
    }//GEN-LAST:event_jMenuUrediMestoActionPerformed

    private void jMenuUrediRSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuUrediRSActionPerformed
        UrediRadnaSmena urs = new UrediRadnaSmena();
    }//GEN-LAST:event_jMenuUrediRSActionPerformed

    private void jMenuUrediMusterijaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuUrediMusterijaActionPerformed
        UrediMusterija um = new UrediMusterija();
    }//GEN-LAST:event_jMenuUrediMusterijaActionPerformed

    private void jMenuUrediRadnikActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuUrediRadnikActionPerformed
        UrediRadnik ur = new UrediRadnik();
    }//GEN-LAST:event_jMenuUrediRadnikActionPerformed

    private void jMenuKreRadnikaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuKreRadnikaActionPerformed
        FrmKreirajRadnika f = new FrmKreirajRadnika();
    }//GEN-LAST:event_jMenuKreRadnikaActionPerformed

    private void jMenuObrRadnikActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuObrRadnikActionPerformed
        ObrisiRadnik or = new ObrisiRadnik();
    }//GEN-LAST:event_jMenuObrRadnikActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        FrmRaspored raspored = new FrmRaspored();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void btnKreirajPoruActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKreirajPoruActionPerformed
        Porudzbina p = new Porudzbina(0, "", 0, LocalDateTime.now(), "", 3, 1);
        try {
            FrmKreirajPorudzbinu porudzbina = new FrmKreirajPorudzbinu(Kontroler.getInstance().kreirajPorudzbina(p),radnik);
        } catch (Exception ex) {
            System.out.println("Neuspelo kreiranje porudzbine" + ex.getMessage());
        }
    }//GEN-LAST:event_btnKreirajPoruActionPerformed

    private void btnPregledPoruActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPregledPoruActionPerformed
        FrmListaPorudzbina lista=new FrmListaPorudzbina();
    }//GEN-LAST:event_btnPregledPoruActionPerformed

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
    private javax.swing.JButton btnKreirajPoru;
    private javax.swing.JButton btnPregledPoru;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuKreMesto;
    private javax.swing.JMenuItem jMenuKreMusterija;
    private javax.swing.JMenuItem jMenuKrePro;
    private javax.swing.JMenuItem jMenuKreRadnaSmena;
    private javax.swing.JMenuItem jMenuKreRadnika;
    private javax.swing.JMenuItem jMenuObrMesto;
    private javax.swing.JMenuItem jMenuObrMusterija;
    private javax.swing.JMenuItem jMenuObrProizvod;
    private javax.swing.JMenuItem jMenuObrRS;
    private javax.swing.JMenuItem jMenuObrRadnik;
    private javax.swing.JMenuItem jMenuUrediMesto;
    private javax.swing.JMenuItem jMenuUrediMusterija;
    private javax.swing.JMenuItem jMenuUrediProizvo;
    private javax.swing.JMenuItem jMenuUrediRS;
    private javax.swing.JMenuItem jMenuUrediRadnik;
    private javax.swing.JLabel lblKorIme;
    // End of variables declaration//GEN-END:variables

//   
    private void blokirajOpcije() {

        jMenu3.setEnabled(false);
        jMenu2.setEnabled(false);
        jMenu5.setEnabled(false);

    }

}
