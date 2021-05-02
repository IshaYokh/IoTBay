package iotbay.g15.dao;

import java.sql.Connection;

/**
 *
 * @author Isha Yokhanna
 */
public abstract class DB {
    protected String URL = "jdbc:derby://localhost:1527/iotbay";
    protected String db = "iotbay";
    protected String dbuser = "iotbay";
    protected String dbpass = "iotbay";
    protected String driver = "org.apache.derby.jdbc.ClientDriver";
    protected Connection conn;
}
