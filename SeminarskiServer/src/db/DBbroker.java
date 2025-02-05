/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

import domain.Mesto;
import domain.Musterija;
import domain.Proizvod;
import domain.RadnaSmena;
import domain.Radnik;
import java.util.List;
import java.sql.*;
import java.time.LocalTime;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Slobodan
 */
public class DBbroker {

    public DBbroker() {
    }

    public Radnik getRadnik(Radnik r) throws SQLException {

        try {
            Connection k = DBConnection.getInstance().getConnection();

            String upit = "SELECT * FROM radnik WHERE korisnickoIme=? AND lozinka=?";

            PreparedStatement ps = k.prepareStatement(upit);

            ps.setString(1, r.getKorIme());
            ps.setString(2, r.getLoznika());

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                r.setIme(rs.getString("ime"));
                r.setPrezime(rs.getString("prezime"));
            } else {
                throw new SQLException("Korisnik ne postoji");
            }

            rs.close();
            ps.close();
            System.out.println("Uspesno ucitavanje Radnika iz baze");
            return r;
        } catch (SQLException ex) {
            System.out.println("Radnik nije pronadjen u bazi");
            ex.printStackTrace();
            throw ex;
        }
    }

    public List<Proizvod> vratiListuSviProizvodi() throws SQLException {

        List<Proizvod> proizvodi = new ArrayList<>();
        boolean ima = false;
        try {
            Connection k = DBConnection.getInstance().getConnection();

            Statement s = k.createStatement();

            String query = "SELECT * FROM proizvod";

            ResultSet rs = s.executeQuery(query);

            while (rs.next()) {
                Proizvod p = new Proizvod(rs.getInt("idProizvod"), rs.getString("naziv"), rs.getInt("jedinicnaCena"));
                proizvodi.add(p);
                ima = true;
            }

            if (ima == false) {
                throw new SQLException("Nema proizvoda u bazi");
            }

            rs.close();
            s.close();

            return proizvodi;

        } catch (SQLException ex) {

            System.out.println(ex.getMessage());
            throw ex;
        }

    }

    public List<Mesto> vratiListuSviMesto() throws SQLException {

        List<Mesto> mesta = new ArrayList<>();

        boolean ima = false;

        try {
            Connection k = DBConnection.getInstance().getConnection();

            Statement s = k.createStatement();

            String query = "SELECT * FROM mesto";

            ResultSet rs = s.executeQuery(query);

            while (rs.next()) {
                Mesto m = new Mesto(rs.getInt("idMesto"), rs.getString("grad"), rs.getString("adresa"));
                mesta.add(m);
                ima = true;
            }

            if (ima == false) {
                throw new SQLException("Nema mesta u bazi");
            }

            rs.close();
            s.close();

            return mesta;

        } catch (SQLException ex) {

            System.out.println(ex.getMessage());
            throw ex;
        }

    }

    public List<RadnaSmena> vratiListuSviRadnaSmena() throws SQLException {

        List<RadnaSmena> radneSmene = new ArrayList<>();
        boolean ima = true;
        try {
            Connection k = DBConnection.getInstance().getConnection();

            Statement s = k.createStatement();

            String query = "SELECT * FROM radnasmena";

            ResultSet rs = s.executeQuery(query);

            while (rs.next()) {
                java.sql.Time sqlVremeOd = rs.getTime("vremeOd");
                java.sql.Time sqlVremeDo = rs.getTime("vremeDo");

                // Konvertovanje u LocalTime
                LocalTime vremeOd = sqlVremeOd != null ? sqlVremeOd.toLocalTime() : null;
                LocalTime vremeDo = sqlVremeDo != null ? sqlVremeDo.toLocalTime() : null;

                RadnaSmena radnasmena = new RadnaSmena(rs.getInt("idRadnaSmena"), rs.getString("naziv"), vremeOd, vremeDo);

                radneSmene.add(radnasmena);
                ima = true;
            }

            if (ima == false) {
                throw new SQLException("Neuspelo ucitavanje radne smene iz baze");
            }

            rs.close();
            s.close();

            return radneSmene;

        } catch (SQLException ex) {

            System.out.println(ex.getMessage());
            throw ex;
        }

    }

    public boolean kreirajProizvod(Proizvod p) throws SQLException {

        try {
            Connection k = DBConnection.getInstance().getConnection();

            String query = "INSERT INTO proizvod (naziv,jedinicnaCena) VALUES (?,?)";
            PreparedStatement ps = k.prepareStatement(query);

            ps.setString(1, p.getNaziv());
            ps.setInt(2, p.getJedinicnaCena());

            ps.executeUpdate();

            ps.close();

            return true;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw ex;
        }
    }

    public boolean kreirajMesto(Mesto m) throws SQLException {
        try {
            Connection k = DBConnection.getInstance().getConnection();

            String query = "INSERT INTO mesto (grad,adresa) VALUES (?,?)";
            PreparedStatement ps = k.prepareStatement(query);

            ps.setString(1, m.getGrad());
            ps.setString(2, m.getAdresa());

            ps.executeUpdate();

            ps.close();

            return true;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw ex;
        }
    }

    public boolean kreirajMusterija(Musterija m) throws Exception {
        try {
            Connection k = DBConnection.getInstance().getConnection();

            String query = "INSERT INTO musterija (ime,prezime,brojTelefona,idMesto) VALUES (?,?,?,?)";
            PreparedStatement ps = k.prepareStatement(query);

            ps.setString(1, m.getIme());
            ps.setString(2, m.getPrezime());
            ps.setString(3, m.getBrojTelefona());
            ps.setInt(4, m.getIdMesto());

            ps.executeUpdate();

            ps.close();

            return true;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw ex;
        }
    }

    public boolean ubaciRadnuSmenu(RadnaSmena rs) throws SQLException {

        try {
            Connection k = DBConnection.getInstance().getConnection();

            String query = "INSERT INTO radnasmena (naziv,vremeOd,vremeDo) VALUES (?,?,?)";
            PreparedStatement ps = k.prepareStatement(query);

            ps.setString(1, rs.getNaziv());
            ps.setTime(2, java.sql.Time.valueOf(rs.getVremeOd()));
            ps.setTime(3, java.sql.Time.valueOf(rs.getVremeDo()));

            ps.executeUpdate();

            ps.close();

            return true;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw ex;
        }

    }

    public boolean obrisiRadnaSmena(int idRadneSmene) throws SQLException {

        try {
            Connection k = DBConnection.getInstance().getConnection();

            String query = "DELETE FROM radnasmena  WHERE idRadnaSmena=?";
            PreparedStatement ps = k.prepareStatement(query);

            ps.setInt(1, idRadneSmene);

            ps.executeUpdate();

            ps.close();

            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw ex;
        }

    }

    public List<Radnik> vratiListuSviRadnik() {

        List<Radnik> radnici = new ArrayList<>();
        try {
            Connection k = DBConnection.getInstance().getConnection();

            Statement s = k.createStatement();

            String query = "SELECT * FROM radnik";

            ResultSet rs = s.executeQuery(query);

            while (rs.next()) {
                Radnik r = new Radnik(rs.getString("ime"), rs.getString("prezime"), rs.getString("korisnickoIme"), rs.getString("lozinka"));
                radnici.add(r);
            }

            s.close();

            return radnici;

        } catch (SQLException ex) {

            System.out.println(ex.getMessage());
            return null;
        }

    }

    public void kreirajRadnika(String ime, String prezime, String korIme, String pass) {

        try {
            Connection k = DBConnection.getInstance().getConnection();

            String query = "INSERT INTO radnik (ime,prezime,korisnickoIme,lozinka) VALUES (?,?,?,?)";
            PreparedStatement ps = k.prepareStatement(query);

            ps.setString(1, ime);
            ps.setString(2, prezime);
            ps.setString(3, korIme);
            ps.setString(4, pass);

            ps.executeUpdate();

            ps.close();

            JOptionPane.showMessageDialog(null, "Uspesno kreiran radnik");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }

    }

}
