package Controllers;

import Entiteter.Användare;
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
    private Button taBortProfilKnapp;

    @FXML
    private Button loggaUtKnapp;

    @FXML
    void loggaUtKnappTryck(ActionEvent event) {
        Användare.loggaUt();

        ControllerConnector controllerConnector = new ControllerConnector();
        controllerConnector.connector("startsida");
        Stage stage = (Stage) loggaUtKnapp.getScene().getWindow();
        stage.close();
    }


        @FXML
    void taBortProfilKnappTryck(ActionEvent event) {
        ControllerConnector controllerConnector = new ControllerConnector();
        controllerConnector.popupConnector("taBortBekräftelsePopUp");
        Stage stage = (Stage) taBortProfilKnapp.getScene().getWindow();
        stage.close();


    }


    @FXML
    void minaLånKnappTryck(ActionEvent event) {
        ControllerConnector controllerConnector = new ControllerConnector();
        controllerConnector.connector("Minalån");
        Stage stage = (Stage) minaLånKnapp.getScene().getWindow();
        stage.close();

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
