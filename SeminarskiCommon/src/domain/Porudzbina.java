/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Slobodan
 */
public class Porudzbina extends AbstractDomainObject {

    private int idPorudzbina;
    private String nacinIsporuke;
    private int ukupnaCena;
    private LocalDateTime datumVreme;
    private String napomena;
    private int idRadnik;
    private int idMusterija;
    private Proizvod pom;

    public Porudzbina() {
    }

    public Porudzbina(int idPorudzbina, String nacinIsporuke, int ukupnaCena, LocalDateTime datumVreme, String napomena, int idRadnik, int idMusterija) {
        this.idPorudzbina = idPorudzbina;
        this.nacinIsporuke = nacinIsporuke;
        this.ukupnaCena = ukupnaCena;
        this.datumVreme = datumVreme;
        this.napomena = napomena;
        this.idRadnik = idRadnik;
        this.idMusterija = idMusterija;
    }

    public int getIdPorudzbina() {
        return idPorudzbina;
    }

    public void setIdPorudzbina(int idPorudzbina) {
        this.idPorudzbina = idPorudzbina;
    }

    public String getNacinIsporuke() {
        return nacinIsporuke;
    }

    public void setNacinIsporuke(String nacinIsporuke) {
        this.nacinIsporuke = nacinIsporuke;
    }

    public int getUkupnaCena() {
        return ukupnaCena;
    }

    public void setUkupnaCena(int ukupnaCena) {
        this.ukupnaCena = ukupnaCena;
    }

    public LocalDateTime getDatumVreme() {
        return datumVreme;
    }

    public void setDatumVreme(LocalDateTime datumVreme) {
        this.datumVreme = datumVreme;
    }

    public String getNapomena() {
        return napomena;
    }

    public void setNapomena(String napomena) {
        this.napomena = napomena;
    }

    public int getIdRadnik() {
        return idRadnik;
    }

    public void setIdRadnik(int idRadnik) {
        this.idRadnik = idRadnik;
    }

    public int getIdMusterija() {
        return idMusterija;
    }

    public void setIdMusterija(int idMusterija) {
        this.idMusterija = idMusterija;
    }

    public Proizvod getPom() {
        return pom;
    }

    public void setPom(Proizvod pom) {
        this.pom = pom;
    }

    @Override
    public String toString() {
        return "Porudzbina{" + "idPorudzbina=" + idPorudzbina + ", nacinIsporuke=" + nacinIsporuke + ", ukupnaCena=" + ukupnaCena + ", datumVreme=" + datumVreme + ", napomena=" + napomena + ", idRadnik=" + idRadnik + ", idMusterija=" + idMusterija + '}';
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
        final Porudzbina other = (Porudzbina) obj;
        return this.idPorudzbina == other.idPorudzbina;
    }

    @Override
    public String tableName() {
        return "porudzbina";
    }

    @Override
    public String alies() {
        return "p";
    }

    @Override
    public String textJoin() {

        if (pom != null) {
            return "JOIN stavkaporudzbine sp ON p.idPorudzbina = sp.idPorudzbina";
        }

        return "";
    }

    @Override
    public String insertColumns() {
        return "(nacinIsporuke,ukupnaCena,datumVreme,napomena,idRadnik,idMusterija)";
    }

    @Override
    public String insertValues() {
        return "'" + nacinIsporuke + "'," + ukupnaCena + ", '" + datumVreme + "','" + napomena + "'," + idRadnik + "," + idMusterija;
    }

    @Override
    public String updateValues() {
        return "nacinIsporuke='" + nacinIsporuke + "' , ukupnaCena= " + ukupnaCena + ", datumVreme='" + datumVreme + "',napomena='" + napomena
                + "',idRadnik=" + idRadnik + ", idMusterija=" + idMusterija;
    }

    @Override
    public String requiredCondition() {
        return " idPorudzbina=" + idPorudzbina;
    }

    @Override
    public String conditionForSelect() {

        if (pom != null) {
            return "WHERE sp.idProizvod=" + pom.getIdProizvod();
        }
        
        if (nacinIsporuke == null && ukupnaCena == 0 && datumVreme == null && idPorudzbina == 0 && napomena == null
                && idRadnik == 0 && idMusterija == 0) {
            return "";
        }

        if (!(idMusterija == 0)) {
            return " WHERE idMusterija= " + idMusterija;
        }

        if (!(idRadnik == 0)) {
            return " WHERE idRadnik= " + idRadnik;
        }

        return " WHERE nacinIsporuke LIKE '%" + nacinIsporuke + "%'";
    }

    @Override
    public String getIdCondition() {
        return "WHERE idPorudzbina=" + idPorudzbina;
    }

    @Override
    public ArrayList<AbstractDomainObject> getList(ResultSet rs) throws SQLException {
        ArrayList<AbstractDomainObject> lista = new ArrayList<>();

        while (rs.next()) {

            Porudzbina p = new Porudzbina(rs.getInt("idPorudzbina"), rs.getString("nacinIsporuke"), rs.getInt("ukupnaCena"),
                    rs.getTimestamp("datumVreme").toLocalDateTime(), rs.getString("napomena"),
                    rs.getInt("idRadnik"), rs.getInt("idMusterija"));
            lista.add(p);
        }
        rs.close();
        return lista;
    }

    @Override
    public AbstractDomainObject getAdo(ResultSet rs) {
        try {
            Porudzbina p = new Porudzbina(rs.getInt("idPorudzbina"), rs.getString("nacinIsporuke"), rs.getInt("ukupnaCena"),
                    rs.getTimestamp("datumVreme").toLocalDateTime(), rs.getString("napomena"),
                    rs.getInt("idRadnik"), rs.getInt("idMusterija"));

            return p;
        } catch (SQLException ex) {
            Logger.getLogger(Mesto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
