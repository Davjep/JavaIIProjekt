package Entiteter;

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

    public static boolean isInloggad() {
        return inloggad;
    }
    public String läggaTillAnvändareSQL(String förNamn, String efterNamn, String telefon, String gatuAdress, String postNummer,
                                     String email, String personNr, String typ, String lösenord) {
        String sqlInsertQuery = "INSERT INTO användare (FörNamn, EfterNamn, Telefon, GatuAdress, postNummer, Email, PersonNr, Ålder, Typ, AntalLåneObjekt, lösenord) " +
                "VALUES ('" + förNamn + "','" + efterNamn + "','" + telefon + "','" + gatuAdress + "','" + postNummer + "','" + email + "','" +
                personNr + "'," + beräknaÅlder(personNr) + ",'" + typ + "', " + 0 + ", '" + lösenord + "' )";
        return sqlInsertQuery;
    }

    public String uppdateraAnvändareSQL (String förNamn, String efterNamn, String telefon, String gatuAdress, String postNummer,
                                         String email, String personNr, String typ, String lösenord) {
        String sqlUpdateQuery = "UPDATE användare SET FörNamn = '" + förNamn + "' , efternamn = '" + efterNamn + "', telefon = '" + telefon
                + "', gatuadress = '" + gatuAdress + "', postnummer = '" + postNummer + "', email = '" + email + "', personnr = '" + personNr
                + "', typ = '" + typ + "', lösenord = '" + lösenord + "' WHERE email = '" + getInloggadEmail() + "'";
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