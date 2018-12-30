package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.image.*;
import javafx.scene.Group;
import data.*;

public class Main extends Application {

    private BattleField field = new BattleField(12,18);
    private Camp<Grandpa> camp1;
    private Camp<Snake> camp2;

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("sample.fxml"));
        Parent root = fxmlLoader.load();
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 1024, 768));

        Controller controller = fxmlLoader.getController();
        controller.setMainapp(this);
        CalaBashBrother[]gourds = { new CalaBashBrother(1,"大娃","红色"),
                new CalaBashBrother(4,"四娃","绿色"),
                new CalaBashBrother(7,"七娃","紫色"),
                new CalaBashBrother(5,"五娃","青色"),
                new CalaBashBrother(3,"三娃","黄色"),
                new CalaBashBrother(2,"二娃","橙色"),
                new CalaBashBrother(6,"六娃","蓝色")};
        Grandpa grandpa = new Grandpa();
        Formation.bubble_sort(gourds, 7);
        camp1 = new Camp<>(grandpa,gourds,7);

        Snake snake = new Snake();
        camp2 = new Camp<>(snake);
        Scorpion scorpion = new Scorpion();
        camp2.add_unit(scorpion);
        for(int i = 0; i<7;i++) {
            Monster temp = new Monster();
            camp2.add_unit(temp);
        }

        Formation.ChangShe(field, camp1,3);
        Formation.YanXing(field,camp2,9,10);
        controller.print();
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public BattleField getField() {
        return field;
    }

    public Camp<Grandpa> getCamp1() {
        return camp1;
    }

    public Camp<Snake> getCamp2() {
        return camp2;
    }
}
