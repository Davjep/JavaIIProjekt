package Controllers;

import Databas.DatabasConnector;
import JavaFXConnector.ControllerConnector;
import Session.SessionsAnvändare;
import Session.SessionsObjekt;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

public class LånaBekräftelsePopUpController {

    @FXML
    private Button jaKnapp;

    @FXML
    private Button nejKnapp;

    @FXML
    void jaKnappTryck(ActionEvent event) {
        SessionsObjekt.getISBN();

        try {
            DatabasConnector databasConnector = new DatabasConnector();
            Connection connection = databasConnector.getConnection();
            String getAnvändarID = "SELECT användarID FROM användare WHERE Email = '" + SessionsAnvändare.getInloggadEmail() + "';";
            Statement sqlgetAnvändarID = connection.createStatement();

            ResultSet användarIDResult = sqlgetAnvändarID.executeQuery(getAnvändarID);

            String insertLån = "INSERT INTO lån (StartDatum, AnvändarId) VALUES ('" + LocalDate.now() + "', '" + användarIDResult.getString("användarID" + "';");


            Statement sqlSkapaLån = connection.createStatement();
            sqlSkapaLån.executeUpdate(insertLån);
        }catch (SQLException e) {
            e.getStackTrace();
            e.getCause();
        }


    }

    @FXML
    void nejKnappTryck(ActionEvent event) {
        ControllerConnector controllerConnector = new ControllerConnector();
        controllerConnector.connector("sök");
        Stage stage = (Stage) nejKnapp.getScene().getWindow();
        stage.close();
    }

}
