package database;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static final String URL_BD = "jdbc:sqlite:src/main/resources/concesionario.db";

    public Connection connect() throws SQLException {
        Connection connection  = DriverManager.getConnection(URL_BD);
        return connection;
    }

}
