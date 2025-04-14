/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package forme;

import domain.Proizvod;
import domain.Musterija;
import domain.Porudzbina;
import domain.Radnik;
import domain.StavkaPorudzbina;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.ListSelectionModel;
import javax.swing.SpinnerDateModel;
import kontroler.Kontroler;
import modeliTabela.TabelProizvodiModel;

/**
 *
 * @author Slobodan
 */
public class FrmKreirajPorudzbinu extends javax.swing.JFrame {

    /**
     * Creates new form FrmKreirajPorudzbinu
     */
    int idPorudzbine;
    int redniBroj = 1;
    int ukupnaCena = 0;
    Radnik radnik;
    List<Proizvod> sviProizvodi;
    List<StavkaPorudzbina> sveStavkePorudzbine;
    List<Musterija> musterije;

    public FrmKreirajPorudzbinu() {
        initComponents();
    }

    public FrmKreirajPorudzbinu(int id, Radnik r) {
        initComponents();
        setVisible(true);
        setLocationRelativeTo(null);

        idPorudzbine = id;
        radnik = r;
        lblId.setText("" + id);

        popuniTabelu();
        popuniStavke();
        popuniMusterije();
        popuniAtribute();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        lblId = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProizvodi = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtKolicina = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        btnDodajStavku = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblStavke = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        txtUkupnaCena = new javax.swing.JLabel();
        jRadioDostava = new javax.swing.JRadioButton();
        jRadioPreuzimanje = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jVreme = new javax.swing.JSpinner();
        jDatum = new com.toedter.calendar.JDateChooser();
        btnZavrsiPorudzbinu = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtNapomena = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        cboxMusterije = new javax.swing.JComboBox<>();
        btnObrisiStavku = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Kreiraj porudzbinu");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel1.setText("ID porudzbine");

        lblId.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N

        tblProizvodi.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
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

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel2.setText("Kolicina:");

        txtKolicina.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jButton1.setText("1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("2");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        btnDodajStavku.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnDodajStavku.setText("Dodaj stavku");
        btnDodajStavku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajStavkuActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel3.setText("Proizvodi");

        tblStavke.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblStavke.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tblStavke);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel4.setText("Stavke porudzbine");

        txtUkupnaCena.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        txtUkupnaCena.setForeground(new java.awt.Color(255, 0, 51));
        txtUkupnaCena.setText("Ukupna cena:");

        buttonGroup.add(jRadioDostava);
        jRadioDostava.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jRadioDostava.setText("Dostava");

        buttonGroup.add(jRadioPreuzimanje);
        jRadioPreuzimanje.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jRadioPreuzimanje.setText("Preuzimanje");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel5.setText("Nacin isporuke");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel6.setText("Datum i vreme");

        jVreme.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jVreme.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(), null, null, java.util.Calendar.HOUR));
        jVreme.setEditor(new javax.swing.JSpinner.DateEditor(jVreme, "HH:mm"));

        jDatum.setDate(new Date());

        btnZavrsiPorudzbinu.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        btnZavrsiPorudzbinu.setText("Zavrsi porudzbinu");
        btnZavrsiPorudzbinu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnZavrsiPorudzbinuActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel7.setText("Napomena");

        txtNapomena.setColumns(20);
        txtNapomena.setRows(5);
        jScrollPane3.setViewportView(txtNapomena);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel8.setText("Musterija");

        cboxMusterije.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        btnObrisiStavku.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btnObrisiStavku.setText("Obrisi stavku");
        btnObrisiStavku.setEnabled(false);
        btnObrisiStavku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrisiStavkuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtKolicina, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)
                        .addComponent(btnDodajStavku))
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel5)
                        .addComponent(lblId, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6)
                        .addComponent(cboxMusterije, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jDatum, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jVreme, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane3))
                    .addComponent(jLabel8)
                    .addComponent(jLabel7)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jRadioDostava, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioPreuzimanje, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(266, 266, 266))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnObrisiStavku)
                        .addGap(9, 9, 9))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtUkupnaCena)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnZavrsiPorudzbinu)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblId, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jRadioDostava)
                                    .addComponent(jRadioPreuzimanje))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jDatum, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jVreme, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cboxMusterije, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnObrisiStavku, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(166, 166, 166)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtKolicina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton2))
                        .addGap(0, 4, Short.MAX_VALUE))
                    .addComponent(btnZavrsiPorudzbinu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDodajStavku, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtUkupnaCena)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        txtKolicina.setText("1");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        txtKolicina.setText("2");

    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnDodajStavkuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajStavkuActionPerformed

        int selectedRow = tblProizvodi.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Nije izabran proizvod");
            return;
        }

        String kolicina = txtKolicina.getText().trim();

        if (!kolicina.matches("^\\d+$")) {
            JOptionPane.showMessageDialog(this, "Unesite validan broj za kolicinu!");
            return;
        }

        int cena = Integer.valueOf(kolicina) * (int) tblProizvodi.getValueAt(selectedRow, 2);
        StavkaPorudzbina sp = new StavkaPorudzbina(idPorudzbine, redniBroj, Integer.valueOf(kolicina), cena, (int) tblProizvodi.getValueAt(selectedRow, 0));
        try {
            Kontroler.getInstance().kreirajStavkaPorudzbina(sp);
            redniBroj++;

            txtKolicina.setText("");
            tblProizvodi.clearSelection();

            popuniStavke();
            btnObrisiStavku.setEnabled(true);
        } catch (Exception ex) {
            System.out.println("Neuspelo kreiranje stavke porudzbine" + ex.getMessage());
        }


    }//GEN-LAST:event_btnDodajStavkuActionPerformed

    private void btnZavrsiPorudzbinuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnZavrsiPorudzbinuActionPerformed

        int id = idPorudzbine;
        int idRadnik = radnik.getIdRadnik();
        String nacinIsporuke = "";

        if (!jRadioDostava.isSelected() && !jRadioPreuzimanje.isSelected()) {
            JOptionPane.showMessageDialog(this, "Moras izabrati nacin isporuke!");
            return;
        }

        if (jRadioDostava.isSelected()) {
            nacinIsporuke = jRadioDostava.getText();
        } else if (jRadioPreuzimanje.isSelected()) {
            nacinIsporuke = jRadioPreuzimanje.getText();
        }

        String napomena = txtNapomena.getText();
        int ukCena = ukupnaCena;

        Musterija m = (Musterija) cboxMusterije.getSelectedItem();
        int idMusterije = m.getIdMusterija();

        LocalDateTime datumVreme = vratiDatumVreme();

        Porudzbina p = new Porudzbina(id, nacinIsporuke, ukCena, datumVreme, napomena, idRadnik, idMusterije);

        try {
            Kontroler.getInstance().promeniPorudzbina(p);

            JOptionPane.showMessageDialog(this, "Uspesno zavrsena porudzbina");

            this.dispose();
        } catch (Exception ex) {
            System.out.println("Neuspelo kreiranje porudzbine" + ex.getMessage());
        }


    }//GEN-LAST:event_btnZavrsiPorudzbinuActionPerformed

    private void btnObrisiStavkuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrisiStavkuActionPerformed

        int izabranRed = tblStavke.getSelectedRow();

        if (izabranRed == -1) {
            JOptionPane.showMessageDialog(this, "Nije izabrana nijedna stavka");
            return;
        }

        int rb = (int) tblStavke.getValueAt(izabranRed, 0);

        StavkaPorudzbina stavka = new StavkaPorudzbina();

        for (StavkaPorudzbina stavkaPorudzbina : sveStavkePorudzbine) {
            if (rb == stavkaPorudzbina.getRb()) {
                stavka = stavkaPorudzbina;
                break;
            }
        }

        try {
            Kontroler.getInstance().obrisiStavkaPorudzbine(stavka);
            popuniStavke();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Neuspelo brisanje stavke!");
            System.out.println("Neuspelo brisanje stavke" + ex.getMessage());
        }

    }//GEN-LAST:event_btnObrisiStavkuActionPerformed

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
            java.util.logging.Logger.getLogger(FrmKreirajPorudzbinu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmKreirajPorudzbinu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmKreirajPorudzbinu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmKreirajPorudzbinu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmKreirajPorudzbinu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDodajStavku;
    private javax.swing.JButton btnObrisiStavku;
    private javax.swing.JButton btnZavrsiPorudzbinu;
    private javax.swing.ButtonGroup buttonGroup;
    private javax.swing.JComboBox<Musterija> cboxMusterije;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private com.toedter.calendar.JDateChooser jDatum;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JRadioButton jRadioDostava;
    private javax.swing.JRadioButton jRadioPreuzimanje;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSpinner jVreme;
    private javax.swing.JLabel lblId;
    private javax.swing.JTable tblProizvodi;
    private javax.swing.JTable tblStavke;
    private javax.swing.JTextField txtKolicina;
    private javax.swing.JTextArea txtNapomena;
    private javax.swing.JLabel txtUkupnaCena;
    // End of variables declaration//GEN-END:variables

    private void popuniTabelu() {

        String[] kolone = {"Id proizvoda", "Naziv", "Cena"};
        TabelProizvodiModel dt = new TabelProizvodiModel(kolone);

        // Postavljanje modela na tabelu
        tblProizvodi.setModel(dt);

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

        //sakriva kolonu id 
        tblProizvodi.getColumnModel().getColumn(0).setMinWidth(0);
        tblProizvodi.getColumnModel().getColumn(0).setMaxWidth(0);
        tblProizvodi.getColumnModel().getColumn(0).setWidth(0);

    }

    private void popuniStavke() {
        String[] kolone = {"rb", "Proizvod", "Kolicina", "Cena"};
        TabelProizvodiModel dt = new TabelProizvodiModel(kolone);

        tblStavke.setModel(dt);

        try {
            sveStavkePorudzbine = Kontroler.getInstance().vratiListuSviStavkePorudzbine(idPorudzbine);
        } catch (Exception ex) {
            System.out.println("Greska pri ucitavanju stavki porudzbine" + ex.getMessage());
            sveStavkePorudzbine = null;
            return;
        }
        int brojac = 0;
        ukupnaCena = 0;

        if (!sveStavkePorudzbine.isEmpty()) {
            for (StavkaPorudzbina sp : sveStavkePorudzbine) {
                String naziv = "";
                for (Proizvod p : sviProizvodi) {
                    if (p.getIdProizvod() == sp.getIdProizvod()) {
                        naziv = p.getNaziv();
                    }
                }
                dt.setRowCount(brojac + 1);

                dt.setValueAt(sp.getRb(), brojac, 0);
                dt.setValueAt(naziv, brojac, 1);
                dt.setValueAt(sp.getKolicina(), brojac, 2);
                dt.setValueAt(sp.getCena(), brojac, 3);

                ukupnaCena += sp.getCena();
                brojac++;
            }
        }

        txtUkupnaCena.setText("Ukupna cena: " + ukupnaCena);

        tblStavke.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tblStavke.setRowSelectionAllowed(true);
        tblStavke.setColumnSelectionAllowed(false);

        tblStavke.getColumnModel().getColumn(0).setMinWidth(0);
        tblStavke.getColumnModel().getColumn(0).setMaxWidth(0);
        tblStavke.getColumnModel().getColumn(0).setWidth(0);
    }

    private void popuniMusterije() {

        try {

            musterije = Kontroler.getInstance().vratiListuSviMusterija();

            for (Musterija musterija : musterije) {
                cboxMusterije.addItem(musterija);
            }

            cboxMusterije.setSelectedIndex(-1);

        } catch (Exception ex) {
            System.out.println("Greska pri popunjavanju comboboxa musuterija" + ex.getMessage());
        }

    }

    private LocalDateTime vratiDatumVreme() {
        Date izabranDatum = jDatum.getDate();
        LocalDate localDate = izabranDatum.toInstant().atZone(java.time.ZoneId.systemDefault())
                .toLocalDate();

        Date izabranoVreme = (Date) jVreme.getValue();
        LocalTime localTime = izabranoVreme.toInstant().atZone(java.time.ZoneId.systemDefault())
                .toLocalTime();

        LocalDateTime datumVreme = LocalDateTime.of(localDate, localTime);
        return datumVreme;
    }

    private void popuniAtribute() {

        try {
            Porudzbina p = Kontroler.getInstance().pretraziPorudzbina(idPorudzbine);

            txtNapomena.setText(p.getNapomena());

            if (p.getNacinIsporuke().equals("Dostava")) {
                jRadioDostava.setSelected(true);
                btnObrisiStavku.setEnabled(true);
            } else if (p.getNacinIsporuke().equals("Preuzimanje")) {
                jRadioPreuzimanje.setSelected(true);
                btnObrisiStavku.setEnabled(true);
            }

            if (p.getDatumVreme() != null) {
                jDatum.setDate(Date.from(
                        p.getDatumVreme()
                                .toLocalDate()
                                .atStartOfDay(ZoneId.systemDefault())
                                .toInstant()
                ));

                LocalDateTime datum = p.getDatumVreme();
                Date date = Date.from(datum.atZone(ZoneId.systemDefault()).toInstant());

                SpinnerDateModel model = new SpinnerDateModel();
                jVreme.setModel(model);
                jVreme.setEditor(new JSpinner.DateEditor(jVreme, "HH:mm"));

                model.setValue(date);
            }

            if (p.getIdMusterija() != 0) {
                for (Musterija m : musterije) {
                    if (m.getIdMusterija() == p.getIdMusterija()) {
                        cboxMusterije.setSelectedItem(m);
                    }
                }
            }

        } catch (Exception ex) {
            System.out.println("Greska pri vracanju porudzbine" + ex.getMessage());
        }

    }
}
