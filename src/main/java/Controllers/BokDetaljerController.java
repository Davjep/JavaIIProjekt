package Controllers;

import Databas.DatabasConnector;
import Databas.Lån;
import JavaFXConnector.ControllerConnector;
import Objekt.Bok;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class BokDetaljerController implements Initializable {

    @FXML
    private TextField ISBNTextFält;

    @FXML
    private TextField titelTextFält;

    @FXML
    private TextField författareTextFält;

    @FXML
    private TextField ämnesordTextFält;

    @FXML
    private TextField kategoriTextFält;

    @FXML
    private TextField utgivningsårTextFält;

    @FXML
    private Button gåTillbakaKnapp;

    @FXML
    private Button lånaBokKnapp;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        Bok bok = new Bok();
        ISBNTextFält.setText(bok.hämtaISBNSQL());
        titelTextFält.setText(bok.hämtaTitelSQL());
        författareTextFält.setText(bok.hämtaFörfattareSQL());
        ämnesordTextFält.setText(bok.hämtaÄmnesordSQL());
        kategoriTextFält.setText(bok.hämtaKategoriSQL());
        utgivningsårTextFält.setText(bok.hämtaUtgivningsårSQL());
    }

    @FXML
    void gåTillbakaKnappTryck(ActionEvent event) {
        ControllerConnector controllerConnector = new ControllerConnector();
        controllerConnector.connector("sök");
        Stage stage = (Stage) gåTillbakaKnapp.getScene().getWindow();
        stage.close();

    }

    @FXML
    void lånaBokKnappTryck(ActionEvent event) {
        // TODO Lägg in spärr för referenslitteratur!
        try {
            DatabasConnector databasConnector = new DatabasConnector();
            Connection connection = databasConnector.getConnection();

            String sqlStatus = "SELECT Status FROM fysiskkopia WHERE ISBN = '" + Bok.getISBN() + "';";

            Statement statusStatement = connection.createStatement();

            ResultSet statusResultat = statusStatement.executeQuery(sqlStatus);
            statusResultat.next();

            if (!statusResultat.getString("status").equalsIgnoreCase("Tillgänglig")) {
                ControllerConnector controllerConnector = new ControllerConnector();
                controllerConnector.popupConnector("ejTillgängligPopUp");
                Stage stage = (Stage) lånaBokKnapp.getScene().getWindow();
                stage.close();
            } else {
                Lån.setLåneTyp("Bok");
                ControllerConnector controllerConnector = new ControllerConnector();
                controllerConnector.popupConnector("lånaBekräftelsePopUp");
                Stage stage = (Stage) lånaBokKnapp.getScene().getWindow();
                stage.close();
            }
        }catch (SQLException e) {
            e.getCause();
            e.getStackTrace();
        }

    }

}

