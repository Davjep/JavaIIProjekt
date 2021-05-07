package Controllers;

import JavaFXConnector.ControllerConnector;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class BokDetaljerController {

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

    }

}

