/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

import domain.AbstractDomainObject;
import domain.Radnik;
import java.util.List;
import java.sql.*;
/**
 *
 * @author Slobodan
 */
public class DBbroker {

    private static DBbroker instance;

    private DBbroker() {
    }

    public static DBbroker getInstance() {

        if (instance == null) {
            instance = new DBbroker();

        }

        return instance;
    }

    public Radnik login(Radnik r) throws SQLException {
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

    public int insert(AbstractDomainObject ado) throws Exception {

        int id = -1;

        String upit = "INSERT INTO " + ado.tableName() + " "
                + ado.insertColumns() + " VALUES(" + ado.insertValues() + ")";

        System.out.println(upit);
        Statement s = DBConnection.getInstance().getConnection().createStatement();
        s.executeUpdate(upit, Statement.RETURN_GENERATED_KEYS);
        ResultSet rs = s.getGeneratedKeys();

        if (rs.next()) {
            id = rs.getInt(1);
        }
        rs.close();
        s.close();

        return id;
    }

    public List<AbstractDomainObject> selectList(AbstractDomainObject ado) throws Exception {

        String upit = "SELECT * FROM " + ado.tableName() + " " + ado.alies()
                + " " + ado.textJoin() + " " + ado.conditionForSelect();
        System.out.println(upit);

        Statement s = DBConnection.getInstance().getConnection().createStatement();
        ResultSet rs = s.executeQuery(upit);
        return ado.getList(rs);

    }

    public int delete(AbstractDomainObject ado) throws Exception {

        String upit = "DELETE FROM " + ado.tableName() + " WHERE " + ado.requiredCondition();
        System.out.println(upit);
        Statement s = DBConnection.getInstance().getConnection().createStatement();
        int affectedRows = s.executeUpdate(upit);
        return affectedRows;

    }

    public int update(AbstractDomainObject ado) throws Exception {

        String upit = "UPDATE " + ado.tableName() + " SET "
                + ado.updateValues() + " WHERE " + ado.requiredCondition();
        System.out.println(upit);
        Statement s = DBConnection.getInstance().getConnection().createStatement();
        int affectedRows = s.executeUpdate(upit);
        return affectedRows;

    }

    public AbstractDomainObject selectObject(AbstractDomainObject ado) throws SQLException {
        String upit = " SELECT * FROM " + ado.tableName() + " " + ado.alies() + " "
                + ado.textJoin() + " " + " " + ado.getIdCondition();
        System.out.println(upit);
        Statement s = DBConnection.getInstance().getConnection().createStatement();
        ResultSet rs = s.executeQuery(upit);
        if (rs.next()) {
            return ado.getAdo(rs);
        }
        return null;
    }

}
