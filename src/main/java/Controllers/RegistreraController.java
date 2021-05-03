package Controllers;

import JavaFXConnector.ControllerConnector;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class RegistreraController {

    @FXML
    private Label förnamnText;

    @FXML
    private Label EfternamnText;

    @FXML
    private Label emailText;

    @FXML
    private TextField förnamnTextFält;

    @FXML
    private TextField efternamnTextFält;

    @FXML
    private TextField emailTextFält;

    @FXML
    private Label telefonNrText;

    @FXML
    private Label adressText;

    @FXML
    private Label personNrText;

    @FXML
    private Label AnvändartypText;

    @FXML
    private TextField telefonNrTextFält;

    @FXML
    private TextField adressTextFält;

    @FXML
    private TextField personNrTextFält;

    @FXML
    private Label lösenordText;

    @FXML
    private PasswordField lösenordTextFält;

    @FXML
    private SplitMenuButton användartypDropDown;

    @FXML
    private Button registreraKnapp;

    @FXML
    private Button avbrytKnapp;

    @FXML
    private MenuItem studentVal;

    @FXML
    private MenuItem forskareVal;

    @FXML
    private MenuItem övrigaUniversitetsanställdaVal;

    @FXML
    private MenuItem allmänhetenVal;

    @FXML
    void RegistreraKnappTryck(ActionEvent event) {

    }

    @FXML
    void avbrytKnappTryck(ActionEvent event) {
        ControllerConnector controllerConnector = new ControllerConnector();
        controllerConnector.connector("startsida");
        Stage stage = (Stage) avbrytKnapp.getScene().getWindow();
        stage.close();
    }

    @FXML
    void allmänhetenValTryck(ActionEvent event) {
        användartypDropDown.setText("Allmänheten");
    }

    @FXML
    void forskareValTryck(ActionEvent event) {
        användartypDropDown.setText("Forskare");
    }

    @FXML
    void studentValTryck(ActionEvent event) {
        användartypDropDown.setText("Student");
    }

    @FXML
    void övrigaUniversitetsanställdaValTryck(ActionEvent event) {
        användartypDropDown.setText("Övriga Universitetsanställda");
    }

}
