package Controllers;

import Databas.Lån;
import Entiteter.Användare;
import JavaFXConnector.ControllerConnector;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class LånaBekräftelsePopUpController {

    @FXML
    private Button jaKnapp;

    @FXML
    private Button nejKnapp;

    @FXML
    void jaKnappTryck(ActionEvent event) {
        Användare användare = new Användare();
        Lån lån = new Lån();
        lån.skapaLån(användare.hämtaAnvändarID());
        ControllerConnector controllerConnector = new ControllerConnector();
        controllerConnector.connector("låneKvitto");
        Stage stage = (Stage) jaKnapp.getScene().getWindow();
        stage.close();
    }

    @FXML
    void nejKnappTryck(ActionEvent event) {
        ControllerConnector controllerConnector = new ControllerConnector();
        controllerConnector.connector("sök");
        Stage stage = (Stage) nejKnapp.getScene().getWindow();
        stage.close();
    }

}
