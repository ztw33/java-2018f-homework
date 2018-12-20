package gui;

import beings.*;
import formations.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;

import java.awt.Label;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import other.CalabashCompare;
import other.CalabashGroup;
import javafx.animation.*;
import javafx.scene.shape.*;
import javafx.util.Duration;
import java.util.Date;
import java.util.*;
import java.text.*;
import java.util.concurrent.Semaphore;

public class Controller{
    @FXML
    private BorderPane borderPane;
    //@Override
    public void initialize(URL location, ResourceBundle resources){

    }
    public void init(){
        /*
        System.out.println(getClass().getResource("/CalabashTest.jpg").toString());
        Image localImage = new Image(getClass().getResource("/CalabashTest.jpg").toString());

        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 20; j++) {
                ImageView imageView = new ImageView();
                imageView.setImage(localImage);
                imageView.setFitHeight(39);
                imageView.setFitWidth(39);
                gridPane.add(imageView, j, i);
            }
            //assert (false);
        }*/
        Image background = new Image(getClass().getResource("/background.jpg").toString());
        BackgroundSize backgroundSize = new BackgroundSize(75*16, 75*8, true,true,true, false);
        borderPane.setBackground(new Background(new BackgroundImage(background, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, backgroundSize)));
    }

    class UIOutput implements OutputAdapter{
        UIOutput(Controller controller) {
            this.controller = controller;
        }
        public void output(Being being) {
            if(being == null){
                return;
            }
            System.out.println("image ready to load on x:"+being.getPositionx()+"y:"+being.getPositiony());
            being.getImageView().setX(75*being.getPositionx());
            being.getImageView().setY(75*being.getPositiony());
            //being.getImageView().setX(75*13);
            //being.getImageView().setY(0);
            controller.borderPane.getChildren().add(being.getImageView());
            /*Path path=new javafx.scene.shape.Path();
            path.getElements().add(new MoveTo(37, 37));
            path.getElements().add(new LineTo(75*being.getPositionx()+37, 75*being.getPositionx()+37));

            //path.getElements().add(new LineTo(75*(newx-oldx), 75*(newy-oldy)));
            //创建路径转变
            PathTransition pt=new PathTransition();
            //pt.setDuration(Duration.millis(1)); //设置持续时间4秒
            pt.setPath(path); //设置路径
            pt.setNode(being.getImageView()); //设置物体
            pt.setOrientation(PathTransition.OrientationType.NONE);
            pt.play(); //启动动画*/
        }

