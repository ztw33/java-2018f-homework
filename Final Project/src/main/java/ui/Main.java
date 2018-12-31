package ui;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class Main extends Application {
    Stage stage = new Stage();

    @Override
    public void start(Stage primaryStage) throws Exception{

        Parent root = FXMLLoader.load(getClass().getResource("/Menu.fxml"));
        primaryStage.setTitle("葫芦娃大战妖精");
        Scene scene = new Scene(root,740,560);
        primaryStage.setResizable(false);
        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                System.exit(0);
            }
        });
        //scene.getStylesheets().add(Login.class.getResource("Login.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public void showWindow()throws Exception{
        start(stage);
    }
    public static void main(String[] args) {
        launch(args);
    }
}
