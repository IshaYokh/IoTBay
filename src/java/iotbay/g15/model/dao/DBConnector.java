package iotbay.g15.model.dao;

import iotbay.g15.model.dao.DB;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector extends DB{
    public DBConnector() throws ClassNotFoundException, SQLException {
        Class.forName(driver);
        conn = DriverManager.getConnection(URL+db, dbuser, dbpass);
    }

    // Returns an instance of the database connection
    public Connection openConnection(){
        return this.conn;
    }
    
    // Closes connection to the database
    public void closeConnection() throws SQLException {
        this.conn.close();
    }
