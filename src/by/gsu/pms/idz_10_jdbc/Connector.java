package by.gsu.pms.idz_10_jdbc;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {

    public Connection createConnection(String url) {

        Connection cn = null;
        try {
            Class.forName("org.sqlite.JDBC");

            cn = DriverManager.getConnection(url);

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        return cn;
    }


}
