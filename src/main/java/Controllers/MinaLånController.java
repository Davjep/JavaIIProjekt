package Controllers;

import JavaFXConnector.ControllerConnector;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class MinaLånController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button TillbakaKnapp;

    @FXML
    void TillbakaKnappTryck(ActionEvent event) {
        ControllerConnector controllerConnector = new ControllerConnector();
        controllerConnector.connector("minProfil");
        Stage stage = (Stage) TillbakaKnapp.getScene().getWindow();
        stage.close();

    }

    @FXML
    void initialize() {
        assert TillbakaKnapp != null : "fx:id=\"TillbakaKnapp\" was not injected: check your FXML file 'Minalån.fxml'.";

    }
}
