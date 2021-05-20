package Controllers;

import Databas.Lån;
import JavaFXConnector.ControllerConnector;
import Objekt.Bok;
import Objekt.Film;
import Objekt.Objekt;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class LåneKvittoController implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if (Lån.getLåneTyp().equalsIgnoreCase("Bok")) {
            Bok bok = new Bok();
            Lån lån = new Lån();
            titelFält.setText(bok.hämtaTitelSQL());
            IDfält.setText(Objekt.getFysiskKopiaID());
            lånedatumFält.setText(lån.hämtaStartDatum());

            if (bok.hämtaKategoriSQL().equalsIgnoreCase("Kurslitteratur")) {
                återlämningsdatumFält.setText(lån.beräknaÅterlämningsDatum(14));
            } else {
                återlämningsdatumFält.setText(lån.beräknaÅterlämningsDatum(30));
            }
        } else {
            Film film = new Film();
            Lån lån = new Lån();
            titelFält.setText(film.hämtaTitelSQL());
            IDfält.setText(Objekt.getFysiskKopiaID());
            lånedatumFält.setText(lån.hämtaStartDatum());

            återlämningsdatumFält.setText(lån.beräknaÅterlämningsDatum(7));
        }

        titelFält.setEditable(false);
        IDfält.setEditable(false);
        lånedatumFält.setEditable(false);
        återlämningsdatumFält.setEditable(false);

    }

    @FXML
    private Label IDtext;

    @FXML
    private TextField titelFält;

    @FXML
    private TextField IDfält;

    @FXML
    private TextField lånedatumFält;

    @FXML
    private TextField återlämningsdatumFält;

    @FXML
    private Button okKnapp;

    @FXML
    void okKnappTryck(ActionEvent event) {
        ControllerConnector controllerConnector = new ControllerConnector();
        controllerConnector.connector("sök");
        Stage stage = (Stage) okKnapp.getScene().getWindow();
        stage.close();

    }


}
