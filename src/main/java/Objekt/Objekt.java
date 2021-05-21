package Objekt;

import Databas.DatabasConnector;
import Entiteter.Användare;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class Objekt {
    protected String titel;
    protected String utgivningsÅr;
    protected boolean tillgänglig;
    protected String status;

    protected static String fysiskKopiaID;

   public Objekt() {

    }

    public Objekt(String titel, String utgivningsÅr, boolean tillgänglig) {
        this.titel = titel;
        this.utgivningsÅr = utgivningsÅr;
        this.tillgänglig = tillgänglig;
    }

    public static String getFysiskKopiaID() {
        return fysiskKopiaID;
    }

    public static void setFysiskKopiaID(String fysiskKopiaID) {
        Objekt.fysiskKopiaID = fysiskKopiaID;
    }

    public String hämtaStatusSQL() {
        try{
            String sqlSök = "SELECT Status FROM fysiskkopia WHERE FysiskKopiaID = " + fysiskKopiaID + "";
            DatabasConnector databasConnector = new DatabasConnector();
            Connection connection = databasConnector.getConnection();
            Statement statement = connection.createStatement();

            ResultSet sqlQuery = statement.executeQuery(sqlSök);
            sqlQuery.next();

            return sqlQuery.getString("status");
        }catch (SQLException e) {
            e.getCause();
            e.getStackTrace();
        }
        return null;
    }

    public void taBortObjektSQL (String objekt) {
        try {
            DatabasConnector databasConnector = new DatabasConnector();
            Connection connection = databasConnector.getConnection();
            String sqlTaBortObjekt;
            if (objekt.equalsIgnoreCase("bok")) {
                sqlTaBortObjekt = "DELETE FROM biblioteket.bok WHERE ISBN = " + Bok.getISBN() + ";";
            } else if (objekt.equalsIgnoreCase("film")) {
                sqlTaBortObjekt = "DELETE FROM biblioteket.film WHERE FilmId = " + Film.getFilmID() + ";";
            } else {
                sqlTaBortObjekt = "DELETE FROM biblioteket.fysiskkopia WHERE FysiskKopiaID = " + Objekt.getFysiskKopiaID() + ";";
            }

            Statement statement = connection.createStatement();
            statement.executeUpdate(sqlTaBortObjekt);
        } catch (SQLException e) {
            e.printStackTrace();
            e.getCause();
        }
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public void setUtgivningsÅr(String utgivningsÅr) {
        this.utgivningsÅr = utgivningsÅr;
    }

    public void setTillgänglig(boolean tillgänglig) {
        this.tillgänglig = tillgänglig;
    }

    public String getTitel() {
        return titel;
    }

    public String getUtgivningsÅr() {
        return utgivningsÅr;
    }

    public boolean isTillgänglig() {
        return tillgänglig;
    }
}
