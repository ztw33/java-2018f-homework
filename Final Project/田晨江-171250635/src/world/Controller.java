package world;

import creature.CalabashBrothers;
import creature.Grandpa;
import creature.LittleGuys;
import creature.SnakeSpirit;
import formation.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import sort.BubbleSort;
import sort.RandomSort;

import java.util.Scanner;

public class Controller  {

    private BattleField battleField;
    private Canvas canvas;

    public Controller(){
        battleField = new BattleField(20,20);
    }


    public void startGame(Stage primaryStage) {

        StackPane root = new StackPane();

        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(25, 25, 25, 25));

        canvas = new Canvas(100, 500);
        root.getChildren().add(canvas);

        Scene scene = new Scene(root,1100,600);
        scene.getStylesheets().add(Controller.class.getClassLoader().getResource("resources/BattleField.css").toExternalForm()); //设置背景

        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setTitle("葫芦世界");

        showUI();

        play();
    }



    public void showUI() {
        battleField.print();
        GraphicsContext gc = canvas.getGraphicsContext2D();
        battleField.loadImage(gc);
    }


    public void play() {

        //GeneralCoordinator coordinator = new GeneralCoordinator();

        /*打印初始阵型*/
        System.out.println("初始化");
        battleField.print();

        try {
            /*各生物初始化*/
            Queue brotherQueue = new Queue(new CalabashBrothers().initialCB());


            /*老爷爷和蛇精初始化*/
            Grandpa grandpa = new Grandpa();
            SnakeSpirit snakeSpirit = new SnakeSpirit();

            /*小喽啰初始化*/
            Queue lGuysQueue = new Queue(new LittleGuys().initialGuys());


            /*各阵型初始化*/
            FormationImp changShe = new ChangShe();
            FormationImp heYi = new HeYi();
            FormationImp yanXing = new YanXing();
            FormationImp hengE = new HengE();


            /*放置葫芦娃*/
            changShe.arrange(battleField, brotherQueue, new Location(5, 5));
            new RandomSort().sort(brotherQueue);
            showUI();
            new BubbleSort().sort(brotherQueue);


            System.out.println("请输入小喽啰的阵型，例如hengE,heYi,yanXing");
            Scanner in = new Scanner(System.in);
            String formaiton = in.next();

            switch (formaiton) {
                case "hengE":
                    hengE.arrange(battleField, lGuysQueue, new Location(5, 8));
                    break;
                case "heYi":
                    heYi.arrange(battleField, lGuysQueue, new Location(8, 8));
                    break;
                case "yanXing":
                    yanXing.arrange(battleField, lGuysQueue, new Location(8, 8));
                    break;
                default:
            }

            showUI();

            /*添加老爷爷和蛇精*/
            battleField.addCreature(grandpa, new Location(3, 3));
            battleField.addCreature(snakeSpirit, new Location(2, 10));
            battleField.print();

            battleField.clear();
            battleField.print();


            /*变换阵法输出*/
            System.out.println("变换阵法");

            /*放置葫芦娃*/
            changShe.arrange(battleField, brotherQueue, new Location(5, 5));

            System.out.println("请输入小喽啰的阵型，例如hengE,heYi,yanXing");
            String formaiton2 = in.next();
            switch (formaiton2) {
                case "hengE":
                    hengE.arrange(battleField, lGuysQueue, new Location(5, 8));
                    break;
                case "heYi":
                    heYi.arrange(battleField, lGuysQueue, new Location(7, 7));
                    break;
                case "yanXing":
                    yanXing.arrange(battleField, lGuysQueue, new Location(8, 8));
                    break;
                default:
            }

            showUI();


            /*添加老爷爷和蛇精*/
            battleField.addCreature(grandpa, new Location(3, 3));
            battleField.addCreature(snakeSpirit, new Location(2, 10));
            showUI();

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
