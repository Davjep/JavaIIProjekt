package Controllers;

import Databas.DatabasConnector;
import Entiteter.Användare;
import JavaFXConnector.ControllerConnector;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
    private Button uppdateraKnapp;

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
        String sqlFörnamnSök = "SELECT förnamn FROM användare WHERE email = '" + Användare.getInloggadEmail() + "'";
        String sqlEfternamnSök = "SELECT efternamn FROM användare WHERE email = '" + Användare.getInloggadEmail() + "'";
        String sqlTelefonSök = "SELECT telefon FROM användare WHERE email = '" + Användare.getInloggadEmail() + "'";
        String sqlGatuadressSök = "SELECT gatuadress FROM användare WHERE email = '" + Användare.getInloggadEmail() + "'";
        String sqlPostNrSök = "SELECT postnummer FROM användare WHERE email = '" + Användare.getInloggadEmail() + "'";
        String sqlEmailSök = "SELECT email FROM användare WHERE email = '" + Användare.getInloggadEmail() + "'";
        String sqlPersonNrSök = "SELECT personNr FROM användare WHERE email = '" + Användare.getInloggadEmail() + "'";
        String sqlAnvändarTypSök = "SELECT typ FROM användare WHERE email = '" + Användare.getInloggadEmail() + "'";
        String sqlLösenordSök = "SELECT lösenord FROM användare WHERE email = '" + Användare.getInloggadEmail() + "'";

        try {
            DatabasConnector databasConnector = new DatabasConnector();
            Connection connection = databasConnector.getConnection();

            //Skapar SQLquery och hämtar data från databasen
            Statement förnamnStatement = connection.createStatement();
            Statement efternamnStatement = connection.createStatement();
            Statement telefonNrStatement = connection.createStatement();
            Statement gatuadressStatement = connection.createStatement();
            Statement postNrStatement = connection.createStatement();
            Statement emailStatement = connection.createStatement();
            Statement personNrStatement = connection.createStatement();
            Statement användarTypStatement = connection.createStatement();
            Statement lösenordStatement = connection.createStatement();

            ResultSet sqlQueryFörnamn = förnamnStatement.executeQuery(sqlFörnamnSök);
            ResultSet sqlQueryEfternamn = efternamnStatement.executeQuery(sqlEfternamnSök);
            ResultSet sqlQueryTelefonNr = telefonNrStatement.executeQuery(sqlTelefonSök);
            ResultSet sqlQueryGatuadress = gatuadressStatement.executeQuery(sqlGatuadressSök);
            ResultSet sqlQueryPostNr = postNrStatement.executeQuery(sqlPostNrSök);
            ResultSet sqlQueryEmail = emailStatement.executeQuery(sqlEmailSök);
            ResultSet sqlQueryPersonNr = personNrStatement.executeQuery(sqlPersonNrSök);
            ResultSet sqlQueryAnvändarTyp = användarTypStatement.executeQuery(sqlAnvändarTypSök);
            ResultSet sqlQueryLösenord = lösenordStatement.executeQuery(sqlLösenordSök);

            //Fyller i den hämtade datan i respektive fält i formuläret
            sqlQueryFörnamn.next();
            förnamnTextFält.setText(sqlQueryFörnamn.getString("förnamn"));
            sqlQueryEfternamn.next();
            efternamnTextFält.setText(sqlQueryEfternamn.getString("efternamn"));
            sqlQueryTelefonNr.next();
            telefonNrTextFält.setText(sqlQueryTelefonNr.getString("telefon"));
            sqlQueryGatuadress.next();
            adressTextFält.setText(sqlQueryGatuadress.getString("gatuadress"));
            sqlQueryPostNr.next();
            postNrTextFält.setText(sqlQueryPostNr.getString("postnummer"));
            sqlQueryEmail.next();
            emailTextFält.setText(sqlQueryEmail.getString("email"));
            sqlQueryPersonNr.next();
            personNrTextFält.setText(sqlQueryPersonNr.getString("personNr"));
            sqlQueryAnvändarTyp.next();
            användartypDropDown.setText(sqlQueryAnvändarTyp.getString("typ"));
            sqlQueryLösenord.next();
            lösenordTextFält.setText(sqlQueryLösenord.getString("lösenord"));

            //Låser alla fält så att användaren inte kan ändra. Detta går sedan att låsa upp via "ändra" knappen
            förnamnTextFält.setEditable(false);
            efternamnTextFält.setEditable(false);
            telefonNrTextFält.setEditable(false);
            adressTextFält.setEditable(false);
            postNrTextFält.setEditable(false);
            emailTextFält.setEditable(false);
            personNrTextFält.setEditable(false);
            lösenordTextFält.setEditable(false);

        } catch (SQLException e) {
            e.getCause();
            e.printStackTrace();
        }
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
    void uppdateraKnappTryck(ActionEvent event) {
        try {
            DatabasConnector databasConnector = new DatabasConnector();
            Connection connection = databasConnector.getConnection();
            Användare användare = new Användare();
            Statement statement = connection.createStatement();
            statement.executeUpdate(användare.uppdateraAnvändareSQL(
                    förnamnTextFält.getText(),
                    efternamnTextFält.getText(),
                    telefonNrTextFält.getText(),
                    adressTextFält.getText(),
                    postNrTextFält.getText(),
                    emailTextFält.getText(),
                    personNrTextFält.getText(),
                    användartypDropDown.getText(),
                    lösenordTextFält.getText()));
            ControllerConnector controllerConnector = new ControllerConnector();
            controllerConnector.popupConnector("successPopUp");
            Stage stage = (Stage) uppdateraKnapp.getScene().getWindow();
            stage.close();

        } catch (SQLException e) {
            e.getCause();
            e.printStackTrace();
        }

    }

    @FXML
    void avbrytKnappTryck(ActionEvent event) {
        ControllerConnector controllerConnector = new ControllerConnector();
        controllerConnector.connector("minProfil");
        Stage stage = (Stage) avbrytKnapp.getScene().getWindow();
        stage.close();
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

