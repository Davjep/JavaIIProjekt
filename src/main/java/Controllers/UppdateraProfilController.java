package Controllers;

import Entiteter.Anställd;
import Entiteter.Användare;
import JavaFXConnector.ControllerConnector;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class UppdateraProfilController implements Initializable {

    @FXML
    private Label errorText;

    @FXML
    private Label förnamnText;

    @FXML
    private Label EfternamnText;

    @FXML
    private Label emailText;

    @FXML
    private TextField förnamnTextFält;

    @FXML
    private TextField efternamnTextFält;

    @FXML
    private TextField emailTextFält;

    @FXML
    private Label telefonNrText;

    @FXML
    private Label adressText;

    @FXML
    private Label postNrText;

    @FXML
    private Label personNrText;

    @FXML
    private Label AnvändartypText;

    @FXML
    private TextField telefonNrTextFält;

    @FXML
    private TextField adressTextFält;

    @FXML
    private TextField postNrTextFält;

    @FXML
    private TextField personNrTextFält;

    @FXML
    private Label lösenordText;

    @FXML
    private PasswordField lösenordTextFält;

    @FXML
    private SplitMenuButton användartypDropDown;

    @FXML
    private MenuItem studentVal;

    @FXML
    private MenuItem forskareVal;

    @FXML
    private MenuItem övrigaUniversitetsanställdaVal;

    @FXML
    private MenuItem allmänhetenVal;

    @FXML
    private Button sparaKnapp;

    @FXML
    private Button avbrytKnapp;

    @FXML
    private Button förnamnÄndraKnapp;

    @FXML
    private Button efternamnÄndraKnapp;

    @FXML
    private Button emailÄndraKnapp;

    @FXML
    private Button telefonNrÄndraKnapp;

    @FXML
    private Button gatuadressÄndraKnapp;

    @FXML
    private Button postNrÄndraKnapp;

    @FXML
    private Button personNrÄndraKnapp;

    @FXML
    private Button användartypÄndraKnapp;

    @FXML
    private Button lösenordÄndraKnapp;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        //Metod som körs när fönstret öppnas för att fylla i den existerande datan från databasen
        Användare användare = new Användare();
        förnamnTextFält.setText(användare.hämtaFörnamnSQL());
        efternamnTextFält.setText(användare.hämtaEfternamnSQL());
        telefonNrTextFält.setText(användare.hämtaTelefonNrSQL());
        adressTextFält.setText(användare.hämtaGatuAdressSQL());
        postNrTextFält.setText(användare.hämtaPostNrSQL());
        emailTextFält.setText(användare.hämtaemailSQL());
        personNrTextFält.setText(användare.hämtaPersonNrSQL());
        användartypDropDown.setText(användare.hämtaAnvändarTypSQL());
        lösenordTextFält.setText(användare.hämtalösenordSQL());

        //Låser alla fält så att användaren inte kan ändra. Detta går sedan att låsa upp via "ändra" knapparna, se metoder nedan
        förnamnTextFält.setEditable(false);
        efternamnTextFält.setEditable(false);
        telefonNrTextFält.setEditable(false);
        adressTextFält.setEditable(false);
        postNrTextFält.setEditable(false);
        emailTextFält.setEditable(false);
        personNrTextFält.setEditable(false);
        lösenordTextFält.setEditable(false);
    }

    @FXML
    void användartypÄndraKnappTryck(ActionEvent event) {
        användartypDropDown.setText("Välj Användartyp");
    }

    @FXML
    void efternamnÄndraKnappTryck(ActionEvent event) {
        efternamnTextFält.setEditable(true);
        efternamnTextFält.setText("");

    }

    @FXML
    void emailÄndraKnappTryck(ActionEvent event) {
        emailTextFält.setEditable(true);
        emailTextFält.setText("");

    }

    @FXML
    void förnamnÄndraKnappTryck(ActionEvent event) {
        förnamnTextFält.setEditable(true);
        förnamnTextFält.setText("");


    }

    @FXML
    void gatuadressÄndraKnappTryck(ActionEvent event) {
        adressTextFält.setEditable(true);
        adressTextFält.setText("");


    }

    @FXML
    void lösenordÄndraKnappTryck(ActionEvent event) {
        lösenordTextFält.setEditable(true);
        lösenordTextFält.setText("");

    }

    @FXML
    void personNrÄndraKnappTryck(ActionEvent event) {
        personNrTextFält.setEditable(true);
        personNrTextFält.setText("");

    }

    @FXML
    void postNrÄndraKnappTryck(ActionEvent event) {
        postNrTextFält.setEditable(true);
        postNrTextFält.setText("");

    }

    @FXML
    void telefonNrÄndraKnappTryck(ActionEvent event) {
        telefonNrTextFält.setEditable(true);
        telefonNrTextFält.setText("");
    }


    @FXML
    void sparaKnappTryck(ActionEvent event) {
        Användare användare = new Användare();
        användare.uppdateraAnvändareSQL(
                förnamnTextFält.getText(),
                efternamnTextFält.getText(),
                telefonNrTextFält.getText(),
                adressTextFält.getText(),
                postNrTextFält.getText(),
                emailTextFält.getText(),
                personNrTextFält.getText(),
                användartypDropDown.getText(),
                lösenordTextFält.getText());

        ControllerConnector controllerConnector = new ControllerConnector();
        controllerConnector.popupConnector("successPopUp");
        Stage stage = (Stage) sparaKnapp.getScene().getWindow();
        stage.close();
    }

    @FXML
    void avbrytKnappTryck(ActionEvent event) {
        if (Anställd.getAnställd()) {
            ControllerConnector controllerConnector = new ControllerConnector();
            controllerConnector.connector("hanteraanvändare");
            Stage stage = (Stage) avbrytKnapp.getScene().getWindow();
            stage.close();
        } else {
            ControllerConnector controllerConnector = new ControllerConnector();
            controllerConnector.connector("minProfil");
            Stage stage = (Stage) avbrytKnapp.getScene().getWindow();
            stage.close();
        }

    }

    //Metoder som sätter val på dropdown menyn.
    @FXML
    void allmänhetenValTryck(ActionEvent event) {
        användartypDropDown.setText("Allmänheten");
    }

    @FXML
    void forskareValTryck(ActionEvent event) {
        användartypDropDown.setText("Forskare");
    }

    @FXML
    void studentValTryck(ActionEvent event) {
        användartypDropDown.setText("Student");
    }

    @FXML
    void övrigaUniversitetsanställdaValTryck(ActionEvent event) {
        användartypDropDown.setText("Övriga Universitetsanställda");
    }


}

