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
                r.setIdRadnik(rs.getInt("idRadnik"));
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

    public List<Musterija> vratiListuSviMusterija() throws SQLException {
        List<Musterija> musterije = new ArrayList<>();

        boolean ima = false;

        try {
            Connection k = DBConnection.getInstance().getConnection();

            Statement s = k.createStatement();

            String query = "SELECT * FROM musterija";

            ResultSet rs = s.executeQuery(query);

            while (rs.next()) {
                Musterija m = new Musterija(rs.getInt("idMusterija"), rs.getString("ime"), rs.getString("prezime"),
                        rs.getString("brojTelefona"), rs.getInt("idMesto"));
                musterije.add(m);
                ima = true;
            }

            if (ima == false) {
                throw new SQLException("Nema musterija u bazi");
            }

            rs.close();
            s.close();

            return musterije;

        } catch (SQLException ex) {

            System.out.println(ex.getMessage());
            throw ex;
        }
    }

    public List<Radnik> vratiListuSviRadnik() throws SQLException {

        List<Radnik> radnici = new ArrayList<>();
        boolean ima = false;
        try {
            Connection k = DBConnection.getInstance().getConnection();

            Statement s = k.createStatement();

            String query = "SELECT * FROM radnik";

            ResultSet rs = s.executeQuery(query);

            while (rs.next()) {
                Radnik r = new Radnik(rs.getInt("idRadnik"), rs.getString("ime"), rs.getString("prezime"),
                        rs.getString("korisnickoIme"), rs.getString("lozinka"));
                radnici.add(r);
                ima = true;
            }

            if (ima == false) {
                throw new SQLException("Nema radnika u bazi");
            }

            rs.close();
            s.close();

            return radnici;

        } catch (SQLException ex) {

            System.out.println(ex.getMessage());
            return null;
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

    public boolean kreirajRadnik(Radnik r) throws SQLException {
        try {
            Connection k = DBConnection.getInstance().getConnection();

            String query = "INSERT INTO radnik (ime,prezime,korisnickoIme,lozinka) VALUES (?,?,?,?)";
            PreparedStatement ps = k.prepareStatement(query);

            ps.setString(1, r.getIme());
            ps.setString(2, r.getPrezime());
            ps.setString(3, r.getKorIme());
            ps.setString(4, r.getLoznika());

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

    public Object obrisiProizvod(int i) throws SQLException {

        try {
            Connection k = DBConnection.getInstance().getConnection();

            String query = "DELETE FROM proizvod WHERE idProizvod=?";
            PreparedStatement ps = k.prepareStatement(query);

            ps.setInt(1, i);

            ps.executeUpdate();

            ps.close();

            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw ex;
        }
    }

    public Object obrisiMesto(int i) throws SQLException {
        try {
            Connection k = DBConnection.getInstance().getConnection();

            String query = "DELETE FROM mesto WHERE idMesto=?";
            PreparedStatement ps = k.prepareStatement(query);

            ps.setInt(1, i);

            ps.executeUpdate();

            ps.close();

            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw ex;
        }
    }

    public Object obrisiMusteriju(int i) throws SQLException {
        try {
            Connection k = DBConnection.getInstance().getConnection();

            String query = "DELETE FROM musterija WHERE idMusterija=?";
            PreparedStatement ps = k.prepareStatement(query);

            ps.setInt(1, i);

            ps.executeUpdate();

            ps.close();

            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw ex;
        }
    }

    public Object obrisiRadnik(int i) throws SQLException {
        try {
            Connection k = DBConnection.getInstance().getConnection();

            String query = "DELETE FROM radnik WHERE idRadnik=?";
            PreparedStatement ps = k.prepareStatement(query);

            ps.setInt(1, i);

            ps.executeUpdate();

            ps.close();

            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw ex;
        }
    }

    public Object promeniProizvod(Proizvod proizvod) throws SQLException {
        try {
            Connection k = DBConnection.getInstance().getConnection();

            String query = "UPDATE proizvod SET naziv = ?, jedinicnaCena = ? WHERE idProizvod=?";
            PreparedStatement ps = k.prepareStatement(query);

            ps.setString(1, proizvod.getNaziv());
            ps.setInt(2, proizvod.getJedinicnaCena());
            ps.setInt(3, proizvod.getIdProizvod());

            ps.executeUpdate();

            ps.close();

            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw ex;
        }
    }

    public Object promeniMesto(Mesto mesto) throws SQLException {
        try {
            Connection k = DBConnection.getInstance().getConnection();

            String query = "UPDATE mesto SET grad = ?, adresa= ? WHERE idMesto=?";
            PreparedStatement ps = k.prepareStatement(query);

            ps.setString(1, mesto.getGrad());
            ps.setString(2, mesto.getAdresa());
            ps.setInt(3, mesto.getIdMesto());

            ps.executeUpdate();

            ps.close();

            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw ex;
        }
    }

    public Object promeniRadnuSmenu(RadnaSmena rs) throws SQLException {
        try {
            Connection k = DBConnection.getInstance().getConnection();

            String query = "UPDATE radnasmena SET naziv = ?, vremeOd= ?, vremeDo=? WHERE idRadnaSmena=?";
            PreparedStatement ps = k.prepareStatement(query);

            ps.setString(1, rs.getNaziv());
            ps.setTime(2, java.sql.Time.valueOf(rs.getVremeOd()));
            ps.setTime(3, java.sql.Time.valueOf(rs.getVremeDo()));
            ps.setInt(4, rs.getIdRadnaSmena());

            ps.executeUpdate();

            ps.close();

            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw ex;
        }
    }

    public Object promeniMusteriju(Musterija m) throws SQLException {
        try {
            Connection k = DBConnection.getInstance().getConnection();

            String query = "UPDATE musterija SET ime = ?, prezime= ?, brojTelefona=?, idMesto=? WHERE idMusterija=?";
            PreparedStatement ps = k.prepareStatement(query);

            ps.setString(1, m.getIme());
            ps.setString(2, m.getPrezime());
            ps.setString(3, m.getBrojTelefona());
            ps.setInt(4, m.getIdMesto());
            ps.setInt(5, m.getIdMusterija());

            ps.executeUpdate();

            ps.close();

            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw ex;
        }
    }

    public Object promeniRadnika(Radnik r) throws SQLException {
        try {
            Connection k = DBConnection.getInstance().getConnection();

            String query = "UPDATE radnik SET ime = ?, prezime= ?, korisnickoIme=?, lozinka=? WHERE idRadnik=?";
            PreparedStatement ps = k.prepareStatement(query);

            ps.setString(1, r.getIme());
            ps.setString(2, r.getPrezime());
            ps.setString(3, r.getKorIme());
            ps.setString(4, r.getLoznika());
            ps.setInt(5, r.getIdRadnik());

            ps.executeUpdate();

            ps.close();

            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw ex;
        }
    }

}
