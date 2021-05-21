package Databas;

import Entiteter.Användare;
import Objekt.Bok;
import Objekt.Film;
import Objekt.FysiskKopia;
import Objekt.Objekt;
import org.junit.jupiter.api.Test;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

class LånTest {

    @Test
    void skapaLån() {
        Lån lån = new Lån();
        Användare användare = new Användare();
        Användare.setInloggadEmail("testmail@test.se");
        System.out.println(lån.beräknaÅterlämningsDatum(0));

        //lån.skapaLån(användare.hämtaAnvändarID());
    }

    @Test
    void taBortLån() {
        Lån lån = new Lån();
        lån.taBortLån("9");
    }

    @Test
    void låna() {

        try {
            Bok.setISBN("43");
            DatabasConnector databasConnector = new DatabasConnector();
            Connection connection = databasConnector.getConnection();

            String sqlStatus = "SELECT Status FROM fysiskkopia WHERE ISBN = '" + Bok.getISBN() + "';";

            Statement statusStatement = connection.createStatement();

            ResultSet statusResultat = statusStatement.executeQuery(sqlStatus);
            statusResultat.next();
            System.out.println("Resultatet är: " + statusResultat.getString("status"));

            if (statusResultat.getString("status").equalsIgnoreCase("Tillgänglig")) {
                System.out.println("Tillgänglig");

            } else {
                System.out.println("Inte alls");
            }
        } catch (SQLException e) {
            e.getCause();
            e.getStackTrace();
        }
    }
    @Test
    void skapalån() {
        Lån lån = new Lån();
        System.out.println(LocalDate.now());
        System.out.println(lån.beräknaÅterlämningsDatum(7));
        //lån.skapaLån("123", "7", 7);

        FysiskKopia fysiskKopia = new FysiskKopia();
        fysiskKopia.setStatus("7","Utlånad");
    }

