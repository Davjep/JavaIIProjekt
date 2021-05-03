package JavaFXConnector;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ControllerConnector {
//Klass som används för att gå från en ruta till en annan
    public void connector(String fxml) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/" + fxml + ".fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(root, 600  ,400));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
            System.exit(1);
        }
    }

}
