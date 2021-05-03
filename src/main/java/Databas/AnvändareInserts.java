package Databas;

public class AnvändareInserts {

    public String sqlInsertAnvändare(String användarId, String förNamn, String efterNamn, String telefon, String adress,
                                     String email, String personNr, int ålder, String typ, int antalLåneObjekt) {

        String sqlInsertQuery = "INSERT INTO användare (AnvändarId, FörNamn, EfterNamn, Telefon, Adress, Email, PersonNr, Ålder, Typ, AntalLåneObjekt)" +
                "VALUES ('" + användarId + "','" + förNamn + "','" + efterNamn + "','" + telefon + "','" + adress + "','" + email + "','" +
                personNr + "'," + ålder + ",'" + typ + "', " + antalLåneObjekt + ")";
        return sqlInsertQuery;
    }
}
