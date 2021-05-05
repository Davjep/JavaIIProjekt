package Controllers;

import JavaFXConnector.ControllerConnector;
import Session.SessionsAnvändare;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class SökController {

    @FXML
    private TextField sökFält;

    @FXML
    private ScrollBar scrollBar;

    @FXML
    private Button sökKnapp;

    @FXML
    private ListView<?> resultatLista;

    @FXML
    private Button hemKnapp;

    @FXML
    private SplitMenuButton kategoriValDropDown;

    @FXML
    private MenuItem bokKategori;

    @FXML
    private MenuItem filmKategori;

    @FXML
    private Label errorText;

    @FXML
    void bokKategoriVal(ActionEvent event) {
        kategoriValDropDown.setText("Bok");
        sökFält.setPromptText("Sök titel, föfattare, ämnesord...");
    }

    @FXML
    void filmKategoriVal(ActionEvent event) {
        kategoriValDropDown.setText("Film");
        sökFält.setPromptText("Sök titel, regissör, genre...");
    }

    @FXML
    void SökKnappTryck(ActionEvent event) {
        String kategoriVal = kategoriValDropDown.getText();
        if (!kategoriVal.equals("Bok") || !kategoriVal.equals("Film")) {
            errorText.setText("Välj kategori innan du söker!");
        }



    }

    @FXML
    void resultatListaMerInfo(MouseEvent event) {

    }
    @FXML
    void hemKnappTryck(ActionEvent event) {
        SessionsAnvändare sessionsAnvändare = new SessionsAnvändare();
        ControllerConnector controllerConnector = new ControllerConnector();
        if (sessionsAnvändare.isInloggad()) {
            controllerConnector.connector("minProfil");
        } else {
            controllerConnector.connector("startsida");
        }
        Stage stage = (Stage) hemKnapp.getScene().getWindow();
        stage.close();

    }

}


