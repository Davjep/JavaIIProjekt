package Controllers;

import Databas.DatabasConnector;
import Entiteter.Anställd;
import Entiteter.Användare;
import JavaFXConnector.ControllerConnector;
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
    private Label loggaInText;

    @FXML
    private Button anställdKnapp;

    boolean anställd = false;

    @FXML
    void anställdKnappTryck(ActionEvent event) {
        loggaInText.setText("Logga In - Anställd");
        anställd = true;
    }

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

            //Dubbla if satser som kollar ifall queryn har fått resultat. Kollar sedan ifall resultatet matchar med det som användaren har angett
            if (sqlQueryEmail.next()){
                String emailResultat = sqlQueryEmail.getString("email");
                if (sqlQueryLösenord.next()) {
                    String lösenordResultat = sqlQueryLösenord.getString("lösenord");
                    if (email.equals(emailResultat) && lösenord.equals(lösenordResultat)) {
                        Användare.setInloggadEmail(emailResultat);
                        if (anställd) {
                            Användare användare = new Användare();
                            if (användare.hämtaAnvändarTypSQL().equalsIgnoreCase("Biblioteksanställda")) {
                                Användare.setInloggad();
                                Anställd.setAnställd(true);
                                ControllerConnector controllerConnector = new ControllerConnector();
                                controllerConnector.connector("admin");
                                Stage stage = (Stage) loggaInKnapp.getScene().getWindow();
                                stage.close();
                            } else {
                                errorText.setText("Endast biblioteksanställda kan logga in som anställd");
                                Användare.setInloggadEmail("");
                            }
                        } else {
                            Användare.setInloggad();
                            ControllerConnector controllerConnector = new ControllerConnector();
                            controllerConnector.connector("minProfil");
                            Stage stage = (Stage) loggaInKnapp.getScene().getWindow();
                            stage.close();
                        }
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
