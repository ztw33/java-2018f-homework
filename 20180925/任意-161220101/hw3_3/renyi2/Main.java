package renyi2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import javafx.scene.image.ImageView;
import java.util.Scanner;

public class Main extends Application {
    static Field f = new Field();
    public static void main(String[] args) {
        //System.out.println("是否需要助阵Y/N");
        System.out.println("请选择喽啰阵型：\n"
                + "1鹤翼\n"
                + "2雁行\n"
                + "3衝軛\n"
                + "4长蛇\n"
                + "5鱼鳞\n"
                + "6方円\n"
                + "7偃月\n"
                + "8锋矢");
        Scanner in = new Scanner(System.in);
        Battlearray a;
        switch (in.nextInt()) {
            case 1:
                a = new FirstBattlearray();
                a.createbattlearray(f, false);
                break;
            case 2:
                a=new SecondBattlearray();
                a.createbattlearray(f,false);
                break;
            case 3:
                a=new ThirdBattlearray();
                a.createbattlearray(f,false);
                break;
            case 4:
                a=new ForthBattlearray();
                a.createbattlearray(f,false);
                break;
            case 5:
                a=new FifthBattlearray();
                a.createbattlearray(f,false);
                break;
            case 6:
                a=new SixthBattlearray();
                a.createbattlearray(f,false);
                break;
            case 7:
                a=new SeventhBattlearray();
                a.createbattlearray(f,false);
                break;
            case 8:
                a=new eighthBattlearray();
                a.createbattlearray(f,true);
                break;
            default:
                return;
        }
        f.show();

        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        try
        {
            BorderPane board=new BorderPane();
            Scene scene=new Scene(board,f.N*f.element_size,f.N*f.element_size);
            ImageView background=new ImageView();
            background.setImage(new Image("/Image/background.png"));
            background.setX(0);
            background.setY(0);
            background.setFitHeight(f.N*f.element_size);
            background.setFitWidth(f.N*f.element_size);
            board.getChildren().add(background);
            for(int i=0;i<f.N;i++)
                for(int j=0;j<f.N;j++)
                    board.getChildren().add(f.imv.get(i).get(j));
            primaryStage.setTitle("葫芦娃大战蛇精");
            primaryStage.setScene(scene);
            primaryStage.show();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
