package Entiteter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnvändareTest {

    @Test
    void hämtaAnvändarID() {
        Anställd anställd = new Anställd("Mikaela", "Test", "Testvägen 123", "12345", "Mikaela@test.se",
                "200012245687", "0701235869", "test3", false);
        Anställd.setAnställd(true);
        Anställd.setID("456892");
        System.out.println(Anställd.getID());
        System.out.println(anställd.hämtaValdEmail());

    }
}