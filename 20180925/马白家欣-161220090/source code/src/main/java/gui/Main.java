package gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/sample.fxml"));
        Scene scene = new Scene(root, 300, 275);
//        scene.getStylesheets().add(getClass().getResource("Css/GuiCss.css").toExternalForm());
        primaryStage.setTitle("Calabash Boys Battle");
        primaryStage.getIcons().add(new Image("/Red.jpeg")) ;
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

}
