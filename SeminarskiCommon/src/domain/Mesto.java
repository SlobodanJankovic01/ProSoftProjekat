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
public class Mesto extends AbstractDomainObject {

    private int idMesto;
    private String grad;
    private String adresa;

    public Mesto() {
    }

    public Mesto(int idMesto, String grad, String adresa) {
        this.idMesto = idMesto;
        this.grad = grad;
        this.adresa = adresa;
    }

    public int getIdMesto() {
        return idMesto;
    }

    public void setIdMesto(int idMesto) {
        this.idMesto = idMesto;
    }

    public String getGrad() {
        return grad;
    }

    public void setGrad(String grad) {
        this.grad = grad;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    @Override
    public String toString() {
        return grad + ", " + adresa;
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
        final Mesto other = (Mesto) obj;
        return this.idMesto == other.idMesto;
    }

    @Override
    public String tableName() {
        return "mesto";
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
        return "(grad,adresa)";
    }

    @Override
    public String insertValues() {
        return "'" + grad + "', '" + adresa + "'";
    }

    @Override
    public String updateValues() {
        return " grad= '" + grad + "', adresa= '" + adresa + "'";
    }

    @Override
    public String requiredCondition() {
        return " idMesto=" + idMesto;
    }

    @Override
    public String conditionForSelect() {
        return "";
    }

    @Override
    public String getIdCondition() {
        return "WHERE idMesto="+idMesto;
    }

    @Override
    public ArrayList<AbstractDomainObject> getList(ResultSet rs) throws SQLException {
        ArrayList<AbstractDomainObject> lista = new ArrayList<>();

        while (rs.next()) {

            int idMesto = rs.getInt("idMesto");
            String grad = rs.getString("grad");
            String adresa = rs.getString("adresa");

            Mesto m = new Mesto(idMesto, grad, adresa);

            lista.add(m);
        }
        rs.close();
        return lista;
    }

    @Override
    public AbstractDomainObject getAdo(ResultSet rs) {
        try {
            int idMesto = rs.getInt("idMesto");
            String grad = rs.getString("grad");
            String adresa = rs.getString("adresa");
            
            Mesto m = new Mesto(idMesto, grad, adresa);
            
            return m;
        } catch (SQLException ex) {
            Logger.getLogger(Mesto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
