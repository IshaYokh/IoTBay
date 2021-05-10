/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iotbay.g15.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author rebecca
 */
public class DBConnector extends DB{
    private Connection conn = null;
    
    public DBConnector() throws ClassNotFoundException, SQLException {
    Class.forName(driver);
    conn = DriverManager.getConnection(URL+db, dbuser, dbpass);
    }

    public Connection getConnection(){
    return conn;
    }

    public void closeConnection() throws SQLException {
    conn.close();
    }
}