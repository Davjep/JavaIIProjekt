package Entiteter;

import Databas.DatabasConnector;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

public class Användare {

    private static boolean inloggad = false;
    private static String inloggadEmail;

    public static String getInloggadEmail() {
        return inloggadEmail;
    }

    public static void setInloggadEmail(String inloggadEmail) {
        Användare.inloggadEmail = inloggadEmail;
    }

    public static void setInloggad() {
        inloggad = true;
    }

    public static void loggaUt() {
        inloggad = false;
        Användare.setInloggadEmail(null);
    }

    public static boolean isInloggad() {
        return inloggad;
    }

    public void läggaTillAnvändareSQL(String förNamn, String efterNamn, String telefon, String gatuAdress, String postNummer,
                                     String email, String personNr, String typ, String lösenord) {
        try {
            DatabasConnector databasConnector = new DatabasConnector();
            Connection connection = databasConnector.getConnection();
            Statement statement = connection.createStatement();
            String sqlInsertQuery = "INSERT INTO användare (FörNamn, EfterNamn, Telefon, GatuAdress, postNummer, Email, PersonNr, Ålder, Typ, AntalLåneObjekt, lösenord) " +
                    "VALUES ('" + förNamn + "','" + efterNamn + "','" + telefon + "','" + gatuAdress + "','" + postNummer + "','" + email + "','" +
                    personNr + "'," + beräknaÅlder(personNr) + ",'" + typ + "', " + 0 + ", '" + lösenord + "' )";
            statement.executeUpdate(sqlInsertQuery);
        }catch (SQLException e) {
            e.getCause();
            e.getStackTrace();
        }
    }

    public void uppdateraAnvändareSQL (String förNamn, String efterNamn, String telefon, String gatuAdress, String postNummer,
                                         String email, String personNr, String typ, String lösenord) {
        try {
            DatabasConnector databasConnector = new DatabasConnector();
            Connection connection = databasConnector.getConnection();
            Statement statement = connection.createStatement();
            String sqlUpdateQuery = "UPDATE användare SET FörNamn = '" + förNamn + "' , efternamn = '" + efterNamn + "', telefon = '" + telefon
                    + "', gatuadress = '" + gatuAdress + "', postnummer = '" + postNummer + "', email = '" + email + "', personnr = '" + personNr
                    + "', Ålder = '" + beräknaÅlder(personNr) + "', typ = '" + typ + "', lösenord = '" + lösenord + "' WHERE email = '" + getInloggadEmail() + "'";
            statement.executeUpdate(sqlUpdateQuery);
        }catch (SQLException e) {
            e.getCause();
            e.getStackTrace();
        }
    }

    public void taBortAnvändareSQL () {
        try {
            DatabasConnector databasConnector = new DatabasConnector();
            Connection connection = databasConnector.getConnection();
            String sqlTaBortAnvändare = "DELETE FROM användare WHERE email = '" + Användare.getInloggadEmail() + "';";
            Statement statement = connection.createStatement();
            statement.executeUpdate(sqlTaBortAnvändare);

        } catch (SQLException e) {
            e.printStackTrace();
            e.getCause();
        }
    }

    public String hämtaFörnamnSQL () {
        try{
            String sqlSök = "SELECT förnamn FROM användare WHERE email = '" + Användare.getInloggadEmail() + "'";
            DatabasConnector databasConnector = new DatabasConnector();
            Connection connection = databasConnector.getConnection();
            Statement statement = connection.createStatement();

            ResultSet sqlQuery = statement.executeQuery(sqlSök);
            sqlQuery.next();

            return sqlQuery.getString("förnamn");
        }catch (SQLException e) {
            e.getCause();
            e.getStackTrace();
        }
        return null;
    }

    public String hämtaEfternamnSQL () {
        try{
            String sqlSök = "SELECT EfterNamn FROM användare WHERE email = '" + Användare.getInloggadEmail() + "'";
            DatabasConnector databasConnector = new DatabasConnector();
            Connection connection = databasConnector.getConnection();
            Statement statement = connection.createStatement();

            ResultSet sqlQuery = statement.executeQuery(sqlSök);
            sqlQuery.next();

            return sqlQuery.getString("efternamn");
        }catch (SQLException e) {
            e.getCause();
            e.getStackTrace();
        }
        return null;
    }

