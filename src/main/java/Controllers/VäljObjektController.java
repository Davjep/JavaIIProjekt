package Controllers;

import Databas.DatabasConnector;
import Entiteter.Användare;
import JavaFXConnector.ControllerConnector;
import Objekt.Bok;
import Objekt.Film;
import Objekt.Objekt;
import Verktyg.VäljIListan;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VäljObjektController {

    @FXML
    private SplitMenuButton kategoriValDropDown;

    @FXML
    private MenuItem bokKategori;

    @FXML
    private MenuItem filmKategori;

    @FXML
    private MenuItem fysiskKopiaKategori;

    @FXML
    private Button hemKnapp;

    @FXML
    private Button sökKnapp;

    @FXML
    private ListView<String> resultatLista;

    @FXML
    private Button väljKnapp;

    @FXML
    void bokKategoriVal(ActionEvent event) {
        kategoriValDropDown.setText("Bok");
    }

    @FXML
    void filmKategoriVal(ActionEvent event) {
        kategoriValDropDown.setText("Film");
    }

    @FXML
    void fysiskKopiaVal(ActionEvent event) {
        kategoriValDropDown.setText("Fysisk Kopia");
    }

    @FXML
    void hemKnappTryck(ActionEvent event) {
        ControllerConnector controllerConnector = new ControllerConnector();
        controllerConnector.connector("admin");
        Stage stage = (Stage) hemKnapp.getScene().getWindow();
        stage.close();
    }

    @FXML
    void sökKnappTryck(ActionEvent event) {
        DatabasConnector databasConnector = new DatabasConnector();
        Connection connection = databasConnector.getConnection();

        if (kategoriValDropDown.getText().equalsIgnoreCase("Bok")) {
            try {
                String bokSök = "SELECT * FROM bok";

                PreparedStatement statement = connection.prepareStatement(bokSök);
                ResultSet resultSet = statement.executeQuery(bokSök);
                while (resultSet.next()) {
                    String ISBN = resultSet.getString("ISBN");
                    String titel = resultSet.getString("titel");
                    String författare = resultSet.getString("författare");
                    String ämnesOrd = resultSet.getString("ämnesOrd");
                    String kategori = resultSet.getString("kategori");
                    String utgivningsÅr = resultSet.getString("utgivningsÅr");

                    resultatLista.getItems().add("ISBN: " + ISBN + ", Titel: " + titel + ", Författare: " + författare +
                            ", Ämnesord: " + ämnesOrd + ", Kategori: " + kategori + ", Utgivningsår: " + utgivningsÅr);
                }
            } catch (SQLException e) {
                e.getCause();
                e.getStackTrace();
            }
        } else if (kategoriValDropDown.getText().equalsIgnoreCase("Film")) {
            try {
                String filmSök = "SELECT * FROM film";

                PreparedStatement statement = connection.prepareStatement(filmSök);
                ResultSet resultSet = statement.executeQuery(filmSök);
                while (resultSet.next()) {
                    String FilmID = resultSet.getString("FilmID");
                    String titel = resultSet.getString("titel");
                    String regissör = resultSet.getString("regissör");
                    String produktionsland = resultSet.getString("produktionsland");

                    resultatLista.getItems().add("FilmID: " + FilmID + ", Titel: " + titel + ", Regissör: " + regissör + ", Produktionsland: " + produktionsland);
                }
            } catch (SQLException e) {
                e.getCause();
                e.getStackTrace();
            }
        } else {
            try {
                String fysiskKopiaSök = "SELECT * FROM biblioteket.fysiskkopia";

                PreparedStatement statement = connection.prepareStatement(fysiskKopiaSök);
                ResultSet resultSet = statement.executeQuery(fysiskKopiaSök);
                while (resultSet.next()) {
                    String ID = resultSet.getString("fysiskkopiaid");
                    String plats = resultSet.getString("plats");
                    String status = resultSet.getString("status");
                    String ISBN = resultSet.getString("ISBN");
                    String filmID = resultSet.getString("filmID");

                    resultatLista.getItems().add("Fysisk KopiaID: " + ID + ", Plats: " + plats + ", Status: " + status + ", ISBN: " + ISBN + ", FilmID: " + filmID);
                }
            } catch (SQLException e) {
                e.getCause();
                e.getStackTrace();
            }
        }
    }

    @FXML
    void väljKnappTryck(ActionEvent event) {
        VäljIListan valdRad = new VäljIListan();
        String fullID = valdRad.väljValdRad(resultatLista.getSelectionModel().getSelectedItem());

        if (kategoriValDropDown.getText().equals("Bok")) {
            Bok.setISBN(fullID);
        } else if (kategoriValDropDown.getText().equals("Film")) {
            Film.setFilmID(fullID);
        } else {
            Objekt.setFysiskKopiaID(fullID);
        }

        ControllerConnector controllerConnector = new ControllerConnector();
        controllerConnector.connector("hanteraObjekt");
        Stage stage = (Stage) resultatLista.getScene().getWindow();
        stage.close();
    }

}
