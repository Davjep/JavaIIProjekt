package Controllers;

import Databas.DatabasConnector;
import Entiteter.Anställd;
import JavaFXConnector.ControllerConnector;
import Verktyg.VäljIListan;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class HanteraAnvändareController implements Initializable {


    @FXML
    private ListView<String> resultatLista;

    @FXML
    private Button väljKnapp;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        DatabasConnector databasConnector = new DatabasConnector();
        Connection connection = databasConnector.getConnection();
        try {
            String sqlAnvändareSök = "SELECT * FROM användare;";
            PreparedStatement statement = connection.prepareStatement(sqlAnvändareSök);
            ResultSet resultSet = statement.executeQuery(sqlAnvändareSök);
            for (int i = 0; resultSet.next(); i++) {
                String användarIDResultat = resultSet.getString("användarID");
                String förNamnResultat = resultSet.getString("förnamn");
                String efterNamnresultat = resultSet.getString("efternamn");
                String emailResultat = resultSet.getString("email");
                String personNrResultat = resultSet.getString("personNr");
                resultatLista.getItems().add(" " + användarIDResultat + ", " + förNamnResultat + ", " + efterNamnresultat + ", " + emailResultat + ", " + personNrResultat);
            }
        }catch (SQLException e) {
            e.getCause();
            e.printStackTrace();
        }
    }

    @FXML
    void väljKnappTryck(ActionEvent event) {
        VäljIListan valdRad = new VäljIListan();
        Anställd.setID(valdRad.väljValdRad(resultatLista.getSelectionModel().getSelectedItem()));

        ControllerConnector controllerConnector = new ControllerConnector();
        controllerConnector.connector("uppdateraprofil");
        Stage stage = (Stage) väljKnapp.getScene().getWindow();
        stage.close();

    }

    @FXML
    private Button gåTillbakaKnapp;

    @FXML
    void gåTillbakaKnappTryck(ActionEvent event) {
        ControllerConnector controllerConnector = new ControllerConnector();
        controllerConnector.connector("admin");
        Stage stage = (Stage) gåTillbakaKnapp.getScene().getWindow();
        stage.close();
    }


}

