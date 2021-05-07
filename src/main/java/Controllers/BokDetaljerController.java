package Controllers;

import Databas.DatabasConnector;
import JavaFXConnector.ControllerConnector;
import Session.SessionsObjekt;
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

    private String ISBN;

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

    public String getISBN() {
        return ISBN;
    }

    public BokDetaljerController(String ISBN) {
        this.ISBN = ISBN;
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
        // TODO Skapar ett kvitto med lånedetaljer
        try {
            DatabasConnector databasConnector = new DatabasConnector();
            Connection connection = databasConnector.getConnection();

            String sqlStatus = "SELECT Status FROM fysiskkopia WHERE ISBN = '" + ISBN + "';";

            Statement statusStatement = connection.createStatement();

            ResultSet statusResultat = statusStatement.executeQuery(sqlStatus);
            statusResultat.next();

            SessionsObjekt.setISBN(ISBN);

            if (!statusResultat.getString("status").equals("Tillgänglig")) {
                ControllerConnector controllerConnector = new ControllerConnector();
                controllerConnector.connector("ejTillgängligPopUp");
                Stage stage = (Stage) lånaBokKnapp.getScene().getWindow();
                stage.close();
            } else {
                ControllerConnector controllerConnector = new ControllerConnector();
                controllerConnector.connector("ejTillgängligPopUp");
                Stage stage = (Stage) lånaBokKnapp.getScene().getWindow();
                stage.close();
            }
        }catch (SQLException e) {
            e.getCause();
            e.getStackTrace();
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        String sqlTitelQuery = "SELECT titel FROM bok WHERE ISBN = '" + ISBN + "';";
        String sqlFörfattareQuery = "SELECT författare FROM bok WHERE ISBN = '" + ISBN + "';";
        String sqlÄmnesordQuery = "SELECT ämnesord FROM bok WHERE ISBN = '" + ISBN + "';";
        String sqlKategoriQuery = "SELECT kategori FROM bok WHERE ISBN = '" + ISBN + "';";
        String sqlUtgivningsårQuery = "SELECT utgivningsår FROM bok WHERE ISBN = '" + ISBN + "';";

        try {
            DatabasConnector databasConnector = new DatabasConnector();
            Connection connection = databasConnector.getConnection();

            Statement titelStatement = connection.createStatement();
            Statement författareStatement = connection.createStatement();
            Statement ämnesordStatement = connection.createStatement();
            Statement kategoriStatement = connection.createStatement();
            Statement utgivningsårStatement = connection.createStatement();

            ResultSet sqlTitelResult = titelStatement.executeQuery(sqlTitelQuery);
            ResultSet sqlFörfattareResult = författareStatement.executeQuery(sqlFörfattareQuery);
            ResultSet sqlÄmnesordResult = ämnesordStatement.executeQuery(sqlÄmnesordQuery);
            ResultSet sqlKategoriResult = kategoriStatement.executeQuery(sqlKategoriQuery);
            ResultSet sqlUtgivningsårResult = utgivningsårStatement.executeQuery(sqlUtgivningsårQuery);

            sqlTitelResult.next();
            sqlFörfattareResult.next();
            sqlÄmnesordResult.next();
            sqlKategoriResult.next();
            sqlUtgivningsårResult.next();

            titelTextFält.setText(sqlTitelResult.getString("titel"));
            författareTextFält.setText(sqlFörfattareResult.getString("författare"));
            ämnesordTextFält.setText(sqlÄmnesordResult.getString("ämnesord"));
            kategoriTextFält.setText(sqlKategoriResult.getString("kategori"));
            utgivningsårTextFält.setText(sqlUtgivningsårResult.getString("utgivningsår"));
        }catch (SQLException e) {
            e.getCause();
            e.getStackTrace();
        }
    }
}

