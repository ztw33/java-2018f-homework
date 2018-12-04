package gui;

import battle.BattleField;
import creature.Creature;
import javafx.fxml.Initializable;
import javafx.event.*;

import formation.*;

import javafx.fxml.*;
import javafx.scene.canvas.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.DragEvent;

public class GameController implements Initializable {
    private BattleField battle;
    private Image background;
    private int width;
    private int height;
    private Creature selected;
    @FXML private Canvas canvas;
    @FXML private Button yanhangHulu;
    @FXML private Button changsheHulu;
    @FXML private Button fangmenHulu;
    @FXML private Button yulinHulu;
    @FXML private Button fengshiHulu;
    @FXML private Button heyiHulu;
    @FXML private Button hengeHulu;
    @FXML private Button yanhangDemon;
    @FXML private Button changsheDemon;
    @FXML private Button fangmenDemon;
    @FXML private Button yulinDemon;
    @FXML private Button fengshiDemon;
    @FXML private Button heyiDemon;
    @FXML private Button hengeDemon;
    @FXML private Label info;
    @FXML private ImageView head;

    public void initialize(java.net.URL location, java.util.ResourceBundle resources) {
        width = 600;
        height = 450;
        battle = new BattleField();
        background = new Image("image/ground.jpg");
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.drawImage(background, 0, 0, 600, 450);


    }

    private void display() {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.drawImage(background, 0, 0, 600, 450);
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                if (battle.space.getCreature(i, j) != null) {
                    gc.drawImage(battle.space.getCreature(i, j).getImage(), 60 + 30 * j, 30 * i, 30, 30);
                }
            }
        }
        /*if (selected != null) {
            ImageView img = new ImageView(selected.getImage());
            img.setFitHeight(50);
            img.setFitWidth(50);
            head.setGraphic(img);
        }*/
    }

    @FXML private void yanhangHuluOnAction(ActionEvent event) {
        battle.huluBrothers.generateFormation(new YanhangFormation(), battle.space, 11, 7, 0);
        display();
    }
    @FXML private void changsheHuluOnAction(ActionEvent event) {
        battle.huluBrothers.generateFormation(new ChangsheFormation(), battle.space, 5, 2, 0);
        display();
    }
    @FXML private void hengeHuluOnAction(ActionEvent event) {
        battle.huluBrothers.generateFormation(new HengeFormation(), battle.space, 5, 2, 0);
        display();
    }
    @FXML private void fengshiHuluOnAction(ActionEvent event) {
        battle.huluBrothers.generateFormation(new FengshiFormation(), battle.space, 7, 5, 0);
        display();
    }
    @FXML private void yulinHuluOnAction(ActionEvent event) {
        battle.huluBrothers.generateFormation(new YulinFormation(), battle.space, 7, 5, 0);
        display();
    }
    @FXML private void heyiHuluOnAction(ActionEvent event) {
        battle.huluBrothers.generateFormation(new HeyiFormation(), battle.space, 7, 2, 0);
        display();
    }
    @FXML private void fangmenHuluOnAction(ActionEvent event) {
        battle.huluBrothers.generateFormation(new FangmenFormation(), battle.space, 7, 5, 0);
        display();
    }
    
    @FXML private void yanhangDemonOnAction(ActionEvent event) {
        battle.monsters.generateFormation(new YanhangFormation(), battle.space, 5, 8, 1);
        display();
    }
    @FXML private void changsheDemonOnAction(ActionEvent event) {
        battle.monsters.generateFormation(new ChangsheFormation(), battle.space, 5, 12, 1);
        display();
    }
    @FXML private void hengeDemonOnAction(ActionEvent event) {
        battle.monsters.generateFormation(new HengeFormation(), battle.space, 5, 12, 1);
        display();
    }
    @FXML private void fengshiDemonOnAction(ActionEvent event) {
        battle.monsters.generateFormation(new FengshiFormation(), battle.space, 7, 10, 1);
        display();
    }
    @FXML private void yulinDemonOnAction(ActionEvent event) {
        battle.monsters.generateFormation(new YulinFormation(), battle.space, 7, 10, 1);
        display();
    }
    @FXML private void heyiDemonOnAction(ActionEvent event) {
        battle.monsters.generateFormation(new HeyiFormation(), battle.space, 7, 13, 1);
        display();
    }
    @FXML private void fangmenDemonOnAction(ActionEvent event) {
        battle.monsters.generateFormation(new FangmenFormation(), battle.space, 7, 10, 1);
        display();
    }

    @FXML private void canvasClick(MouseEvent event) {
        int x = (int)event.getX() - 60;
        int y = (int)event.getY();
        x = x / 30;
        y = y / 30;

        if (battle.space.getCreature(y, x) != null) {
            selected = battle.space.getCreature(y, x);
            head.setImage(selected.getImage());
            info.setText(selected.getName());
        }
    }

    @FXML private void canvasDragDetect(MouseEvent event) {
        int x = (int)event.getX() - 60;
        int y = (int)event.getY();
        x = x / 30;
        y = y / 30;
        if (battle.space.getCreature(y, x) != null) {
            selected = battle.space.getCreature(y, x);
            head.setImage(selected.getImage());
            info.setText(selected.getName());
        }
    }

    @FXML private void canvasDrag(MouseEvent event) {
        int x = (int)event.getX() - 60;
        int y = (int)event.getY();
        x = x / 30;
        y = y / 30;
        //System.out.print(y);
        //System.out.print(" ");
        //System.out.println(x);
        if (selected != null) {
            selected.moveTo(battle.space, y, x);
        }
        display();
    }
}
