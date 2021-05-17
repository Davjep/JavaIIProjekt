package Objekt;

import Databas.DatabasConnector;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Film extends Objekt {
    private static String filmID;
    private String regissör;
    private static String genre;
    private String åldersBegränsning;
    private String produktionsland;

    public Film() {
        super();
    }

    public Film(String titel, String regissör, String genre, String produktionsland, String utgivningsÅr, boolean tillgänglig, String åldersBegränsning, String plats) {
        super(titel, plats, utgivningsÅr, tillgänglig);
        this.regissör = regissör;
        Film.genre = genre;
        this.åldersBegränsning = åldersBegränsning;
        this.produktionsland = produktionsland;
    }

    public static void setFilmID(String filmID) {
        Film.filmID = filmID;
    }

    public static String getFilmID() {
        return filmID;
    }

    public void läggTillFilmSQL() {
        try {
            DatabasConnector databasConnector = new DatabasConnector();
            Connection connection = databasConnector.getConnection();
            Statement statement = connection.createStatement();
            String sqlInsertQuery = "INSERT INTO film (titel, regissör, genre, produktionsland, utgivningsår, åldersbegränsning) " +
                    "VALUES ('" + getTitel() + "','" + getRegissör() + "','" + getGenre() + "','" + getProduktionsland() + "','" + getUtgivningsÅr() + "', '" + getÅldersBegränsning() + "');";
            statement.executeUpdate(sqlInsertQuery);
        }catch (SQLException e) {
            e.getCause();
            e.getStackTrace();
        }
    }

    public String hämtaFilmIDSQL() {
        try{
            String sqlSök = "SELECT FilmId FROM film WHERE FilmId = '" + Film.getFilmID() + "'";
            DatabasConnector databasConnector = new DatabasConnector();
            Connection connection = databasConnector.getConnection();
            Statement statement = connection.createStatement();

            ResultSet sqlQuery = statement.executeQuery(sqlSök);
            sqlQuery.next();

            return sqlQuery.getString("filmID");
        }catch (SQLException e) {
            e.getCause();
            e.getStackTrace();
        }
        return null;
    }

    public String hämtaTitelSQL() {
        try{
            String sqlSök = "SELECT Titel FROM film WHERE FilmId = '" + Film.getFilmID() + "'";
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

    public String hämtaRegissörSQL() {
        try{
            String sqlSök = "SELECT Regissör FROM film WHERE FilmId = '" + Film.getFilmID() + "'";
            DatabasConnector databasConnector = new DatabasConnector();
            Connection connection = databasConnector.getConnection();
            Statement statement = connection.createStatement();

            ResultSet sqlQuery = statement.executeQuery(sqlSök);
            sqlQuery.next();

            return sqlQuery.getString("regissör");
        }catch (SQLException e) {
            e.getCause();
            e.getStackTrace();
        }
        return null;
    }

    public String hämtaGenreSQL() {
        try{
            String sqlSök = "SELECT Genre FROM film WHERE FilmId = '" + Film.getFilmID() + "'";
            DatabasConnector databasConnector = new DatabasConnector();
            Connection connection = databasConnector.getConnection();
            Statement statement = connection.createStatement();

            ResultSet sqlQuery = statement.executeQuery(sqlSök);
            sqlQuery.next();

            return sqlQuery.getString("genre");
        }catch (SQLException e) {
            e.getCause();
            e.getStackTrace();
        }
        return null;
    }
    public String hämtaProduktionslandSQL() {
        try{
            String sqlSök = "SELECT ProduktionsLand FROM film WHERE FilmId = '" + Film.getFilmID() + "'";
            DatabasConnector databasConnector = new DatabasConnector();
            Connection connection = databasConnector.getConnection();
            Statement statement = connection.createStatement();

            ResultSet sqlQuery = statement.executeQuery(sqlSök);
            sqlQuery.next();

            return sqlQuery.getString("produktionsland");
        }catch (SQLException e) {
            e.getCause();
            e.getStackTrace();
        }
        return null;
    }

    public String hämtaUtgivningsårSQL() {
        try{
            String sqlSök = "SELECT UtgivningsÅr FROM film WHERE FilmId = '" + Film.getFilmID() + "'";
            DatabasConnector databasConnector = new DatabasConnector();
            Connection connection = databasConnector.getConnection();
            Statement statement = connection.createStatement();

            ResultSet sqlQuery = statement.executeQuery(sqlSök);
            sqlQuery.next();

            return sqlQuery.getString("UtgivningsÅr");
        }catch (SQLException e) {
            e.getCause();
            e.getStackTrace();
        }
        return null;
    }

    public String hämtaÅldersBegränsningSQL() {
        try{
            String sqlSök = "SELECT ÅldersBegränsning FROM film WHERE FilmId = '" + Film.getFilmID() + "'";
            DatabasConnector databasConnector = new DatabasConnector();
            Connection connection = databasConnector.getConnection();
            Statement statement = connection.createStatement();

            ResultSet sqlQuery = statement.executeQuery(sqlSök);
            sqlQuery.next();

            return sqlQuery.getString("ÅldersBegränsning");
        }catch (SQLException e) {
            e.getCause();
            e.getStackTrace();
        }
        return null;
    }

    public String getRegissör() {
        return regissör;
    }

    public void setRegissör(String regissör) {
        this.regissör = regissör;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        Film.genre = genre;
    }

    public String getÅldersBegränsning() {
        return åldersBegränsning;
    }

    public void setÅldersBegränsning(String åldersBegränsning) {
        this.åldersBegränsning = åldersBegränsning;
    }

    public String getProduktionsland() {
        return produktionsland;
    }

    public void setProduktionsland(String produktionsland) {
        this.produktionsland = produktionsland;
    }
}
