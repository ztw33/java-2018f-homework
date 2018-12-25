package guiApp;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Random;
import java.util.Arrays;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.*;
import javafx.scene.layout.GridPane;
import javafx.scene.canvas.*;
import Battle.*;
import Creatures.*;
import Formations.*;

public class GameController implements Initializable {
    @FXML private Button gameStartButton;
    @FXML private Button changeFormationButton;
    @FXML private Button quitButton;
    @FXML private TextArea gameLog;
    @FXML private Canvas imageArea;
    Image backgroundImage = new Image("resourceFiles/background.jpg");
    private Battlefield battlefield = new Battlefield();
    private Heros heros = new Heros();
    private BadGuys badGuys = new BadGuys();
    private ArrayList<FormationProvider> formationProviders = new ArrayList<>();
    Integer currentHerosFormation;
    Integer currentBadGuysFormation;
    boolean isGamming = false;


    @FXML private void gameStartHandler() {
        if(isGamming) { return; }
        isGamming = true;
        gameLog.clear();
        gameLog.appendText("游戏开始,双方排起了雁行阵！\n");
        Image backgroundImage = new Image("resourceFiles/background.jpg");
        GraphicsContext gc = imageArea.getGraphicsContext2D();
        gc.drawImage(backgroundImage,0,0); //重绘覆盖
        heros.changeFormation(new ChangShe(),battlefield);
        badGuys.changeFormation(new ChangShe(),battlefield);
        currentBadGuysFormation = 3;
        currentHerosFormation = 3;
        displayBattlefield();
    }
    @FXML private void changeFormationHandler() {
        clearBattlefield();
        currentBadGuysFormation = (currentBadGuysFormation+2)%8;
        currentHerosFormation = (currentHerosFormation+1)%8;
        String fomationName = badGuys.changeFormation(formationProviders.get(currentBadGuysFormation),battlefield);
        gameLog.appendText("怪兽阵营排出了："+fomationName+"\n");
        fomationName = heros.changeFormation(formationProviders.get(currentHerosFormation),battlefield);
        gameLog.appendText("葫芦娃们不甘示弱，排出了："+fomationName+"\n");
        displayBattlefield();
    }
    @FXML private void quitHandler() {
        clearBattlefield();
        isGamming = false;
        gameLog.appendText("本轮游戏结束。\n");
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO:初始化、读入资源
        gameLog.setText("游戏准备开始！\n");
        gameLog.setEditable(false);
        GraphicsContext gc = imageArea.getGraphicsContext2D();
        gc.drawImage(backgroundImage,0,0);
        formationProviders.addAll(Arrays.asList(new HeYi(),new YanXing(),new ChongE(),
                new ChangShe(),new YuLin(),new Fang(),new YanYue(),new FengShi()));
    }
    private void displayBattlefield() {
        ArrayList<ArrayList<Block<Creature>>> blocks = battlefield.getBattlefield();
        for(int i = 0;i<blocks.size();i++) {
            for(int j = 0;j<blocks.get(i).size();j++) {
                Image image = blocks.get(i).get(j).getImage();
                GraphicsContext gc = imageArea.getGraphicsContext2D();
                gc.drawImage(image,j*58,i*58);
            }
        }
    }
    private void clearBattlefield() {
        battlefield.clear();
        GraphicsContext gc = imageArea.getGraphicsContext2D();
        gc.drawImage(backgroundImage,0,0);
    }
}
