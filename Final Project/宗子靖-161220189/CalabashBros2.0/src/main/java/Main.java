import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

import java.net.URL;

public class Main extends Application {

    private BattleField battleField;
    private Controller controller;

    @Override
    public void start(Stage primaryStage) {
        try {
            URL location = getClass().getResource("game.fxml");
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(location);
            fxmlLoader.setBuilderFactory(new JavaFXBuilderFactory());
            Parent root = fxmlLoader.load();

            primaryStage.setTitle("葫芦娃大战妖精");
            controller = fxmlLoader.getController();
            Scene scene = new Scene(root, 804, 681);
            primaryStage.setScene(scene);
            primaryStage.setResizable(false);

            primaryStage.show();

            battleField = new BattleField(12, 18, false, controller.anchorPane);

            scene.setOnKeyPressed(event -> {
                if (event.getCode() == KeyCode.SPACE) {
                    System.out.println("space pressed");
                    battleField.spacePressed();
                }
                if (event.getCode() == KeyCode.L) {
                    System.out.println("l pressed");
                    battleField.lPressed(primaryStage);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}
