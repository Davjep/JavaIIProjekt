package Databas;

import Entiteter.Användare;
import org.junit.jupiter.api.Test;

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
    public void läggaTillAnvändareTest() {
        Användare användare = new Användare();
            användare.läggaTillAnvändareSQL("Test", "Testsson", "078659984", "Testroad 123", "78456", "testmail@test.se", "199201014578", "Forskare", "test");
    }

    @Test
    public void uppdateraAnvändare() {
        Användare användare = new Användare();
        Användare.setInloggadEmail("testmail@test.se");
        användare.uppdateraAnvändareSQL("Testbertat", "Testgren", "078659984", "Testroad 1", "78456", "testmail@test.se", "196801014578", "Forskare", "test");
    }

    @Test
    public void räkna() {

    }

}