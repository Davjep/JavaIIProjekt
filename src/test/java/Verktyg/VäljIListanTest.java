package Verktyg;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VäljIListanTest {

    @Test
    void väljValdRad() {
        VäljIListan väljIListan = new VäljIListan();
        System.out.println(väljIListan.väljValdRad(" 21235, abdcs"));
    }
}