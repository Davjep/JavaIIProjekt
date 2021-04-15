package Entiteter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnvändareTest {

    @Test
    void användare() {
        Användare användare = new Användare("David J",
                "19920125-5271",
                "Abc 123",
                "jepsson@test.se",
                "0808120833",
                "666",
                "Student",
                29,
                "David123!");
    }
}