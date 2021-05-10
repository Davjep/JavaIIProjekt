package Controllers;

import Databas.DatabasConnector;
import Entiteter.Användare;
import JavaFXConnector.ControllerConnector;
import Objekt.Bok;
import Objekt.Film;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SökController {


    boolean valdKategori; //variabel för att definiera vilken kategori som är vald. true = bok, false = film

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
                    valdKategori = true;
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
                    valdKategori = false;
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
    void resultatListaMerInfo(MouseEvent event) {
        ControllerConnector controllerConnector = new ControllerConnector();
        controllerConnector.connector("bokDetaljer");
        Stage stage = (Stage) resultatLista.getScene().getWindow();
        stage.close();

    }

    @FXML
    void hemKnappTryck(ActionEvent event) {
        ControllerConnector controllerConnector = new ControllerConnector();
        if (Användare.isInloggad()) {
            controllerConnector.connector("minProfil");
        } else {
            controllerConnector.connector("startsida");
        }
        Stage stage = (Stage) hemKnapp.getScene().getWindow();
        stage.close();

    }

    @FXML
    void väljKnappTryck(ActionEvent event) {

        //Variabler för att identifiera ISBN i resultatlista Stringen
        int förstaIndex = resultatLista.getSelectionModel().getSelectedItem().indexOf(" ");
        int sistaIndex = resultatLista.getSelectionModel().getSelectedItem().indexOf(",");

        ArrayList IDarray = new ArrayList();

        for (int i = (förstaIndex + 1); i < sistaIndex; i++){
            char ISBNchar = resultatLista.getSelectionModel().getSelectedItem().charAt(i);
            IDarray.add(ISBNchar);
        }

        String ISBNoutput = "0";
        for (int i = 0; i < IDarray.toArray().length; i++){
            ISBNoutput += IDarray.get(i);
        }

        StringBuilder fullID = new StringBuilder(ISBNoutput).deleteCharAt(0);

        if (valdKategori) {
            Bok.setISBN(fullID.toString());
            ControllerConnector controllerConnector = new ControllerConnector();
            controllerConnector.connector("bokDetaljer");
            Stage stage = (Stage) resultatLista.getScene().getWindow();
            stage.close();
        } else {
            Film.setFilmID(fullID.toString());
            ControllerConnector controllerConnector = new ControllerConnector();
            controllerConnector.connector("filmDetaljer");
            Stage stage = (Stage) resultatLista.getScene().getWindow();
            stage.close();
        }

    }
}


