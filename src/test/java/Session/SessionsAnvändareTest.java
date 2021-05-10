package Session;

import Entiteter.Användare;
import org.junit.jupiter.api.Test;

class SessionsAnvändareTest {

    @Test
    void setAndGetInloggadEmail() {
        //Användare sessionsAnvändare = new SessionsAnvändare();
        Användare.setInloggad();
        Användare.setInloggadEmail("Jorsan");
        System.out.println(Användare.getInloggadEmail());
    }
}