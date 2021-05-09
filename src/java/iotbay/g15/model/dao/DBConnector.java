/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iotbay.g15.model.dao;

/**
 *
 * @author Kevin
 */

import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.SQLException;

public class DBConnector extends DB {

    public DBConnector() throws ClassNotFoundException, SQLException {

        Class.forName(driver);

        conn = DriverManager.getConnection(URL + db, dbuser, dbpass);

    }

    public Connection openConnection() {

        return this.conn;

    }

    public void closeConnection() throws SQLException {

        this.conn.close();

    }

}
