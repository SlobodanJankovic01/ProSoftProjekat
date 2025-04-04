/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

import domain.Mesto;
import domain.Musterija;
import domain.Porudzbina;
import domain.Proizvod;
import domain.RadnaSmena;
import domain.Radnik;
import domain.RadnikRadnaSmena;
import domain.StavkaPorudzbina;
import java.util.List;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
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

    public List<RadnikRadnaSmena> vratiListuSviRadnikRadnaSmena() throws SQLException {

        List<RadnikRadnaSmena> raspored = new ArrayList<>();

        try {
            Connection k = DBConnection.getInstance().getConnection();

            Statement s = k.createStatement();

            String query = "SELECT * FROM rrs";

            ResultSet rs = s.executeQuery(query);

            while (rs.next()) {
                int id = rs.getInt("id");
                int idRadnika = rs.getInt("idRadnik");
                int idRadneSmene = rs.getInt("idRadnaSmena");

                java.sql.Date sqlDate = rs.getDate("datum");
                LocalDate datum = sqlDate != null ? sqlDate.toLocalDate() : null;

                RadnikRadnaSmena rrs = new RadnikRadnaSmena(id, idRadnika, idRadneSmene, datum);
                raspored.add(rrs);
            }

            if (raspored.isEmpty()) {
                throw new SQLException("Baza raspoerda je prazna");
            }

            rs.close();
            s.close();

            return raspored;

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

    public boolean kreirajRadnikRadnaSmena(RadnikRadnaSmena rrs) throws SQLException {
        try {
            Connection k = DBConnection.getInstance().getConnection();

            String query = "INSERT INTO rrs (idRadnik,idRadnaSmena,datum) VALUES (?,?,?)";
            PreparedStatement ps = k.prepareStatement(query);

            ps.setInt(1, rrs.getIdRadnik());
            ps.setInt(2, rrs.getIdRadnaSmena());
            ps.setDate(3, java.sql.Date.valueOf(rrs.getDatum()));

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

    public Object obrisiRadnikRadnaSmena(int i) throws SQLException {
        try {
            Connection k = DBConnection.getInstance().getConnection();

            String query = "DELETE FROM rrs WHERE id=?";
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

    public Object promeniRadnikRadnaSmena(RadnikRadnaSmena rrs) throws SQLException {
        try {
            Connection k = DBConnection.getInstance().getConnection();

            String query = "UPDATE rrs SET idRadnik= ?, idRadnaSmena=?, datum=? WHERE id=?";
            PreparedStatement ps = k.prepareStatement(query);

            ps.setInt(1, rrs.getIdRadnik());
            ps.setInt(2, rrs.getIdRadnaSmena());
            ps.setDate(3, java.sql.Date.valueOf(rrs.getDatum()));
            ps.setInt(4, rrs.getId());

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

    public Proizvod pretraziProizvod(int id) throws SQLException {
        try {
            Connection k = DBConnection.getInstance().getConnection();

            String query = "SELECT * FROM proizvod WHERE idProizvod=?";
            PreparedStatement ps = k.prepareStatement(query);

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            Proizvod p = new Proizvod();

            if (rs.next()) {
                p.setIdProizvod(rs.getInt("idProizvod"));
                p.setNaziv(rs.getString("naziv"));
                p.setJedinicnaCena(rs.getInt("jedinicnaCena"));
            }

            rs.close();
            ps.close();

            return p;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw ex;
        }
    }

    public Mesto pretraziMesto(int i) throws SQLException {
        try {
            Connection k = DBConnection.getInstance().getConnection();

            String query = "SELECT * FROM mesto WHERE idMesto=?";
            PreparedStatement ps = k.prepareStatement(query);

            ps.setInt(1, i);

            ResultSet rs = ps.executeQuery();

            Mesto m = new Mesto();

            if (rs.next()) {
                m.setIdMesto(rs.getInt("idMesto"));
                m.setGrad(rs.getString("grad"));
                m.setAdresa(rs.getString("adresa"));
            }

            rs.close();
            ps.close();

            return m;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw ex;
        }
    }

    public Musterija pretraziMusterija(int i) throws SQLException {
        try {
            Connection k = DBConnection.getInstance().getConnection();

            String query = "SELECT * FROM musterija WHERE idMusterija=?";
            PreparedStatement ps = k.prepareStatement(query);

            ps.setInt(1, i);

            ResultSet rs = ps.executeQuery();

            Musterija m = new Musterija();

            if (rs.next()) {
                m.setIdMusterija(rs.getInt("idMusterija"));
                m.setIme(rs.getString("ime"));
                m.setPrezime(rs.getString("prezime"));
                m.setBrojTelefona(rs.getString("brojTelefona"));
                m.setIdMesto(rs.getInt("idMesto"));
            }

            rs.close();
            ps.close();

            return m;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw ex;
        }
    }

    public RadnaSmena pretraziRadnaSmena(int i) throws SQLException {
        try {
            Connection k = DBConnection.getInstance().getConnection();

            String query = "SELECT * FROM radnasmena WHERE idRadnaSmena=?";
            PreparedStatement ps = k.prepareStatement(query);

            ps.setInt(1, i);

            ResultSet rs = ps.executeQuery();

            RadnaSmena r = new RadnaSmena();

            if (rs.next()) {
                java.sql.Time sqlVremeOd = rs.getTime("vremeOd");
                java.sql.Time sqlVremeDo = rs.getTime("vremeDo");

                LocalTime vremeOd = sqlVremeOd != null ? sqlVremeOd.toLocalTime() : null;
                LocalTime vremeDo = sqlVremeDo != null ? sqlVremeDo.toLocalTime() : null;

                r.setIdRadnaSmena(rs.getInt("idRadnaSmena"));
                r.setNaziv(rs.getString("naziv"));
                r.setVremeOd(vremeOd);
                r.setVremeDo(vremeDo);
            }

            rs.close();
            ps.close();

            return r;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw ex;
        }
    }

    public Radnik pretraziRadnik(int i) throws SQLException {
        try {
            Connection k = DBConnection.getInstance().getConnection();

            String query = "SELECT * FROM radnik WHERE idRadnik=?";
            PreparedStatement ps = k.prepareStatement(query);

            ps.setInt(1, i);

            ResultSet rs = ps.executeQuery();

            Radnik r = new Radnik();

            if (rs.next()) {
                r.setIdRadnik(rs.getInt("idRadnik"));
                r.setIme(rs.getString("ime"));
                r.setPrezime(rs.getString("prezime"));
                r.setKorIme(rs.getString("korisnickoIme"));
            }

            rs.close();
            ps.close();

            return r;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw ex;
        }
    }

    public List<Mesto> vratiListuMesto(String argument) throws SQLException {
        List<Mesto> mesta = new ArrayList<>();

        try {
            Connection k = DBConnection.getInstance().getConnection();
            String query = "SELECT * FROM mesto WHERE grad LIKE ?";
            PreparedStatement ps = k.prepareStatement(query);
            ps.setString(1, "%" + argument + "%");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Mesto m = new Mesto(rs.getInt("idMesto"), rs.getString("grad"), rs.getString("adresa"));
                mesta.add(m);
            }

            if (mesta.isEmpty()) {
                throw new SQLException("Nema mesta u bazi");
            }

            rs.close();
            ps.close();

            return mesta;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw ex;
        }
    }

    public List<Musterija> vratiListuMusterija(String argument) throws SQLException {
        List<Musterija> musterije = new ArrayList<>();

        try {
            Connection k = DBConnection.getInstance().getConnection();
            String query = "SELECT * FROM musterija WHERE ime LIKE ?";

            PreparedStatement ps = k.prepareStatement(query);

            ps.setString(1, "%" + argument + "%");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Musterija m = new Musterija(rs.getInt("idMusterija"), rs.getString("ime"), rs.getString("prezime"),
                        rs.getString("brojTelefona"), rs.getInt("idMesto"));
                musterije.add(m);
            }

            if (musterije.isEmpty()) {
                throw new SQLException("Nema musterija u bazi");
            }

            rs.close();
            ps.close();

            return musterije;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw ex;
        }
    }

    public List<Proizvod> vratiListuProizvod(String argument) throws SQLException {

        List<Proizvod> proizvodi = new ArrayList<>();

        try {
            Connection k = DBConnection.getInstance().getConnection();
            String query = "SELECT * FROM proizvod WHERE naziv LIKE ?";

            PreparedStatement ps = k.prepareStatement(query);

            ps.setString(1, "%" + argument + "%");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Proizvod p = new Proizvod(rs.getInt("idProizvod"), rs.getString("naziv"), rs.getInt("jedinicnaCena"));
                proizvodi.add(p);
            }

            if (proizvodi.isEmpty()) {
                throw new SQLException("Nema proizvoda u bazi");
            }

            rs.close();
            ps.close();

            return proizvodi;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw ex;
        }
    }

    public List<Radnik> vratiListuRadnik(String ime) throws SQLException {

        try {

            List<Radnik> radnici = new ArrayList<>();

            Connection k = DBConnection.getInstance().getConnection();
            String query = "SELECT * FROM radnik WHERE ime LIKE ?";

            PreparedStatement ps = k.prepareStatement(query);

            ps.setString(1, "%" + ime + "%");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Radnik r = new Radnik(rs.getInt("idRadnik"), rs.getString("ime"), rs.getString("prezime"),
                        rs.getString("korisnickoIme"), rs.getString("lozinka"));
                radnici.add(r);
            }

            if (radnici.isEmpty()) {
                throw new SQLException("Nema radnika u bazi");
            }

            rs.close();
            ps.close();

            return radnici;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw ex;
        }
    }

    public List<RadnaSmena> vratiListuRadnaSmena(String naziv) throws SQLException {
        try {

            List<RadnaSmena> radneSmene = new ArrayList<>();

            Connection k = DBConnection.getInstance().getConnection();
            String query = "SELECT * FROM radnasmena WHERE naziv LIKE ?";

            PreparedStatement ps = k.prepareStatement(query);

            ps.setString(1, "%" + naziv + "%");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                java.sql.Time sqlVremeOd = rs.getTime("vremeOd");
                java.sql.Time sqlVremeDo = rs.getTime("vremeDo");

                // Konvertovanje u LocalTime
                LocalTime vremeOd = sqlVremeOd != null ? sqlVremeOd.toLocalTime() : null;
                LocalTime vremeDo = sqlVremeDo != null ? sqlVremeDo.toLocalTime() : null;

                RadnaSmena radnasmena = new RadnaSmena(rs.getInt("idRadnaSmena"), rs.getString("naziv"), vremeOd, vremeDo);

                radneSmene.add(radnasmena);
            }

            if (radneSmene.isEmpty()) {
                throw new SQLException("Nema radnih smena u bazi");
            }

            rs.close();
            ps.close();

            return radneSmene;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw ex;
        }

    }

    public int kreirajPorudzbina(Object argumenti) throws SQLException {
        Porudzbina p = (Porudzbina) argumenti;
        int id = -1;
        try {
            Connection k = DBConnection.getInstance().getConnection();

            String query = "INSERT INTO porudzbina (nacinIsporuke,ukupnaCena,datumVreme,napomena,idRadnik,idMusterija) VALUES (?,?,?,?,?,?)";
            PreparedStatement ps = k.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, p.getNacinIsporuke());
            ps.setInt(2, p.getUkupnaCena());
            ps.setTimestamp(3, Timestamp.valueOf(p.getDatumVreme()));
            ps.setString(4, p.getNapomena());
            ps.setInt(5, p.getIdRadnik());
            ps.setInt(6, p.getIdMusterija());

            int affectedRows = ps.executeUpdate();

            if (affectedRows > 0) {
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    id = rs.getInt(1);
                }
                rs.close();
            }

            ps.close();

            return id;
        } catch (SQLException ex) {
            System.out.println("Neuspelo kreiranje porudzbine" + ex.getMessage());
            throw ex;
        }

    }

    public boolean kreirajStavkuPorudzbina(StavkaPorudzbina sp) throws SQLException {
        try {
            Connection k = DBConnection.getInstance().getConnection();

            String query = "INSERT INTO stavkaporudzbine (idPorudzbina,rb,kolicina,cena,idProizvod) VALUES (?,?,?,?,?)";
            PreparedStatement ps = k.prepareStatement(query);

            ps.setInt(1, sp.getIdPorudzbina());
            ps.setInt(2, sp.getRb());
            ps.setInt(3, sp.getKolicina());
            ps.setInt(4, sp.getCena());
            ps.setInt(5, sp.getIdProizvod());

            ps.executeUpdate();

            ps.close();

            return true;

        } catch (SQLException ex) {
            System.out.println("Neuspelo kreiranje stavke porudzbine" + ex.getMessage());
            throw ex;
        }
    }

    public List<StavkaPorudzbina> vratiListuStavkePorudzbine(int id) throws SQLException {
        List<StavkaPorudzbina> stavke = new ArrayList<>();
        try {
            Connection k = DBConnection.getInstance().getConnection();

            String query = "SELECT * FROM stavkaporudzbine WHERE idPorudzbina=?";

            PreparedStatement ps = k.prepareStatement(query);

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                StavkaPorudzbina sp = new StavkaPorudzbina(rs.getInt("idPorudzbina"), rs.getInt("rb"), rs.getInt("kolicina"),
                        rs.getInt("cena"), rs.getInt("idProizvod"));
                stavke.add(sp);
            }

            rs.close();
            ps.close();

            return stavke;

        } catch (SQLException ex) {

            System.out.println(ex.getMessage());
            throw ex;
        }
    }

}
