/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/AWTForms/Dialog.java to edit this template
 */
package forme;

import domain.Radnik;
import domain.RadnaSmena;
import domain.RadnikRadnaSmena;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import kontroler.Kontroler;

/**
 *
 * @author Slobodan
 */
public class UrediSmenu extends java.awt.Dialog {

    /**
     * Creates new form UrediSmenu
     */
    List<Radnik> radnici = new ArrayList<>();
    List<RadnaSmena> radneSmene = new ArrayList<>();
    RadnikRadnaSmena rRS;

    public UrediSmenu(java.awt.Frame parent, boolean modal) {

        super(parent, modal);

        initComponents();
        setVisible(true);

        setLocationRelativeTo(null);
        popuniCboxeve();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    public UrediSmenu(java.awt.Frame parent, boolean modal, RadnikRadnaSmena rrs) {
        super(parent, modal);

        rRS=rrs;
        
        initComponents();
        setVisible(true);

        setLocationRelativeTo(null);
        popuniCboxeve();
        
        postaviVrednosti(rrs);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cboxRadnici = new javax.swing.JComboBox<>();
        cboxSmene = new javax.swing.JComboBox<>();
        jKalendar = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        btnIzmeni = new javax.swing.JButton();

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        jLabel1.setText("Radnik");

        jLabel2.setText("Radna smena");

        jLabel3.setText("Datum");

        btnIzmeni.setText("Izmeni");
        btnIzmeni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIzmeniActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnIzmeni, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jKalendar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cboxSmene, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cboxRadnici, 0, 132, Short.MAX_VALUE)))
                .addContainerGap(62, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cboxRadnici, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cboxSmene, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jKalendar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(33, 33, 33)
                .addComponent(btnIzmeni)
                .addContainerGap(74, Short.MAX_VALUE))
        );

        add(jPanel1, java.awt.BorderLayout.NORTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Closes the dialog
     */
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        setVisible(false);
        dispose();
    }//GEN-LAST:event_closeDialog

    private void btnIzmeniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzmeniActionPerformed

        Radnik r=(Radnik) cboxRadnici.getSelectedItem();
        RadnaSmena rs=(RadnaSmena) cboxSmene.getSelectedItem();
        Date d=jKalendar.getDate();
        
        if (r == null || rs == null || d == null) {
            JOptionPane.showMessageDialog(this,"Moraju biti izabrani radnik, radna smena i datum!");
            return;
        }

        LocalDate datum = d.toInstant().atZone(java.time.ZoneId.systemDefault())
                .toLocalDate();
        
        RadnikRadnaSmena rrs=new RadnikRadnaSmena(rRS.getId(), r.getIdRadnik(), rs.getIdRadnaSmena(), datum);
        
        System.out.println(rRS.getId()+","+ r.getIdRadnik()+","+ rs.getIdRadnaSmena()+","+ datum);
        
        try {
            Kontroler.getInstance().promeniRadnikRadnaSmena(rrs);
            JOptionPane.showMessageDialog(this, "Uspesno izmenjena smena");
            this.dispose();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,"Greska kod izmene smene");
        }

    }//GEN-LAST:event_btnIzmeniActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                UrediSmenu dialog = new UrediSmenu(new java.awt.Frame(), true);
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
    private javax.swing.JButton btnIzmeni;
    private javax.swing.JComboBox<Radnik> cboxRadnici;
    private javax.swing.JComboBox<RadnaSmena> cboxSmene;
    private com.toedter.calendar.JDateChooser jKalendar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

    private void popuniCboxeve() {
        try {

            radnici = Kontroler.getInstance().vratiListuSviRadnik();
            radneSmene = Kontroler.getInstance().vratiListuSviRadnaSmena();

            for (RadnaSmena radnaSmena : radneSmene) {
                cboxSmene.addItem(radnaSmena);
            }

            cboxSmene.setSelectedIndex(-1);

            for (Radnik radnik : radnici) {
                cboxRadnici.addItem(radnik);
            }

            cboxRadnici.setSelectedIndex(-1);

        } catch (Exception ex) {
            System.out.println("Greska kod popunjavanja comboBoxeva" + ex.getMessage());
        }
    }

    private void postaviVrednosti(RadnikRadnaSmena rrs) {

        Radnik r = null;
        RadnaSmena rs=null;

        for (Radnik radnik : radnici) {
            if (radnik.getIdRadnik() == rrs.getIdRadnik()) {
                r = radnik;
                break;
            }
        }

        for (RadnaSmena radnasmena : radneSmene) {
            if (radnasmena.getIdRadnaSmena() == rrs.getIdRadnaSmena()) {
                rs = radnasmena;
                break;
            }
        }
        
        Date datum=java.sql.Date.valueOf(rrs.getDatum());
        
        jKalendar.setDate(datum);
        cboxRadnici.setSelectedItem((Radnik) r);
        cboxSmene.setSelectedItem((RadnaSmena) rs);
        

    }

}
