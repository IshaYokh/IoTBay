package iotbay.g15.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import iotbay.g15.model.dao.DB;
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
