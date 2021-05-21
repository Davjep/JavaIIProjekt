package Databas;

import Controllers.ÅterlämnaLånController;
import Entiteter.Användare;
import Objekt.Bok;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Lån {
    private static String låneTyp;

    public static String getLåneTyp() {
        return låneTyp;
    }

    public static void setLåneTyp(String låneTyp) {
        Lån.låneTyp = låneTyp;
    }

    public void skapaLån(String AnvändarID, String fysiskKopiaID, int låneDagar) {

        try {
            DatabasConnector databasConnector = new DatabasConnector();
            Connection connection = databasConnector.getConnection();
            Statement sqlSkapaLån = connection.createStatement();

            String insertLån = "INSERT INTO lån (StartDatum, AnvändarId, Återlämningsdatum, FysiskkopiaID) " +
                    "VALUES ('" + LocalDate.now() + "', " + AnvändarID + ", '" + beräknaÅterlämningsDatum(låneDagar) + "', " + fysiskKopiaID + ");";

            sqlSkapaLån.executeUpdate(insertLån);

        }catch (SQLException e) {
            e.getStackTrace();
            e.getCause();
        }
    }

    public void uppdateraLån() {

    }

    public void taBortLån(String fysiskKopiaID) {
        try{
            DatabasConnector databasConnector = new DatabasConnector();
            Connection connection = databasConnector.getConnection();
            Statement statement = connection.createStatement();

            String sqlQuery = "DELETE FROM lån WHERE FysiskkopiaID = " + fysiskKopiaID + ";";

            statement.executeUpdate(sqlQuery);
        } catch (SQLException e ) {
            e.getCause();
            e.getStackTrace();
        }



    }
    public String hämtaLåneID (){
        try{
            Användare användare = new Användare();
            String sqlSök = "SELECT LåneId FROM lån WHERE användarId = " + användare.hämtaAnvändarID() + "";
            DatabasConnector databasConnector = new DatabasConnector();
            Connection connection = databasConnector.getConnection();
            Statement statement = connection.createStatement();

            ResultSet sqlQuery = statement.executeQuery(sqlSök);
            sqlQuery.next();

            return sqlQuery.getString("låneid");
        }catch (SQLException e) {
            e.getCause();
            e.getStackTrace();
        }
        return null;
    }

    public String hämtaStartDatum (){

        try{
            Användare användare = new Användare();
            String sqlSök = "SELECT StartDatum FROM lån WHERE användarId = " + användare.hämtaAnvändarID() + "";
            DatabasConnector databasConnector = new DatabasConnector();
            Connection connection = databasConnector.getConnection();
            PreparedStatement statement = connection.prepareStatement(sqlSök);

            ResultSet sqlQuery = statement.executeQuery(sqlSök);
            Date date = new Date();
            while (sqlQuery.next()) {
                date = new SimpleDateFormat("yyyy-MM-dd").parse(sqlQuery.getString("StartDatum"));
            }
            SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
            return format1.format(date);

        } catch (SQLException | ParseException e) {
            e.getCause();
            e.getStackTrace();
        }
        return null;
    }

    public String beräknaÅterlämningsDatum (int days) {

        Calendar c = Calendar.getInstance();
        Date date = new Date();
        c.setTime(date);
        c.add(Calendar.DAY_OF_MONTH, days);
        Date nyDate = c.getTime();
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");

        return format1.format(nyDate);
    }

    public String hämtaAnvändarID (){
        try{
            Användare användare = new Användare();
            String sqlSök = "SELECT användarId FROM lån WHERE användarId = " + användare.hämtaAnvändarID() + "";
            DatabasConnector databasConnector = new DatabasConnector();
            Connection connection = databasConnector.getConnection();
            Statement statement = connection.createStatement();

            ResultSet sqlQuery = statement.executeQuery(sqlSök);
            sqlQuery.next();

            return sqlQuery.getString("användarID");
        }catch (SQLException e) {
            e.getCause();
            e.getStackTrace();
        }
        return null;
    }


    public String hämtaLåneStatus() {

        try {
            DatabasConnector databasConnector = new DatabasConnector();
            Connection connection = databasConnector.getConnection();

            String sqlStatus = "SELECT Status FROM fysiskkopia WHERE ISBN = '" + Bok.getISBN() + "';";

            Statement statusStatement = connection.createStatement();

            ResultSet statusResultat = statusStatement.executeQuery(sqlStatus);
            statusResultat.next();

            return statusResultat.getString("status");
        } catch (SQLException e) {
            e.getCause();
            e.getStackTrace();
        }
        return null;
    }

    public boolean kanAnvändareLåna() {
        //Hämtar användartyp och kallar sedan på räknaantallån metoden
        Användare användare = new Användare();

        if (användare.hämtaAnvändarTypSQL().equalsIgnoreCase("Student")) {
            return räknaAntalLån(10);
        } else if (användare.hämtaAnvändarTypSQL().equalsIgnoreCase("Forskare")) {
            return räknaAntalLån(20);
        } else if (användare.hämtaAnvändarTypSQL().equalsIgnoreCase("Övriga Universitetsanställda")) {
            return räknaAntalLån(15);
        } else if (användare.hämtaAnvändarTypSQL().equalsIgnoreCase("Allmänheten")) {
            return räknaAntalLån(5);
        } else {
            return false;
        }
    }
    public boolean räknaAntalLån(int maxAntal) {
        //Kollar hur många objekt som användaren just nu lånar, och jämför med max antal
        Användare användare = new Användare();

        if (användare.hämtaAntalLåneObjekt() < maxAntal) {
            return true;
        } else {
            return false;
        }
    }
}