    public String hämtaTelefonNrSQL () {
        try{
            String sqlSök = "SELECT Telefon FROM användare WHERE email = '" + Användare.getInloggadEmail() + "'";
            DatabasConnector databasConnector = new DatabasConnector();
            Connection connection = databasConnector.getConnection();
            Statement statement = connection.createStatement();

            ResultSet sqlQuery = statement.executeQuery(sqlSök);
            sqlQuery.next();

            return sqlQuery.getString("Telefon");
        }catch (SQLException e) {
            e.getCause();
            e.getStackTrace();
        }
        return null;
    }

    public String hämtaGatuAdressSQL () {
        try{
            String sqlSök = "SELECT GatuAdress FROM användare WHERE email = '" + Användare.getInloggadEmail() + "'";
            DatabasConnector databasConnector = new DatabasConnector();
            Connection connection = databasConnector.getConnection();
            Statement statement = connection.createStatement();

            ResultSet sqlQuery = statement.executeQuery(sqlSök);
            sqlQuery.next();

            return sqlQuery.getString("gatuadress");
        }catch (SQLException e) {
            e.getCause();
            e.getStackTrace();
        }
        return null;
    }

    public String hämtaPostNrSQL () {
        try{
            String sqlSök = "SELECT Postnummer FROM användare WHERE email = '" + Användare.getInloggadEmail() + "'";
            DatabasConnector databasConnector = new DatabasConnector();
            Connection connection = databasConnector.getConnection();
            Statement statement = connection.createStatement();

            ResultSet sqlQuery = statement.executeQuery(sqlSök);
            sqlQuery.next();

            return sqlQuery.getString("postnummer");
        }catch (SQLException e) {
            e.getCause();
            e.getStackTrace();
        }
        return null;
    }

    public String hämtaemailSQL () {
        try{
            String sqlSök = "SELECT Email FROM användare WHERE email = '" + Användare.getInloggadEmail() + "'";
            DatabasConnector databasConnector = new DatabasConnector();
            Connection connection = databasConnector.getConnection();
            Statement statement = connection.createStatement();

            ResultSet sqlQuery = statement.executeQuery(sqlSök);
            sqlQuery.next();

            return sqlQuery.getString("email");
        }catch (SQLException e) {
            e.getCause();
            e.getStackTrace();
        }
        return null;
    }

    public String hämtaPersonNrSQL () {
        try{
            String sqlSök = "SELECT PersonNr FROM användare WHERE email = '" + Användare.getInloggadEmail() + "'";
            DatabasConnector databasConnector = new DatabasConnector();
            Connection connection = databasConnector.getConnection();
            Statement statement = connection.createStatement();

            ResultSet sqlQuery = statement.executeQuery(sqlSök);
            sqlQuery.next();

            return sqlQuery.getString("personNr");
        }catch (SQLException e) {
            e.getCause();
            e.getStackTrace();
        }
        return null;
    }

    public String hämtaAnvändarTypSQL () {
        try{
            String sqlSök = "SELECT Typ FROM användare WHERE email = '" + Användare.getInloggadEmail() + "'";
            DatabasConnector databasConnector = new DatabasConnector();
            Connection connection = databasConnector.getConnection();
            Statement statement = connection.createStatement();

            ResultSet sqlQuery = statement.executeQuery(sqlSök);
            sqlQuery.next();

            return sqlQuery.getString("typ");
        }catch (SQLException e) {
            e.getCause();
            e.getStackTrace();
        }
        return null;
    }

    public String hämtalösenordSQL () {
        try{
            String sqlSök = "SELECT Lösenord FROM användare WHERE email = '" + Användare.getInloggadEmail() + "'";
            DatabasConnector databasConnector = new DatabasConnector();
            Connection connection = databasConnector.getConnection();
            Statement statement = connection.createStatement();

            ResultSet sqlQuery = statement.executeQuery(sqlSök);
            sqlQuery.next();

            return sqlQuery.getString("lösenord");
        }catch (SQLException e) {
            e.getCause();
            e.getStackTrace();
        }
        return null;
    }

    public int beräknaÅlder(String personnummer){
        //Metod som tar 4 första av personnumret, omvandlar till int, tar dagens årtal minus födelseår.
        String årtal = personnummer.substring(0,4);
        int räknaÅrtal = Integer.parseInt(årtal);
        LocalDate år = LocalDate.now();
        int nuvarandeÅr = år.getYear();
        return nuvarandeÅr - räknaÅrtal;
    }
}