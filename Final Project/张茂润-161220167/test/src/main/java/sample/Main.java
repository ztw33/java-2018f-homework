package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.HBox;

public class Main extends Application {
    @Edit(editor = "zmr", time = "20181201")
    @Override
    public void start(Stage primaryStage)  throws Exception{
        try{
            Parent root = FXMLLoader.load(getClass().getResource("/sample.fxml"));
            primaryStage.setTitle("HuluBrothersVSSnake");

            /*MenuItem menuItem1 = new MenuItem("Option 1");
            MenuItem menuItem2 = new MenuItem("Option 2");
            MenuItem menuItem3 = new MenuItem("Option 3");
            MenuButton menuButton = new MenuButton("Options", null, menuItem1, menuItem2, menuItem3);
            HBox hbox = new HBox(menuButton);*/

            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            //primaryStage.setScene(new Scene(root));
            primaryStage.show();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}


