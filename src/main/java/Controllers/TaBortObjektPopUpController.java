package Controllers;

import JavaFXConnector.ControllerConnector;
import Objekt.Bok;
import Objekt.Film;
import Objekt.FysiskKopia;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class TaBortObjektPopUpController {

    @FXML
    private Button jaKnapp;

    @FXML
    private Button nejKnapp;

    @FXML
    void jaKnappTryck(ActionEvent event) {
        if (Bok.getISBN() != null) {
            Bok bok = new Bok();
            bok.taBortObjektSQL("Bok");
        } else if (Film.getFilmID() != null) {
            Film film = new Film();
            film.taBortObjektSQL("Film");
        } else {
            FysiskKopia fysiskKopia = new FysiskKopia();
            fysiskKopia.taBortObjektSQL("fysiskKopia");
        }
        ControllerConnector controllerConnector = new ControllerConnector();
        controllerConnector.popupConnector("admin");
        Stage stage = (Stage) jaKnapp.getScene().getWindow();
        stage.close();
    }

    @FXML
    void nejKnappTryck(ActionEvent event) {
        ControllerConnector controllerConnector = new ControllerConnector();
        controllerConnector.popupConnector("hanteraObjekt");
        Stage stage = (Stage) nejKnapp.getScene().getWindow();
        stage.close();
    }

}
