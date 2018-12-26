package sample;

import creature.*;
import field.BattleField;
import formation.SingleLineBattleArray;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Scanner;

public class StandOff extends Application {
    static int row=10;
    static int column=20;
    static int singleRow=row;    //两个不同队伍各自的行和列的值
    static int singleColumn=column/2-1;

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("sample.fxml"));
        Parent root = fxmlLoader.load();
        primaryStage.setTitle("CalabashBrother");
        primaryStage.setScene(new Scene(root, 950, 600));
        Controller controller = fxmlLoader.getController();
        Scanner scanner=new Scanner(System.in);
        BattleField battleField=new BattleField(row,column);

        BattleField leftBattleField;
        BattleField rightBattleField;

        sample.Coordinator coordinator=new sample.Coordinator(); //初始化指挥员
        CalabashBrother[] calabashBrothers=new CalabashBrother[7];  //初始化葫芦娃队伍
        coordinator.RandomSort(calabashBrothers);
        coordinator.BubbleSort(calabashBrothers);  //对起初乱序的七个葫芦娃进行排序
        leftBattleField=coordinator.command(calabashBrothers,new SingleLineBattleArray(singleRow,singleColumn)); //得到葫芦娃排列完后的阵列

        System.out.print("请输入蝎子精、小喽啰的总个数（若随机到鱼鳞、方円、偃月、锋矢阵，则总个数已定）：");
        int numOfDemon=scanner.nextInt();
        Demon[] demon=new Demon[numOfDemon];
        demon[0]=new Scorpion();
        for(int i=1;i<numOfDemon;i++){
            demon[i]=new Minions();
        }
        rightBattleField=coordinator.command(demon,coordinator.RandomFormation(singleRow,singleColumn)); //随机选取一个阵列，得到妖精排列完后的阵列
        if(leftBattleField!=null && rightBattleField!=null) {  //如果两个阵列均符合总场地的大小，则合并并打印
            Embattle(battleField,leftBattleField,rightBattleField);
        }
        battleField.print(controller);

        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

    private static void Embattle(BattleField field, BattleField leftBattleField, BattleField rightBattleField) {  //合并两个阵列
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < singleColumn; j++) {
                field.battlefield[i][j].setCreature(leftBattleField.battlefield[i][j].getCreature());
                field.battlefield[i][20 - singleColumn + j].setCreature(rightBattleField.battlefield[i][j].getCreature());
            }
        }
        Grandpa grandpa = new Grandpa();
        Snake snake = new Snake();
        field.battlefield[0][singleColumn-1].setCreature(grandpa);
        field.battlefield[0][(20 - 1) / 2 + 2].setCreature(snake);
    }
}
