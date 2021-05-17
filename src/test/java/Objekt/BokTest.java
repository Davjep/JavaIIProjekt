package Objekt;

import Entiteter.Användare;
import org.junit.jupiter.api.Test;

class BokTest {

    @Test
    void hämtaKategoriSQL() {
        Användare.setInloggadEmail("Jorsan");
        Bok.setFysiskKopiaID("5");
        Bok bok = new Bok();
        System.out.println(bok.hämtaStatusSQL());
        System.out.println(Bok.getFysiskKopiaID());
    }
}