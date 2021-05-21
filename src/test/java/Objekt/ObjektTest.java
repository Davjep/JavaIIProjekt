package Objekt;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ObjektTest {

    @Test
    void taBortObjektSQL() {
        Film fysiskKopia = new Film();
        Film.setFilmID("4");
        fysiskKopia.taBortObjektSQL("film");
    }
}