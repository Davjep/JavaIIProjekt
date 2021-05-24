package Controllers;

import JavaFXConnector.ControllerConnector;
import Objekt.Bok;
import Objekt.Film;
import Objekt.FysiskKopia;
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
    private MenuItem fysiskKopiaKategori;

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
    private Label errorText;

    @FXML
    private Button läggTillKnapp;

    @FXML
    private Button avbrytKnapp;

    @FXML
    private SplitMenuButton statusValMeny;

    @FXML
    private MenuItem tillgängligVal;

    @FXML
    private MenuItem utlånadVal;

    @FXML
    private MenuItem reserveradVal;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //Gömmer fält innan val av objekt har gjorts
        for (Label label : Arrays.asList(text1, text2, text3, text4, text5, text6)) {
            label.setVisible(false);
        }

        for (TextField textField : Arrays.asList(textFält1, textFält2, textFält3, textFält4, textFält5, textFält6)) {
            textField.setVisible(false);
        }
        statusValMeny.setVisible(false);
    }

    @FXML
    void avbrytKnappTryck(ActionEvent event) {
        ControllerConnector controllerConnector = new ControllerConnector();
        controllerConnector.connector("admin");
        Stage stage = (Stage) avbrytKnapp.getScene().getWindow();
        stage.close();
    }

    @FXML
    void läggTillKnappTryck(ActionEvent event) {

        if (objektValMeny.getText().equals("Bok")) {

            String dataInputBok[] = {
                    textFält1.getText(),
                    textFält2.getText(),
                    textFält3.getText(),
                    textFält4.getText(),
                    textFält5.getText(),
            };

            if (!isEmpty(dataInputBok)) {
                Bok nyBok = new Bok(textFält1.getText(),
                        textFält2.getText(),
                        textFält3.getText(),
                        textFält4.getText(),
                        textFält5.getText(),
                        true);

                nyBok.läggTillBokSQL();

                errorText.setText("");

                ControllerConnector controllerConnector = new ControllerConnector();
                controllerConnector.popupConnector("successPopUp");
                Stage stage = (Stage) läggTillKnapp.getScene().getWindow();
                stage.close();
            }
        } else if (objektValMeny.getText().equals("Film")) {

            String dataInputFilm[] = {
                    textFält1.getText(),
                    textFält2.getText(),
                    textFält3.getText(),
                    textFält4.getText(),
                    textFält5.getText(),
            };

            if (!isEmpty(dataInputFilm)) {
                Film nyFilm = new Film(textFält1.getText(),
                        textFält2.getText(),
                        textFält3.getText(),
                        textFält4.getText(),
                        textFält5.getText(),
                        true,
                        textFält6.getText());

                nyFilm.läggTillFilmSQL();

                errorText.setText("");

                ControllerConnector controllerConnector = new ControllerConnector();
                controllerConnector.popupConnector("successPopUp");
                Stage stage = (Stage) läggTillKnapp.getScene().getWindow();
                stage.close();
            }
        } else {
            if (textFält1.getText().isEmpty() && textFält2.getText().isEmpty()) {
                errorText.setText("Vänligen fyll i antigen ISBN eller FilmID");
            } else if (!textFält1.getText().isEmpty() && !textFält2.getText().isEmpty()) {
                errorText.setText("En fysisk kopia kan bara ha angingen ISBN ELLER FilmID, inte båda två...");
            } else {
                String dataInputFysiskKopia[] = {
                        textFält1.getText(),
                        textFält2.getText(),
                        textFält3.getText(),
                        statusValMeny.getText()
                };

                if (!isEmpty(dataInputFysiskKopia)) {
                    errorText.setText("");

                    FysiskKopia nyFysiskKopia = new FysiskKopia(textFält1.getText(), textFält2.getText(), textFält3.getText(), statusValMeny.getText());

                    nyFysiskKopia.läggTillFysiskKopiaSQL();

                    ControllerConnector controllerConnector = new ControllerConnector();
                    controllerConnector.popupConnector("successPopUp");
                    Stage stage = (Stage) läggTillKnapp.getScene().getWindow();
                    stage.close();

                }
            }
        }
    }

    @FXML
    void bokKategoriVal(ActionEvent event) {
        //Visar korrekt fält och text när man väljer bok alternativet
        objektValMeny.setText("Bok");
        for (Label label : Arrays.asList(text1, text2, text3, text4, text5)) {
            label.setVisible(true);
        }
        text6.setVisible(false);
        for (TextField textField : Arrays.asList(textFält1, textFält2, textFält3, textFält4, textFält5)) {
            textField.setVisible(true);
        }
        textFält6.setVisible(false);
        statusValMeny.setVisible(false);

        text1.setText("Titel");
        text2.setText("Författare");
        text3.setText("Ämnesord");
        text4.setText("Kategori");
        text5.setText("Utgivningsår");

    }

    @FXML
    void filmKategoriVal(ActionEvent event) {
        //Visar korrekt fält och text när man väljer film alternativet
        objektValMeny.setText("Film");
        for (Label label : Arrays.asList(text1, text2, text3, text4, text5, text6)) {
            label.setVisible(true);
        }

        for (TextField textField : Arrays.asList(textFält1, textFält2, textFält3, textFält4, textFält5, textFält6)) {
            textField.setVisible(true);
        }
        statusValMeny.setVisible(false);

        text1.setText("Titel");
        text2.setText("Regissör");
        text3.setText("Genre");
        text4.setText("Produktionsland");
        text5.setText("Utgivningsår");
        text6.setText("Åldersbegränsning");
    }

    @FXML
    void fysiskKopiaKategoriVal(ActionEvent event) {
        //Visar korrekt fält och text när man väljer fysisk kopia alternativet
        objektValMeny.setText("Fysisk Kopia");
        for (Label label : Arrays.asList(text1, text2, text3, text4)) {
            label.setVisible(true);
        }
        for (Label label : Arrays.asList(text5, text6)) {
            label.setVisible(false);
        }
        for (TextField textField : Arrays.asList(textFält1, textFält2, textFält3)) {
            textField.setVisible(true);
        }
        for (TextField textField : Arrays.asList(textFält4, textFält5, textFält6)) {
            textField.setVisible(false);
        }
        statusValMeny.setVisible(true);
        text1.setText("ISBN");
        text2.setText("FilmID");
        text3.setText("Plats");
        text4.setText("Status");
    }

    @FXML
    void reserveradValTryck(ActionEvent event) {
        statusValMeny.setText("Reserverad");
    }

    @FXML
    void tillgängligValTryck(ActionEvent event) {
        statusValMeny.setText("Tillgänglig");
    }

    @FXML
    void utlånadValTryck(ActionEvent event) {
        statusValMeny.setText("Utlånad");
    }

    private boolean isEmpty(String[] array) {
        boolean isEmpty = true;
        for (int i = 0; i < array.length; i++) {
            if (array[i].isEmpty()) {
                errorText.setText("Vänligen fyll i alla fält");
                isEmpty = true;
            } else {
                isEmpty = false;
            }
        }
        return isEmpty;
    }

}

