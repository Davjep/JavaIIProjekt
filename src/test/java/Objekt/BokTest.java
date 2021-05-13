package Objekt;

import Entiteter.Användare;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BokTest {

    @Test
    void hämtaKategoriSQL() {
        Användare.setInloggadEmail("Jorsan");
        Bok.setISBN("1");
        Bok bok = new Bok();
        System.out.println(bok.hämtaKategoriSQL());
    }
}