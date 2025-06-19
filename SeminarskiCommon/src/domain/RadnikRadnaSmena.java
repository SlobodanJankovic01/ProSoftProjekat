/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Slobodan
 */
public class RadnikRadnaSmena extends AbstractDomainObject {

    private int id;
    private int idRadnik;
    private int idRadnaSmena;
    private LocalDate datum;

    public RadnikRadnaSmena() {
    }

    public RadnikRadnaSmena(int id, int idRadnik, int idRadnaSmena, LocalDate datum) {
        this.id = id;
        this.idRadnik = idRadnik;
        this.idRadnaSmena = idRadnaSmena;
        this.datum = datum;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdRadnik() {
        return idRadnik;
    }

    public void setIdRadnik(int idRadnik) {
        this.idRadnik = idRadnik;
    }

    public int getIdRadnaSmena() {
        return idRadnaSmena;
    }

    public void setIdRadnaSmena(int idRadnaSmena) {
        this.idRadnaSmena = idRadnaSmena;
    }

    public LocalDate getDatum() {
        return datum;
    }

    public void setDatum(LocalDate datum) {
        this.datum = datum;
    }

    @Override
    public String toString() {
        return "RadnikRadnaSmena{" + "id=" + id + ", idRadnik=" + idRadnik + ", idRadnaSmena=" + idRadnaSmena + ", datum=" + datum + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
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
        final RadnikRadnaSmena other = (RadnikRadnaSmena) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.idRadnik != other.idRadnik) {
            return false;
        }
        return this.idRadnaSmena == other.idRadnaSmena;
    }

    @Override
    public String tableName() {
        return "rrs";
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
        return "(idRadnik,idRadnaSmena,datum)";
    }

    @Override
    public String insertValues() {
        return "" + idRadnik + ", " + idRadnaSmena + ",'" + datum + "'";
    }

    @Override
    public String updateValues() {
        return " idRadnik= " + idRadnik + ", idRadnaSmena= " + idRadnaSmena + ", datum= '" + datum + "'";
    }

    @Override
    public String requiredCondition() {
        return "id=" + id;
    }

    @Override
    public String conditionForSelect() {
        return "";
    }

    @Override
    public String getIdCondition() {
        return "WHERE id="+id;
    }

    @Override
    public ArrayList<AbstractDomainObject> getList(ResultSet rs) throws SQLException {
        ArrayList<AbstractDomainObject> lista = new ArrayList<>();

        while (rs.next()) {

            int id = rs.getInt("id");
            int idRadnika = rs.getInt("idRadnik");
            int idRadneSmene = rs.getInt("idRadnaSmena");

            java.sql.Date sqlDate = rs.getDate("datum");
            LocalDate datum = sqlDate != null ? sqlDate.toLocalDate() : null;

            RadnikRadnaSmena rrs = new RadnikRadnaSmena(id, idRadnika, idRadneSmene, datum);
            lista.add(rrs);
        }
        rs.close();
        return lista;
    }

    @Override
    public AbstractDomainObject getAdo(ResultSet rs) {
        try {
            int id = rs.getInt("id");
            int idRadnika = rs.getInt("idRadnik");
            int idRadneSmene = rs.getInt("idRadnaSmena");

            java.sql.Date sqlDate = rs.getDate("datum");
            LocalDate datum = sqlDate != null ? sqlDate.toLocalDate() : null;

            RadnikRadnaSmena rrs = new RadnikRadnaSmena(id, idRadnika, idRadneSmene, datum);
            return rrs;
        } catch (SQLException ex) {
            Logger.getLogger(Mesto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
