package Frame;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

//游戏屏幕的父类
public abstract class GameScreen extends Canvas {
    private List<GameObject> objectList = new ArrayList<GameObject>();    //存放游戏中所有物体的容器
    private Timeline timeline;
    private KeyFrame keyFrame;
    private int duration = 30;
    private boolean ifPutString;         
    private String outputString;         
    private int xOutputString = 500, yOutputString = 300;       
    protected static final String wd = System.getProperty("user.dir");
    private static Image bkp = null;

    static{
        try {
            bkp = new Image(new FileInputStream(wd + "\\resources\\background2.jpg"));
        } catch (
                FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    protected double x, y, width, height;       //屏幕的位置和长、宽

    public GameScreen(double x, double y,double width,double height){
        super(width,height);
        this.x = x; this.y = y;
        this.width = width; this.height = height;
        setLayoutX(x); setLayoutY(y);
        initTimeLine();
        ifPutString = false;
    }

    //初始化事件处理函数
    public void initEvents(){

        getParent().getScene().setOnKeyPressed(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent event) {
                onKeyPressed(event);
            }
        });
        getParent().getScene().setOnKeyReleased(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent event) {
                onKeyReleased(event);
            }
        });
        getParent().getScene().setOnMouseClicked(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                onMouseClicked(event);
            }
        });
    }
   
    protected abstract void onKeyPressed(KeyEvent event);
    protected abstract void onKeyReleased(KeyEvent event);
    protected abstract void onMouseClicked(MouseEvent event);
    //添加和删除物体
    public void addObject(GameObject object){
        this.objectList.add(object);
    }
    public void removeObject(GameObject object){
        this.objectList.remove(object);
    }
    //屏幕显示文字
    public void showInfo(String info){
        ifPutString = true;
        outputString = info;

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                setIfPutString(false);
                System.gc();cancel();
            }
        },2000);
    }
    //画出所有物体
    public void draw(GraphicsContext gc){
        gc.clearRect(0,0,getWidth(),getHeight());   //清屏
        gc.drawImage(bkp,0,0,bkp.getWidth(),bkp.getHeight(),0,0,width,height);  
        if(ifPutString){
            gc.fillText(outputString,xOutputString,yOutputString);
        }
        for(int i=0;i<objectList.size();i++){
            GameObject o = objectList.get(i);
            if(o.isVisible()){
                o.draw(gc);
            }
        }
    }
    //更新所有物体
    public void update(){
        for(GameObject object:objectList){
            if(object.isUpdate()){
                object.update();
            }
        }
    }
    //初始化时间表
    private void initTimeLine(){
        timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);        //无限循环
        keyFrame = new KeyFrame(Duration.millis(duration), new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                draw(getGraphicsContext2D());
                update();
            }
        });
        timeline.getKeyFrames().add(keyFrame);
    }
    //开始执行时间表
    public void start(){
        timeline.play();
    }
    //暂停执行时间表
    public void pause(){
        timeline.pause();
    }

    //停止时间表
    public void stop(){
        timeline.stop();
    }

    public List<GameObject> getObjectList() {
        return objectList;
    }


    public void setIfPutString(boolean ifPutString) {
        this.ifPutString = ifPutString;
    }
}


