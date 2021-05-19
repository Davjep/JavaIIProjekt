package Controllers;

import JavaFXConnector.ControllerConnector;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ReservationPopUpController {

    @FXML
    private Button okKnapp;

    @FXML
    void okKnappTryck(ActionEvent event) {
        ControllerConnector controllerConnector = new ControllerConnector();
        controllerConnector.connector("sök");
        Stage stage = (Stage) okKnapp.getScene().getWindow();
        stage.close();
    }

}