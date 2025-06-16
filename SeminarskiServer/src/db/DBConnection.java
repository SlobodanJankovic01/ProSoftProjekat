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

    public static DBConnection instance;
    private Connection connection;

    public DBConnection() throws SQLException {
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/seminarski", "root", "");
        connection.setAutoCommit(false);
    }

    public static DBConnection getInstance() throws SQLException {

        if (instance == null) {
            instance = new DBConnection();
        }

        return instance;
    }

    public Connection getConnection() {
        return connection;
    }

}
