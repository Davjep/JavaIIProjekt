package Controllers;

import Databas.Lån;
import JavaFXConnector.ControllerConnector;
import Objekt.Bok;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class BokDetaljerController implements Initializable {

    @FXML
    private TextField ISBNTextFält;

    @FXML
    private TextField titelTextFält;

    @FXML
    private TextField författareTextFält;

    @FXML
    private TextField ämnesordTextFält;

    @FXML
    private TextField kategoriTextFält;

    @FXML
    private TextField utgivningsårTextFält;

    @FXML
    private Button gåTillbakaKnapp;

    @FXML
    private Button lånaBokKnapp;

    @FXML
    private Label errorText;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        Bok bok = new Bok();
        ISBNTextFält.setText(bok.hämtaISBNSQL(Bok.getISBN()));
        titelTextFält.setText(bok.hämtaTitelSQL());
        författareTextFält.setText(bok.hämtaFörfattareSQL());
        ämnesordTextFält.setText(bok.hämtaÄmnesordSQL());
        kategoriTextFält.setText(bok.hämtaKategoriSQL());
        utgivningsårTextFält.setText(bok.hämtaUtgivningsårSQL());
    }

    @FXML
    void gåTillbakaKnappTryck(ActionEvent event) {
        ControllerConnector controllerConnector = new ControllerConnector();
        controllerConnector.connector("sök");
        Stage stage = (Stage) gåTillbakaKnapp.getScene().getWindow();
        stage.close();

    }

    @FXML
    void lånaBokKnappTryck(ActionEvent event) {
        Bok bok = new Bok();
        if (bok.hämtaKategoriSQL().equalsIgnoreCase("Referenslitteratur")) {
            errorText.setText("Referenslitteratur kan ej lånas ut! ");
        } else if (bok.hämtaKategoriSQL().equalsIgnoreCase("Tidsskrift")) {
            errorText.setText("Tidsskrifter kan ej lånas ut! ");
        } else {
            errorText.setText("");
            Lån.setLåneTyp("Bok");
            ControllerConnector controllerConnector = new ControllerConnector();
            controllerConnector.connector("väljfysiskkopia");
            Stage stage = (Stage) gåTillbakaKnapp.getScene().getWindow();
            stage.close();
            /*
            Lån lån = new Lån();
            if (!lån.hämtaLåneStatus().equalsIgnoreCase("Tillgänglig")) {
                ControllerConnector controllerConnector = new ControllerConnector();
                controllerConnector.popupConnector("ejTillgängligPopUp");
                Stage stage = (Stage) lånaBokKnapp.getScene().getWindow();
                stage.close();
            } else {
                Lån.setLåneTyp("Bok");
                ControllerConnector controllerConnector = new ControllerConnector();
                controllerConnector.popupConnector("lånaBekräftelsePopUp");
                Stage stage = (Stage) lånaBokKnapp.getScene().getWindow();
                stage.close();
            }*/
        }
    }

}

