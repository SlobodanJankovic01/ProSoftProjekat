/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Slobodan
 */
public class StavkaPorudzbina extends AbstractDomainObject {

    private int idPorudzbina;
    private int rb;
    private int kolicina;
    private int cena;
    private int idProizvod;

    public StavkaPorudzbina() {
    }

    public StavkaPorudzbina(int idPorudzbina, int rb, int kolicina, int cena, int idProizvod) {
        this.idPorudzbina = idPorudzbina;
        this.rb = rb;
        this.kolicina = kolicina;
        this.cena = cena;
        this.idProizvod = idProizvod;
    }

    public int getIdPorudzbina() {
        return idPorudzbina;
    }

    public void setIdPorudzbina(int idPorudzbina) {
        this.idPorudzbina = idPorudzbina;
    }

    public int getRb() {
        return rb;
    }

    public void setRb(int rb) {
        this.rb = rb;
    }

    public int getKolicina() {
        return kolicina;
    }

    public void setKolicina(int kolicina) {
        this.kolicina = kolicina;
    }

    public int getCena() {
        return cena;
    }

    public void setCena(int cena) {
        this.cena = cena;
    }

    public int getIdProizvod() {
        return idProizvod;
    }

    public void setIdProizvod(int idProizvod) {
        this.idProizvod = idProizvod;
    }

    @Override
    public String toString() {
        return "StavkaPorudzbina{" + "idPorudzbina=" + idPorudzbina + ", rb=" + rb + ", kolicina=" + kolicina + ", cena=" + cena + ", idProizvod=" + idProizvod + '}';
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
        final StavkaPorudzbina other = (StavkaPorudzbina) obj;
        if (this.idPorudzbina != other.idPorudzbina) {
            return false;
        }
        return this.rb == other.rb;
    }

    @Override
    public String tableName() {
        return "stavkaporudzbine";
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
        return "(idPorudzbina,rb,kolicina,cena,idProizvod)";
    }

    @Override
    public String insertValues() {
        return idPorudzbina + "," + rb + ", " + kolicina + "," + cena + "," + idProizvod;
    }

    @Override
    public String updateValues() {
        return "idPorudzbina=" + idPorudzbina + ",rb= " + rb + ", kolicina= " + kolicina + ",cena=" + cena + ",idProizvod=" + idProizvod;
    }

    @Override
    public String requiredCondition() {
        return " idPorudzbina=" + idPorudzbina + " AND rb=" + rb + " AND idProizvod=" + idProizvod;
    }

    @Override
    public String conditionForSelect() {
        return "WHERE idPorudzbina=" + idPorudzbina;
    }

    @Override
    public String getIdCondition() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<AbstractDomainObject> getList(ResultSet rs) throws SQLException {
        ArrayList<AbstractDomainObject> lista = new ArrayList<>();

        while (rs.next()) {

            StavkaPorudzbina sp = new StavkaPorudzbina(rs.getInt("idPorudzbina"), rs.getInt("rb"), rs.getInt("kolicina"),
                    rs.getInt("cena"), rs.getInt("idProizvod"));
            lista.add(sp);
        }
        rs.close();
        return lista;
    }

}
