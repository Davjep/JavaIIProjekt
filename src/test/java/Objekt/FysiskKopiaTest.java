package Objekt;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FysiskKopiaTest {

    @Test
    void läggTillFysiskKopiaSQL() {
        String ISBN = "44";
        String filmID = "";

        FysiskKopia fysiskKopia = new FysiskKopia(ISBN, filmID, "C0002", "Tillgänglig");
        System.out.println(fysiskKopia.getISBN());
        fysiskKopia.läggTillFysiskKopiaSQL();
    }
}