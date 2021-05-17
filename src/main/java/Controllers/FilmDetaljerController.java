package Controllers;

import JavaFXConnector.ControllerConnector;
import Objekt.Film;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class FilmDetaljerController implements Initializable {

    @FXML
    private TextField filmIDTextFält;

    @FXML
    private TextField titelTextFält;

    @FXML
    private TextField regissörTextFält;

    @FXML
    private TextField genreTextFält;

    @FXML
    private TextField produktionsLandTextFält;

    @FXML
    private TextField åldersBegränsningTextFält;

    @FXML
    private Button gåTillbakaKnapp;

    @FXML
    private Button lånaFilmKnapp;

    @FXML
    private TextField utgivningsÅrTextFält;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Film film = new Film();
        filmIDTextFält.setText(film.hämtaFilmIDSQL());
        titelTextFält.setText(film.hämtaTitelSQL());
        regissörTextFält.setText(film.hämtaRegissörSQL());
        genreTextFält.setText(film.hämtaGenreSQL());
        produktionsLandTextFält.setText(film.hämtaProduktionslandSQL());
        utgivningsÅrTextFält.setText(film.hämtaUtgivningsårSQL());
        åldersBegränsningTextFält.setText(film.hämtaÅldersBegränsningSQL());
    }

    @FXML
    void gåTillbakaKnappTryck(ActionEvent event) {
        ControllerConnector controllerConnector = new ControllerConnector();
        controllerConnector.connector("sök");
        Stage stage = (Stage) gåTillbakaKnapp.getScene().getWindow();
        stage.close();

    }

    @FXML
    void lånaFilmKnappTryck(ActionEvent event) {
        ControllerConnector controllerConnector = new ControllerConnector();
        controllerConnector.connector("väljfysiskkopia");
        Stage stage = (Stage) lånaFilmKnapp.getScene().getWindow();
        stage.close();
        //TODO Ta bort följande om allt fungerar som de ska med fysisk kopia
/*        try {
            DatabasConnector databasConnector = new DatabasConnector();
            Connection connection = databasConnector.getConnection();
            Statement statement = connection.createStatement();

            String sqlStatus = "SELECT Status FROM fysiskkopia WHERE filmid = '" + Film.getFilmID() + "';";

            ResultSet resultat = statement.executeQuery(sqlStatus);
            resultat.next();

            if (!resultat.getString("status").equals("Tillgänglig")) {
                ControllerConnector controllerConnector = new ControllerConnector();
                controllerConnector.connector("ejTillgängligPopUp");
                Stage stage = (Stage) lånaFilmKnapp.getScene().getWindow();
                stage.close();
            } else {
                Lån.setLåneTyp("Film");
                ControllerConnector controllerConnector = new ControllerConnector();
                controllerConnector.connector("lånaBekräftelsePopUp");
                Stage stage = (Stage) lånaFilmKnapp.getScene().getWindow();
                stage.close();

            }
        }catch (SQLException e) {
            e.getCause();
            e.getStackTrace();
        }*/

    }
}
