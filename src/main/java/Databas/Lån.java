package Databas;

import Entiteter.Användare;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class Lån {
    private static String låneTyp;

    public static String getLåneTyp() {
        return låneTyp;
    }

    public static void setLåneTyp(String låneTyp) {
        Lån.låneTyp = låneTyp;
    }






    public void skapaLån(String AnvändarID) {
        try {
            DatabasConnector databasConnector = new DatabasConnector();
            Connection connection = databasConnector.getConnection();
            Statement sqlSkapaLån = connection.createStatement();
            String insertLån = "INSERT INTO lån (StartDatum, AnvändarId) VALUES ('" + LocalDate.now() + "', " + AnvändarID + ");";

            sqlSkapaLån.executeUpdate(insertLån);

        }catch (SQLException e) {
            e.getStackTrace();
            e.getCause();
        }
    }

    public void uppdateraLån() {

    }

    public void taBortLån() {

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
    public Date hämtaStartDatum (){
        //TODO Måste fixa så att man får rätt datum. Idag får man endast datumet för det första lånet som skapades
        try{
            Användare användare = new Användare();
            String sqlSök = "SELECT StartDatum FROM lån WHERE användarId = " + användare.hämtaAnvändarID() + "";
            DatabasConnector databasConnector = new DatabasConnector();
            Connection connection = databasConnector.getConnection();
            Statement statement = connection.createStatement();

            ResultSet sqlQuery = statement.executeQuery(sqlSök);
            sqlQuery.next();

            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(sqlQuery.getString("StartDatum"));

            return date;

        } catch (SQLException | ParseException e) {
            e.getCause();
            e.getStackTrace();
        }
        return null;
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

    public Date beräknaÅterlämningsDatum (int days) {

        Calendar c = Calendar.getInstance();
        c.setTime(hämtaStartDatum());
        c.add(Calendar.DAY_OF_MONTH, days);
        return c.getTime();
    }

}
