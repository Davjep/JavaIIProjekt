package Controllers;

import Databas.DatabasConnector;
import JavaFXConnector.ControllerConnector;
import Session.SessionsAnvändare;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class taBortProfilPopUpController {

    @FXML
    private Button jaKnapp;

    @FXML
    private Button nejKnapp;

    @FXML
    void jaKnappTryck(ActionEvent event) {
        try {
            DatabasConnector databasConnector = new DatabasConnector();
            Connection connection = databasConnector.getConnection();
            String sqlTaBortAnvändare = "DELETE FROM användare WHERE email = '" + SessionsAnvändare.getInloggadEmail() + "';";
            Statement statement = connection.createStatement();
            statement.executeUpdate(sqlTaBortAnvändare);
            Stage stage = (Stage) jaKnapp.getScene().getWindow();
            stage.close();
            System.exit(0);

        } catch (SQLException e) {
            e.printStackTrace();
            e.getCause();
        }




    }

    @FXML
    void nejKnappTryck(ActionEvent event) {
        ControllerConnector controllerConnector = new ControllerConnector();
        controllerConnector.connector("minProfil");
        Stage stage = (Stage) nejKnapp.getScene().getWindow();
        stage.close();

    }

}
