package Controllers;


import Databas.DatabasConnector;
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
    void avbrytKnappTryck(ActionEvent event) {
        System.exit(0);

    }

    @FXML
    void återlämnaKnappTryck(ActionEvent event) {
        DatabasConnector databasConnector = new DatabasConnector();
        Connection connection = databasConnector.getConnection();

        // TODO: Vad händer om den är reserverad , behöver ändra status
        //Behöver även göra ett felmeddelande ifall att man skriver in fel fysiskaKopiaId

        String fysiskKopiaId = textFält.getText();

        FysiskKopia fysiskKopia = new FysiskKopia();
        fysiskKopia.setStatus(fysiskKopiaId,"Tillgänglig");
    }

    @FXML
    void initialize() {
        assert textFält != null : "fx:id=\"textFält\" was not injected: check your FXML file 'återlämnaLån.fxml'.";
        assert återlämnaKnapp != null : "fx:id=\"återlämnaKnapp\" was not injected: check your FXML file 'återlämnaLån.fxml'.";
        assert avbrytKnapp != null : "fx:id=\"avbrytKnapp\" was not injected: check your FXML file 'återlämnaLån.fxml'.";

    }
}
