package Objekt;

import Databas.DatabasConnector;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Film {
    private static String filmID;

    public static void setFilmID(String filmID) {
        Film.filmID = filmID;
    }

    public static String getFilmID() {
        return filmID;
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
}
