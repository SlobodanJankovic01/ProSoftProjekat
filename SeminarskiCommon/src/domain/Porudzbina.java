/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
/**
 *
 * @author Slobodan
 */
public class Porudzbina extends AbstractDomainObject{
    
    private int idPorudzbina;
    private String nacinIsporuke;
    private int ukupnaCena;
    private LocalDateTime datumVreme;
    private String napomena;
    private int idRadnik;
    private int idMusterija;

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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String alies() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String textJoin() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String insertColumns() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String insertValues() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String updateValues() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String requiredCondition() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String conditionForSelect() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getIdCondition() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<AbstractDomainObject> getList(ResultSet rs) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
    
    
    
    
    
    
}
