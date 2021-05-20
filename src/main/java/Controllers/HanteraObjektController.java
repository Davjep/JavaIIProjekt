package Controllers;

import JavaFXConnector.ControllerConnector;
import Objekt.Bok;
import Objekt.Film;
import Objekt.FysiskKopia;
import Objekt.Objekt;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

public class HanteraObjektController implements Initializable {

    @FXML
    private Button sparaKnapp;

    @FXML
    private Button avbrytKnapp;

    @FXML
    private Label text2;

    @FXML
    private Label text1;

    @FXML
    private Label text3;

    @FXML
    private Label text4;

    @FXML
    private Label text5;

    @FXML
    private Label text6;

    @FXML
    private Label text7;

    @FXML
    private TextField text1TextFält;

    @FXML
    private TextField text2TextFält;

    @FXML
    private TextField text3TextFält;

    @FXML
    private TextField text4TextFält;

    @FXML
    private TextField text5TextFält;

    @FXML
    private TextField text6TextFält;

    @FXML
    private TextField text7TextFält;

    @FXML
    private Button text2ÄndraKnapp;

    @FXML
    private Button text3ÄndraKnapp;

    @FXML
    private Button text4ÄndraKnapp;

    @FXML
    private Button text5ÄndraKnapp;

    @FXML
    private Button text6ÄndraKnapp;

    @FXML
    private Button text7ÄndraKnapp;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if (Bok.getISBN() != null) {
            Bok bok = new Bok();
            text1.setText("ISBN");
            text2.setText("Titel");
            text3.setText("Författare");
            text4.setText("Ämnesord");
            text5.setText("Kategori");
            text6.setText("Utgivningsår");

            text1TextFält.setText(Bok.getISBN());
            text2TextFält.setText(bok.hämtaTitelSQL());
            text3TextFält.setText(bok.hämtaFörfattareSQL());
            text4TextFält.setText(bok.hämtaÄmnesordSQL());
            text5TextFält.setText(bok.hämtaKategoriSQL());
            text6TextFält.setText(bok.hämtaUtgivningsårSQL());

            for (TextField textField : Arrays.asList(text1TextFält, text2TextFält, text3TextFält, text4TextFält, text5TextFält, text6TextFält)) {
                textField.setEditable(false);
            }

            text7.setVisible(false);
            text7TextFält.setVisible(false);
            text7ÄndraKnapp.setVisible(false);

        } else if (Film.getFilmID() != null) {
            Film film = new Film();

            text1.setText("FilmID");
            text2.setText("Titel");
            text3.setText("Regissör");
            text4.setText("Genre");
            text5.setText("Produktionsland");
            text6.setText("Utgivningsår");
            text7.setText("Åldersbegränsning");

            text1TextFält.setText(Film.getFilmID());
            text2TextFält.setText(film.hämtaTitelSQL());
            text3TextFält.setText(film.hämtaRegissörSQL());
            text4TextFält.setText(film.hämtaGenreSQL());
            text5TextFält.setText(film.hämtaProduktionslandSQL());
            text6TextFält.setText(film.hämtaUtgivningsårSQL());
            text7TextFält.setText(film.hämtaÅldersBegränsningSQL());

            for (TextField textField : Arrays.asList(text1TextFält, text2TextFält, text3TextFält, text4TextFält, text5TextFält, text6TextFält, text7TextFält)) {
                textField.setEditable(false);
            }

        } else {
            FysiskKopia fysiskKopia = new FysiskKopia();

            text1.setText("Fysisk Kopia ID");
            text2.setText("Plats");
            text3.setText("Status");
            text4.setText("ISBN");
            text5.setText("FilmID");

            text1TextFält.setText(Objekt.getFysiskKopiaID());
            text2TextFält.setText(fysiskKopia.hämtaPlatsSQL());
            text3TextFält.setText(fysiskKopia.hämtaStatusSQL());
            text4TextFält.setText(fysiskKopia.hämtaISBNSQL());
            text5TextFält.setText(fysiskKopia.hämtaFilmIDSQL());

            for (TextField textField : Arrays.asList(text1TextFält, text2TextFält, text3TextFält, text4TextFält, text5TextFält)) {
                textField.setEditable(false);
            }

            text6.setVisible(false);
            text7.setVisible(false);
            text6TextFält.setVisible(false);
            text7TextFält.setVisible(false);
            text6ÄndraKnapp.setVisible(false);
            text7ÄndraKnapp.setVisible(false);
        }
    }

    @FXML
    void avbrytKnappTryck(ActionEvent event) {
        ControllerConnector controllerConnector = new ControllerConnector();
        controllerConnector.connector("admin");
        Stage stage = (Stage) avbrytKnapp.getScene().getWindow();
        stage.close();
    }

    @FXML
    void sparaKnappTryck(ActionEvent event) {
        if (text1.getText().equalsIgnoreCase("ISBN")) {
            Bok bok = new Bok();
            bok.uppdateraBokSQL(text2TextFält.getText(),
                    text3TextFält.getText(),
                    text4TextFält.getText(),
                    text5TextFält.getText(),
                    text6TextFält.getText());

        } else if (text1.getText().equalsIgnoreCase("FilmID")) {
            Film film = new Film();
            film.uppdateraFilmSQL(text2TextFält.getText(),
                    text3TextFält.getText(),
                    text4TextFält.getText(),
                    text5TextFält.getText(),
                    text6TextFält.getText(),
                    text7TextFält.getText());

        } else {
            FysiskKopia fysiskKopia = new FysiskKopia();
            fysiskKopia.uppdateraFysiskKopiaSQL(text2TextFält.getText(),
                    text3TextFält.getText(),
                    text4TextFält.getText(),
                    text5TextFält.getText());
        }
        ControllerConnector controllerConnector = new ControllerConnector();
        controllerConnector.popupConnector("successPopUp");
        Stage stage = (Stage) sparaKnapp.getScene().getWindow();
        stage.close();
    }

    @FXML
    void text2ÄndraKnappTryck(ActionEvent event) {
        text2TextFält.setEditable(true);
        text2TextFält.setText("");
    }

    @FXML
    void text3ÄndraKnappTryck(ActionEvent event) {
        text3TextFält.setEditable(true);
        text3TextFält.setText("");
    }

    @FXML
    void text4ÄndraKnappTryck(ActionEvent event) {
        text4TextFält.setEditable(true);
        text4TextFält.setText("");
    }

    @FXML
    void text5ÄndraKnappTryck(ActionEvent event) {
        text5TextFält.setEditable(true);
        text5TextFält.setText("");
    }

    @FXML
    void text6ÄndraKnappTryck(ActionEvent event) {
        text6TextFält.setEditable(true);
        text6TextFält.setText("");
    }

    @FXML
    void text7ÄndraKnappTryck(ActionEvent event) {
        text7TextFält.setEditable(true);
        text7TextFält.setText("");
    }
}
