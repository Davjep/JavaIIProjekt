package Controllers;

import Databas.DatabasConnector;
import JavaFXConnector.ControllerConnector;
import Session.SessionsAnvändare;
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

    private static ArrayList<String> ISBN = new ArrayList();

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
        //TODO Fortsätt här!
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
                    ISBN.add(ISBNresultat);
                }
            }catch (SQLException e) {
                e.getCause();
                e.printStackTrace();
            }
        } else if (kategoriVal.equals("Film")){

        } else {
            errorText.setText("Välj kategori innan du söker!");
        }
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
        SessionsAnvändare sessionsAnvändare = new SessionsAnvändare();
        ControllerConnector controllerConnector = new ControllerConnector();
        if (sessionsAnvändare.isInloggad()) {
            controllerConnector.connector("minProfil");
        } else {
            controllerConnector.connector("startsida");
        }
        Stage stage = (Stage) hemKnapp.getScene().getWindow();
        stage.close();

    }

    @FXML
    void väljKnappTryck(ActionEvent event) {
        String x = resultatLista.getSelectionModel().getSelectedItem();



        //Variabler för att identifiera ISBN i resultatlista Stringen
        int förstaIndex = resultatLista.getSelectionModel().getSelectedItem().indexOf(" ");
        int sistaIndex = resultatLista.getSelectionModel().getSelectedItem().indexOf(",");
        ArrayList<Character> ISBNarray2 = new ArrayList();
        for (int i = (förstaIndex + 1); i < sistaIndex; i++){
            //ArrayList<> ISBNarray = new ArrayList();
            char ISBN = resultatLista.getSelectionModel().getSelectedItem().charAt(i);
            ISBNarray2.add(ISBN);
        }

        //if (ISBN.equals(ISBNarray2.toString()))
        System.out.println(ISBNarray2.toString());
        int abc = 0;
        for (int i = 0; i < ISBNarray2.toArray().length; i++){
            int resultat = ISBNarray2.get(i);
            System.out.println(resultat);
            abc =+ resultat;
        }
        System.out.print(abc);
        System.out.println("Siffra 1 är: " + ISBNarray2.get(0) + "siffra 2 är " + ISBNarray2.get(1));

    }
}


