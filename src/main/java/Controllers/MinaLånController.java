package Controllers;

import Databas.DatabasConnector;
import Databas.Lån;
import Entiteter.Användare;
import JavaFXConnector.ControllerConnector;
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

public class MinaLånController implements Initializable {

    @FXML
    private ListView<String> lånTabell;

    @FXML
    private ListView<String> reservationerTabell;

    @FXML
    private Button TillbakaKnapp;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //Optional TODO Fixa så att titel på objektet läggs till

        hämtaLån();
        hämtaReservationer();
    }

    @FXML
    void TillbakaKnappTryck(ActionEvent event) {
        ControllerConnector controllerConnector = new ControllerConnector();
        controllerConnector.connector("minProfil");
        Stage stage = (Stage) TillbakaKnapp.getScene().getWindow();
        stage.close();

    }

    private void hämtaLån() {
        DatabasConnector databasConnector = new DatabasConnector();
        Connection connection = databasConnector.getConnection();
        try {

            Användare användare = new Användare();

            String hämtaLån = "SELECT * from biblioteket.lån WHERE användarId = " + användare.hämtaAnvändarID() + ";";
            PreparedStatement statement = connection.prepareStatement(hämtaLån);
            ResultSet resultSet = statement.executeQuery(hämtaLån);

            while (resultSet.next()) {
                String låneID = resultSet.getString("LåneID");
                String startDatum = resultSet.getString("startdatum");
                String användarID = resultSet.getString("användarID");
                String återlämningsDatum = resultSet.getString("återlämningsDatum");
                String fysiskKopiaID = resultSet.getString("fysiskKopiaID");

                lånTabell.getItems().add(" LåneID: " + låneID + ", startdatum: " + startDatum + ", användarID: " + användarID +
                        ", återlämningsdatum: " + återlämningsDatum + ", fysiskKopiaID: " + fysiskKopiaID);
            }
        } catch (SQLException e) {
            e.getStackTrace();
            e.getCause();
        }
    }

    private void hämtaReservationer() {
        try {
            DatabasConnector databasConnector = new DatabasConnector();
            Connection connection = databasConnector.getConnection();
            Användare användare = new Användare();

            String hämtaReservationer = "SELECT * from biblioteket.reservation WHERE användarId = " + användare.hämtaAnvändarID() + ";";
            PreparedStatement statement = connection.prepareStatement(hämtaReservationer);
            ResultSet resultSet = statement.executeQuery(hämtaReservationer);

            while (resultSet.next()) {
                String id = resultSet.getString("reservationsID");
                String datum = resultSet.getString("reservationsdatum");
                String användarID = resultSet.getString("användarID");
                String fysiskKopiaID = resultSet.getString("fysiskKopiaID");

                reservationerTabell.getItems().add("ReservationsID: " + id + ", reservationsdatum: " + datum + ", användarID: " + användarID +
                        ", fysiskKopiaID: " + fysiskKopiaID);
            }
        } catch (SQLException e) {
            e.getCause();
            e.getStackTrace();
        }

    }

}