    @Test
    void hämtaLåneInfo() throws SQLException, ParseException {
        Lån lån = new Lån();

        //Användare användare = new Användare();
        Användare.setInloggadEmail("testmail@test.se");
        System.out.println(lån.hämtaStartDatum());
        Calendar c = Calendar.getInstance();
        System.out.println(lån.hämtaStartDatum());
        //c.setTime(lån.hämtaStartDatum());
        c.add(Calendar.DAY_OF_MONTH, 25);
        Date newDate = c.getTime();
        System.out.println(newDate);
        System.out.println(lån.beräknaÅterlämningsDatum(25));


    }
    @Test
    void hämtaDatum() {
        Användare användare = new Användare();
        Användare.setInloggadEmail("Jorsan");
        användare.hämtaAnvändarID();
        try{
            String sqlSök = "SELECT StartDatum FROM lån WHERE användarId = " + användare.hämtaAnvändarID() + "";
            DatabasConnector databasConnector = new DatabasConnector();
            Connection connection = databasConnector.getConnection();
            PreparedStatement statement = connection.prepareStatement(sqlSök);

            ResultSet sqlQuery = statement.executeQuery(sqlSök);
            //sqlQuery.next();
            Date date = new Date();
            System.out.println(date);
            while (sqlQuery.next()) {
                date = new SimpleDateFormat("yyyy-MM-dd").parse(sqlQuery.getString("StartDatum"));

                System.out.println(date);
            }

            //date = new SimpleDateFormat("yyyy-MM-dd").parse(sqlQuery.getString("StartDatum"));

            System.out.print("sista " + date);

        } catch (SQLException | ParseException e) {
            e.getCause();
            e.getStackTrace();
        }
    }
    @Test
    public void låneLista() {
        DatabasConnector databasConnector = new DatabasConnector();

        Connection connection = databasConnector.getConnection();


        Användare.setInloggadEmail("Jorsan");

        try {

            Användare användare = new Användare();
            System.out.println(användare.hämtaAnvändarID());
            String hämtaLån = "SELECT * from biblioteket.lån WHERE användarId = " + användare.hämtaAnvändarID() + ";";
            PreparedStatement statement = connection.prepareStatement(hämtaLån);
            ResultSet resultSet = statement.executeQuery(hämtaLån);

            while(resultSet.next()) {
                String titel;
                String låneID = resultSet.getString("LåneID");
                System.out.println("1: " + låneID);
                String startDatum = resultSet.getString("startdatum");
                System.out.println("2: " + startDatum);
                String användarID = resultSet.getString("användarID");
                System.out.println("3: " + användarID);
                String återlämningsDatum = resultSet.getString("återlämningsDatum");
                System.out.println("4: " + återlämningsDatum);
                String fysiskKopiaID = resultSet.getString("fysiskKopiaID");
                System.out.println("5: " + fysiskKopiaID);

                String getTitelBok = "SELECT Titel from bok WHERE ISBN = (SELECT ISBN FROM fysiskkopia WHERE FysiskKopiaID = " + fysiskKopiaID + ");";
                String getTitelFilm = "SELECT Titel from film WHERE FilmId = (SELECT FilmID FROM fysiskkopia WHERE FysiskKopiaID = " + fysiskKopiaID + ");";



                PreparedStatement titelBokStatement = connection.prepareStatement(getTitelBok);
                ResultSet titelBokResult = titelBokStatement.executeQuery(getTitelBok);
                titelBokResult.next();
                System.out.println("6: " + titelBokResult.getString("titel"));



                if (!titelBokResult.getString("titel").equals("")) {
                    titel = titelBokResult.getString("Titel");
                    System.out.println("8: " + titel);
                    titelBokResult.close();
                } else {
                    PreparedStatement titelFilmStatement = connection.prepareStatement(getTitelFilm);
                    ResultSet titelFilmResult = titelFilmStatement.executeQuery(getTitelFilm);
                    System.out.println("7: " + titelFilmResult.getString("titel"));
                    titelFilmResult.next();
                    titel = titelFilmResult.getString("Titel");
                    System.out.println("9: " + titel);
                    titelFilmResult.close();
                }


                System.out.println(" LåneID: " + låneID + ", titel: " + titel + ", startdatum: " + startDatum + ", användarID: " + användarID +
                        ", återlämningsdatum: " + återlämningsDatum + ", fysiskKopiaID: " + fysiskKopiaID);
            }
        } catch (SQLException e) {
            e.getStackTrace();
            e.getCause();
        }
    }
    @Test
    public void testaÅldersbegränsning() {
        Film film = new Film();
        Användare användare = new Användare();
        Film.setFilmID("2");
        Användare.setInloggadEmail("Baby@driver.com");

        if (Integer.parseInt(film.hämtaÅldersBegränsningSQL()) < användare.hämtaÅlderSQL()) {
            System.out.println("du kan låna");
        } else {
            System.out.println("Du är för ung");
        }
    }
    @Test
    public void kollaÅterlämningTest() {
        DatabasConnector databasConnector = new DatabasConnector();
        Connection connection = databasConnector.getConnection();

        try {
            String sqlSök = "SELECT * FROM biblioteket.lån;";
            PreparedStatement statement = connection.prepareStatement(sqlSök);
            ResultSet resultSet = statement.executeQuery(sqlSök);
            while (resultSet.next()) {
                Date dagensDatum = new Date();
                //System.out.println(dagensDatum);
                Date återlämningsdatum = new SimpleDateFormat("yyyy-MM-dd").parse(resultSet.getString("återlämningsdatum"));
                //System.out.println(återlämningsdatum);
                if (återlämningsdatum.after(dagensDatum)) {
                    System.out.println(återlämningsdatum + " is after " + dagensDatum);
                } else {
                    System.out.println(återlämningsdatum + " is before " + dagensDatum);
                }
            }



        }catch (SQLException | ParseException e) {
            e.getCause();
            e.getStackTrace();
        }
    }
}