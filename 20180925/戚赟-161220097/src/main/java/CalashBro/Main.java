package CalashBro;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.image.Image;

public  class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {

            // Read file fxml and draw interface.
            Parent root = FXMLLoader.load(getClass().getResource("/MainScreen.fxml"));
            Scene main_sence = new Scene(root); //创建一个新的Sence
            primaryStage.setTitle("qun's CalaBash_Brothers");
            primaryStage.setScene(main_sence);
            primaryStage.show();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
