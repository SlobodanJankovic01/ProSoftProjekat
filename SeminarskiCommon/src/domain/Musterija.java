/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Slobodan
 */
public class Musterija extends AbstractDomainObject {

    private int idMusterija;
    private String ime;
    private String prezime;
    private String brojTelefona;
    private int idMesto;

    public Musterija() {
    }

    public Musterija(int idMusterija, String ime, String prezime, String brojTelefona, int idMesto) {
        this.idMusterija = idMusterija;
        this.ime = ime;
        this.prezime = prezime;
        this.brojTelefona = brojTelefona;
        this.idMesto = idMesto;
    }

    public int getIdMusterija() {
        return idMusterija;
    }

    public void setIdMusterija(int idMusterija) {
        this.idMusterija = idMusterija;
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

    public String getBrojTelefona() {
        return brojTelefona;
    }

    public void setBrojTelefona(String brojTelefona) {
        this.brojTelefona = brojTelefona;
    }

    public int getIdMesto() {
        return idMesto;
    }

    public void setIdMesto(int idMesto) {
        this.idMesto = idMesto;
    }

    @Override
    public String toString() {
        return ime + " " + prezime;
    }

    @Override
    public int hashCode() {
        int hash = 5;
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
        final Musterija other = (Musterija) obj;
        return this.idMusterija == other.idMusterija;
    }

    @Override
    public String tableName() {
        return "musterija";
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
        return "(ime,prezime,brojTelefona,idMesto)";
    }

    @Override
    public String insertValues() {
        return "'" + ime + "', '" + prezime + "', '" + brojTelefona + "', " + idMesto;
    }

    @Override
    public String updateValues() {
        return " ime= '" + ime + "', prezime= '" + prezime + "', brojTelefona='" + brojTelefona + "', idMesto=" + idMesto;
    }

    @Override
    public String requiredCondition() {
        return " idMusterija=" + idMusterija;
    }

    @Override
    public String conditionForSelect() {
        if (ime == null && prezime == null && brojTelefona == null && idMesto == 0 ) {
            return "";
        }

        //if (!tipovi.isEmpty()) {
          //  return " WHERE tt.idTipa= " + tipovi.get(0).getIdTipa();
        //}

        return " WHERE ime LIKE '%" + ime + "%' ";
    }

    @Override
    public String getIdCondition() {
        return "WHERE idMusterija=" + idMusterija;
    }

    @Override
    public ArrayList<AbstractDomainObject> getList(ResultSet rs) throws SQLException {
        ArrayList<AbstractDomainObject> lista = new ArrayList<>();

        while (rs.next()) {

            int idMusterija = rs.getInt("idMusterija");
            String ime = rs.getString("ime");
            String prezime = rs.getString("prezime");
            String brTelefona = rs.getString("brojTelefona");
            int idMesta = rs.getInt("idMesto");

            Musterija m = new Musterija(idMusterija, ime, prezime, brTelefona, idMesta);

            lista.add(m);
        }
        rs.close();
        return lista;
    }

    @Override
    public AbstractDomainObject getAdo(ResultSet rs) {
        try {
            int idMusterija = rs.getInt("idMusterija");
            String ime = rs.getString("ime");
            String prezime = rs.getString("prezime");
            String brTelefona = rs.getString("brojTelefona");
            int idMesta = rs.getInt("idMesto");

            Musterija m = new Musterija(idMusterija, ime, prezime, brTelefona, idMesta);

            return m;
        } catch (SQLException ex) {
            Logger.getLogger(Mesto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
