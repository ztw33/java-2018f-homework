package GUI;

import Formations.*;
import Source.Global;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.net.URL;


public class GUIWindow extends Application{
    //MARK:Properties

    /*help properties*/
    boolean beginFlag = false;
    boolean endFlag = false;
    int rounder = 0;

    /* Label */
    Label label = new Label();

    /* menuBar */
    MenuBar menuBar = new MenuBar();

    /* menuBar-file */
    Menu fileMenu = new Menu("file");
    MenuItem recordItem = new MenuItem("save file");
    MenuItem beginItem = new MenuItem("begin game");
    MenuItem readItem = new MenuItem("read file");

    /* menuBar-file-battleCalabashBrother */
    Menu battleMenu = new Menu("formation");
    Menu calabashMenu = new Menu("calabash");
    MenuItem broQueue1 = new MenuItem("鹤翼");
    MenuItem broQueue2 = new MenuItem("雁行");
    MenuItem broQueue3 = new MenuItem("衡轭");
    MenuItem broQueue4 = new MenuItem("长蛇");
    MenuItem broQueue5 = new MenuItem("鱼鳞");
    MenuItem broQueue6 = new MenuItem("方门");
    MenuItem broQueue7 = new MenuItem("偃月 ");
    MenuItem broQueue8 = new MenuItem("锋矢");

    /* menuBar-file-battleMonster */
    Menu monsterMenu = new Menu("monster");
    MenuItem monQueue1 = new MenuItem("鹤翼");
    MenuItem monQueue2 = new MenuItem("雁行");
    MenuItem monQueue3 = new MenuItem("衡轭");
    MenuItem monQueue4 = new MenuItem("长蛇");
    MenuItem monQueue5 = new MenuItem("鱼鳞");
    MenuItem monQueue6 = new MenuItem("方门");
    MenuItem monQueue7 = new MenuItem("偃月 ");
    MenuItem monQueue8 = new MenuItem("锋矢");

    /* gridPane */
    //static Canvas canvas = new Canvas();
    static GridPane gridPane = new GridPane();

    //MARK:Initialize;

    //help init

    /* set menuItem action */
    private void addActions(){
        addBroActions();
        addMonActions();
    }

