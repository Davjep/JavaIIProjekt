package Controllers;

import JavaFXConnector.ControllerConnector;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class StartsidaController {

    @FXML
    private Button loggaInKnapp;

    @FXML
    private Button sökKnapp;

    @FXML
    private Button registreraKnapp;

    @FXML
    void tryckLoggaIn(ActionEvent event) {
        ControllerConnector controllerConnector = new ControllerConnector();
        controllerConnector.connector("loggaIn");
        Stage stage = (Stage) loggaInKnapp.getScene().getWindow();
        stage.close();

    }

    @FXML
    void tryckRegistreraKnapp(ActionEvent event) {
        ControllerConnector controllerConnector = new ControllerConnector();
        controllerConnector.connector("registrera");
        Stage stage = (Stage) registreraKnapp.getScene().getWindow();
        stage.close();
    }

    @FXML
    void tryckSökKnapp(ActionEvent event) {
        ControllerConnector controllerConnector = new ControllerConnector();
        controllerConnector.connector("sök");
        Stage stage = (Stage) sökKnapp.getScene().getWindow();
        stage.close();
    }

}
