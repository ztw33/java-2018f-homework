package sample;
import qx3.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.util.List;
import java.util.Scanner;

public class Main extends Application {
    private static Battlefield battlefield;
    @Override
    public void start(Stage primaryStage) throws Exception{
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        BorderPane root=new BorderPane();
        ImageView background=new ImageView();
        background.setImage(new Image("/picture/11.png"));
        background.setX(0);
        background.setY(0);
        background.setFitWidth(battlefield.getN()*battlefield.getScale());
        background.setFitHeight(battlefield.getN()*battlefield.getScale());
        root.getChildren().add(background);
        List<List<ImageView>> image=battlefield.getImage();
        for(int i=0;i<battlefield.getN();i++)
        {
            for(int j=0;j<battlefield.getN();j++)
            {
                root.getChildren().add(image.get(i).get(j));
            }
        }
        Scene scene=new Scene(root,battlefield.getN()*battlefield.getScale(),battlefield.getN()*battlefield.getScale());
        primaryStage.setTitle("葫芦娃大战蛇蝎精");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("请输入战场的大小N（10<N<=20,因为超过20会超过显示器全屏时的height，导致显示不全）:");
        int N=sc.nextInt();
        while(N<=10)
        {
            System.out.print("战场太小了，请重新输入：");
            N=sc.nextInt();
        }
        System.out.print("请选择怪物方的阵型（输入阵型的编号）：\n");
        System.out.print("1、鹤翼\n");
        System.out.print("2、雁行\n");
        System.out.print("3、衡轨\n");
        System.out.print("4、长蛇\n");
        System.out.print("5、鱼鳞\n");
        System.out.print("6、方円\n");
        System.out.print("7、偃月\n");
        System.out.print("8、锋矢\n");
        int no=sc.nextInt();
        battlefield=new Battlefield(N);
        Warrior warrior=new Warrior();
        WarriorFormation warriorFormation=new WarriorFormation();
        warriorFormation.formation(warrior,battlefield);
        Monster monster=new Monster();
        MonsterFormation formation=new HYFormation();
        switch (no)
        {
            case 1:formation=new HYFormation();break;
            case 2:formation=new YXFormation();break;
            case 3:formation=new HGFormation();break;
            case 4:formation=new CSFormation();break;
            case 5:formation=new YLFormation();break;
            case 6:formation=new FYFormation();break;
            case 7:formation=new YYFormation();break;
            case 8:formation=new FSFormation();break;
        }
        formation.formation(monster,battlefield);
        launch(args);
    }
}
