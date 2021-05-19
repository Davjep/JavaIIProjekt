package Controllers;

import Databas.Lån;
import Entiteter.Användare;
import JavaFXConnector.ControllerConnector;
import Objekt.Bok;
import Objekt.Film;
import Objekt.Objekt;
import Objekt.FysiskKopia;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class LånaBekräftelsePopUpController {

    @FXML
    private Button jaKnapp;

    @FXML
    private Button nejKnapp;

    @FXML
    private Label meddelande;

    @FXML
    void jaKnappTryck(ActionEvent event) {
        //TODO Testa max begränsningar för ålder och antal lån

        //Skapar ett nytt lån i databasen sålänge användaren kan låna fler.
        // Om det är bok räknar vi ut hur många dagar den får lånas. Annars 1 vecka, alltid samma för film.
        Användare användare = new Användare();
        Lån lån = new Lån();
        if (lån.kanAnvändareLåna()) {
            if (Lån.getLåneTyp().equalsIgnoreCase("Bok")) {
                Bok bok = new Bok();
                if (bok.hämtaKategoriSQL().equals("Referenslitteratur")) {
                    lån.skapaLån(användare.hämtaAnvändarID(), Objekt.getFysiskKopiaID(), 14);
                } else {
                    lån.skapaLån(användare.hämtaAnvändarID(), Objekt.getFysiskKopiaID(), 31);
                }
                slutför();
            } else {
                Film film = new Film();
                if (Integer.parseInt(film.getÅldersBegränsning()) < användare.hämtaÅlderSQL()) {
                    lån.skapaLån(användare.hämtaAnvändarID(), Objekt.getFysiskKopiaID(), 7);
                    slutför();
                } else {
                    meddelande.setText("Du kan ej låna denna film pga satt åldersbegränsning");
                }
            }

        } else {
            meddelande.setText("Du kan ej låna denna film då du har nått max antal lånade objekt");
        }


    }

    @FXML
    void nejKnappTryck(ActionEvent event) {
        ControllerConnector controllerConnector = new ControllerConnector();
        controllerConnector.connector("sök");
        Stage stage = (Stage) nejKnapp.getScene().getWindow();
        stage.close();
    }

    private void slutför() {
        FysiskKopia fysiskKopia = new FysiskKopia();
        fysiskKopia.setStatus(Objekt.getFysiskKopiaID(), "Utlånad");

        ControllerConnector controllerConnector = new ControllerConnector();
        controllerConnector.connector("låneKvitto");
        Stage stage = (Stage) jaKnapp.getScene().getWindow();
        stage.close();
    }

}
