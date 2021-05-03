package Controllers;

import JavaFXConnector.ControllerConnector;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class MinProfilController {

    @FXML
    private Button minaLånKnapp;

    @FXML
    private Button UppdateraProfilKnapp;

    @FXML
    private Label minProfilTitel;

    @FXML
    private Button sökKnapp;

    @FXML
    void minaLånKnappTryck(ActionEvent event) {

    }

    @FXML
    void sökKnappTryck(ActionEvent event) {
        ControllerConnector controllerConnector = new ControllerConnector();
        controllerConnector.connector("sök");
        Stage stage = (Stage) sökKnapp.getScene().getWindow();
        stage.close();
    }

    @FXML
    void uppdateraProfilKnappTryck(ActionEvent event) {
        ControllerConnector controllerConnector = new ControllerConnector();
        controllerConnector.connector("uppdateraProfil");
        Stage stage = (Stage) sökKnapp.getScene().getWindow();
        stage.close();
    }

}
