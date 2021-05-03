package Controllers;

import JavaFXConnector.ControllerConnector;
import Session.SessionsAnvändare;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class SökController {

    @FXML
    private TextField SökFält;

    @FXML
    private ScrollBar ScrollBar;

    @FXML
    private Button SökKnapp;

    @FXML
    private ListView<?> resultatLista;

    @FXML
    private Button hemKnapp;

    @FXML
    void SökKnappTryck(ActionEvent event) {

    }

    @FXML
    void resultatListaMerInfo(MouseEvent event) {

    }
    @FXML
    void hemKnappTryck(ActionEvent event) {
        SessionsAnvändare sessionsAnvändare = new SessionsAnvändare();
        ControllerConnector controllerConnector = new ControllerConnector();
        if (sessionsAnvändare.isInloggad()) {
            controllerConnector.connector("minProfil");
        } else {
            controllerConnector.connector("startsida");
        }
        Stage stage = (Stage) hemKnapp.getScene().getWindow();
        stage.close();

    }

}


