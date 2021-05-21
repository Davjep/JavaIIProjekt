package Controllers;

import Databas.DatabasConnector;
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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

public class FörseningarController implements Initializable {

    @FXML
    private ListView<String> resultatLista;

    @FXML
    private Button gåTillbakaKnapp;

    @FXML
    void gåTillbakaKnappTryck(ActionEvent event) {
        ControllerConnector controllerConnector = new ControllerConnector();
        controllerConnector.connector("admin");
        Stage stage = (Stage) gåTillbakaKnapp.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        DatabasConnector databasConnector = new DatabasConnector();
        Connection connection = databasConnector.getConnection();

        try {
            String sqlSök = "SELECT * FROM biblioteket.lån;";
            PreparedStatement statement = connection.prepareStatement(sqlSök);
            ResultSet resultSet = statement.executeQuery(sqlSök);
            Date dagensDatum = new Date();
            while (resultSet.next()) {
                Date återlämningsdatum = new SimpleDateFormat("yyyy-MM-dd").parse(resultSet.getString("återlämningsdatum"));
                if (!återlämningsdatum.after(dagensDatum)) {
                    String låneID = resultSet.getString("låneID");
                    String startDatum = resultSet.getString("startDatum");
                    String användarID = resultSet.getString("användarID");
                    String återlämingsDatum = resultSet.getString("återlämningsdatum");
                    String fysiskKopiaID = resultSet.getString("fysiskKopiaID");

                    resultatLista.getItems().add("LåneID: " + låneID + ", StartDatum: " + startDatum + ", AnvändarID: " + användarID + ", återlämningsDatum: " + återlämingsDatum + ", FysiskKopiaID: " + fysiskKopiaID);
                }
            }
        }catch (SQLException | ParseException e) {
            e.getCause();
            e.getStackTrace();
        }
    }
}
