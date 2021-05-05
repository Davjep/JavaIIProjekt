package Controllers;

import JavaFXConnector.ControllerConnector;
import org.junit.jupiter.api.Test;

class RegistreraControllerTest {

    @Test
    void registrera() {
        ControllerConnector controllerConnector = new ControllerConnector();
        controllerConnector.connector("registrera");
    }
}