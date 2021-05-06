package Session;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SessionsAnvändareTest {

    @Test
    void setAndGetInloggadEmail() {
        SessionsAnvändare sessionsAnvändare = new SessionsAnvändare();
        SessionsAnvändare.setInloggad();
        sessionsAnvändare.setInloggadEmail("Jorsan");
        System.out.println(sessionsAnvändare.getInloggadEmail());
    }
}