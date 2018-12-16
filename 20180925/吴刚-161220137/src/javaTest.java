import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class javaTest extends Application
{
    @Override
    public void start(Stage primaryStage)
    {
        Pane pane = new Pane();

        Rectangle rectangle = new Rectangle();
        rectangle.setHeight(50);
        rectangle.setWidth(50);
        rectangle.setFill(Paint.valueOf("BLACK"));

        rectangle.setLayoutX(100);
        rectangle.setLayoutY(100);
//        rectangle.setX(20);
//        rectangle.setY(20);
        rectangle.setTranslateX(50);


        System.out.println(rectangle.getBoundsInLocal());
        System.out.println(rectangle.getBoundsInParent());
        System.out.println(rectangle.getLayoutBounds());
        pane.getChildren().add(rectangle);
        Scene scene = new Scene(pane, 500,500);
        primaryStage.setTitle("14.6");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args)
    {
        Application.launch(args);
    }
}