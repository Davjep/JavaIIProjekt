package Objekt;

import Entiteter.Användare;
import org.junit.jupiter.api.Test;

class BokTest {

    @Test
    void hämtaKategoriSQL() {
        Användare.setInloggadEmail("Jorsan");
        Bok.setID("1");
        Bok.setISBN("2");
        Bok bok = new Bok();
        System.out.println(Bok.getISBN());
        System.out.println(Bok.getID());
    }
}