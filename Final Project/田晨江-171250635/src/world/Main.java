package world;

import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import world.*;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                try {

                    new Controller().startGame(primaryStage);

                } catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }



    public static void main(String[] args){
        launch(args);
    }



    }

