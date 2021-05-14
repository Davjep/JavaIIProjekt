package Controllers;

import Entiteter.Användare;
import JavaFXConnector.ControllerConnector;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class SuccessPopUpController {

    @FXML
    private Label registreradText;

    @FXML
    private Button okKnapp;

    @FXML
    void okKnappTryck(ActionEvent event) {
        ControllerConnector controllerConnector = new ControllerConnector();
        if (Användare.getInloggad()) {
            controllerConnector.connector("minProfil");
            Stage stage = (Stage) okKnapp.getScene().getWindow();
            stage.close();
        } else {
            controllerConnector.connector("startsida");
            Stage stage = (Stage) okKnapp.getScene().getWindow();
            stage.close();
        }
    }


}

