/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iotbay.g15.model.dao;

import java.sql.Connection;
 
public abstract class DB {
    protected String URL = "jdbc:derby://localhost:1527/";
    protected String db  = "iotbay" ;
    protected String dbuser = "iotbay";
    protected String dbpass = "iotbay";
    protected String driver = "org.apache.derby.jdbc.ClientDriver";
    protected Connection conn;
}
