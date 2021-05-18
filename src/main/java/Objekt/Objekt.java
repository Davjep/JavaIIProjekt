package Objekt;

import Databas.DatabasConnector;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class Objekt {
    protected String titel;
    protected String utgivningsÅr;
    protected boolean tillgänglig;
    protected String status;

    protected static String ID;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public static String getID() {
        return ID;
    }

    public static void setID(String ID) {
        Objekt.ID = ID;
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
