package Databas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabasConnector {
    private String url = "jdbc:mysql://localhost/";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    private PreparedStatement selectUser;
    private Connection connection;
    private String databaseName;

    public Connection getConnection() {
        try {
            databaseName = "biblioteket";
            url += databaseName;
            connection = DriverManager.getConnection(url, USERNAME, PASSWORD);
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            System.exit(1);
        }
        return connection;
    }

}
