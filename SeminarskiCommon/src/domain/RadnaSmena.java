/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Slobodan
 */
public class RadnaSmena extends AbstractDomainObject {

    private int idRadnaSmena;
    private String naziv;
    private LocalTime vremeOd;
    private LocalTime vremeDo;

    public RadnaSmena() {
    }

    public RadnaSmena(int idRadnaSmena, String naziv, LocalTime vremeOd, LocalTime vremeDo) {
        this.idRadnaSmena = idRadnaSmena;
        this.naziv = naziv;
        this.vremeOd = vremeOd;
        this.vremeDo = vremeDo;
    }

    public int getIdRadnaSmena() {
        return idRadnaSmena;
    }

    public void setIdRadnaSmena(int idRadnaSmena) {
        this.idRadnaSmena = idRadnaSmena;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public LocalTime getVremeOd() {
        return vremeOd;
    }

    public void setVremeOd(LocalTime vremeOd) {
        this.vremeOd = vremeOd;
    }

    public LocalTime getVremeDo() {
        return vremeDo;
    }

    public void setVremeDo(LocalTime vremeDo) {
        this.vremeDo = vremeDo;
    }

    @Override
    public String toString() {
        return naziv;
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
        final RadnaSmena other = (RadnaSmena) obj;
        return this.idRadnaSmena == other.idRadnaSmena;
    }

    @Override
    public String tableName() {
        return "radnasmena";
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
        return "(naziv,vremeOd,vremeDo)";
    }

    @Override
    public String insertValues() {
        return "'" + naziv + "', '" + java.sql.Time.valueOf(vremeOd) + "','" + java.sql.Time.valueOf(vremeDo) + "'";
    }

    @Override
    public String updateValues() {
        return " naziv= '" + naziv + "', vremeOd= '" + java.sql.Time.valueOf(vremeOd) + "',vremeDo='" + java.sql.Time.valueOf(vremeDo) + "'";
    }

    @Override
    public String requiredCondition() {
        return " idRadnaSmena=" + idRadnaSmena;
    }

    @Override
    public String conditionForSelect() {
        if (naziv == null && vremeOd == null && vremeDo==null && idRadnaSmena==0) {
            return "";
        }

        //if (!tipovi.isEmpty()) {
        //  return " WHERE tt.idTipa= " + tipovi.get(0).getIdTipa();
        //}
        return " WHERE naziv LIKE '%" + naziv + "%' ";    }

    @Override
    public String getIdCondition() {
        return "WHERE idRadnaSmena="+idRadnaSmena;
    }

    @Override
    public ArrayList<AbstractDomainObject> getList(ResultSet rs) throws SQLException {
        ArrayList<AbstractDomainObject> lista = new ArrayList<>();

        while (rs.next()) {

            java.sql.Time sqlVremeOd = rs.getTime("vremeOd");
            java.sql.Time sqlVremeDo = rs.getTime("vremeDo");

            // Konvertovanje u LocalTime
            LocalTime vremeOd = sqlVremeOd != null ? sqlVremeOd.toLocalTime() : null;
            LocalTime vremeDo = sqlVremeDo != null ? sqlVremeDo.toLocalTime() : null;

            RadnaSmena radnasmena = new RadnaSmena(rs.getInt("idRadnaSmena"), rs.getString("naziv"), vremeOd, vremeDo);

            lista.add(radnasmena);
        }
        rs.close();
        return lista;
    }

    @Override
    public AbstractDomainObject getAdo(ResultSet rs) {
        try {
            java.sql.Time sqlVremeOd = rs.getTime("vremeOd");
            java.sql.Time sqlVremeDo = rs.getTime("vremeDo");

            // Konvertovanje u LocalTime
            LocalTime vremeOd = sqlVremeOd != null ? sqlVremeOd.toLocalTime() : null;
            LocalTime vremeDo = sqlVremeDo != null ? sqlVremeDo.toLocalTime() : null;

            RadnaSmena radnasmena = new RadnaSmena(rs.getInt("idRadnaSmena"), rs.getString("naziv"), vremeOd, vremeDo);

            return radnasmena;
        } catch (SQLException ex) {
            Logger.getLogger(Mesto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
