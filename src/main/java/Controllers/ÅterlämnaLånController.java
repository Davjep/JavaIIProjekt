package Controllers;


import Databas.DatabasConnector;
import Databas.Lån;
import JavaFXConnector.ControllerConnector;
import Objekt.FysiskKopia;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
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
        DatabasConnector databasConnector = new DatabasConnector();
        Connection connection = databasConnector.getConnection();

        // TODO: Behöver även göra ett felmeddelande ifall att man skriver in fel fysiskaKopiaId
        //TODO lägg till koppling till success

        String fysiskKopiaId = textFält.getText();

        Lån lån = new Lån();
        lån.taBortLån(fysiskKopiaId);

    }

    @FXML
    void initialize() {
        assert textFält != null : "fx:id=\"textFält\" was not injected: check your FXML file 'återlämnaLån.fxml'.";
        assert återlämnaKnapp != null : "fx:id=\"återlämnaKnapp\" was not injected: check your FXML file 'återlämnaLån.fxml'.";
        assert avbrytKnapp != null : "fx:id=\"avbrytKnapp\" was not injected: check your FXML file 'återlämnaLån.fxml'.";

    }
}
