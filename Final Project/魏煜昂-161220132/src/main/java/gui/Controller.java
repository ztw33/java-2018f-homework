package gui;

import creature.HeroList;
import creature.MonsterList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;


import static gui.Global.herolist;
import static gui.Global.monsterlist;
import static gui.Global.status;

public class Controller {
    @FXML
    Label label;
    @FXML
    protected BorderPane borderPane;
    @FXML
    private GridPane battleground;
    @FXML
    protected MenuItem setQueue1;
    @FXML
    private BorderPane rootpane;
    @FXML
    protected void setQueue1(ActionEvent event){
        label.setText("start");
        System.out.println("hello1");
        herolist = new HeroList();
        herolist.setQueue(1);
        monsterlist = new MonsterList();
        monsterlist.setQueue(1);
        paintAll();
        fight();
    }
    @FXML
    protected void setQueue2(ActionEvent event){
        label.setText("start");
        System.out.println("hello2");
        herolist = new HeroList();
        monsterlist = new MonsterList();
        herolist.setQueue(2);
        monsterlist.setQueue(1);
        paintAll();
        fight();
    }

    private void fight() {
        battleground.setOnMouseMoved(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                //System.out.println("move!!!!!!");
                herolist.move();
                //System.out.println("done");
                monsterlist.move();
                paintAll();
                if (monsterlist.List.isEmpty() || herolist.List.isEmpty()) {
                    status = 2;
                    System.out.println("end");
                    label.setText("end");
                }
            }
        });
    }


    private void paintAll()
    {
        clearAll();
        for (int i=0;i < herolist.List.size();i++)
        { setOneImage(herolist.get(i).getImage(),herolist.get(i).getX(),herolist.get(i).getY());; }
        for (int i=0;i < monsterlist.List.size();i++)
        { setOneImage(monsterlist.get(i).getImage(),monsterlist.get(i).getX(),monsterlist.get(i).getY());; }
    }

    private void setOneImage(Image image, int x, int y)
    {
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(80);
        imageView.setFitWidth(80);
        battleground.add(imageView,x,y);
    }

    private void clearAll()
    {
        Node node = battleground.getChildren().get(0);
        battleground.getChildren().clear();
        battleground.getChildren().add(node);
    }



}
