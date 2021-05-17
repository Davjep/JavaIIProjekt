package Controllers;

import Databas.DatabasConnector;
import Entiteter.Användare;
import JavaFXConnector.ControllerConnector;
import Objekt.Bok;
import Objekt.Film;
import Verktyg.VäljIListan;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SökController {

    @FXML
    private TextField sökFält;

    @FXML
    private ScrollBar scrollBar;

    @FXML
    private Button sökKnapp;

    @FXML
    private ListView<String> resultatLista;

    @FXML
    private Button hemKnapp;

    @FXML
    private Button väljKnapp;

    @FXML
    private SplitMenuButton kategoriValDropDown;

    @FXML
    private MenuItem bokKategori;

    @FXML
    private MenuItem filmKategori;

    @FXML
    private Label errorText;

    @FXML
    void bokKategoriVal(ActionEvent event) {
        kategoriValDropDown.setText("Bok");
        sökFält.setPromptText("Sök titel, föfattare, ämnesord...");
    }

    @FXML
    void filmKategoriVal(ActionEvent event) {
        kategoriValDropDown.setText("Film");
        sökFält.setPromptText("Sök titel, regissör, genre...");
    }

    @FXML
    void sökKnappTryck(ActionEvent event) {
        DatabasConnector databasConnector = new DatabasConnector();
        Connection connection = databasConnector.getConnection();

        String kategoriVal = kategoriValDropDown.getText();
        if (kategoriVal.equals("Bok")) {
            try {
                String sqlBokSök = "SELECT * FROM bok WHERE Författare LIKE '%" + sökFält.getText() + "%' OR Titel LIKE '%" + sökFält.getText() +
                        "%' OR ISBN LIKE '%" + sökFält.getText() + "%' OR ÄmnesOrd LIKE '%" + sökFält.getText() + "%';";
                PreparedStatement statement = connection.prepareStatement(sqlBokSök);
                ResultSet resultSet = statement.executeQuery(sqlBokSök);
                for (int i = 0; resultSet.next(); i++) {
                    String titelResultat = resultSet.getString("Titel");
                    String författareResultat = resultSet.getString("Författare");
                    String ISBNresultat = resultSet.getString("ISBN");
                    String ämnesordResultat = resultSet.getString("Ämnesord");
                    resultatLista.getItems().add("ISBN: " + ISBNresultat + ", Titel: " + titelResultat + ", Författare: " + författareResultat + ", Ämne: " + ämnesordResultat);
                }
            }catch (SQLException e) {
                e.getCause();
                e.printStackTrace();
            }
        } else if (kategoriVal.equals("Film")){
            try {
                String sqlFilmSök = "SELECT * FROM film WHERE Regissör LIKE '%" + sökFält.getText() + "%' OR Titel LIKE '%" + sökFält.getText() +
                        "%';";
                PreparedStatement statement = connection.prepareStatement(sqlFilmSök);
                ResultSet resultSet = statement.executeQuery(sqlFilmSök);
                for (int i = 0; resultSet.next(); i++) {
                    String filmIDResultat = resultSet.getString("FilmID");
                    String titelResultat = resultSet.getString("Titel");
                    String regissörResultat = resultSet.getString("regissör");
                    String genreResultat = resultSet.getString("genre");
                    resultatLista.getItems().add("FilmID: " + filmIDResultat + ", Titel: " + titelResultat + ", Regissör: " + regissörResultat + ", Genre: " + genreResultat);
                }
            }catch (SQLException e) {
                e.getCause();
                e.printStackTrace();
            }
        } else {
            errorText.setText("Välj kategori innan du söker!");
        }
        resultatLista.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
    }


    @FXML
    void hemKnappTryck(ActionEvent event) {
        ControllerConnector controllerConnector = new ControllerConnector();
        if (Användare.getInloggad()) {
            controllerConnector.connector("minProfil");
        } else {
            controllerConnector.connector("startsida");
        }
        Stage stage = (Stage) hemKnapp.getScene().getWindow();
        stage.close();

    }

    @FXML
    void väljKnappTryck(ActionEvent event) {
        VäljIListan valdRad = new VäljIListan();
        String fullID = valdRad.väljValdRad(resultatLista.getSelectionModel().getSelectedItem());

        if (kategoriValDropDown.getText().equals("Bok")) {
            Bok.setISBN(fullID);
            ControllerConnector controllerConnector = new ControllerConnector();
            controllerConnector.connector("bokDetaljer");
            Stage stage = (Stage) resultatLista.getScene().getWindow();
            stage.close();
        } else {
            Film.setFilmID(fullID);
            ControllerConnector controllerConnector = new ControllerConnector();
            controllerConnector.connector("filmDetaljer");
            Stage stage = (Stage) resultatLista.getScene().getWindow();
            stage.close();
        }

    }
}


