import javafx.application.Platform;
import world.BattleField;
import creature.CalabashBrothers;
import creature.*;
import creature.LittleGuys;
import world.*;
import formation.*;
import javafx.application.Application;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import sort.BubbleSort;
import sort.RandomSort;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import java.util.Scanner;

public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new Controller().start(primaryStage);
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

