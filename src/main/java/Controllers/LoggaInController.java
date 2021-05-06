package Controllers;

import Databas.DatabasConnector;
import JavaFXConnector.ControllerConnector;
import Session.SessionsAnvändare;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoggaInController {

    @FXML
    private Button loggaInKnapp;

    @FXML
    private TextField emailFält;

    @FXML
    private PasswordField lösenordFält;

    @FXML
    private Label användarnamnText;

    @FXML
    private Label lösenordText;

    @FXML
    private Label errorText;

    @FXML
    void loggaInKnappTryck(ActionEvent event) {
        DatabasConnector databasConnector = new DatabasConnector();
        Connection connection = databasConnector.getConnection();

        String email = emailFält.getText();
        String lösenord = lösenordFält.getText();
        String sqlEmailSök = "SELECT email FROM användare WHERE användare.email = '" + email + "'";
        String sqlLösenordSök = "SELECT lösenord FROM användare WHERE användare.lösenord = '" + lösenord + "'";

        try {
            Statement emailStatement = connection.createStatement();
            Statement lösenordStatement = connection.createStatement();
            ResultSet sqlQueryEmail = emailStatement.executeQuery(sqlEmailSök);
            ResultSet sqlQueryLösenord = lösenordStatement.executeQuery(sqlLösenordSök);

            if (sqlQueryEmail.next()){
                String emailResultat = sqlQueryEmail.getString("email");
                if (sqlQueryLösenord.next()) {
                    String lösenordResultat = sqlQueryLösenord.getString("lösenord");
                    if (email.equals(emailResultat) && lösenord.equals(lösenordResultat)) {
                        SessionsAnvändare sessionsAnvändare = new SessionsAnvändare();
                        sessionsAnvändare.setInloggad();
                        sessionsAnvändare.setInloggadEmail(emailResultat);
                        ControllerConnector controllerConnector = new ControllerConnector();
                        controllerConnector.connector("minProfil");
                        Stage stage = (Stage) loggaInKnapp.getScene().getWindow();
                        stage.close();
                    }
                }
            } else {
                errorText.setText("Felaktig email och/eller lösenord. Vänligen prova igen...");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            e.getCause();
        }
    }

    @FXML
    void lösenordInput(ActionEvent event) {

    }
    @FXML
    void emailInput(ActionEvent event) {

    }

}