        public void move(final Being being, final int newx, final int newy, final int oldx, final int oldy) {
            /*
            Path path=new javafx.scene.shape.Path();
            path.getElements().add(new MoveTo(oldx*75+37, oldy*75+37));
            path.getElements().add(new LineTo((newx)*75+37, (newy)*75+37));

            //path.getElements().add(new LineTo(75*(newx-oldx), 75*(newy-oldy)));
            //创建路径转变
            final PathTransition pt=new PathTransition();
            pt.setDuration(Duration.millis(500)); //设置持续时间4秒
            pt.setPath(path); //设置路径
            pt.setNode(being.getImageView()); //设置物体
            pt.setOrientation(PathTransition.OrientationType.NONE);
            pt.play(); //启动动画
            */
            /*
            pt.setOnFinished(new EventHandler<ActionEvent>() {
                public void handle(ActionEvent event) {

                    //System.out.println("AnimationEndRelease:"+being.getMySemaphore());
                    //being.getMySemaphore().animationEndRelease();
                    //being.getMySemaphore().semaphoreAnimationEnd.notify();
                }
            });
            */
            /*
            while(pt.getStatus() == Animation.Status.RUNNING)
                ;
            */
            try{
                //System.out.println("sleep now");
                //Thread.sleep(1000);
                /*
                Path path=new javafx.scene.shape.Path();
                path.getElements().add(new MoveTo(oldx*75+37, oldy*75+37));
                path.getElements().add(new LineTo((newx)*75+37, (newy)*75+37));

                //path.getElements().add(new LineTo(75*(newx-oldx), 75*(newy-oldy)));
                //创建路径转变
                final PathTransition pt=new PathTransition();
                //pt.setDuration(Duration.millis(10000)); //设置持续时间4秒
                pt.setPath(path); //设置路径
                pt.setNode(being.getImageView()); //设置物体
                pt.setOrientation(PathTransition.OrientationType.NONE);
                pt.play(); //启动动画
                while(pt.getStatus() != Animation.Status.STOPPED){
                    System.out.println(pt.getStatus());
                    being.toldname();
                    if(pt.getStatus() == Animation.Status.PAUSED){
                        pt.play();
                    }
                }
                */
                being.getImageView().setX(75*newx);
                being.getImageView().setY(75*newy);
                being.toldname();
                System.out.println("AnimationEndRelease:"+being.getMySemaphore());
                being.getMySemaphore().animationEndRelease();
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        private Controller controller;
        //private Being being;
    }
    public void startGame(){
        UIOutput temp = new UIOutput(this);
        Battlefield battlefield = new Battlefield(temp);
        MySemaphore[] semaphoresList = new MySemaphore[7+1+1+8];
        for(int i = 0; i < semaphoresList.length; i++){
            semaphoresList[i] = new MySemaphore(1,0);
            //System.out.println("create:"+semaphoresList[i].semaphoreAnimationEnd);
        }
        EvilParty[] enemy = new EvilParty[8];
        ScorpionThread scorpion = new ScorpionThread(battlefield, semaphoresList[9]);
        enemy[0] = scorpion;
        enemy[0].setImageView(BeingImage.Scorpion);
        Thread scorpionThread = new Thread(scorpion);

        Thread[] littleMonsterThreadList = new Thread[7];
        for(int i = 1; i < 8; i++){
            LittleMonsterThread littleMonster = new LittleMonsterThread(battlefield, semaphoresList[9+i]);
            enemy[i] = littleMonster;
            enemy[i].setImageView(BeingImage.LittleMonster);
            littleMonsterThreadList[i-1] = new Thread(littleMonster);
        }
        SnakeThread snake = new SnakeThread(battlefield, semaphoresList[8]);
        snake.setImageView(BeingImage.Snake);
        Thread snakeThread = new Thread(snake);

        GrandfatherThread grandfather = new GrandfatherThread(battlefield, semaphoresList[7]);
        grandfather.setImageView(BeingImage.Grandfather);
        Thread grandfatherThread = new Thread(grandfather);

        Thread[] calabashThreadList = new Thread[7];
        CalabashThread[] calabashList = new CalabashThread[7];
        for(int i = 0; i < calabashList.length; i++){
            calabashList[i] = new CalabashThread(battlefield, i, semaphoresList[i]);
            //System.out.println(semaphoresList[i].semaphoreAnimationEnd);
            calabashThreadList[i] = new Thread(calabashList[i]);
        }
        calabashList[0].setImageView(BeingImage.RedOne);
        calabashList[1].setImageView(BeingImage.OrangeOne);
        calabashList[2].setImageView(BeingImage.YellowOne);
        calabashList[3].setImageView(BeingImage.GreenOne);
        calabashList[4].setImageView(BeingImage.CyanOne);
        calabashList[5].setImageView(BeingImage.BlueOne);
        calabashList[6].setImageView(BeingImage.PurpleOne);
        CalabashGroup calabashGroup = new CalabashGroup(calabashList);


        calabashGroup.shuffle();
        calabashGroup.print();
        calabashGroup.sort(new CalabashCompare());
        calabashGroup.print();
        //calabashGroup.quickSort();

        new SquareCircle().formationCreatrue(battlefield, enemy, snake);
        new LongSnake().formationCreatrue(battlefield, (Creature[]) calabashGroup.getFormationCreatrue(), grandfather);
        battlefield.printField();


        Thread roundTimerThread = new Thread(new RoundTimer(semaphoresList, battlefield));
        roundTimerThread.start();

        for(int i = 0; i < littleMonsterThreadList.length; i++){
            littleMonsterThreadList[i].start();
        }
        scorpionThread.start();
        snakeThread.start();
        grandfatherThread.start();

        for(int i = 0; i < calabashThreadList.length; i++){
            calabashThreadList[i].start();
        }
    }
    void testImageViewMove(){
        ImageView temp = new ImageView(BeingImage.PurpleOne.getImage());
        temp.setFitWidth(74);
        temp.setFitHeight(74);
        temp.setX(74);
        temp.setY(74);
        borderPane.getChildren().add(temp);
        //gridPane.getChildren().remove(imageView);
        //创建路径
        /*javafx.scene.shape.Path path=new javafx.scene.shape.Path();
        path.getElements().add(new MoveTo(75*0+37, 75*0+37));
        path.getElements().add(new LineTo(75*4+37, 75*4+37));
        path.getElements().add(new LineTo(75*6+37, 75*3+37));
        //path.getElements().add(new MoveTo(75*4, 75*6));
        //path.getElements().add(new CubicCurveTo(380, 0, 380, 120, 200, 120));
        //path.getElements().add(new CubicCurveTo(0, 120, 0, 240, 380, 240));
        //创建路径转变
        PathTransition pt=new PathTransition();
        pt.setDuration(Duration.millis(30000));//设置持续时间4秒
        pt.setPath(path);//设置路径
        pt.setNode(temp);//设置物体
        pt.setOrientation(PathTransition.OrientationType.NONE);
        //设置周期性，无线循环
        //pt.setCycleCount(Timeline.INDEFINITE);
        //pt.setAutoReverse(false);//自动往复
        //long timePre = System.nanoTime();
        pt.play();//启动动画
        */
        //long timePass = System.nanoTime()-timePre;
        //System.out.println(timePass);
        //gridPane.getChildren().remove(imageView);
        //gridPane.add(imageView, 4, 6);
    }
}
