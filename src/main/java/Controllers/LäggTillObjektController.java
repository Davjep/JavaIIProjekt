package Controllers;

import JavaFXConnector.ControllerConnector;
import Objekt.Bok;
import Objekt.Film;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

public class LäggTillObjektController implements Initializable {

    @FXML
    private Label objektVal;

    @FXML
    private SplitMenuButton objektValMeny;


    @FXML
    private MenuItem bokKategori;

    @FXML
    private MenuItem filmKategori;

    @FXML
    private Label text1;

    @FXML
    private Label text2;

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
    private TextField textFält1;

    @FXML
    private TextField textFält2;

    @FXML
    private TextField textFält3;

    @FXML
    private TextField textFält4;

    @FXML
    private TextField textFält5;

    @FXML
    private TextField textFält6;

    @FXML
    private TextField textFält7;


    @FXML
    private Label errorText;

    @FXML
    private Button läggTillKnapp;

    @FXML
    private Button avbrytKnapp;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        for (Label label : Arrays.asList(text1, text2, text3, text4, text5, text6, text7)) {
            label.setVisible(false);
        }

        for (TextField textField : Arrays.asList(textFält1, textFält2, textFält3, textFält4, textFält5, textFält6, textFält7)) {
            textField.setVisible(false);
        }
    }

    @FXML
    void avbrytKnappTryck(ActionEvent event) {

    }

    @FXML
    void läggTillKnappTryck(ActionEvent event) {
        boolean fältIfyllda = false;

        if (objektValMeny.getText().equals("Bok")) {

            String dataInputBok[] = {
                    textFält1.getText(),
                    textFält2.getText(),
                    textFält3.getText(),
                    textFält4.getText(),
                    textFält5.getText(),
                    textFält6.getText(),
            };

            for (int i = 0; i < dataInputBok.length; i++) {
                if (dataInputBok[i].isEmpty()) {
                    errorText.setText("Vänligen fyll i alla fält");
                    fältIfyllda = false;
                } else {
                    fältIfyllda = true;
                }
            }
            if (fältIfyllda) {
                Bok nyBok = new Bok(textFält1.getText(),
                        textFält2.getText(),
                        textFält3.getText(),
                        textFält4.getText(),
                        textFält5.getText(),
                        true,
                        textFält6.getText());

                nyBok.läggTillBokSQL();

                errorText.setText("");

                ControllerConnector controllerConnector = new ControllerConnector();
                controllerConnector.popupConnector("successPopUp");
                Stage stage = (Stage) läggTillKnapp.getScene().getWindow();
                stage.close();
            }
        } else {

            String dataInputFilm[] = {
                    textFält1.getText(),
                    textFält2.getText(),
                    textFält3.getText(),
                    textFält4.getText(),
                    textFält5.getText(),
                    textFält6.getText(),
                    textFält7.getText()
            };

            for (int i = 0; i < dataInputFilm.length; i++) {
                if (dataInputFilm[i].isEmpty()) {
                    errorText.setText("Vänligen fyll i alla fält");
                    fältIfyllda = false;
                } else {
                    fältIfyllda = true;
                }
            }
            if (fältIfyllda) {
                Film nyFilm = new Film(textFält1.getText(),
                        textFält2.getText(),
                        textFält3.getText(),
                        textFält4.getText(),
                        textFält5.getText(),
                        true,
                        textFält6.getText(),
                        textFält7.getText());

                nyFilm.läggTillFilmSQL();

                errorText.setText("");

                ControllerConnector controllerConnector = new ControllerConnector();
                controllerConnector.popupConnector("successPopUp");
                Stage stage = (Stage) läggTillKnapp.getScene().getWindow();
                stage.close();
            }
        }
    }

    @FXML
    void bokKategoriVal(ActionEvent event) {
        objektValMeny.setText("Bok");
        for (Label label : Arrays.asList(text1, text2, text3, text4, text5, text6)) {
            label.setVisible(true);
        }

        for (TextField textField : Arrays.asList(textFält1, textFält2, textFält3, textFält4, textFält5, textFält6)) {
            textField.setVisible(true);
        }

        text1.setText("Titel");
        text2.setText("Författare");
        text3.setText("Ämnesord");
        text4.setText("Kategori");
        text5.setText("Utgivningsår");
        text6.setText("Plats");

    }

    @FXML
    void filmKategoriVal(ActionEvent event) {
        objektValMeny.setText("Film");
        for (Label label : Arrays.asList(text1, text2, text3, text4, text5, text6, text7)) {
            label.setVisible(true);
        }

        for (TextField textField : Arrays.asList(textFält1, textFält2, textFält3, textFält4, textFält5, textFält6, textFält7)) {
            textField.setVisible(true);
        }

        text1.setText("Titel");
        text2.setText("Regissör");
        text3.setText("Genre");
        text4.setText("Produktionsland");
        text5.setText("Utgivningsår");
        text6.setText("Åldersbegränsning");
        text7.setText("Plats");
    }


}