    /* set bro actions */
    private void addBroActions(){

        broQueue1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(beginFlag)
                    return;
                QueueOne queueOne = new QueueOne(true);
                repaintMap();
            }
        });

        broQueue2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(beginFlag)
                    return;
                QueueTwo queueTwo = new QueueTwo(true);
                repaintMap();
            }
        });

        broQueue3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(beginFlag)
                    return;
                QueueThree queueThree = new QueueThree(true);
                repaintMap();
            }
        });

        broQueue4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(beginFlag)
                    return;
                QueueFour queueFour = new QueueFour(true);
                repaintMap();
            }
        });

        broQueue5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(beginFlag)
                    return;
                QueueFive queueFive = new QueueFive(true);
                repaintMap();
            }
        });

        broQueue6.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(beginFlag)
                    return;
                QueueSix queueSix = new QueueSix(true);
                repaintMap();
            }
        });

        broQueue7.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(beginFlag)
                    return;
                QueueSeven queueSeven = new QueueSeven(true);
                repaintMap();
            }
        });

        broQueue8.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(beginFlag)
                    return;
                QueueEight queueEight = new QueueEight(true);
                repaintMap();
            }
        });
    }

    /* set monster actions */
    private void addMonActions(){

        monQueue1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(beginFlag)
                    return;
                QueueOne queueOne = new QueueOne(false);
                repaintMap();
            }
        });

        monQueue2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(beginFlag)
                    return;
                QueueTwo queueTwo = new QueueTwo(false);
                repaintMap();
            }
        });

        monQueue3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(beginFlag)
                    return;
                QueueThree queueThree = new QueueThree(false);
                repaintMap();
            }
        });

        monQueue4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(beginFlag)
                    return;
                QueueFour queueFour = new QueueFour(false);
                repaintMap();
            }
        });

        monQueue5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(beginFlag)
                    return;
                QueueFive queueFive = new QueueFive(false);
                repaintMap();
            }
        });

        monQueue6.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(beginFlag)
                    return;
                QueueSix queueSix = new QueueSix(false);
                repaintMap();
            }
        });

        monQueue7.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(beginFlag)
                    return;
                QueueSeven queueSeven = new QueueSeven(false);
                repaintMap();
            }
        });

        monQueue8.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(beginFlag)
                    return;
                QueueEight queueEight = new QueueEight(false);
                repaintMap();
            }
        });
    }

    //init;

    /*init label*/
    private void labelInit(){
        label.setPrefSize(1000,100);
        label.setAlignment(Pos.CENTER);
        label.setFont(new Font(30));
        label.setText("Press Space to begin a new game");
    }

    /* init menuBar */
    private void menuBarInit(){

        //file menu init;
        fileMenu.getItems().add(readItem);
        fileMenu.getItems().add(recordItem);
        fileMenu.getItems().add(beginItem);
        menuBar.getMenus().add(fileMenu);

        //battleMenu init;
        battleMenu.getItems().add(calabashMenu);
        battleMenu.getItems().add(monsterMenu);
        menuBar.getMenus().add(battleMenu);

        //battle_brother init;
        calabashMenu.getItems().add(broQueue1);
        calabashMenu.getItems().add(broQueue2);
        calabashMenu.getItems().add(broQueue3);
        calabashMenu.getItems().add(broQueue4);
        calabashMenu.getItems().add(broQueue5);
        calabashMenu.getItems().add(broQueue6);
        calabashMenu.getItems().add(broQueue7);
        calabashMenu.getItems().add(broQueue8);

        //battle_monster init;
        monsterMenu.getItems().add(monQueue1);
        monsterMenu.getItems().add(monQueue2);
        monsterMenu.getItems().add(monQueue3);
        monsterMenu.getItems().add(monQueue4);
        monsterMenu.getItems().add(monQueue5);
        monsterMenu.getItems().add(monQueue6);
        monsterMenu.getItems().add(monQueue7);
        monsterMenu.getItems().add(monQueue8);

        //add Actions
        //addActions();
    }

    /* init gridPane */
    private void gridPaneInit() throws Exception {

        //init gridPane's background
        gridPane.setBackground(backgroundInit());

        //init Constraints of gridPane
        ColumnConstraints column1 = new ColumnConstraints();    column1.setPercentWidth(50);
        ColumnConstraints column2 = new ColumnConstraints();    column2.setPercentWidth(50);
        ColumnConstraints column3 = new ColumnConstraints();    column3.setPercentWidth(50);
        ColumnConstraints column4 = new ColumnConstraints();    column4.setPercentWidth(50);
        ColumnConstraints column5 = new ColumnConstraints();    column5.setPercentWidth(50);
        ColumnConstraints column6 = new ColumnConstraints();    column6.setPercentWidth(50);
        ColumnConstraints column7 = new ColumnConstraints();    column7.setPercentWidth(50);
        ColumnConstraints column8 = new ColumnConstraints();    column8.setPercentWidth(50);
        ColumnConstraints column9 = new ColumnConstraints();    column9.setPercentWidth(50);
        ColumnConstraints column10 = new ColumnConstraints();   column10.setPercentWidth(50);

        ColumnConstraints column11 = new ColumnConstraints();   column11.setPercentWidth(50);
        ColumnConstraints column12 = new ColumnConstraints();   column12.setPercentWidth(50);
        ColumnConstraints column13 = new ColumnConstraints();   column13.setPercentWidth(50);
        ColumnConstraints column14 = new ColumnConstraints();   column14.setPercentWidth(50);
        ColumnConstraints column15 = new ColumnConstraints();   column15.setPercentWidth(50);
        ColumnConstraints column16 = new ColumnConstraints();   column16.setPercentWidth(50);
        ColumnConstraints column17 = new ColumnConstraints();   column17.setPercentWidth(50);
        ColumnConstraints column18 = new ColumnConstraints();   column18.setPercentWidth(50);
        ColumnConstraints column19 = new ColumnConstraints();   column19.setPercentWidth(50);
        ColumnConstraints column20 = new ColumnConstraints();   column20.setPercentWidth(50);

        RowConstraints row1 = new RowConstraints(); row1.setPercentHeight(50);
        RowConstraints row2 = new RowConstraints(); row2.setPercentHeight(50);
        RowConstraints row3 = new RowConstraints(); row3.setPercentHeight(50);
        RowConstraints row4 = new RowConstraints(); row4.setPercentHeight(50);
        RowConstraints row5 = new RowConstraints(); row5.setPercentHeight(50);
        RowConstraints row6 = new RowConstraints(); row6.setPercentHeight(50);
        RowConstraints row7 = new RowConstraints(); row7.setPercentHeight(50);
        RowConstraints row8 = new RowConstraints(); row8.setPercentHeight(50);
        RowConstraints row9 = new RowConstraints(); row9.setPercentHeight(50);
        RowConstraints row10 = new RowConstraints(); row10.setPercentHeight(50);

        //add constraints to gridPane
        gridPane.getColumnConstraints().addAll(column1,column2,column3,column4,column5,column6,column7,
                column8,column9,column10,column11,column12,column13,column14,column15,column16,
                column17,column18,column19,column20);
        gridPane.getRowConstraints().addAll(row1,row2,row3,row4,row5,row6,row7,row8,row9,row10);

        //show lines of rows and cols;
        gridPane.setGridLinesVisible(true);

        //show initialize formation;
        Map map = Global.map;
        QueueFour broQueue = new QueueFour(true);
        QueueFour monQueue = new QueueFour(false);
        for(int i = 0; i < Global.colCount; i++){
            for(int j = 0; j < Global.rowCount; j++){
                if(!map.isEmpty(i,j))
                    gridPane.add(new ImageView(map.getCreatureImage(i,j)),i,j);
            }
        }

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        //init border pane;
        BorderPane borderPane = new BorderPane();
        borderPane.setPrefSize(1000,600);

        //set label;
        labelInit();
        borderPane.setBottom(label);

        //set menuBar at top position;
        menuBarInit();
        borderPane.setTop(menuBar);

        //set gridPane
        gridPaneInit();
        borderPane.setCenter(gridPane);

        //add Actions
        addActions();

        //start;
        Scene scene = new Scene(borderPane);
        primaryStage.setScene(scene);
        primaryStage.show();

        //add keyboard action;
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {

                if(event.getCode() == KeyCode.SPACE) {
                    if(endFlag == true){
                        if(Global.grandFather.getPos_y() == 0 && Global.grandFather.getPos_x() == 0){
                            QueueFour broQue = new QueueFour(true);
                            QueueFour monQue = new QueueFour(false);
                            repaintMap();
                        }
                        beginFlag = true;
                        endFlag = false;
                        return;
                    }
                    if(!beginFlag) {
                        Global.game.start();
                        beginFlag = true;
                        label.setText("Game Begin,Press Enter to continue");
                    }
                    else{
                        label.setText("game already begin,press enter to continue");
                    }
                }
                else if(event.getCode() == KeyCode.ENTER) {
                    if(!beginFlag) {
                        label.setText("press space to begin game");
                        return;
                    }
                    if(Global.isHuluFailed()){
                        label.setText("Monster Win,choose a formation and Press space key to init");
                        repaintMap();
                        beginFlag = false;
                        endFlag = true;
                        rounder = 0;
                        Global.creatureInit();
                    }
                    else if(Global.isMonFailed()){
                        label.setText("Huluwa Win,choose a formation and Press space key to init");
                        repaintMap();
                        beginFlag = false;
                        endFlag = true;
                        rounder = 0;
                        Global.creatureInit();
                    }
                    else {
                        repaintMap();
                        Global.game.roundTime();
                        rounder++;
                        label.setText("rounder"+rounder);
                    }
                }
            }

        });

    }

    /* clear gridPane */
    public static void clearGridPane(){
        Node node = gridPane.getChildren().get(0);
        gridPane.getChildren().clear();
        gridPane.getChildren().add(node);
    }

    /* repaint Global map */
    public static void repaintMap(){
        clearGridPane();
        for(int i = 0; i < Global.colCount; i++){
            for(int j = 0; j < Global.rowCount;j++){
                    gridPane.add(new ImageView(Global.map.getCreatureImage(i,j)),i,j);
            }
        }
    }


    /* set Background */
    private Background backgroundInit() throws Exception{
        Image image;
        URL url = getClass().getResource(Global.backGroundURL);
        image = new Image(url.toString());
        if(image == null)
            System.out.println("1");
        Background background = new Background(new BackgroundImage(image,
                BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
                new BackgroundSize(1000,500,true,true,true,true)));
        return background;
    }

    /*test move*/
    /*
    public static void showMap(){
        for(int i = 0; i < Global.rowCount; i++){
            for(int j = 0; j < Global.colCount; j++){
                if(Global.map.isEmpty(j,i))
                    System.out.print("* ");
                else
                    System.out.print("= ");
            }
            System.out.println();
        }
    }
    */



}