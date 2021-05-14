package Entiteter;

import Databas.DatabasConnector;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Anställd extends Entitet {
    private static boolean anställd;
    private boolean chef;
    private static String ID;

    public Anställd() {

    }

    public Anställd(String förNamn, String efterNamn, String gatuAdress, String postNr, String email, String personNr, String telefonNr, String lösenord, boolean chef) {
        super(förNamn, efterNamn, gatuAdress, postNr, email, personNr, telefonNr, lösenord);
        this.chef = chef;
    }

    public static String getID() {
        return ID;
    }

    public static void setID(String ID) {
        Anställd.ID = ID;
    }

    public static boolean getAnställd() {
        return anställd;
    }

    public static void setAnställd() {
        anställd = true;
    }

    public boolean getChef() {
        return chef;
    }

    public void setChef(boolean chef) {
        this.chef = chef;
    }

    //Metod som hämtar email ifall anställd ska modifiera ett valt användarkonto
    public String hämtaValdEmail() {
        try {
            DatabasConnector databasConnector = new DatabasConnector();
            Connection connection = databasConnector.getConnection();

            String hittaEmail = "SELECT email FROM användare WHERE AnvändarId = '" + Anställd.getID() + "'";
            Statement emailStatement = connection.createStatement();

            ResultSet emailQuery = emailStatement.executeQuery(hittaEmail);
            return emailQuery.toString();
        } catch (SQLException e) {
            e.getCause();
            e.getStackTrace();
        }
        return null;
    }
}
