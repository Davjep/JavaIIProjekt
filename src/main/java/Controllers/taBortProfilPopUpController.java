package Controllers;

import Entiteter.Användare;
import JavaFXConnector.ControllerConnector;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class taBortProfilPopUpController {

    @FXML
    private Button jaKnapp;

    @FXML
    private Button nejKnapp;

    @FXML
    void jaKnappTryck(ActionEvent event) {
        Användare användare = new Användare();
        användare.taBortAnvändareSQL();

        Stage stage = (Stage) jaKnapp.getScene().getWindow();
        stage.close();
        System.exit(0);
    }

    @FXML
    void nejKnappTryck(ActionEvent event) {
        ControllerConnector controllerConnector = new ControllerConnector();
        controllerConnector.connector("minProfil");
        Stage stage = (Stage) nejKnapp.getScene().getWindow();
        stage.close();

    }

}
