package Main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/startsida.fxml"));
            primaryStage.setTitle("Startsida");
            primaryStage.setScene(new Scene(root, 600  ,400));
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
            System.exit(1);
        }

    }

    public static void main(String[] args) {
        //Start of program
        launch(args);
    }
}
// Linn kommenterar