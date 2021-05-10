package Controllers;

import Entiteter.Användare;
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
    private Label gatuadressText;

    @FXML
    private Label personNrText;

    @FXML
    private Label AnvändartypText;

    @FXML
    private TextField telefonNrTextFält;

    @FXML
    private TextField gatuadressTextFält;

    @FXML
    private Label postnummerText;

    @FXML
    private TextField postnummerTextFält;

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
    private Label errorText;

    @FXML
    void RegistreraKnappTryck(ActionEvent event) {
        String dataInput[] = {
                förnamnTextFält.getText(),
                efternamnTextFält.getText(),
                telefonNrTextFält.getText(),
                gatuadressTextFält.getText(),
                postnummerTextFält.getText(),
                emailTextFält.getText(),
                personNrTextFält.getText(),
                användartypDropDown.getText(),
                lösenordTextFält.getText()
        };
        boolean fältIfyllda = false;

        for (int i = 0; i < dataInput.length; i++) {
            if (dataInput[i].isEmpty()) {
                errorText.setText("Vänligen fyll i alla fält");
                fältIfyllda = false;
            } else {
                fältIfyllda = true;
            }
        }
        if (fältIfyllda) {
            Användare läggaTillAnvändare = new Användare();
            läggaTillAnvändare.läggaTillAnvändareSQL(förnamnTextFält.getText(),
                    efternamnTextFält.getText(),
                    telefonNrTextFält.getText(),
                    gatuadressTextFält.getText(),
                    postnummerTextFält.getText(),
                    emailTextFält.getText(),
                    personNrTextFält.getText(),
                    användartypDropDown.getText(),
                    lösenordTextFält.getText());

            errorText.setText("");

            ControllerConnector controllerConnector = new ControllerConnector();
            controllerConnector.popupConnector("successPopUp");
            Stage stage = (Stage) registreraKnapp.getScene().getWindow();
            stage.close();
        }
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
