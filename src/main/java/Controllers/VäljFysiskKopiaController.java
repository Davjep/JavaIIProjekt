package Controllers;

import Databas.DatabasConnector;
import JavaFXConnector.ControllerConnector;
import Objekt.Bok;
import Objekt.Film;
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

public class VäljFysiskKopiaController implements Initializable {

    @FXML
    private ListView<String> resultatLista;

    @FXML
    private Button väljKnapp;

    @FXML
    private Button gåTillbakaKnapp;

    private static String status;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        DatabasConnector databasConnector = new DatabasConnector();
        Connection connection = databasConnector.getConnection();
        try {
            String sqlFysiskKopiaSök = "SELECT * FROM fysiskkopia WHERE ISBN = " + Bok.getISBN() + " OR FilmID = " + Film.getFilmID() + ";";
            PreparedStatement statement = connection.prepareStatement(sqlFysiskKopiaSök);
            ResultSet resultSet = statement.executeQuery(sqlFysiskKopiaSök);
            for (int i = 0; resultSet.next(); i++) {
                String fysiskKopiaIDResultat = resultSet.getString("fysiskkopiaID");
                String platsResultat = resultSet.getString("plats");
                String statusResultat = resultSet.getString("status");
                String ISBNResultat = resultSet.getString("ISBN");
                String filmIDResultat = resultSet.getString("filmid");
                resultatLista.getItems().add(" " + fysiskKopiaIDResultat + ", " + platsResultat + ", " + statusResultat + ", " + ISBNResultat + ", " + filmIDResultat);
            }
        }catch (SQLException e) {
            e.getCause();
            e.printStackTrace();
        }

    }

    @FXML
    void gåTillbakaKnappTryck(ActionEvent event) {

        ControllerConnector controllerConnector = new ControllerConnector();
        controllerConnector.connector("sök");
        Stage stage = (Stage) gåTillbakaKnapp.getScene().getWindow();
        stage.close();



    }

    @FXML
    void väljKnappTryck(ActionEvent event) {
        VäljIListan valdRad = new VäljIListan();
        String fullID = valdRad.väljValdRad(resultatLista.getSelectionModel().getSelectedItem());
        //if / else ifall ISBN är tom eller ej
        if (Bok.getISBN().equals("")) {
            Film film = new Film();
            Film.setFysiskKopiaID(fullID);
            status = film.hämtaStatusSQL();
        } else {
            Bok.setFysiskKopiaID(fullID);
            Bok bok = new Bok();
            status = bok.hämtaStatusSQL();
        }
        slutför();
    }

    private void slutför() {

        ControllerConnector controllerConnector = new ControllerConnector();
        if (status.equalsIgnoreCase("Tillgänglig")) {
            controllerConnector.popupConnector("lånabekräftelsepopup");
            Stage stage = (Stage) väljKnapp.getScene().getWindow();
            stage.close();
        } else {
            controllerConnector.popupConnector("ejTillgängligPopUp");
            Stage stage = (Stage) väljKnapp.getScene().getWindow();
            stage.close();
        }
    }

}
