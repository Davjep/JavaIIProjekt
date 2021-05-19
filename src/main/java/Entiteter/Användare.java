package Entiteter;

import Databas.DatabasConnector;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

public class Användare extends Entitet {
    String typ;

    public Användare() {
        super();
    }


    public Användare(String förNamn, String efterNamn, String telefonNr, String gatuAdress, String postNr,
                     String email, String personNr, String typ, String lösenord) {
        super(förNamn, efterNamn, gatuAdress, postNr, email, personNr, telefonNr, lösenord);
        this.typ = typ;
    }

    public void läggaTillAnvändareSQL() {
        try {
            DatabasConnector databasConnector = new DatabasConnector();
            Connection connection = databasConnector.getConnection();
            Statement statement = connection.createStatement();
            String sqlInsertQuery = "INSERT INTO användare (FörNamn, EfterNamn, Telefon, GatuAdress, postNummer, Email, PersonNr, Ålder, Typ, AntalLåneObjekt, lösenord) " +
                    "VALUES ('" + getFörNamn() + "','" + getEfterNamn() + "','" + getTelefonNr() + "','" + getGatuAdress() + "','" + getPostNr() + "','" + getEmail() + "','" +
                    getPersonNr() + "'," + beräknaÅlder(personNr) + ",'" + getTyp() + "', " + 0 + ", '" + getLösenord() + "' )";
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

    //Nedan metoder är alla för att hämta användarinformation från databasen

    public String hämtaAnvändarID (){
        String email;
        if (Anställd.getAnställd()) {
            Anställd anställd = new Anställd();
            email = anställd.hämtaValdEmail();
        } else {
            email = Användare.getInloggadEmail();
        }

        try {
            String sqlSök = "SELECT AnvändarId FROM användare WHERE email = '" + email + "'";
            DatabasConnector databasConnector = new DatabasConnector();
            Connection connection = databasConnector.getConnection();
            Statement statement = connection.createStatement();

            ResultSet sqlQuery = statement.executeQuery(sqlSök);
            sqlQuery.next();

            return sqlQuery.getString("användarId");
        }catch (SQLException e) {
            e.getCause();
            e.getStackTrace();
        }
        return null;
    }

    public String hämtaFörnamnSQL () {
        String email;
        if (Anställd.getAnställd()) {
            Anställd anställd = new Anställd();
            email = anställd.hämtaValdEmail();
        } else {
            email = Användare.getInloggadEmail();
        }
        try{
            String sqlSök = "SELECT förnamn FROM användare WHERE email = '" + email + "'";
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
        String email;
        if (Anställd.getAnställd()) {
            Anställd anställd = new Anställd();
            email = anställd.hämtaValdEmail();
        } else {
            email = Användare.getInloggadEmail();
        }

        try{
            String sqlSök = "SELECT EfterNamn FROM användare WHERE email = '" + email + "'";
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
        String email;
        if (Anställd.getAnställd()) {
            Anställd anställd = new Anställd();
            email = anställd.hämtaValdEmail();
        } else {
            email = Användare.getInloggadEmail();
        }

        try{
            String sqlSök = "SELECT Telefon FROM användare WHERE email = '" + email + "'";
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
        String email;
        if (Anställd.getAnställd()) {
            Anställd anställd = new Anställd();
            email = anställd.hämtaValdEmail();
        } else {
            email = Användare.getInloggadEmail();
        }

        try{
            String sqlSök = "SELECT GatuAdress FROM användare WHERE email = '" + email + "'";
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
        String email;
        if (Anställd.getAnställd()) {
            Anställd anställd = new Anställd();
            email = anställd.hämtaValdEmail();
        } else {
            email = Användare.getInloggadEmail();
        }

        try{
            String sqlSök = "SELECT Postnummer FROM användare WHERE email = '" + email + "'";
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
        String email;

        if (Anställd.getAnställd()) {
            Anställd anställd = new Anställd();
            email = anställd.hämtaValdEmail();
        } else {
            email = Användare.getInloggadEmail();
        }

        try{
            String sqlSök = "SELECT Email FROM användare WHERE email = '" + email + "'";
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
        String email;
        if (Anställd.getAnställd()) {
            Anställd anställd = new Anställd();
            email = anställd.hämtaValdEmail();
        } else {
            email = Användare.getInloggadEmail();
        }

        try{
            String sqlSök = "SELECT PersonNr FROM användare WHERE email = '" + email + "'";
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
        String email;
        if (Anställd.getAnställd()) {
            Anställd anställd = new Anställd();
            email = anställd.hämtaValdEmail();
        } else {
            email = Användare.getInloggadEmail();
        }

        try{
            String sqlSök = "SELECT Typ FROM användare WHERE email = '" + email + "'";
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
        String email;
        if (Anställd.getAnställd()) {
            Anställd anställd = new Anställd();
            email = anställd.hämtaValdEmail();
        } else {
            email = Användare.getInloggadEmail();
        }

        try{
            String sqlSök = "SELECT Lösenord FROM användare WHERE email = '" + email + "'";
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

    public int hämtaÅlderSQL() {
        try{
            String sqlSök = "SELECT Ålder FROM användare WHERE email = '" + email + "'";
            DatabasConnector databasConnector = new DatabasConnector();
            Connection connection = databasConnector.getConnection();
            Statement statement = connection.createStatement();

            ResultSet sqlQuery = statement.executeQuery(sqlSök);
            sqlQuery.next();

            return Integer.parseInt(sqlQuery.getString("ålder"));

        }catch (SQLException e) {
            e.getCause();
            e.getStackTrace();
        }
        return 0;
    }

    public int beräknaÅlder(String personnummer){
        //Metod som tar 4 första av personnumret, omvandlar till int, tar dagens årtal minus födelseår.
        String årtal = personnummer.substring(0,4);
        int räknaÅrtal = Integer.parseInt(årtal);
        LocalDate år = LocalDate.now();
        int nuvarandeÅr = år.getYear();
        return nuvarandeÅr - räknaÅrtal;
    }

    public String getTyp() {
        return typ;
    }

    public int hämtaAntalLåneObjekt() {

        try{
            String sqlSök = "SELECT AntalLåneObjekt FROM användare WHERE email = '" + Användare.getInloggadEmail() + "'";
            DatabasConnector databasConnector = new DatabasConnector();
            Connection connection = databasConnector.getConnection();
            Statement statement = connection.createStatement();

            ResultSet sqlQuery = statement.executeQuery(sqlSök);
            sqlQuery.next();

            return Integer.parseInt(sqlQuery.getString("AntalLåneObjekt"));

        }catch (SQLException e) {
            e.getCause();
            e.getStackTrace();
        }
        return 0;
    }
}