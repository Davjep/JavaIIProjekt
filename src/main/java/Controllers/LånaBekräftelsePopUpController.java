package Controllers;

import Databas.Lån;
import Entiteter.Användare;
import JavaFXConnector.ControllerConnector;
import Objekt.Bok;
import Objekt.Objekt;
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
        //Skapar ett nytt lån i databasen. Om det är bok räknar vi ut hur många dagar den får lånas. Annars 1 vecka, alltid samma för film.
        Användare användare = new Användare();
        Lån lån = new Lån();
        if (Lån.getLåneTyp().equalsIgnoreCase("Bok")) {
            Bok bok = new Bok();
            if (bok.hämtaKategoriSQL().equals("Referenslitteratur")) {
                lån.skapaLån(användare.hämtaAnvändarID(), Objekt.getFysiskKopiaID(), 14);
            } else {
                lån.skapaLån(användare.hämtaAnvändarID(), Objekt.getFysiskKopiaID(), 31);
            }
        } else {
            lån.skapaLån(användare.hämtaAnvändarID(), Objekt.getFysiskKopiaID(), 7);
        }

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
