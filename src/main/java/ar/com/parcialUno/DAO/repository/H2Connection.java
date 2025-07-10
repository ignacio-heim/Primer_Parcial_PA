package ar.com.parcialUno.DAO.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class H2Connection {

    private static final String url = "jdbc:h2:~/testdb";
    private static final String user = "sa";
    private static final String password = "";

    public static Connection getConnection() {
        try {
            //System.out.println("Conexion exitosa");
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
