package Controllers;

import Databas.Lån;
import JavaFXConnector.ControllerConnector;
import Objekt.Bok;
import Objekt.Film;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
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
            IDfält.setText(bok.hämtaISBNSQL());
            lånedatumFält.setText(lån.hämtaStartDatum().toString());

            if (bok.hämtaKategoriSQL().equalsIgnoreCase("Kurslitteratur")) {
                återlämningsdatumFält.setText(lån.beräknaÅterlämningsDatum(14).toString());
            } else {
                återlämningsdatumFält.setText(lån.beräknaÅterlämningsDatum(30).toString());
            }
        } else {
            Film film = new Film();
            Lån lån = new Lån();
            titelFält.setText(film.hämtaTitelSQL());
            IDfält.setText(film.hämtaFilmIDSQL());
            lånedatumFält.setText(lån.hämtaStartDatum().toString());

            återlämningsdatumFält.setText(lån.beräknaÅterlämningsDatum(7).toString());
        }

    }

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
