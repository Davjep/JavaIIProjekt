package Databas;

import Entiteter.Användare;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class AnvändareInsertsTest {


    @Test
    public void beräknaÅlderTest() {
        Användare användareLaggaTill = new Användare();
        try {
            DatabasConnector databasConnector = new DatabasConnector();
            Connection connection = databasConnector.getConnection();
            Statement statement = connection.createStatement();
            statement.executeUpdate(användareLaggaTill.läggaTillAnvändareSQL(
                    "Test",
                    "Testson",
                    "012345",
                    "testvägen 1",
                    "51124",
                    "testmail",
                    "199201010101",
                    "Student",
                    "test") );
        }catch (SQLException e) {
            e.getCause();
            e.printStackTrace();
        }
    }

    @Test
    public void räkna() {

    }

}