/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;


import java.sql.*;
/**
 *
 * @author Slobodan
 */
public class DBConnection {
    
    static DBConnection instance;

    
    
    
    
    public static DBConnection getInstance() {
        
        if(instance==null){
            instance=new DBConnection();
        }
        
        return instance;
    }
    
    
    
    public static Connection getConnection() throws SQLException{
        
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/seminarski", "root", "");
        
    }
    
    
}
