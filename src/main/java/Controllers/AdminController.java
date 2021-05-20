package Controllers;

import Entiteter.Användare;
import JavaFXConnector.ControllerConnector;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class AdminController {

    @FXML
    private Button läggTillObjektKnapp;

    @FXML
    private Button läggTillAnvändareKnapp;

    @FXML
    private Button hanteraObjektKnapp;

    @FXML
    private Button hanteraAnvändareKnapp;

    @FXML
    private Button loggaUtKnapp;

    @FXML
    void hanteraAnvändareKnappTryck(ActionEvent event) {
        ControllerConnector controllerConnector = new ControllerConnector();
        controllerConnector.connector("hanteraAnvändare");
        Stage stage = (Stage) hanteraAnvändareKnapp.getScene().getWindow();
        stage.close();

    }

    @FXML
    void hanteraObjektKnappTryck(ActionEvent event) {
        //TODO Skapa!
        ControllerConnector controllerConnector = new ControllerConnector();
        controllerConnector.connector("väljObjekt");
        Stage stage = (Stage) hanteraAnvändareKnapp.getScene().getWindow();
        stage.close();
    }

    @FXML
    void loggaUtKnappTryck(ActionEvent event) {
        Användare.loggaUt();

        ControllerConnector controllerConnector = new ControllerConnector();
        controllerConnector.connector("startsida");
        Stage stage = (Stage) loggaUtKnapp.getScene().getWindow();
        stage.close();

    }

    @FXML
    void läggTillAnvändareKnappTryck(ActionEvent event) {
        ControllerConnector controllerConnector = new ControllerConnector();
        controllerConnector.connector("registrera");
        Stage stage = (Stage) läggTillAnvändareKnapp.getScene().getWindow();
        stage.close();

    }

    @FXML
    void läggTillObjektKnappTryck(ActionEvent event) {
        ControllerConnector controllerConnector = new ControllerConnector();
        controllerConnector.connector("läggtillobjekt");
        Stage stage = (Stage) läggTillAnvändareKnapp.getScene().getWindow();
        stage.close();
    }

}

