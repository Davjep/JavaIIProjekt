package Databas;

import Entiteter.Användare;
import Objekt.Bok;
import org.junit.jupiter.api.Test;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

class LånTest {

    @Test
    void skapaLån() {
        Lån lån = new Lån();
        Användare användare = new Användare();
        Användare.setInloggadEmail("testmail@test.se");
        System.out.println(lån.beräknaÅterlämningsDatum(0));

        //lån.skapaLån(användare.hämtaAnvändarID());
    }

    @Test
    void låna() {

        try {
            Bok.setISBN("43");
            DatabasConnector databasConnector = new DatabasConnector();
            Connection connection = databasConnector.getConnection();

            String sqlStatus = "SELECT Status FROM fysiskkopia WHERE ISBN = '" + Bok.getISBN() + "';";

            Statement statusStatement = connection.createStatement();

            ResultSet statusResultat = statusStatement.executeQuery(sqlStatus);
            statusResultat.next();
            System.out.println("Resultatet är: " + statusResultat.getString("status"));

            if (statusResultat.getString("status").equalsIgnoreCase("Tillgänglig")) {
                System.out.println("Tillgänglig");

            } else {
                System.out.println("Inte alls");
            }
        } catch (SQLException e) {
            e.getCause();
            e.getStackTrace();
        }
    }

    @Test
    void taBortLån() {
    }

    @Test
    void hämtaLåneInfo() throws SQLException, ParseException {
        Lån lån = new Lån();

        //Användare användare = new Användare();
        Användare.setInloggadEmail("testmail@test.se");
        System.out.println(lån.hämtaStartDatum());
        Calendar c = Calendar.getInstance();
        System.out.println(lån.hämtaStartDatum());
        c.setTime(lån.hämtaStartDatum());
        c.add(Calendar.DAY_OF_MONTH, 25);
        Date newDate = c.getTime();
        System.out.println(newDate);
        System.out.println(lån.beräknaÅterlämningsDatum(25));

    }
    @Test
    void hämtaDatum() {
        Användare användare = new Användare();
        Användare.setInloggadEmail("Jorsan");
        användare.hämtaAnvändarID();
        try{
            String sqlSök = "SELECT StartDatum FROM lån WHERE användarId = " + användare.hämtaAnvändarID() + "";
            DatabasConnector databasConnector = new DatabasConnector();
            Connection connection = databasConnector.getConnection();
            PreparedStatement statement = connection.prepareStatement(sqlSök);

            ResultSet sqlQuery = statement.executeQuery(sqlSök);
            //sqlQuery.next();
            Date date = new Date();
            System.out.println(date);
            while (sqlQuery.next()) {
                date = new SimpleDateFormat("yyyy-MM-dd").parse(sqlQuery.getString("StartDatum"));

                System.out.println(date);
            }

            //date = new SimpleDateFormat("yyyy-MM-dd").parse(sqlQuery.getString("StartDatum"));

            System.out.print("sista " + date);

        } catch (SQLException | ParseException e) {
            e.getCause();
            e.getStackTrace();
        }
    }
}