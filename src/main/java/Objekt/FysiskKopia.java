package Objekt;

import Databas.DatabasConnector;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class FysiskKopia {
    private String plats;
    private String status;
    private String ISBN;
    private String filmID;

    public FysiskKopia(String ISBN, String FilmID, String plats, String status) {
        this.plats = plats;
        this.status = status;
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

    public String getPlats() {
        return plats;
    }

    public void setPlats(String plats) {
        this.plats = plats;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
