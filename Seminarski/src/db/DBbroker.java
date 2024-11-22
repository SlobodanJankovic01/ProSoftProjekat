/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

import domain.Radnik;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Slobodan
 */
public class DBbroker {

    public DBbroker() {
    }

    public List<Radnik> vratiListuSviRadnik() {
        
        List<Radnik> radnici=new ArrayList<>();
        try {
            Connection k=DBConnection.getInstance().getConnection();
            
            Statement s=k.createStatement();
            
            String query="SELECT * FROM radnik";
            
            ResultSet rs=s.executeQuery(query);
            
            while (rs.next()) {                
                Radnik r=new Radnik(rs.getString("ime"), rs.getString("prezime"), rs.getString("korisnickoIme"), rs.getString("lozinka"));
                radnici.add(r);
            }
            
            s.close();
            
            return radnici;
            
        } catch (SQLException ex) {

            System.out.println(ex.getMessage());
            return null;
        }

    }

    public void kreirajRadnika(String ime, String prezime, String korIme, String pass) {

        try {
            Connection k=DBConnection.getInstance().getConnection();
            
            String query="INSERT INTO radnik (ime,prezime,korisnickoIme,lozinka) VALUES (?,?,?,?)";
            PreparedStatement ps=k.prepareStatement(query);
            
            ps.setString(1, ime);
            ps.setString(2, prezime);
            ps.setString(3, korIme);
            ps.setString(4, pass);
            
            ps.executeUpdate();
            
            ps.close();
            
            JOptionPane.showMessageDialog(null, "Uspesno kreiran radnik");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }

    }
    
    
}
