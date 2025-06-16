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
public class Proizvod extends AbstractDomainObject {

    private int idProizvod;
    private String naziv;
    private int jedinicnaCena;

    public Proizvod() {
    }

    public Proizvod(int idProizvod, String naziv, int jedinicnaCena) {
        this.idProizvod = idProizvod;
        this.naziv = naziv;
        this.jedinicnaCena = jedinicnaCena;
    }

    public int getIdProizvod() {
        return idProizvod;
    }

    public void setIdProizvod(int idProizvod) {
        this.idProizvod = idProizvod;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public int getJedinicnaCena() {
        return jedinicnaCena;
    }

    public void setJedinicnaCena(int jedinicnaCena) {
        this.jedinicnaCena = jedinicnaCena;
    }

    @Override
    public String toString() {
        return naziv;
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
        final Proizvod other = (Proizvod) obj;
        return this.idProizvod == other.idProizvod;
    }

    @Override
    public String tableName() {
        return "proizvod";
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
        return "(naziv,jedinicnaCena)";
    }

    @Override
    public String insertValues() {
        return "'" + naziv + "', " + jedinicnaCena;
    }

    @Override
    public String updateValues() {
        return " naziv= '" + naziv + "', jedinicnaCena= " + jedinicnaCena;
    }

    @Override
    public String requiredCondition() {
        return " idProizvod=" + idProizvod;
    }

    @Override
    public String conditionForSelect() {
        return "";
    }

    @Override
    public String getIdCondition() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<AbstractDomainObject> getList(ResultSet rs) throws SQLException {
        ArrayList<AbstractDomainObject> lista = new ArrayList<>();

        while (rs.next()) {

            int idProizvod = rs.getInt("idProizvod");
            String naziv = rs.getString("naziv");
            int jedinicnaCena = rs.getInt("jedinicnaCena");

            Proizvod p=new Proizvod(idProizvod, naziv, jedinicnaCena);

            lista.add(p);
        }
        rs.close();
        return lista;
    }

}
