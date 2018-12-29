import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class UIApp extends Application {

    private Parent root;

    private Parent createContent() throws IOException {
        this.root = FXMLLoader.load(getClass().getResource("resources/board.fxml"));
        return this.root;
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("战局");
        primaryStage.getIcons().add(new Image("resources/DaWa.png"));
        Scene scene = new Scene(createContent(), 1000, 1000);
        scene.setFill(Color.YELLOW);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
