package Databas;

import Entiteter.Användare;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

public class AnvändareTest {

    @Test
    public void hämtaAnvändareTest() {
        Användare användare = new Användare();
        Användare.setInloggadEmail("Jorsan");
        System.out.printf(användare.hämtaFörnamnSQL() + "%n" +
                användare.hämtaEfternamnSQL() + "%n" +
                användare.hämtaAnvändarTypSQL());
    }

    @Test
    public void läggaTillAnvändareTest() throws SQLException {
        Användare användare = new Användare("Test", "Testman", "078659984",
                "Testroad 124", "78456", "testmail@test.se", "192201014578", "Forskare", "test");
        användare.läggaTillAnvändareSQL();
    }

    @Test
    public void uppdateraAnvändare() {
        Användare användare = new Användare();
        Användare.setInloggadEmail("testmail@test.se");
        användare.uppdateraAnvändareSQL("Testbertat", "Testgren", "078659984", "Testroad 1", "78456", "testmail@test.se", "196801014578", "Forskare", "test");
    }

    @Test
    public void loggaIn() {
        Användare.setInloggadEmail("biblan@mail.se");
        System.out.println(Användare.getInloggadEmail());
        Användare användare = new Användare();
        if (användare.hämtaAnvändarTypSQL().equalsIgnoreCase("Biblioteksanställda")) {
            System.out.println("Ja");
        } else {
            System.out.println("Nej");
        }


    }

}