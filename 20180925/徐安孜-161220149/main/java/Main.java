package main.java;
import javafx.event.EventHandler;
import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import java.io.InputStream;
import java.util.Properties;

import static main.java.Battle.battlefield;
import static main.java.Battle.god;
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            BorderPane root = new BorderPane();
            Scene scene = new Scene(root,battlefield.columns*battlefield.elementSize,battlefield.rows*battlefield.elementSize);
            ImageView background=new ImageView();
            background.setImage(new Image("/main/resource/background.jpg"));
            background.setX(0);
            background.setY(0);
            background.setFitHeight(battlefield.rows*battlefield.elementSize);
            background.setFitWidth(battlefield.columns*battlefield.elementSize);
            root.getChildren().add(background);
            for(int i=0;i<battlefield.columns;i++)
                for(int j=0;j<battlefield.rows;j++){
                    root.getChildren().add(battlefield.imv[i][j]);
                }
            scene.setOnMouseClicked(new EventHandler<MouseEvent>(){
                public void handle(MouseEvent me) {
                    Battle.restart();
                    if(Battle.current==1) {
                        Battle.scene1();
                        Battle.current = 2;
                    }
                    else{
                        Battle.scene2();
                        Battle.current = 1;
                    }

                }
            });
            primaryStage.setTitle("Calabash");
            primaryStage.getIcons().add(new Image("/main/resource/1.png"));
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch(Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {

        InputStream is = Main.class.getResourceAsStream("/main/resource/Battle.properties");
        Properties ps = new Properties();
        try {
            ps.load(is);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        int rows,columns,elementSize;
        rows = new Integer(ps.getProperty("map_rows"));
        columns = new Integer(ps.getProperty("map_columns"));
        elementSize=new Integer(ps.getProperty("element_size"));
        battlefield = new Space(rows,columns,elementSize);
        god =new SpaceManager();


        launch(args);

    }
}