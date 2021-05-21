package Objekt;

import Databas.DatabasConnector;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FysiskKopia extends Objekt {
    private String plats;
    private String ISBN;
    private String filmID;

    public FysiskKopia() {

    }

    public FysiskKopia(String ISBN, String FilmID, String plats, String status) {
        this.plats = plats;
        super.status = status;
        this.ISBN = ISBN;
        this.filmID = FilmID;
    }

    public void läggTillFysiskKopiaSQL() {
        try {
            DatabasConnector databasConnector = new DatabasConnector();
            Connection connection = databasConnector.getConnection();
            Statement statement = connection.createStatement();
            String sqlInsertQuery;
            if (getISBN().equals("")) {
                sqlInsertQuery = "INSERT INTO fysiskkopia (Plats, Status, FilmID) " +
                        "VALUES ('" + getPlats() + "','" + getStatus() + "','" + getFilmID() + "');";

            } else {
                sqlInsertQuery = "INSERT INTO fysiskkopia (Plats, Status, ISBN) " +
                        "VALUES ('" + getPlats() + "','" + getStatus() + "','" + getISBN() + "');";
            }
            statement.executeUpdate(sqlInsertQuery);
        }catch (SQLException e) {
            e.getCause();
            e.getStackTrace();
        }
    }
    public void uppdateraFysiskKopiaSQL(String plats, String status, String ISBN, String filmID) {
        try {
            DatabasConnector databasConnector = new DatabasConnector();
            Connection connection = databasConnector.getConnection();
            Statement statement = connection.createStatement();
            String sqlUpdateQuery = "UPDATE biblioteket.fysiskkopia SET Plats = '" + plats + "' , Status = '" + status + "' , ISBN = " + ISBN +
                    " , FilmID = " + filmID + " WHERE FysiskKopiaID = " + Objekt.getFysiskKopiaID();
            statement.executeUpdate(sqlUpdateQuery);
        } catch (SQLException e) {
            e.getCause();
            e.getStackTrace();
        }
    }

    public String hämtaFysiskKopiaIDSQL() {
        try {
            String sqlSök = "SELECT FysiskKopiaID FROM fysiskkopia WHERE FysiskKopiaID = " + Objekt.getFysiskKopiaID();
            DatabasConnector databasConnector = new DatabasConnector();
            Connection connection = databasConnector.getConnection();
            Statement statement = connection.createStatement();

            ResultSet sqlQuery = statement.executeQuery(sqlSök);
            sqlQuery.next();

            return sqlQuery.getString("fysiskkopiaid");
        } catch (SQLException e) {
            e.getCause();
            e.getStackTrace();
        }
        return null;
    }

    public String hämtaPlatsSQL() {
        try {
            String sqlSök = "SELECT Plats FROM fysiskkopia WHERE FysiskKopiaID = " + Objekt.getFysiskKopiaID();
            DatabasConnector databasConnector = new DatabasConnector();
            Connection connection = databasConnector.getConnection();
            Statement statement = connection.createStatement();

            ResultSet sqlQuery = statement.executeQuery(sqlSök);
            sqlQuery.next();

            return sqlQuery.getString("plats");
        } catch (SQLException e) {
            e.getCause();
            e.getStackTrace();
        }
        return null;
    }

    public String hämtaStatusSQL() {
        try {
            String sqlSök = "SELECT Status FROM fysiskkopia WHERE FysiskKopiaID = " + Objekt.getFysiskKopiaID();
            DatabasConnector databasConnector = new DatabasConnector();
            Connection connection = databasConnector.getConnection();
            Statement statement = connection.createStatement();

            ResultSet sqlQuery = statement.executeQuery(sqlSök);
            sqlQuery.next();

            return sqlQuery.getString("status");
        } catch (SQLException e) {
            e.getCause();
            e.getStackTrace();
        }
        return null;
    }

    public String hämtaISBNSQL() {
        try {
            String sqlSök = "SELECT ISBN FROM fysiskkopia WHERE FysiskKopiaID = " + Objekt.getFysiskKopiaID();
            DatabasConnector databasConnector = new DatabasConnector();
            Connection connection = databasConnector.getConnection();
            Statement statement = connection.createStatement();

            ResultSet sqlQuery = statement.executeQuery(sqlSök);
            sqlQuery.next();

            return sqlQuery.getString("ISBN");
        } catch (SQLException e) {
            e.getCause();
            e.getStackTrace();
        }
        return null;
    }

    public String hämtaFilmIDSQL() {
        try {
            String sqlSök = "SELECT FilmID FROM fysiskkopia WHERE FysiskKopiaID = " + Objekt.getFysiskKopiaID();
            DatabasConnector databasConnector = new DatabasConnector();
            Connection connection = databasConnector.getConnection();
            Statement statement = connection.createStatement();

            ResultSet sqlQuery = statement.executeQuery(sqlSök);
            sqlQuery.next();

            return sqlQuery.getString("filmID");
        } catch (SQLException e) {
            e.getCause();
            e.getStackTrace();
        }
        return null;
    }

    public String getPlats() {
        return plats;
    }

    public void setPlats(String plats) {
        this.plats = plats;
    }

    public void setStatus(String fysiskKopiaID, String status) {
        this.status = status;
        try {
            DatabasConnector databasConnector = new DatabasConnector();
            Connection connection = databasConnector.getConnection();
            Statement statement = connection.createStatement();
            String fysiskKopiaIdUpdate = "UPDATE FysiskKopia SET status = '" + status + "' WHERE FysiskKopiaId = '" + fysiskKopiaID + "'";

            statement.executeUpdate(fysiskKopiaIdUpdate);
        }catch (SQLException e) {
            e.getCause();
            e.getStackTrace();
        }
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getFilmID() {
        return filmID;
    }

    public void setFilmID(String filmID) {
        this.filmID = filmID;
    }
}
