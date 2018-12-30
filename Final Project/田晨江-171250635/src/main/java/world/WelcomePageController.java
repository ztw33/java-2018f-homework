package world;

import javafx.animation.FadeTransition;
import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

public class WelcomePageController extends Application {

    Group ellipseGroup = new Group();
    @FXML
    private AnchorPane rootPan;

    @Override
    public void start(Stage primaryStage) throws Exception {

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("fxml/WelcomePage.fxml"));
//        System.out.println(getClass().getResource("fxml/WelcomePage.fxml"));
        rootPan = fxmlLoader.load();

        Scene scene = new Scene(rootPan, 800, 500);
//        System.out.println(getClass().getResource("css/WelcomePage.css"));
        scene.getStylesheets().add(getClass().getResource("css/WelcomePage.css").toExternalForm());
        scene.setFill(Color.TRANSPARENT);

        for (int i = 0; i < 6; i++) { createEllipse(i); }

        ellipseGroup.setLayoutX(scene.getWidth() / 2);
        ellipseGroup.setLayoutY(scene.getHeight() / 2 - 50);
        rootPan.getChildren().add(ellipseGroup);
        rotateEllipses(ellipseGroup);

		rootPan.setOnMouseClicked(e ->
    {
        Platform.runLater(new Runnable()
        {
            @Override
            public void run()
            {
                new Controller(primaryStage);
            }
        });
    });

		primaryStage.setScene(scene);
		primaryStage.initStyle(StageStyle.UNDECORATED);
		primaryStage.show();

}

//     public static void main(String[] args) {
//     launch(args);
//     }


    public void rotateEllipses(Group ellipse)
    {
        FadeTransition fd = new FadeTransition(Duration.millis(3000), ellipse);
        fd.setFromValue(0.1);
        fd.setToValue(1);
        fd.setCycleCount(Timeline.INDEFINITE);
        fd.setAutoReverse(true);
        // fd.setAutoReverse(true);
        fd.play();

        RotateTransition rt = new RotateTransition(Duration.millis(3000), ellipse);
        rt.setFromAngle(0);
        rt.setToAngle(180);
        rt.setCycleCount(1);
        rt.play();
    }


    public void createEllipse(int i)
    {
        Ellipse ellipse = new Ellipse(50, 100);
        ellipse.setFill(Color.web("rgba(255,255,255,0.3)"));

        ellipse.setRotate(i * 30);

        ellipseGroup.getChildren().add(ellipse);
    }

}

