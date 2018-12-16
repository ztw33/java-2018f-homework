package JavaFx;

import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

import battlefield.BattleField;
import items.Creature;
import items.calabash.CalabashBro;
import items.calabash.OldPapa;
import items.evil.Goblin;
import items.evil.ScorpionEvil;
import items.evil.SnakeEvil;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;

public class BattlefieldController implements Initializable {
    //Initialize all creatures here.
    private Creature[] calabashbros = {new CalabashBro(), new CalabashBro(), new CalabashBro(), new CalabashBro(), new CalabashBro(), new CalabashBro(), new CalabashBro()};
    private Creature[] calabashbrosexpred = {calabashbros[1], calabashbros[2], calabashbros[3], calabashbros[4], calabashbros[5], calabashbros[6],};
    private Creature oldpapa = new OldPapa();
    private Creature snakeevil = new SnakeEvil();
    private Creature scorpion = new ScorpionEvil();
    private Creature[] goblins = new Goblin[20];
    { //instance initialize goblins
        for (int i = 0; i < 20; i++) {
            goblins[i] = new Goblin();
        }
    }

    //Initialize background battlefield here
    BattleField bf = new BattleField();
    //Initialize OnScene battlefield here
    private BattleFXield battlefxield;

    private void syncBackgroundBFToUI(){
        Creature[][] creatures = bf.getCreatures();
        for(int i=0;i<20;i++){
            for(int j=0;j<20;j++){
                if(creatures[i][j]==null)
                    battlefxield.ImagesOnBattleField[i][j].setImage(null);
                else{
                    BattleFXield.switchIdentifierToImage(battlefxield.ImagesOnBattleField[i][j], creatures[i][j].reportIdentifier());
                }
            }
        }
    }


    public void leftCheerButtonClicked(ActionEvent event){
        bf.removeCreatureFromBattleField(oldpapa);
        bf.setCheeringCreatureLocation(oldpapa, false);
        bf.printBattleFieldStatus();
        syncBackgroundBFToUI();
    }
    public void rightCheerButtonClicked(ActionEvent event){
        bf.removeCreatureFromBattleField(snakeevil);
        bf.setCheeringCreatureLocation(snakeevil, true);
        bf.printBattleFieldStatus();
        syncBackgroundBFToUI();
    }


    @Override public void initialize(URL location, ResourceBundle resources){
        battlefxield = new BattleFXield();


        BattleFieldGridPane.getChildren().add(new ImageView());
        for(int i=0; i<20; i++){
            for(int j=0; j<20; j++){
                BattleFieldGridPane.getChildren().add(battlefxield.ImagesOnBattleField[i][j]);
           }
        }
        ChangeLeftChoiceBox.getItems().addAll("HeYI", "YanXing", "HengE", "ChangShe");
        ChangeRightChoiceBox.getItems().addAll("HeYI", "YanXing", "HengE", "ChangShe", "YuLin", "FangYuan", "YanYue", "FengShi");
        BattleFieldGridPane.setGridLinesVisible(true);

        ChangeRightChoiceBox.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                if(newValue.intValue() == 0){
                    bf.clearRightBattleField();
                    bf.deployHeYiZhen(scorpion, goblins, true);
                    bf.printBattleFieldStatus();
                    syncBackgroundBFToUI();
                }
                if(newValue.intValue() == 1){
                    bf.clearRightBattleField();
                    bf.deployYanXingZhen(scorpion, goblins, true);
                    bf.printBattleFieldStatus();
                    syncBackgroundBFToUI();
                }
                if(newValue.intValue() == 2){
                    bf.clearRightBattleField();
                    bf.deployHengEZhen(scorpion, goblins, true);
                    bf.printBattleFieldStatus();
                    syncBackgroundBFToUI();
                }
                if(newValue.intValue() == 3){
                    bf.clearRightBattleField();
                    bf.deployChangSheZhen(scorpion, goblins, true);
                    bf.printBattleFieldStatus();
                    syncBackgroundBFToUI();
                }
                if(newValue.intValue() == 4){
                    bf.clearRightBattleField();
                    bf.deployYuLinZhen(scorpion, goblins, true);
                    bf.printBattleFieldStatus();
                    syncBackgroundBFToUI();
                }
                if(newValue.intValue() == 5){
                    bf.clearRightBattleField();
                    bf.deployFangYuanZhen(scorpion, goblins, true);
                    bf.printBattleFieldStatus();
                    syncBackgroundBFToUI();
                }
                if(newValue.intValue() == 6){
                    bf.clearRightBattleField();
                    bf.deployYanYueZhen(scorpion, goblins, true);
                    bf.printBattleFieldStatus();
                    syncBackgroundBFToUI();
                }
                if(newValue.intValue() == 7){
                    bf.clearRightBattleField();
                    bf.deployFengShiZhen(scorpion, goblins, true);
                    bf.printBattleFieldStatus();
                    syncBackgroundBFToUI();
                }
            }
        });
        ChangeLeftChoiceBox.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                if(newValue.intValue() == 0){
                    bf.clearLeftBattleField();
                    bf.deployHeYiZhen(calabashbros[0], calabashbrosexpred, false);
                    bf.printBattleFieldStatus();
                    syncBackgroundBFToUI();
                }
                if(newValue.intValue() == 1){
                    bf.clearLeftBattleField();
                    bf.deployYanXingZhen(calabashbros[0], calabashbrosexpred, false);
                    bf.printBattleFieldStatus();
                    syncBackgroundBFToUI();
                }
                if(newValue.intValue() == 2){
                    bf.clearLeftBattleField();
                    bf.deployHengEZhen(calabashbros[0], calabashbrosexpred, false);
                    bf.printBattleFieldStatus();
                    syncBackgroundBFToUI();
                }
                if(newValue.intValue() == 3){
                    bf.clearLeftBattleField();
                    bf.deployChangSheZhen(calabashbros[0], calabashbrosexpred, false);
                    bf.printBattleFieldStatus();
                    syncBackgroundBFToUI();
                }
            }
        });
    }

    @FXML
    GridPane BattleFieldGridPane;
    @FXML
    ChoiceBox<String> ChangeLeftChoiceBox;
    @FXML
    ChoiceBox<String> ChangeRightChoiceBox;
    @FXML
    Button leftcheerbutton;
    @FXML
    Button rightcheerbutton;
}
