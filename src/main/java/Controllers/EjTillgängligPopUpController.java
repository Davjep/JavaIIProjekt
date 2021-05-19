package Controllers;

import Databas.Reservation;
import Entiteter.Användare;
import JavaFXConnector.ControllerConnector;
import Objekt.Bok;
import Objekt.Objekt;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class EjTillgängligPopUpController {

    @FXML
    private Button jaKnapp;

    @FXML
    private Button nejKnapp;

    @FXML
    void jaKnappTryck(ActionEvent event) {
        Användare användare = new Användare();
        Reservation reservation = new Reservation(användare.hämtaAnvändarID(), Objekt.getFysiskKopiaID());

        reservation.skapaReservationSQL();

        ControllerConnector controllerConnector = new ControllerConnector();
        controllerConnector.popupConnector("reservationPopUp");
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
