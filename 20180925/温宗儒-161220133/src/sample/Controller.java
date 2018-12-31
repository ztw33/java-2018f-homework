package src.sample;


import backstage.Position;
import backstage.Space;
import backstage.creature.Creature;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import util.ImageCreator;
import java.util.ArrayList;
import java.util.Random;

public class Controller  {

    @FXML public Pane creaturePane;



    //根据position布局显示各种怪物
    private static void show(Position[][] positions, Pane mainPane) {
        ImageCreator imageCreator = new ImageCreator();//实现图片组件的批量创建
        int maxRow = Space.getMaxRow();
        int maxCol = Space.getMaxCow();
        for (int i = 0; i < maxRow; i++) {
            for (int j = 0; j < maxCol; j++) {
                if (positions[i][j].isPossession()) {
                    Creature creature = positions[i][j].getCreature();
                    String url = creature.getImageUrl();
                    ImageView imageView = imageCreator.create(url, i, j);
                    mainPane.getChildren().add(imageView);
                }
            }
        }

    }


    //开始游戏，初始化
    public void startGame(ActionEvent actionEvent){
        System.out.println("点击开始游戏");
        Space space = new Space(); //初始化space，葫芦娃、蛇精、爷爷就位
        space.initialize();
        Position[][] positions = space.randomFormation(3);
        show(positions,creaturePane);

    }

    //敌方改变布阵
    public void changeFormation(ActionEvent actionEvent){
        Space space = new Space();

        Random random = new Random();
        int maxRandomNumber = 7;
        int randomNumber;
        randomNumber = random.nextInt(maxRandomNumber) + 1;
        emptyPane();
        Position[][] positions = space.randomFormation(randomNumber);
        show(positions, creaturePane);

    }

    //清空所有图画
    public void emptyPane() {
        ObservableList<Node> nodes = creaturePane.getChildren();
        ArrayList<Node> list = new ArrayList<>();
        for(Node imageView : nodes){
            if(imageView instanceof ImageView){
                list.add(imageView);
            }
        }
        creaturePane.getChildren().removeAll(list);
    }
}