package Databas;

import Session.SessionsAnvändare;

import java.time.LocalDate;

public class AnvändareInserts {

    public String sqlInsertAnvändare (String förNamn, String efterNamn, String telefon, String gatuAdress, String postNummer,
                                     String email, String personNr, String typ, String lösenord) {
        String sqlInsertQuery = "INSERT INTO användare (FörNamn, EfterNamn, Telefon, GatuAdress, postNummer, Email, PersonNr, Ålder, Typ, AntalLåneObjekt, lösenord) " +
                    "VALUES ('" + förNamn + "','" + efterNamn + "','" + telefon + "','" + gatuAdress + "','" + postNummer + "','" + email + "','" +
                    personNr + "'," + beräknaÅlder(personNr) + ",'" + typ + "', " + 0 + ", '" + lösenord + "' )";
        return sqlInsertQuery;
    }

    public String sqlUpdateAnvändare (String förNamn, String efterNamn, String telefon, String gatuAdress, String postNummer,
                                      String email, String personNr, String typ, String lösenord) {
        SessionsAnvändare sessionsAnvändare = new SessionsAnvändare();
        String sqlUpdateQuery = "UPDATE användare SET FörNamn = '" + förNamn + "' , efternamn = '" + efterNamn + "', telefon = '" + telefon
                + "', gatuadress = '" + gatuAdress + "', postnummer = '" + postNummer + "', email = '" + email + "', personnr = '" + personNr
                + "', typ = '" + typ + "', lösenord = '" + lösenord + "' WHERE email = '" + sessionsAnvändare.getInloggadEmail() + "'";
        return sqlUpdateQuery;
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
