/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Slobodan
 */
public class Radnik extends AbstractDomainObject {

    private int idRadnik;
    private String ime;
    private String prezime;
    private String korIme;
    private String loznika;

    public Radnik() {
    }

    public Radnik(int idRadnik, String ime, String prezime, String korIme, String loznika) {
        this.idRadnik = idRadnik;
        this.ime = ime;
        this.prezime = prezime;
        this.korIme = korIme;
        this.loznika = loznika;
    }

    public int getIdRadnik() {
        return idRadnik;
    }

    public void setIdRadnik(int idRadnik) {
        this.idRadnik = idRadnik;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getKorIme() {
        return korIme;
    }

    public void setKorIme(String korIme) {
        this.korIme = korIme;
    }

    public String getLoznika() {
        return loznika;
    }

    public void setLoznika(String loznika) {
        this.loznika = loznika;
    }

    @Override
    public String toString() {
        return ime + " " + prezime;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Radnik other = (Radnik) obj;
        if (this.idRadnik != other.idRadnik) {
            return false;
        }
        if (!Objects.equals(this.korIme, other.korIme)) {
            return false;
        }
        return Objects.equals(this.loznika, other.loznika);
    }

    @Override
    public String tableName() {
        return "radnik";
    }

    @Override
    public String alies() {
        return "";
    }

    @Override
    public String textJoin() {
        return "";
    }

    @Override
    public String insertColumns() {
        return "(ime,prezime,korisnickoIme,lozinka)";
    }

    @Override
    public String insertValues() {
        return "'" + ime + "', '" + prezime + "','" + korIme + "','" + loznika + "'";
    }

    @Override
    public String updateValues() {
        return " ime= '" + ime + "', prezime= '" + prezime + "', korisnickoIme= '" + korIme + "', lozinka='" + loznika + "'";
    }

    @Override
    public String requiredCondition() {
        return "idRadnik=" + idRadnik;
    }

    @Override
    public String conditionForSelect() {
        if (ime == null && prezime == null && korIme==null && loznika==null && idRadnik==0) {
            return "";
        }

        //if (!tipovi.isEmpty()) {
        //  return " WHERE tt.idTipa= " + tipovi.get(0).getIdTipa();
        //}
        return " WHERE ime LIKE '%" + ime + "%' ";
    }

    @Override
    public String getIdCondition() {
        return "WHERE idRadnik=" + idRadnik;
    }

    @Override
    public ArrayList<AbstractDomainObject> getList(ResultSet rs) throws SQLException {
        ArrayList<AbstractDomainObject> lista = new ArrayList<>();

        while (rs.next()) {

            Radnik r = new Radnik(rs.getInt("idRadnik"), rs.getString("ime"), rs.getString("prezime"),
                    rs.getString("korisnickoIme"), rs.getString("lozinka"));

            lista.add(r);
        }
        rs.close();
        return lista;
    }

    @Override
    public AbstractDomainObject getAdo(ResultSet rs) {
        try {
            Radnik r = new Radnik(rs.getInt("idRadnik"), rs.getString("ime"), rs.getString("prezime"),
                    rs.getString("korisnickoIme"), rs.getString("lozinka"));

            return r;
        } catch (SQLException ex) {
            Logger.getLogger(Mesto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
