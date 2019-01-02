import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;

public class Main extends Application {
    final Controller controller = new Controller();
    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setScene(new Scene(controller.initialization()));
        primaryStage.setResizable(false);
        primaryStage.setTitle("葫芦娃大战妖精：空格开始，L读取历史，S保存历史");
        primaryStage.show();
        controller.start(primaryStage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
