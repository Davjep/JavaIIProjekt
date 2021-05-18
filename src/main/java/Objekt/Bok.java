package Objekt;

import Databas.DatabasConnector;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Bok extends Objekt {

    private static String ISBN;
    private String författare;
    private String ämnesord;
    private String kategori;

    public Bok() {
        super();
    }

    public Bok(String titel, String författare, String ämnesord, String kategori, String utgivningsÅr, boolean tillgänglig) {
        super(titel, utgivningsÅr, tillgänglig);
        this.författare = författare;
        this.ämnesord = ämnesord;
        this.kategori = kategori;
    }

    public static void setISBN(String ID) {
        Bok.ISBN = ID;
    }

    public static String getISBN() {
        return ISBN;
    }

    public void läggTillBokSQL() {
        try {
            DatabasConnector databasConnector = new DatabasConnector();
            Connection connection = databasConnector.getConnection();
            Statement statement = connection.createStatement();
            String sqlInsertQuery = "INSERT INTO bok (Titel, Författare, ÄmnesOrd, Kategori, UtgivningsÅr) " +
                    "VALUES ('" + getTitel() + "','" + getFörfattare() + "','" + getÄmnesord() + "','" + getKategori() + "','" + getUtgivningsÅr() + "' )";
            statement.executeUpdate(sqlInsertQuery);
        }catch (SQLException e) {
            e.getCause();
            e.getStackTrace();
        }
    }

    public String hämtaTitelSQL() {
        try{
            String sqlSök = "SELECT Titel FROM bok WHERE ISBN = '" + Bok.getISBN() + "'";
            DatabasConnector databasConnector = new DatabasConnector();
            Connection connection = databasConnector.getConnection();
            Statement statement = connection.createStatement();

            ResultSet sqlQuery = statement.executeQuery(sqlSök);
            sqlQuery.next();

            return sqlQuery.getString("titel");
        }catch (SQLException e) {
            e.getCause();
            e.getStackTrace();
        }
        return null;
    }

    public String hämtaFörfattareSQL() {
        try{
            String sqlSök = "SELECT Författare FROM bok WHERE ISBN = '" + Bok.getISBN() + "'";
            DatabasConnector databasConnector = new DatabasConnector();
            Connection connection = databasConnector.getConnection();
            Statement statement = connection.createStatement();

            ResultSet sqlQuery = statement.executeQuery(sqlSök);
            sqlQuery.next();

            return sqlQuery.getString("författare");
        }catch (SQLException e) {
            e.getCause();
            e.getStackTrace();
        }
        return null;
    }

    public String hämtaÄmnesordSQL() {
        try{
            String sqlSök = "SELECT ÄmnesOrd FROM bok WHERE ISBN = '" + Bok.getISBN() + "'";
            DatabasConnector databasConnector = new DatabasConnector();
            Connection connection = databasConnector.getConnection();
            Statement statement = connection.createStatement();

            ResultSet sqlQuery = statement.executeQuery(sqlSök);
            sqlQuery.next();

            return sqlQuery.getString("ämnesord");
        }catch (SQLException e) {
            e.getCause();
            e.getStackTrace();
        }
        return null;
    }

    public String hämtaKategoriSQL() {
        try{
            String sqlSök = "SELECT Kategori FROM bok WHERE ISBN = '" + Bok.getISBN() + "'";
            DatabasConnector databasConnector = new DatabasConnector();
            Connection connection = databasConnector.getConnection();
            Statement statement = connection.createStatement();

            ResultSet sqlQuery = statement.executeQuery(sqlSök);
            sqlQuery.next();

            return sqlQuery.getString("kategori");
        }catch (SQLException e) {
            e.getCause();
            e.getStackTrace();
        }
        return null;
    }

    public String hämtaUtgivningsårSQL() {
        try{
            String sqlSök = "SELECT UtgivningsÅr FROM bok WHERE ISBN = '" + Bok.getISBN() + "'";
            DatabasConnector databasConnector = new DatabasConnector();
            Connection connection = databasConnector.getConnection();
            Statement statement = connection.createStatement();

            ResultSet sqlQuery = statement.executeQuery(sqlSök);
            sqlQuery.next();

            return sqlQuery.getString("utgivningsår");
        }catch (SQLException e) {
            e.getCause();
            e.getStackTrace();
        }
        return null;
    }

    public String hämtaISBNSQL() {
        try{
            String sqlSök = "SELECT ISBN FROM bok WHERE ISBN = '" + Bok.getISBN() + "'";
            DatabasConnector databasConnector = new DatabasConnector();
            Connection connection = databasConnector.getConnection();
            Statement statement = connection.createStatement();

            ResultSet sqlQuery = statement.executeQuery(sqlSök);
            sqlQuery.next();

            return sqlQuery.getString("ISBN");
        }catch (SQLException e) {
            e.getCause();
            e.getStackTrace();
        }
        return null;
    }

    public String getFörfattare() {
        return författare;
    }

    public void setFörfattare(String författare) {
        this.författare = författare;
    }

    public String getÄmnesord() {
        return ämnesord;
    }

    public void setÄmnesord(String ämnesord) {
        this.ämnesord = ämnesord;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }
}

