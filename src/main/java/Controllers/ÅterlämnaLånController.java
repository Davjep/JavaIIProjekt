package Controllers;


import Databas.DatabasConnector;
import Databas.Lån;
import JavaFXConnector.ControllerConnector;
import Objekt.FysiskKopia;
import Objekt.Objekt;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class ÅterlämnaLånController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField textFält;

    @FXML
    private Button återlämnaKnapp;

    @FXML
    private Button avbrytKnapp;

    @FXML
    private Button gåTillbakaKnapp;

    @FXML
    private Label errorText;

    @FXML
    void avbrytKnappTryck(ActionEvent event) {
        System.exit(0);

    }

    @FXML
    void gåTillbakaKnappTryck(ActionEvent event) {
        ControllerConnector controllerConnector = new ControllerConnector();
        controllerConnector.connector("startsida");
        Stage stage = (Stage) gåTillbakaKnapp.getScene().getWindow();
        stage.close();
    }

    @FXML
    void återlämnaKnappTryck(ActionEvent event) {

        if (ärIDkorrekt(textFält.getText())) {
            Lån lån = new Lån();
            lån.taBortLån(textFält.getText());

            ControllerConnector controllerConnector = new ControllerConnector();
            controllerConnector.popupConnector("successPopUp");
            Stage stage = (Stage) återlämnaKnapp.getScene().getWindow();
            stage.close();
        } else {
            errorText.setText("Inkorrekt ID!");
        }
    }

    @FXML
    void initialize() {
        assert textFält != null : "fx:id=\"textFält\" was not injected: check your FXML file 'återlämnaLån.fxml'.";
        assert återlämnaKnapp != null : "fx:id=\"återlämnaKnapp\" was not injected: check your FXML file 'återlämnaLån.fxml'.";
        assert avbrytKnapp != null : "fx:id=\"avbrytKnapp\" was not injected: check your FXML file 'återlämnaLån.fxml'.";

    }

    private boolean ärIDkorrekt(String ID) {
        FysiskKopia fysiskKopia = new FysiskKopia();
        Objekt.setFysiskKopiaID(ID);

        return fysiskKopia.hämtaFysiskKopiaIDSQL().equalsIgnoreCase(ID);
    }
}
